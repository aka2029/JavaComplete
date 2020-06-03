//	diceGame (Pg. 15) and maze problem (Pg. 16)

package lecture7;

import java.util.ArrayList;

public class Demo1 {
	
//	THE MAZE PATH PROBLEM - here we've pre-assumed the matrix size to be 3x3
	static ArrayList<String> maze(int startX, int startY, int endX, int endY){
		if(startX==endX && startY==endY) {
			ArrayList<String> temp =new ArrayList<>();
			temp.add("");
			return temp;
		}
		if(startX>endX || startY>endY) {
//			This is the main trick to solve this question
			ArrayList<String> temp = new ArrayList<String>();
			return temp;
		}
		ArrayList<String> finalResult = new ArrayList<>();
		ArrayList<String> horzResult = maze(startX+1,startY,endX,endY);
		for(String tempH: horzResult) {
			finalResult.add("H"+tempH);
		}
		ArrayList<String> vertResult =maze(startX,startY+1,endX,endY);
		for(String tempV: vertResult) {
			finalResult.add("V"+tempV);
		}
		ArrayList<String> diagResult =maze(startX+1,startY+1,endX,endY);
		for(String tempD: diagResult) {
			finalResult.add("D"+tempD);
		}
		return finalResult;
	}
	
//	THE ULTIMATE DICE GAME (IN RECURSION)
	static ArrayList<String> diceGame(int currentValue , int endValue){
		if(currentValue==endValue) {
			ArrayList<String> temp =new ArrayList<>();
			temp.add("");
			return temp;
		}
		if(currentValue>endValue) {
//			This is the main trick to solve this question
			ArrayList<String> temp =new ArrayList<>();
			return temp;
		}
		ArrayList<String> finalResult = new ArrayList<>();
		for(int dice = 1; dice<=6; dice++) {
			int newValue = currentValue + dice;
			ArrayList<String> result = diceGame(newValue, endValue);
			for(String r : result) {
				finalResult.add(dice  + r);
			}
		}
		return finalResult;
	}
	public static void main(String[] args) {
		int startValue = 0;
		int endValue = 10;
		//ArrayList<String> perm = diceGame(startValue, endValue);
		//System.out.println(perm);
		
		System.out.println(maze(0, 0, 2, 2));
		ArrayList<Integer> list = new ArrayList<>();
		list.add(10);
		list.add(20);
		for(int i : list) {
			System.out.println(i);
		}
		list.forEach((i)->System.out.println(i));

	}

}
