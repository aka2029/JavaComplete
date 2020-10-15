package dp;

public class SubSetSumProblem {

	static boolean subSetSumDP(int set[], int n, int sum) {
		boolean subSetMatrix [][] = new boolean[n+1][sum+1];
		// go to  all rows but col 0 and mark true
		for(int i = 0;i<=n; i++) {
			subSetMatrix[i][0] = true;
		}
		// cols of row 0 false
		for(int i = 0; i<=sum; i++) {
			subSetMatrix[0][i] = false;
		}
		// fill the remaining table
		for(int i = 1; i<=n; i++) {
			for(int j = 1; j<=sum; j++) {
				if(j<set[i-1]) {
					subSetMatrix[i][j] = subSetMatrix[i-1][j];
				}
				if(j>=set[i-1]){
					subSetMatrix[i][j] = subSetMatrix[i-1][j] || subSetMatrix[i-1][j-set[i-1]];
				}
			}
		}
		return subSetMatrix[n][sum];
	}
	static boolean subSetSum(int set[], int n , int sum) {
		//subset exist
		if(sum==0) {
			return true;
		}
		if(sum>0 && n==0) {
			return false;
		}
		// Ignore
		if(set[n-1]>sum) {
			return subSetSum(set, n-1, sum);
		}
		// include the last element in sum
		// or exclude the last element
		return subSetSum(set, n-1, sum) || subSetSum(set, n-1, sum-set[n-1]);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int set[] = {2,1,3,5};
		System.out.println(subSetSum(set, set.length, 4));
		//System.out.println(subSetSumDP(set, set.length, 4));
	}

}
