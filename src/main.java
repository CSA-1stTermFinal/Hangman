import java.util.Random;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String[] words = {"dog", "cat", "house", "animal", "apple", "pizza", "computer", "monitor", "mouse", "keyboard"};
        int rnd = new Random().nextInt(words.length);
        int lengthOfWord = words[rnd].length();
        String wordToGuess = words[rnd];
        char[] hiddenWord = new  char[40];
        char[] charWord = new char[20];
        char userGuess;
        int numOfGuesses = 8;
        final int MAX_GUESSES = 0;

        System.out.println("Welcome to hangman");
        System.out.println("Your word to guess is: ");

        for (int i = 0; i < lengthOfWord; i++) {
            charWord[i] = wordToGuess.charAt(i);
            hiddenWord[i] = '_';
            System.out.print(hiddenWord[i] + " ");
        }

        while (numOfGuesses != MAX_GUESSES && hiddenWord != wordToGuess.toCharArray()) {
            System.out.println("\nEnter a letter");
            userGuess = input.next().charAt(0);

            for (int i = 0; i < lengthOfWord; i++) {
                if (charWord[i] == userGuess) {
                    hiddenWord[i] = userGuess;
                    numOfGuesses++;
                }
            }
            for (int i = 0; i < lengthOfWord; i++) {
                System.out.print(hiddenWord[i] + " ");
            }

            numOfGuesses--;

            if (numOfGuesses == MAX_GUESSES) {
                System.out.println("Sorry but you suck at this");
                System.out.println("The word was " + wordToGuess);
            }
            else if (hiddenWord == wordToGuess.toCharArray()) {
                System.out.println("Congratulations you got it");
            }
            else {
                System.out.println("You have " + numOfGuesses + " guesses left");
            }
        }
    }
}
