// The Missing Number Question - Pg:4

package lecture2;

public class Demo1 {
	public static void main(String[] args) {

		int arr[] = { 1, 3, 4 };
		int x = 0;
		int y = 0;
		int min = 1;
		int max = 4;
		for (int i = 0; i < arr.length; i++) {
			x = x ^ arr[i];
		}
		for (int i = min; i <= max; i++) {
			y = y ^ i;
		}
		System.out.println("Missing No is " + (x ^ y));

	}
}

/*
	MY WAY..!!
 	
 	public class MissingNum {
	
	public static void main(String[] args) {
		int[] givenArr = {1,2,3,4,5};
		int[] missingArr = {1,2,3, 8 ,4,5};
		int x = 0, y = 0;
		
		for(int i = 0; i < givenArr.length; i++) {
			x = x ^ givenArr[i];
		}
		for(int i = 0; i < missingArr.length; i++) {
			y = y ^ missingArr[i];
		}
		
		int missingVal = x ^ y;
		System.out.println(missingVal);
	}
}
 
*/
