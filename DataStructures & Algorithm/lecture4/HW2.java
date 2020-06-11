//	Pg.11 Q2 String search. Find if "m" exists in "amit"

package lecture4;

public class HW2 {
//	using recursion
	
	static int searchInString(String str, char x, int curIndex) {
		if(curIndex >= str.length()) { //this = is also very very important
			return -1;
		}
		
		if(str.charAt(curIndex) == x) {
			return curIndex;
		}
		
		return searchInString(str, x, curIndex+1);
	}
	
	public static void main(String[] args) {
		String str = "akash";
		String msg = searchInString(str, 'z', 0)>= 0 ? "Found" : "Not Found";
		System.out.println(msg);
	}
	
	
	
//	static boolean checkIf(String str, char x) {
//		for(int i = 0; i< str.length(); i++) {
//			if(str.charAt(i) == x) return true;
//		}
//		return false;
//	}
//	
//	public static void main(String[] args) {
//		boolean val = checkIf("amit", 'm');
//		if(val) System.out.println("m found");
//		else System.out.println("m doesn't exist");
//		
//	}
}
