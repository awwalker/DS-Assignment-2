# DS-Assignment-2

Programming Project 2

Find Words

## Objectives

The goal of this programming project is for you to master (or at least get practice on) the following tasks:

  * using recursion to solve problems
  * reading data from input files
  * using command line arguments
  * writing Java programs

## The Program Input and Output

You may use any Java classes for reading from input files.

#### Input File

Your program is given the name of the input text file as its command line argument (the first and only argument used by this program). The text file contains a dictionary that is used by the program. You may assume that the dictionary contains a sorted list of words, one per line. A word is any sequence of lower case letters.

If the filename is omitted from the command line, it is an error. The program should display an error message and terminate. The error message should indicate what went wrong (for example: ”Error: missing name of the input file”).

If the filename is given but the file does not exist or cannot be opened for reading by the program, for any reason, it is an error. The program should display an error message and terminate. The error message should indicate what went wrong (for example: ”Error: file dictionaryEnglish.txt does not exist.”, but make sure to replace the name with the name of the file with which the program was
called).

Your program is NOT ALLOWED to hardcode the input filename in its own code. It is up to the user of the program to specify the name of the input file. Your program should not modify the name of the user-specified file (do not append anything to the name).

Your program may not read the input file more than once.

Your program may not modify the input file.

#### Output File

Your program does not produce any output files. 

#### User Input

The user should be prompted to enter a string of characters (letters only, no spaces, commas, or any other characters). Your program should accept both upper case and lower case letters. If the user enters any uppercase letters, your program should convert them to lowercase before proceeding.

If the user enters any characters other than letters, it is an error. The program should display an error message and terminate. The error message should indicate what went wrong (for example: ”Error: you entered an invalid character; only letters can be accepted”).

#### Console Output

The program should display in lower case letters all anagrams of the user typed letters that are valid words based on the dictionary that the program uses. The program should display the total number of unique words found (for example: "Found 3 words"), followed by the list of words. The words should be displayed one per line and in alphabetical order. If there are any repeated words in the list of generated anagrams, they should not be shown only once in your output.

If there are no valid words that can be created from the user provided letters, the program should display a message: "No words
found".

## Computational Task

Once the user has entered the letters, the program displays all the words in the dictionary that can be formed as combinations of all the letters entered by the user.

#### Creating all Possible Words

The task of creating possible words should be achieved recursively using the backtracking technique. Make sure to review the examples used in class for creating all possible strings from the given set of characters.

If the user enters n letters there are n! different possible words (note that some of them might repeat, if some of the letters repeat) - but not many of them are going to be found in the dictionary. You should design an algorithm that tries different combinations of letters and checks if they are in the dictionary, but it should do it in a smart way: do not try words that cannot possibly be in the dictionary, i.e., do not follow the paths that do not lead to words. For example, if the user enters zzasw and your algorithm starts generating a sequence of characters starting with zz, but there are no words in your dictionary that start with zz, then there is no point in generating all of the sequences that start with zz - your algorithm should skip them.

#### Searching in the Dictionary

In order to determine if a given sequence is a valid word in a dictionary, your program needs to perform searches. You need to implement your own search method to achieve this. You should use a recursive implementation of a binary search.

The program will also need to be able to determine if there are any words in the dictionary that begin with a particular sequence of characters. The implementation of such method will be similar to the binary search implementation. It should also be recursive.

## Program Design

Your program must contain three classes:

  * Dictionary class to represent the collection of words read in from the input file (i.e., the dictionary used by the program). This class is responsible for performing queries in the dictionary. The Dictionary class should implement the following interface:

  public interface DictionaryInterface {

	/\*\*

	\* This method determines if a given word is in this Dictionary.
	
	\* @param word the word to be checked
	
	\* @return true if the word is in this Dictionary,
	
	\* false otherwise
	
	\*/
	
	boolean findWord ( String word );

	/\* \*
	
	\* This method determines if a given prefix is a prefix of a word that   

	\* exists in this Dictionary.

	\* @param prefix the prefix to be checked
	
	\* @return true if the prefix is in this Dictionary,
	
	\* false otherwise
	
	\*/
	
	boolean findPrefix ( String prefix );
  
  }

  * LetterBag class to represent the letters entered by the user/player. This class is responsible for creation of all the different words. It should use the Dictionary object to accomplish its task. The LetterBag class should implement the following interface:

  public interface LetterBagInterface {

  	/\*\*

  	 \* This method determines the list of words that can be created from a 
  	 
  	 \* given LetterBag object that are present in the 
  	 
  	 \* provided Dictionary object dict.
  	 
  	 \* @param dict the Dictionary object to be used
  	 
  	 \* @return a list of valid words in alphabetical order
  	 
  	 \*/
  	 
  	 ArrayList<String> getAllWords ( Dictionary dict );
  
  }

  * FindWords class that is the runable program containing the main() method. This class is responsible for parsing the command line argument, reading the input file, reading the user input, creating the Dictionary and LetterBag objects and then using them to display the results. This class may have methods other than the main() method.

You will need to have files specifying the above interfaces. You may use additional classes, if you wish. 

## Programming Rules

You must document all your code using Javadoc. Your class documentation needs to provide a description of what it is used for and the name of its author. Your methods need to have description, specification of parameters, return values, exceptions thrown and any assumptions that they are making. 

A class's data fields and methods should not be declared static unless they are to be shared by all instances of the class or provide access to such data.

You must use backtracking and recursion to produce the list of words.

You may use ArrayList and String classes, but you must implement your own search and sort methods. 

You may use any classes for reading the input from the file.

You may use any exception related classes (if you wish).