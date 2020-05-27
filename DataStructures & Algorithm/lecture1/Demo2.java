package lecture1;

public class Demo2 {
	public static void main(String[] args) {
		int max = Integer.MIN_VALUE ;
		int arr [] = {200, 90, 56, 77, 110, 2, 5, 6};
		for(int i = arr.length-1; i>=0; i--) {
			if(arr[i]>max) {
				max = arr[i];
				System.out.println(max);
			}
		}
	}
}
