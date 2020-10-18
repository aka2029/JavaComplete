package dp;

public class DicePossiblites {
	// Rec
	static int countNoOfWays(int currentValue, int endValue) {
		if(currentValue == endValue) {
			return 1;
		}
		if(currentValue>endValue) {
			return 0; 
		}
		int count = 0;
		for (int dice = 1; dice<=6; dice++) {
			count = count + countNoOfWays(currentValue + dice, endValue);
		}
		return count;
	}
	// DP - MEM
	static int countNoOfWaysMem(int currentValue, int endValue, int cache []) {
		if(currentValue == endValue) {
			return 1;
		}
		if(currentValue>endValue) {
			return 0; 
		}
		if(cache[currentValue]!=0) {
			return cache[currentValue];
		}
		int count = 0;
		for (int dice = 1; dice<=6; dice++) {
			count = count + countNoOfWaysMem(currentValue + dice, endValue,cache);
		}
		return count;
	}
	
	static int countNoOfWaysTab(int currentValue, int endValue) {
		int cache[] = new int[endValue+ 1];
		cache[endValue] = 1;
		for(int i = endValue-1; i>=0; i--) {
			int count = 0;
			for(int dice = 1; dice<=6 && dice+i<cache.length; dice++) {
				count+=cache[dice+i];
			}
			cache[i] = count;
		}
		return cache[0];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int count = countNoOfWays(0,10);
		//System.out.println("Count is "+count);
//		int result = countNoOfWaysMem(0,10,new int[10+1]);
//		System.out.println(result);
		int result = countNoOfWaysTab(0,10);
		System.out.println(result);

	}

}
