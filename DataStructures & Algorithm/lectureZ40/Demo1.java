package interview;

import java.util.ArrayList;
import java.util.Scanner;

public class Demo1 {
	
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		/*String str = scanner.next();//"10,20,30,40,50,60,70";
		String arr[] = str.trim().split(",");
		int num [] = new int[arr.length];
		*/
		int index = 0;
		ArrayList<Integer> l = new ArrayList<>();
		while(true) {
			int e = scanner.nextInt();
			if(e==-1) {
				break;
			}
			l.add(scanner.nextInt());
			
		}
//		for(String a : arr) {
//			num[index]=  Integer.parseInt(a.trim());
//			index++;
//		}
		
		scanner.close();
		

	}

}
