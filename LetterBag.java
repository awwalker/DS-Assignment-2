/**
 * This class uses an ArrayList of Strings to represent
 * a 'bag of letters' given by a users input. 
 * Methods in this class are designed to produce viable
 * anagrams (given a Dictionary of words to look through). 
 * First by generating viable prefixes and then by checking
 * for words matching the length of the generated prefixes against
 * words in a Dictionary. 
 * @author aaronwalker
 */
import java.util.ArrayList;

public class LetterBag implements LetterBagInterface {
	ArrayList<String> letters;
	
	public LetterBag(){
		letters = new ArrayList<String>();
	}
	/**
	 * This method gets the size of a LetterBag object
	 * @return int the size of the LetterBag object as an int
	 */
	public int size(){
		return letters.size();
	}

	/**
	 * This method adds a word to a LetterBag
	 * @param word the word / prefix to be added
	 */
	public void addWord(String word){
		letters.add(word);
	}
	
	/**
	 * This method returns the object in a LetterBag object
	 * at a specified index
	 * @param index the index to look at
	 * @return String the item at index
	 */
	public String get(int index){
		return letters.get(index);
	}
	
	/**
	 * This method determines the list of words that can be created
	 * from a given LetterBag object that are present in the 
	 * provided Dictionary object dict. 
	 * @param dict the Dictionary object to be used
	 * @return a list of valid words in alphabetical order
	 */

	public ArrayList<String> getAllWords(Dictionary dict){
		//create ArrayList of Strings to populate with the words found in the Dictionary object
		ArrayList<String> dictionaryWords = new ArrayList<String>();
		for(int i = 0; i < letters.size(); i++){//look through all words in the LetterBag
			if(dict.findWord(letters.get(i))){//look through Dictionary for all words in the LetterBag
				dictionaryWords.add(letters.get(i));//add the word if its in the Dictionary
			}
		}
		return dictionaryWords;
	}
	

	/**
	 * Uses the recursive function generatePrefixes 
	 * and trims down the necessary parameters.
	 * @param letters the string of letters to build all 
	 * prefixes from
	 * @param dict a Dictionary object to use for backtracking
	 * and making sure only prefixes that exist in the Dictionary are created
	 * @return l a LetterBag full of the prefixes / words that can be found 
	 * in the Dictionary
	 */
	public LetterBag generatePrefixes(String letters, Dictionary dict){
		LetterBag l = new LetterBag();//new letterbag to fill with prefixes 
		Dictionary smallerDict = dict.trimDict(letters);
		//starts with blank prefix and the passed in string and creates a new LetterBag 
		//to populate with prefixes
		generatePrefixes("", letters, l, smallerDict); //limit users input to just a string and dictionary
		return l;
	}

	/**
	 * This method generates prefixes based on letters in a LetterBag
	 * and using backtracking to only generate prefixes / words that
	 * may exist in a Dictionary
	 * @param prefix an empty string to build prefixes in
	 * @param letters a string containing all letters input by the user
	 * @param words a LetterBag object to fill with the prefixes / words 
	 * created 
	 * @param dict a Dictionary to check prefixes against as they are generated
	 * to stop generation of useless prefixes
	 */
	private void generatePrefixes(String prefix, String letters, LetterBag words, Dictionary dict){
		//BASE CASE
		//System.out.println(prefix);
		//if the prefix has become as long as the passed in word and the prefix is not already in 
		//the new LetterBag add it
		if(letters.length() == 0 && ( words.size() == 0 || !words.findPrefixes(prefix) )){
			words.addWord(prefix);
		}
		//RECURSIVE call
		//if not at base case...
		else{
			for(int j = 0; j < letters.length(); j++){	//go over each letter in the passed string
				if(dict.findPrefix(prefix)){ //continue using prefix only if it is still in the Dictionary
					//Recursively add a character to the prefix from the remainder of the passed string
					//shrink the amount of letters to draw from
					generatePrefixes( prefix + letters.charAt(j),
						letters.substring(0, j) + letters.substring(j+1), 
						words, dict );

				}
			}
		}
	}
	
	
	/**
	 * This method uses the recursive method 
	 * findPrefixes(String prefix, int current, int end)
	 * to limit the parameters being used by the user to 
	 * just the prefix being looked for
	 * @param prefix the prefix the method is looking for
	 * @return true / false based on whether or not the prefix is in the LetterBag
	 */
	public boolean findPrefixes(String prefix){
		//limit the amount of information user has to input to just the prefix they want to find
		//searches from beginning of the LetterBag to the last index
		return findPrefixes(prefix, 0, letters.size() - 1);
	}
	
	/**
	 * This method uses linear search to find a prefix inside a LetterBag.
	 * Because a LetterBag may not be in a sorted order binary search 
	 * may not work. LetterBag objects won't hold too many prefixes so 
	 * linear search should not cause any performance issues
	 * @param prefix the prefix to look for
	 * @param current the point inside the LetterBag the method is looking at
	 * @param end the end point of the LetterBag / where to stop looking
	 * @return true / false if the prefix is in / not in the LetterBag
	 */
	public boolean findPrefixes(String prefix, int current, int end){
		//BASE CASE
		//if we are looking at 1 + the last index of the LetterBag terminate
		if(current == end + 1){
			return false;
		}
		else{
			if(letters.get(current).equals(prefix)){
				return true;
			}
			return findPrefixes(prefix, current + 1, end);
		}
	}
}
