/**
 * This class represents a dictionary of words to compare
 * user input / generated anagrams against. 
 * Any dictionary represented by this class / that uses
 * methods in this class must be sorted alphabetically
 * 
 * Methods in this class are designed to 
 * 		 * check if whole words are in a dictionary
 * 		 * check if prefixes are in a dictionary
 * 		 * trim a dictionary to only words of the same
 *  		length as input
 *  @author aaronwalker
 */
import java.util.ArrayList;

public class Dictionary implements DictionaryInterface{
	ArrayList<String> dict; 
	
	public Dictionary(){
		dict = new ArrayList<String>();
	}
	
	/**
	 * This method determines if a given word
	 * is in this Dictionary using the method 
	 * findWord(word, start, end). It limits the 
	 * necessary user input to just the word to be 
	 * searched for.
	 * It is necessary the Dictionary be sorted
	 * @param word the word to be checked
	 * @return true if the word is in this Dictionary,
	 * false otherwise
	 */
	//REWRITE RECURSIVE
	public boolean findWord(String word){
		//looking for the word from beginning of the Dictionary to the last index
		return findWord(word, 0, dict.size() - 1);
	}
	
	/**
	 * This method uses recursive binary search
	 * to determine if a word is in this Dictionary object.
	 * It is necessary the Dictionary be sorted
	 * @param word the word to be checked
	 * @param start int the starting position of the search
	 * @param end int the ending position of the search
	 * @return true if the word is in the Dictionary, 
	 * false otherwise.
	 */
	public boolean findWord(String word, int start, int end){
		//BASE CASE
		if(start <= end){//if we are still searching
			int mid = (start + end) / 2; //find mid point of dictionary
			if(dict.get(mid).equals(word)){
				return true; //true if we have found the word at the mid point of dictionary
			}
			else if(word.compareTo(dict.get(mid)) < 0){ //if the word we are searching for comes before mid point
				return findWord(word, start, mid - 1); //search only up until word before mid point
			}
			else{//if word comes after mid point
				return findWord(word, mid + 1, end); //search from after mid point to the end
			}
		}
		return false; //if we are no longer in bounds of the dictionary it has not been found
	}
	/**
	 * This method determines if a given
	 * prefix is a prefix of a word that exists in
	 * this Dictionary by using the method 
	 * findPrefix(String prefix, int start, int end).
	 * The Dictionary object that this method is used on has to be sorted.
	 * This method limits user input to just the String representation of a prefix
	 * using 0 as the start of the search and the end of the search as the 
	 * the last index in the Dictonary object.
	 * @param prefix the prefix to be checked
	 * @return true if the prefix is in this Dictionary,
	 * false otherwise
	 */
	//REWRITE RECURSIVE
	public boolean findPrefix(String prefix){//uses the recursive method
		//limits the amount of user input to just the prefix to be found
		return findPrefix(prefix, 0, dict.size() - 1 );
	}
	
	/**
	 * This method determines if a given
	 * prefix is a prefix of a word that exists in
	 * this Dictionary using binary search and recursion.
	 * The Dictionary object has to be sorted 
	 * @param prefix the prefix to be checked, int start index to start search,
	 * int end index where to end the search
	 * @return true if the prefix is in this Dictionary,
	 * false otherwise
	 */
	private boolean findPrefix(String prefix, int start, int end){
		//BASE CASE
		//make sure search is still viable
		if(start <= end){
			//create midpoint
			int mid = (start + end) / 2;
			//if the word at the mid point is the same from the beginning to 
			//the length of the prefix return true
			if(prefix.equals(dict.get(mid).substring(0, prefix.length()  ))){
				return true;
			}//if the dictionary word up till the prefix length is 'greater' than the prefix 
			//search the first half of the dictionary
			else if( dict.get(mid).substring(0, prefix.length() ).compareTo(prefix) > 0 ){
				return findPrefix(prefix, start, mid - 1);
				
			}//otherwise search the second half
			else{
				return findPrefix(prefix, mid + 1, end);
				
			}
		}//if never found return false
		return false;
	}
	
	/**
	 * This method reduces the size of a Dictionary object
	 * by building a new Dictionary that only contains words
	 * with length equal to the length of the passed in String
	 * @param input the String with which to match length
	 * @return trimmedDict a new Dictionary object with only words
	 * that have the same length as the passed in String
	 */
	public Dictionary trimDict(String input){
		Dictionary trimmedDict = new Dictionary();
		for(String word : dict){
			if(word.length() == input.length()){
				trimmedDict.addWord(word);
			}
		}
		return trimmedDict;
	}
	
	/**
	 * This method adds a word into a Dictionary object
	 * @param word the word to be added
	 */
	void addWord(String word){
		dict.add(word);
	}
}
