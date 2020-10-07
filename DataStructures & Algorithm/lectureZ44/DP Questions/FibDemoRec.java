package dp;

public class FibDemoRec {
	
	static int fib(int n ) {
		if(n==0 || n==1) {
			return n;
		}
		int first = fib(n-1);
		int second = fib(n-2);
		int sum = first + second;
		return sum;
	}
	
	static int memo(int n , int cache[]) {
		if(n==0 || n==1) {
			return n;
		}
		if(cache[n]!=0) {
			System.out.println("FROM CACHE");
			return cache[n];
		}
		int first = memo(n-1, cache);
		int second = memo(n-2,cache);
		int sum = first + second;
		cache[n] = sum;
		System.out.println("Not From Cache");
		return cache[n];
	}
	
	static int tabulation(int n) {
		int cache [] = new int [n+1];
		cache[0] = 0 ;
		cache[1] = 1;
		for(int i = 2; i<=n ; i++) {
			cache[i]= cache[i-1] + cache[i-2];
		}
		return cache[n];
	}
	public static void main(String[] args) {
		int nth = 10;
		//int cache[] = new int[nth+1];
		//System.out.println(memo(nth,cache));
		//System.out.println(memo(nth,cache));
		System.out.println(tabulation(nth));
	}

}
