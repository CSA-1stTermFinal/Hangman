import java.util.Random;
import java.util.Scanner;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.channels.FileChannel;
import java.nio.ByteBuffer;
import static java.nio.file.StandardOpenOption.*;

public class Main {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        final int MAX_GUESSES = 8;
        String[] words = {"dog", "cat", "house", "animal", "apple", "pizza", "computer", "monitor", "mouse", "keyboard", "coronavirus", "bruh", "loser", "winner", "help", "corn", "food"};
        char[] hiddenWord = new  char[40];
        char[] charWord = new char[20];
        char userGuess;
        char continueToPlay = 'y';
        String name;
        String delimiter = "|";
        Path scoreTxt = Paths.get("C:\\Users\\d4wso\\Desktop\\Hangman\\src\\Score");
        FileChannel fcIN = null;
        GetAndSet stuff = new GetAndSet();

        System.out.println("Welcome to hangman");
        System.out.println("Enter your name");
        stuff.setName(input.nextLine());

        while (continueToPlay == 'y') {
            int rnd = new Random().nextInt(words.length);
            String wordToGuess = words[rnd];
            int lengthOfWord = wordToGuess.length();
            int numOfGuesses = 0;
            int correct = 0;
            int count = 0;

            System.out.println("\nYour word to guess is: ");
            for (int i = 0; i < lengthOfWord; i++) {
                charWord[i] = wordToGuess.charAt(i);
                hiddenWord[i] = '_';
                System.out.print(hiddenWord[i] + " ");
            }

            System.out.println();

            while (numOfGuesses != MAX_GUESSES) {
                DrawMan.main(numOfGuesses);
                System.out.println("\nEnter a letter");
                userGuess = input.next().charAt(0);

                for (int i = 0; i < lengthOfWord; i++) {
                    if (charWord[i] == userGuess) {
                        hiddenWord[i] = userGuess;
                        if (count == 0) {
                            numOfGuesses--;
                            count++;
                        }
                    }

                    System.out.print(hiddenWord[i] + " ");

                    if (hiddenWord[i] == charWord[i]) {
                        correct++;
                    }
                }

                numOfGuesses++;
                count = 0;

                if (correct == lengthOfWord) {
                    System.out.println("\nCongratulations " + stuff.getName() + " you won");
                    stuff.setWins(stuff.getWins() + 1);
                    break;
                } else if (numOfGuesses == MAX_GUESSES) {
                    System.out.println("\nSorry but you suck at this");
                    System.out.println("The word was " + wordToGuess);
                    stuff.setLosses(stuff.getLosses() + 1);
                    DrawMan.youLose();
                } else {
                    System.out.println("\nYou have " + (MAX_GUESSES-numOfGuesses) + " guesses left");
                }

                correct = 0;
            }

            System.out.println("Do you want to continue playing: y/n");
            continueToPlay = input.next().charAt(0);
        }

        try {
            fcIN = (FileChannel) Files.newByteChannel(scoreTxt, CREATE, WRITE);
            String s = "Name: " + stuff.getName() + " " + delimiter + " Wins: " + stuff.getWins() + " " + delimiter + " Losses: " + stuff.getLosses();
            byte[] data = s.getBytes();
            ByteBuffer buffer = ByteBuffer.wrap(data);
            fcIN.write(buffer);
        } catch (Exception e) {
            System.out.println("Error message: " + e);
        }
    }
}
