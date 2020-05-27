// Bubble Sort and subsequence question

package lecture6;

import java.util.ArrayList;

public class Demo1 {
	static ArrayList<String> subSequence(String name) {
		if(name.length()==0) {
			ArrayList<String> list = new ArrayList<>();
			list.add("");
			return list;
		}
		char currentChar = name.charAt(0);
		String subString = name.substring(1);
		ArrayList<String> finalList = new ArrayList<>();
		ArrayList<String> returnList  =subSequence(subString);
		for(String temp: returnList) {
			finalList.add(temp);
			finalList.add(currentChar+temp);
		}
		return finalList;
	}
	static void sort(int arr[], int firstIndex, int lastIndex) {
		if(lastIndex==0) {
			return ;
		}
		if(firstIndex==lastIndex) {
			sort(arr,0,lastIndex-1);
			return ;
		}
		if(arr[firstIndex]>arr[firstIndex+1]) {
			int temp = arr[firstIndex];
			arr[firstIndex] = arr[firstIndex+1];
			arr[firstIndex+1] = temp;
		}
		
		sort(arr, firstIndex+1, lastIndex);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		int arr[] = {60,50,20,10};
//		sort(arr, 0, arr.length-1);
//		for(int i : arr) {
//			System.out.println(i);
//		}
		ArrayList<String> result = subSequence("amit");
		System.out.println(result);
	}

}
