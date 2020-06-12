//	Think deeply this easy solution makes a lot of sense.

package lecture4;

public class HW4 {
	static boolean isSorted(int[] arr, int curIndex) {
		if(curIndex == (arr.length-1)) {
			return true;
		}
		
		if(arr[curIndex] > arr[curIndex+1]) return false;
		
		return isSorted(arr, curIndex+1);
	}
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		String msg = (isSorted(arr, 0))? "Yes, It's sorted" : "Ohh, no..it's not sorted" ;
		System.out.println(msg);
	}
}
