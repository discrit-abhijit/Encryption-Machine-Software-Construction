/**
 * EncryptionMachine class implements a Caesar Cipher encryption algorithm.
 * Caesar Cipher is a substitution cipher where each character in the message is shifted by a fixed number of positions in the alphabet.
 * This program prompts the user for the key and the number of words in the key.Then, it encrypts each word in the key and displays the encrypted result to ensure secure communication.
 *
 * @author [Abhijit Das]
 */
import java.util.Scanner;

public class EncryptionMachine {
    public static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    public static final int SHIFT = 3;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Caesar Cipher Encryption Program!");
        System.out.println("The program lets you encrypt a message with a key for your recipient to decrypt!");
        System.out.println(); // Print a blank line
        System.out.print("Please enter the first word of the key: ");
        String firstWord = scanner.next();
        String encryptedFirstWord = encryptWord(firstWord, SHIFT);
        System.out.println("\"" + firstWord + "\" has been encrypted to: " + encryptedFirstWord);
        System.out.println(); // Print a blank line
        System.out.print("\nEnter the number of words in your key: ");
        int numWords = scanner.nextInt();
        System.out.println(); // Print a blank line
        
        for (int i = 1; i < numWords; i++) {
            System.out.print("Enter word #" + (i + 1) + " of the key: ");
            String word = scanner.next();
            String encryptedWord = encryptWord(word, SHIFT);
            System.out.println("\"" + word + "\" has been encrypted to: " + encryptedWord);
            System.out.println(); // Print a blank line
        }
        
        System.out.println("\nMessage fully encrypted. Happy secret messaging!");

        scanner.close();
    }

    /**
     * Encrypts a single letter using Caesar cipher with a given shift value.
     *
     * @param letter The letter to be encrypted
     * @param shift  The shift value for encryption
     * @return The encrypted letter
     */
    public static char encryptLetter(char letter, int shift) {
        int index = ALPHABET.indexOf(letter);
        int encryptedIndex = (index + shift) % ALPHABET.length();
        return ALPHABET.charAt(encryptedIndex);
    }

    /**
     * Encrypts a word using Caesar cipher with a given shift value.
     *
     * @param word  The word to be encrypted
     * @param shift The shift value for encryption
     * @return The encrypted word
     */
    public static String encryptWord(String word, int shift) {
        StringBuilder encryptedWord = new StringBuilder();
        for (char letter : word.toCharArray()) {
            char encryptedLetter = encryptLetter(letter, shift);
            encryptedWord.append(encryptedLetter);
        }
        return encryptedWord.toString();
    }
}