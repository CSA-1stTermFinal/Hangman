import java.util.Random;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        String[] words = {"dog", "cat", "house", "animal", "apple", "pizza", "computer", "monitor", "mouse", "keyboard"};
        int rnd = new Random().nextInt(10);
        int lengthOfWord = words[rnd].length();
        String wordToGuess = words[rnd];
        String hiddenWord = "";
        char userGuess;
        int numOfGuesses;

        System.out.println("Welcome to hangman");

        for (int i = 0; i < lengthOfWord; i++) {
            hiddenWord = hiddenWord + "_ ";
        }

        System.out.println("Your word to guess is " + hiddenWord + wordToGuess);
        System.out.println("Enter a letter");
        userGuess = input.next().charAt(0);

        for (int i = 0; i < lengthOfWord; i++) {
            if (wordToGuess.substring(i, i + 1).equals(userGuess)) {
                hiddenWord = hiddenWord.replace('_',userGuess);
            }
        }

        if (wordToGuess.substring(0, 1).equals(userGuess)) {
            hiddenWord = hiddenWord.replace('_',userGuess);
        }
        System.out.println(hiddenWord);
    }
}
