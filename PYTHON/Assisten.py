import speech_recognition as sr
import datetime
import pyttsx3
from google.cloud import speech_v1p1beta1 as speech
import os

def speak(text):
    engine = pyttsx3.init()
    engine.say(text)
    engine.runAndWait()

def recognize_speech():
    client = speech.SpeechClient()

    config = {
        "encoding": speech.RecognitionConfig.AudioEncoding.LINEAR16,
        "sample_rate_hertz": 16000,
        "language_code": "id-ID",
    }

    with sr.Microphone() as source:
        print("Silakan katakan sesuatu...")
        audio = client.recognize(config=config, audio=speech.RecognitionAudio(content=source))

    try:
        return audio.results[0].alternatives[0].transcript
    except IndexError:
        print("Maaf, tidak bisa mengenali suara Anda.")

def welcome_message():
    print("Selamat datang! Saya siap membantu Anda. Silakan berbicara.")

def main():
    os.environ["GOOGLE_APPLICATION_CREDENTIALS"] = "path/to/your/credential.json"

    welcome_message()
    
    while True:
        command = recognize_speech()
        
        if command:
            if "selamat tinggal" in command:
                print("Sampai jumpa! Semoga harimu menyenangkan.")
                break
            elif "hari ini" in command:
                print("Hari ini adalah hari yang cerah!")
            elif "terima kasih" in command:
                print("Tidak masalah, selalu senang bisa membantu.")
            elif "menu utama" in command:
                speak("Menu utama. Pilih salah satu dari pilihan berikut: waktu sekarang, nama pemilik, tanggal dan hari sekarang, dan waktu sekarang. Silakan bicara.")
            elif "waktu sekarang" in command:
                now = datetime.datetime.now()
                current_time = now.strftime("%H:%M")
                speak("Waktu sekarang adalah " + current_time)
            elif "nama pemilik" in command:
                speak("Nama pemilik belum diatur.")
            elif "tanggal dan hari" in command:
                now = datetime.datetime.now()
                today = now.strftime("%A, %d %B %Y")
                speak("Hari ini adalah " + today)
            elif "waktu real-time" in command:
                now = datetime.datetime.now()
                current_time = now.strftime("%H:%M:%S")
                speak("Waktu real-time sekarang adalah " + current_time)
            else:
                print("Maaf, saya tidak memahami perintah Anda.")
                
if __name__ == "__main__":
    main()
