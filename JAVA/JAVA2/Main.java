package JAVA.JAVA2;

public class Main {

    public static int countVowels(char[] word) {
        char[] vowels = {'a', 'i', 'u', 'e', 'o'};
        int count = 0;
    
        for (int i = 0; i < word.length; i++) { // Loop ini akan berjalan sebanyak n kali, di mana n adalah panjang array word.
            for (int j = 0; j < vowels.length; j++) { // Loop ini akan berjalan sebanyak m kali, di mana m adalah panjang array vowels.
                if (Character.toLowerCase(word[i]) == vowels[j]) { // Operasi ini adalah operasi konstan.
                    count++; // Operasi ini adalah operasi konstan.
                    break; // Operasi ini adalah operasi konstan.
                }
            }
        }
        return count;
    }
    
    }
