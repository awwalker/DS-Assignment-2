/**
 * This class uses merge sort algorithm to sort an array alphabetically
 * 
 * @author aaronwalker
 *
 */
public class Sort{

	public static void quickSort(String[] words ){
		qSort(words, 0, words.length - 1);
	}
	
	public static void qSort(String[] words , int low, int high){
		int pivot = (low + high) / 2;
		swap(words, pivot, high);
		int part = partition(words, low, high - 1, words[high]);
		swap(words, part, high);
		if((part - low) > 1){qSort(words, low, part -1);}
		if((high - part) > 1){qSort(words, part + 1, high);}
	}
	
	public static int partition(String[] words , int left, int right, String pivot){
		while(left <= right){
			while(words[left].compareTo(pivot) < 0){left++;}
			while( right >= left &&words[right].compareTo(pivot) >= 0){right--;}
			if(left < right){swap(words, left, right);}
		}
		return left;
	}
	
	public static void swap(String[] words, int index1, int index2){
		String temp = words[index1];
		words[index1] = words[index2];
		words[index2] = temp;
	}
	
}
