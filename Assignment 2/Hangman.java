package eg.edu.alexu.csd.datastructure.hangman;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.Random;
import java.util.Scanner;

public class Hangman implements IHangman{
	private char test;
	private int i = 0, flag,count=0, length ,j;
	private int maxWrong;
	private static int k = 0;
    private static String[] words = new String[100];
	private String word = new String();
	private String[] draws;
	public static void main(String[] args) throws Exception {
		Hangman o = new Hangman() ;
		System.out.println("WELCOME TO HANGMAN GAME");
		o.setDictionary(words);
		System.out.println(o.selectRandomSecretWord());
		System.out.println(o.length);
		//draws = new String[o.length]
		o.setMaxWrongGuesses(o.length);
		System.out.println(o.maxWrong);
	    String[] draws = new String[o.length];
	for (k = 0; k < o.length; k++) {
		draws[k] = "_";
		System.out.print(draws[k]+" ");
	}
	for (k = 0; o.maxWrong != 0 && o.count != o.length ; k++) {
//		System.out.println(o.word.charAt(0)==o.test);
		System.out.println("\n\nGUESS A LETTER ... ");
		System.out.println("\n\nAnd then press ENTER twice ... ");
		Scanner scan = new Scanner(System.in);
		o.test = scan.next().charAt(0);
		if(Character.isLetter(o.test)) {
			o.guess(o.test);
		}else {
			System.out.println("Error , you must enter only letter ");
	}
		if(o.count == o.length) {
			System.out.println("you win !!!");
			System.out.println("The word is "+o.word);
		}else if (o.maxWrong ==0) {
			System.out.println("you lose !");
			System.out.println("The word is "+o.word);
		}
	}
	}
	

	@Override
	public void setDictionary(String[] words) {
		File f = new File("C:\\Users\\Dell\\OneDrive\\Desktop\\dictionary.txt");
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while ((line = br.readLine()) != null) {
				words[i] = line;
				i++;
			}
			br.close();
			fr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public String selectRandomSecretWord() {
		Random rand = new Random();
		int rand1 = rand.nextInt(20);
		word = new String(words[rand1]);
		length =word.length();
		return word;
	}

	@Override
	public String guess(Character c) throws Exception {
		Hangman o = new Hangman() ;
		test = Character.toLowerCase(o.test);
		i=0;
		while(i<length) {
			//System.out.println(word.charAt(i)==test);
		if(word.charAt(i)==test) {
			flag = 1;
			draws[i]= Character.toString(test);
			i++;
			count++;
			System.out.println("hennnna1"+i);
		}else 
			i++;
		}
		if(flag == 1) {
			System.out.println("Correct letter");
		}else {
			maxWrong -- ;
			System.out.println("Incorrect letter");
		}
		for (j = 0; j< o.length; j++) {
			System.out.print(draws[j]+" ");
		}
		return null;
	}

	@Override
	public void setMaxWrongGuesses(Integer max) {
	 maxWrong = length ;
	}
		
}
	