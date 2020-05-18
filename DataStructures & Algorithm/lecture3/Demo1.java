// Mostly all the Recursion Questions done are from previous class but the main thing that is

// done to do question both ways 1. returning no. 2. returning void signature

package lecture3;

public class Demo1 {
	static int fact(int num) {
		if(num==1) {
			return 1;
		}
		int returnValue = fact(num-1);
		return num * returnValue;
	}
	
	static void print(int num) {
		if(num==0) {
			return ;
		}
		
		//num--;
		//--num;
		//print(--num);
		if(num%2!=0) {
			System.out.println(num);
		}
		//System.out.println(num);
		print(num-1);
		if(num%2==0) {
		System.out.println(num);
		}
	}
	static int power(int num, int pow) {
		if(pow==0) {
			return 1;
		}
		int returnValue = power(num, pow -1);
		return num * returnValue;
	}
	static int countZeros(int num) {
		if(num==0) {
			return 0;
		}
		
		int returnValue = countZeros(num/10);
		// Post
		if(num%10==0) {
			returnValue++;
			
		}
		return returnValue;
		
	}
	static void countZeros(int num, int count) {
		if(num==0) {
			//return 0;
			System.out.println("Count is "+count);
			return ;
		}
		
		//int returnValue = countZeros(num/10);
		if(num%10==0) {
			count++;
			
		}
		// Pre
		countZeros(num/10, count);  // Tail Recursion
		//return returnValue;
		
	}
	static int sumOfDigit(int num) {
		if(num==0) {
			return 0;
		}
		
		int returnValue =  sumOfDigit(num/10);
		return returnValue + num % 10;
		
		
	}
	
	static String reverse(String str) {
		if(str.length()==1) {
			return String.valueOf(str.charAt(0));
		}
		String subString = str.substring(1);
		String returnValue = reverse(subString);
		//System.out.println(returnValue + " "+subString);
		return returnValue + str.charAt(0);
	}
	static void reverse(String str, String result) {
//		if(str.length()==1) {
//			return String.valueOf(str.charAt(0));
//		}
//		String subString = str.substring(1);
//		String returnValue = reverse(subString);
//		//System.out.println(returnValue + " "+subString);
//		return returnValue + str.charAt(0);
	}
	
	static void sumOfDigit(int num , int sum) {
		if(num==0) {
			System.out.println("Sum is "+sum);
			return;
		}
		sum = sum + num%10;
		num = num/10;
		sumOfDigit(num, sum);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//print(5);
		//System.out.println(fact(5));
		//System.out.println(power(2,3));
		//System.out.println(sumOfDigit(123));
		//sumOfDigit(123, 0);
		//countZeros(20607,0);
		//System.out.println(reverse("shyam"));
		//System.out.println(countZeros(20607));
		System.out.println(reverse("shyam"));
	}
}
