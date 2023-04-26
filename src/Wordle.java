import java.util.Random;
import java.util.Scanner;

public class Wordle {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random r = new Random();

        String[] words = new String[]{"trick", "unite", "mouse", "table", "smash"};

        String randomWord = words[r.nextInt(words.length)];

        int guesses = 6;


        boolean[] guessedLetters = new boolean[randomWord.length()];

        while (guesses > 0) {
            System.out.println("Enter letter: ");
            String input = s.nextLine().toLowerCase();
            char letter = input.charAt(0);
            boolean found = false;

            for (int i = 0; i < randomWord.length(); i++) {
                if (randomWord.charAt(i) == letter) {
                    guessedLetters[i] = true;
                    found = true;
                }
            }

            if (found) {
                System.out.println("You guessed the letter!");
            } else {
                System.out.println("The letter " + letter + " isn't in the word ");
                guesses--;
            }

            if (isGuessed(guessedLetters)) {
                System.out.println("You guessed the word. It was: " + randomWord);
                return;
            }
            System.out.println("Attempts left: " + guesses);
            System.out.println(displayWord(randomWord, guessedLetters));

        }

    }

    public static String displayWord(String word, boolean[] guessedLetters) {
        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < word.length(); i++) {
            if (guessedLetters[i]) {
                builder.append(word.charAt(i));
            } else {
                builder.append("[]");
            }
        }
        return builder.toString();
    }

    public static boolean isGuessed(boolean[] guessedLetters) {
        for (boolean guessed : guessedLetters) {
            if (!guessed) {
                return false;
            }
        }
        return true;
    }
}
