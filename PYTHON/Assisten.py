import speech_recognition as sr
import pyttsx3

def recognize_speech():
    r = sr.Recognizer()

    with sr.Microphone() as source:
        print("Please say something...")
        audio = r.listen(source)

    try:
        text = r.recognize_google(audio, language='en-US')  # Menggunakan bahasa Inggris
        print("You said:", text)
        return text
    except sr.UnknownValueError:
        print("Sorry, I couldn't understand your voice.")
    except sr.RequestError as e:
        print("Error on Google request; {0}".format(e))

def change_voice(engine, voice_id):
    voices = engine.getProperty('voices')
    engine.setProperty('voice', voices[voice_id].id)

def speak(text, voice_id=0):  
    engine = pyttsx3.init()
    
    # Checking if voice_id is valid
    voices = engine.getProperty('voices')
    if voice_id < 0 or voice_id >= len(voices):
        print("Error: Invalid voice ID.")
        return
    
    # Selecting the voice based on voice_id
    change_voice(engine, voice_id)

    # Speaking the text
    engine.say(text)
    engine.runAndWait()

def welcome_message():
    speak("Welcome! I'm ready to assist you. Please speak.")

def main():
    welcome_message()
    
    while True:
        command = recognize_speech()
        
        if command:
            if "goodbye" in command:
                speak("Goodbye! Have a great day.")
                break
            elif "today" in command:
                speak("Today is a beautiful day!")
            elif "thank you" in command:
                speak("You're welcome, always happy to help.")
            else:
                speak("Sorry, I didn't understand your command.")
                
if __name__ == "__main__":
    main()
