package dp;

public class ClimbStair {
	
	static int countClimb(int n) {
		if(n==1 || n==0) {
			return 1;
		}
		if(n==2) {
			return 2;
		}
		else
		return countClimb(n-1) + countClimb(n-2);
	}
	
	
	static int countClimbTab(int n) {
		int cache [] = new int [n+1];
		cache[1] = 1 ;
		cache[2] = 2;
		for(int i = 3; i<=n ; i++) {
			cache[i]= cache[i-1] + cache[i-2];
		}
		return cache[n];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result = countClimbTab(4);
		System.out.println(result);

	}

}
