import java.util.Random;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        final int MAX_GUESSES = 0;
        String[] words = {"dog", "cat", "house", "animal", "apple", "pizza", "computer", "monitor", "mouse", "keyboard"};
        char[] hiddenWord = new  char[40];
        char[] charWord = new char[20];
        char userGuess;
        char continueToPlay = 'y';
        int wins = 0;
        String name;

        System.out.println("Welcome to hangman");
        System.out.println("Enter your name");
        name = input.nextLine();

        while (continueToPlay == 'y') {
            int rnd = new Random().nextInt(words.length);
            int lengthOfWord = words[rnd].length();
            int numOfGuesses = 8;
            int correct = 0;
            int count = 0;
            String wordToGuess = words[rnd];

            System.out.println("\nYour word to guess is: ");
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
                        if (count == 0) {
                            numOfGuesses++;
                            count++;
                        }
                    }
                }
                for (int i = 0; i < lengthOfWord; i++) {
                    System.out.print(hiddenWord[i] + " ");
                }
                for (int i = 0; i < lengthOfWord; i++) {
                    if (hiddenWord[i] == charWord[i]) {
                        correct++;
                    }
                }

                numOfGuesses--;
                count = 0;

                if (correct == lengthOfWord) {
                    System.out.println("\nCongratulations " + name + " you won");
                    wins++;
                    break;
                } else if (numOfGuesses == MAX_GUESSES) {
                    System.out.println("\nSorry but you suck at this");
                    System.out.println("The word was " + wordToGuess);
                } else {
                    System.out.println("\nYou have " + numOfGuesses + " guesses left");
                }

                correct = 0;
            }

            System.out.println("Do you want to continue playing: y/n");
            continueToPlay = input.next().charAt(0);
        }

        System.out.println("You won " + wins + " times.");
    }
}
