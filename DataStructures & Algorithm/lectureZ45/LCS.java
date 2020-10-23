package dp;

public class LCS {
	
	static int lcs(String first, String second) {
		if(first.length()==0 || second.length()==0) {
			return 0;
		}
		int count = 0;
		if(first.charAt(0) == second.charAt(0)) {
			count = 1 + lcs(first.substring(1), second.substring(1));
		}
		else {
			int firstResult = lcs(first.substring(1),second);
			int secondResult = lcs(first, second.substring(1));
			count = Math.max(firstResult, secondResult);
		}
		return count;
	}
	
	static int lcsMemo(String first, String second, int m , int n, int dp[][]) {
		if(m==0 || n==0) {
			return 0;
		}
		if(dp[m-1][n-1]!=0) {
			return dp[m-1][n-1];
		}
		
		if(first.charAt(0) == second.charAt(0)) {
			dp[m-1][n-1] = 1 + lcs(first.substring(1), second.substring(1));
			return dp[m-1][n-1];
		}
		else {
			int firstResult = lcs(first.substring(1),second);
			int secondResult = lcs(first, second.substring(1));
			dp[m-1][n-1] = Math.max(firstResult, secondResult);
			return dp[m-1][n-1];
		}
		
	}
	
	static int lcsTab(String first, String second, int m , int n) {
		int matrix [][] =new int[m+1][n+1];
		for(int i = 0 ; i<=m ; i++) {
			for(int j =0 ; j<=n ; j++) {
				if(i==0 || j==0) {
					matrix[i][j] = 0;
				}
				else
					if(first.charAt(i-1) == second.charAt(j-1)) {
						matrix[i][j] = matrix[i-1][j-1]+1;
					}
					else {
						matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]);
					}
			}
		}
		return matrix[m][n];
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		int r = lcs("abbg","agbg");
		int dp[][] = new int["abbg".length()]["agbg".length()];
		//int r = lcsMemo("abbg","agbg","abbg".length(),"agbg".length(),dp);
		int r = lcsTab("abbg", "agbg", "abbg".length(), "agbg".length());
		System.out.println(r);

	}

}
