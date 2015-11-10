/**
 * This class allows the user to input a word and then uses 
 * a sorted Dictionary, also provided by the user, to check
 * if any anagrams of the given String of input are inside the 
 * Dictionary.
 * Does not return a value but prints out answers to the console.
 * Errors (will result in):
 * 		*No input file given: "No Dictionary Input Found: Please provide a Dictionary"
 * 		*Input file not available: "No input dictionary detected: dictName does not exist"
 * 		*Bad User input: "Please enter a valid string!"
 * If any anagrams are found:
 * 		*Console outputs---> Found #anagrams 
 * 							 word1
 * 							 .....
 * 							 wordx (in alphabetical order)
 * If no anagrams found:
 * 		*Console outputs---> No words found for the string "userInput" in dictionary dictName
 * @author aaronwalker 
 */
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class FindWords extends Sort {
	static String[] words;
	public static void main(String[] args){
		try{
			File read = new File(args[0]);
			Scanner in = new Scanner(System.in);
			String input;
			try{
				System.out.println("Please input a string of characters to check in the dictionary:");//prompt
				input = in.nextLine();//get input
				if(input.matches("^[^\\Q!@#$%~`^&*()\\E \\d\\p{javaWhitespace}]+$")){//accept no white space and no digits and no special characters
					input = input.toLowerCase(); //shift all input to just lower case
					Dictionary dict = new Dictionary(); //create new Dictionary object
					LetterBag letters = new LetterBag(); //create new LetterBag
				//Fill Dictionary object
					Scanner reader = new Scanner(read);
					while(reader.hasNext()){//add each word in the Dictionary file to the dict object
						String line = reader.nextLine();//gather input from Dictionary file
						if(!line.isEmpty()){
							dict.addWord(line); //each line represents one word...add that word to the dictionary object
						}
					}
					//dict = dict.trimDict(input);

				//Generate Prefixes and then Find Words
					//Generate prefixes in LetterBag 
					letters = letters.generatePrefixes(input, dict); //use the user input and dict to build prefixes
					//fill an ArrayList of Strings with just words found in dictionary
					
					ArrayList<String> foundWords = letters.getAllWords(dict);
					String[] words = foundWords.toArray(new String[foundWords.size()] );

					if(!foundWords.isEmpty()){//if there are words found let user know which words and how many in total
						System.out.printf("Found %s words: \n" , foundWords.size() ); //how many words found
						quickSort(words); //sort all words alphabetically using merge sort
						for(int i = 0; i < words.length ; i++){
							System.out.println(words[i]); //return words
						}
					}
					else{//if no words found in the dictionary
						System.out.printf("No words found for the string \"%s\" in the dictionary %s", input, args[0]);
					}
					reader.close();
					in.close();
				}
				else{//if user inputs white spaces or numbers
					System.out.println("Please enter a valid string!");
				}
			}catch(IOException e){//if the dictionary is not given by user
				System.out.printf("No input dictionary detected: %s does not exist", args[0]);
			}
		}catch(ArrayIndexOutOfBoundsException e){//also if dictionary is not given by user
			System.out.println("No Dictionary Input Found: Please provide a Dictionary");
		}
	}
	
	

}

