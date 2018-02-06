package Homework_10;

import java.util.Random;
import javax.swing.JOptionPane;

public class HW10P02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] nouns = {"computer", "mouse", "phone", "cable", "eraser", 
				"belt", "keychain", "key", "screen", "cup",
				"calculator", "trash", "monitor", "lanyard", "tie",
				"shoes", "door", "clothes", "house", "car", 
				"band", "tire", "window", "mirror", "circle",
				"square", "paperclip", "pencil", "paper", "pen"};
		
		String[] adjectives = {"abandoned", "able", "absolute", "adorable", "adventurous",
				"babyish", "bad", "back", "baggy", "bare",
				"calculating", "calm", "candid", "canine", "capital", 
				"damaged", "damp", "dangerous", "dapper", "daring",
				"each", "eager", "earnest", "early", "easy", 
				"fabulous", "failing", "faint", "fair", "faithful"};
		
		String[] verbs = {"awake", "be", "beat", "become", "begin",
				"bend", "bring", "build", "buy", "choose", 
				"come", "do", "draw", "drive", "drink", 
				"eat", "fall", "fight", "find", "forgive",
				"freeze", "get", "give", "go", "grow",
				"hand", "have", "hear", "hide", "hit"};
		
		String[] prepositions = {"aboard", "about", "above", "across", "after",
				"against", "along", "alongside", "amid", "among", 
				"amongst", "around", "as", "aside", "astride",
				"at", "atop", "barring", "behind", "below",
				"beneath", "beside", "besides", "between", "beyond"};
		
		String[] articles = {"the", "a"};
		
		String sentence = getSentence(nouns, adjectives, verbs, prepositions, articles) + "\n"
				+ getSentence(nouns, adjectives, verbs, prepositions, articles) + "\n"
				+ getSentence(nouns, adjectives, verbs, prepositions, articles) + "\n"
				+ getSentence(nouns, adjectives, verbs, prepositions, articles) + "\n"
				+ getSentence(nouns, adjectives, verbs, prepositions, articles) + "\n"
				+ getSentence(nouns, adjectives, verbs, prepositions, articles) + "\n"
				+ getSentence(nouns, adjectives, verbs, prepositions, articles) + "\n";
		
		JOptionPane.showMessageDialog(null, sentence);
	}
	
	public static String getSentence(String[] v, String[] w, String[] x, String[] y, String[] z)
	{
		
		String str = "";
		
		Random ran = new Random();
		
		str = z[ran.nextInt(z.length)] + " " + w[ran.nextInt(w.length)] + " " +
				v[ran.nextInt(v.length)] + " " +  x[ran.nextInt(x.length)] + " " +
				y[ran.nextInt(y.length)] + " " + z[ran.nextInt(z.length)] + " " +
				w[ran.nextInt(w.length)] + " " + v[ran.nextInt(v.length)];
		
		return str;
	}
}
