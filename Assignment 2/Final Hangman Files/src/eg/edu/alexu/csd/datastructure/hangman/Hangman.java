package eg.edu.alexu.csd.datastructure.hangman;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Hangman implements IHangman {

	String randomword;
	String[] dictionary;
	int numberofWords = 0;
	int Leftguesses;
	char[] displayedWord;
	boolean win = false;

	@Override
	public void setDictionary(String[] words) {
		dictionary = new String[numberofWords];
		if (numberofWords > 0) {
			System.arraycopy(words, 0, dictionary, 0, numberofWords);
			selectRandomSecretWord();
		} else {
			System.out.println("Dictionary is empty!");
			return;
		}
	}

	public void readFromDictionary() {
		try {
			File f = new File("src//eg//edu//alexu//csd//datastructure//hangman//dictionary.txt");
			BufferedReader br = new BufferedReader(new FileReader(f));
			String[] words = new String[100];
			String line = br.readLine();
			while (line != null) {
				words[numberofWords] = line;
				numberofWords++;
				line = br.readLine();
			}
			br.close();
			setDictionary(words);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Can't open file !");
		}

	}

	@Override
	public String selectRandomSecretWord() {
		Random rand = new Random();
		int int_rand = rand.nextInt(numberofWords);
		randomword = new String(dictionary[int_rand]);
		displayedWord = new char[randomword.length()];
		Arrays.fill(displayedWord, '-');
		return randomword;
	}

	@Override
	public String guess(Character c) throws Exception {
		Pattern pattern = Pattern.compile("[^A-Za-z]"); //checks that the word only contains letters
        Matcher match = pattern.matcher(randomword);
        if(match.find()){
            throw new Exception("Buggy word!");
        }

        c=Character.toLowerCase(c);
        int index = randomword.toLowerCase().indexOf(c);
        if(index==-1) {
            Leftguesses--;
            System.out.println("Wrong Letter ... Try Again");
        }

        for (int k = 0; k < randomword.length() ; k++) {
            if(k==index) {
                displayedWord[k]= randomword.charAt(index) ;
                index = randomword.toLowerCase().indexOf(c, index + 1);
            }
        }

        if(Leftguesses==0) {
        	return" You reached maximum number of wrong guesses!! ... YOU LOSE";
            //throw new Exception("You reached maximum number of wrong guesses!!");
        }
        if(String.valueOf(displayedWord).indexOf('-')==-1)
            win=true;
        return String.valueOf(displayedWord);

	}

	@Override
	public void setMaxWrongGuesses(Integer max) {
	 if(max!=0)
         Leftguesses =max;
     else
         Leftguesses = 0;
	}

}
