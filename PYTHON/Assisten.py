import speech_recognition as sr
import datetime
import pyttsx3

# Inisialisasi engine di luar fungsi
engine = pyttsx3.init()

def speak(text):
    # Menggunakan variabel engine yang sudah diinisialisasi di luar fungsi
    engine.say(text)
    engine.runAndWait()

def recognize_speech(language="id-ID"):
    recognizer = sr.Recognizer()

    with sr.Microphone() as source:
        print("Silakan katakan sesuatu...")
        audio_data = recognizer.listen(source)

    try:
        if language == "id-ID":
            text = recognizer.recognize_google(audio_data, language="id-ID")
        elif language == "en-US":
            text = recognizer.recognize_google(audio_data, language="en-US")
        else:
            print("Bahasa tidak didukung.")
            return ""
        return text
    except sr.UnknownValueError:
        print("Maaf, tidak bisa mengenali suara Anda.")
        return ""
    except sr.RequestError:
        print("Maaf, ada masalah dengan koneksi internet.")
        return ""

def manual_input():
    print("Ketik perintah Anda:")
    return input().lower()

def welcome_message():
    print("Selamat datang! Saya siap membantu Anda. Silakan berbicara.")

def main():
    welcome_message()
    
    while True:
        print("Pilih bahasa (Indonesia atau Inggris):")
        language_choice = input().lower()
        
        if language_choice == "indonesia":
            language = "id-ID"
            break
        elif language_choice == "inggris":
            language = "en-US"
            break
        else:
            print("Bahasa tidak didukung.")

    while True:
        command = recognize_speech(language).lower()
        
        if command:
            if "selamat tinggal" in command:
                speak("Sampai jumpa! Semoga harimu menyenangkan.")
                break
            elif "hari ini" in command:
                speak("Hari ini adalah hari yang cerah!")
            elif "terima kasih" in command:
                speak("Tidak masalah, selalu senang bisa membantu.")
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
                speak("Maaf, saya tidak memahami perintah Anda. Apakah Anda ingin mengetik manual? (Ya/Tidak)")
                answer = input().lower()
                if answer == "ya":
                    command = manual_input()
                    # Melanjutkan logika pemrosesan perintah dari pengguna
                else:
                    speak("Silakan coba lagi atau ketik 'Ya' untuk mengetik manual.")

if __name__ == "__main__":
    main()
