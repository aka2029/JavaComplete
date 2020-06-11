// Recursion demo file ... all questions given in previous class

package lecture5;

public class Demo1 {
	static boolean isSortedArray(int arr[], int currentIndex) {
		if((arr.length-1)==currentIndex){
			return true;
		}
		if(arr[currentIndex]>arr[currentIndex+1]) {
			return false;
		}
		return isSortedArray(arr, currentIndex+1);
	}
	
	static int searchInArray(int arr[],int searchElement, int currentIndex) {
		if(currentIndex>=arr.length) {
			return -1;
		}
		if(arr[currentIndex]==searchElement) {
			return currentIndex;
		}
		return searchInArray(arr, searchElement, currentIndex+1);
	}
	
	static int searchInArrayLastIndex(int arr[],int searchElement, int currentIndex) {
//		This question focuses on Post Processing & HINT: Stack Fall
		if(currentIndex==(arr.length-1)) {
			return -1;
		}
		int lastIndex = searchInArrayLastIndex(arr,searchElement, currentIndex+1);
		if(lastIndex==-1) { // Here Fall Start
			if(arr[currentIndex]== searchElement) {
				return currentIndex;
			}
			else {
				return -1;
			}
		}
		else {
			return lastIndex;
		}
	}
	
//	RETURN ALL INDEXES OF THE NUMBER TO BE FOUND
	static int[] searchInArrayAllIndexes(int arr[],int searchElement, int currentIndex, int counter) {
		if(currentIndex==(arr.length-1)) {
			int blankArr [] = new int[counter];
			return blankArr;
		}
		int resultArray [] = null;
		if(arr[currentIndex]== searchElement) {
			resultArray = searchInArrayAllIndexes(arr, searchElement,currentIndex+1, counter+1);
		}
		else {
			resultArray = searchInArrayAllIndexes(arr, searchElement,currentIndex+1, counter);
		}
		// Post Processing
		if(arr[currentIndex]==searchElement) {
			resultArray[counter] = currentIndex;
		}
		return resultArray;
	}
	
	public static void main(String[] args) {
		int arr [] = {10,20,130,40,50,130,2};
		
//		String msg = searchInArrayLastIndex(arr,130,0)>=0?"Found":"Not Found";
		
//		String msg = isSortedArray(arr,0)?"Sorted ":"Not Sorted";
		
		String msg = searchInArray(arr,14330,0)>=0?"Found":"Not Found";
		
		System.out.println(msg);

	}
}
