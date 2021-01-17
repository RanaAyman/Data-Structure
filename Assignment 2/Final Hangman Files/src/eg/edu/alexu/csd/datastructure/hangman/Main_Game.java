package eg.edu.alexu.csd.datastructure.hangman;

import java.util.Scanner;

public class Main_Game {

	public static void main(String[] args) throws Exception {
		Hangman hangman = new Hangman();
        Scanner scan = new Scanner(System.in);
		System.out.println("WELCOME TO HANGMAN GAME");
		hangman.readFromDictionary();
//      System.out.println(hangman.randomword);
        hangman.setMaxWrongGuesses(hangman.randomword.length());
        System.out.println(String.valueOf(hangman.displayedWord));
        char letter;
        while(hangman.Leftguesses!=0) {
            if(hangman.win) {
                System.out.println("YOU WIN !");
                break;
            }
            System.out.println("Guess a letter...");
            do {
                letter = scan.next().charAt(0);
            } while (letter == '\u0000');// to check that a character isn't null
            System.out.println(hangman.guess(letter));
            System.out.println("Left wrong guesses : " + hangman.Leftguesses);
        }
        scan.close();
	}

}
