//	Solving lecture6's subsequence problem, lecture7's maze and dice problem using return void type

package lecture8;

public class Demo1 {

	static void subSequence(String str, String result) {
		if(str.length()==0) {
			System.out.println(result);
			return ;
		}
		char singleChar = str.charAt(0);
		String remainingString = str.substring(1);
		subSequence(remainingString, result);
		subSequence(remainingString, result+singleChar);
	}
	
	static void perm(String str , String result) {
		if(str.length()==0) {
			System.out.println(result);
			return ;
		}
		for(int i =0; i<str.length(); i++) {
			char singleChar = str.charAt(i);
			String subString = str.substring(0,i) + str.substring(i+1);
			perm(subString, result+singleChar);
		}
	}
	
	static void diceGame(int current, int end, String result) {
		if(current==end) {
			System.out.println(result);
			return ;
		}
		if(current>end) {
			return ;
		}
		for(int dice = 1; dice<=6; dice++) {
			diceGame(current+dice, end, result+dice);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		subSequence("abc", "");
		perm("abc","");
//		diceGame(0, 10 , "");

	}

}
