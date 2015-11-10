/**
 * This interface ensures that any class that implements
 * it will include the methods:
 * 		* boolean findWord(String word)
 * 		* boolean findPrefix(String prefix)
 * @author Joanna Klukowska
 *
 */
public interface DictionaryInterface {
	/**
	 * This method determines if a given word
	 * is in this Dictionary.
	 * @param word the word to be checked
	 * @return true if the word is in this Dictionary,
	 * false otherwise
	 */
	boolean findWord( String word );
	
	/**
	 * This method determines if a given
	 * prefix is a prefix of a word that exists in
	 * this Dictionary. 
	 * @param prefix the prefix to be checked
	 * @return a list of valid words in alphabetical order
	 */
	boolean findPrefix( String prefix );
	
}
