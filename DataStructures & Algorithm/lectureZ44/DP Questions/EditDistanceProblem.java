package dp;

public class EditDistanceProblem {

	static int ed(String first, String second, int m ,int n) {
		if(m==0) {
			return n;
		}
		if(n==0) {
			return m;
		}
		if(first.charAt(m-1)==second.charAt(n-1)) {
			return ed(first, second, m-1, n-1);
		}
		int insert = ed(first, second, m, n-1);
		int delete = ed(first, second, m-1, n);
		int replace = ed(first, second, m-1, n-1);
		int min = Math.min(insert, delete);
		return 1 + Math.min(min, replace);
	}
	
	static int edDP(String first, String second) {
		int m = first.length();
		int n = second.length();
		int matrix [][] = new int[m+1][n+1];
		for(int i = 0; i<=m;i++) {
			for(int j = 0; j<=n; j++) {
				if(i==0) {
					matrix[i][j] = j;
				}
				else
				if(j==0) {
					matrix[i][j] = i;
				}
				else
					if(first.charAt(i-1) == second.charAt(j-1)) {
						matrix[i][j]= matrix[i-1][j-1];
					}
					else {
						int insert = matrix[i][j-1];
						int del = matrix[i-1][j];
						int replace = matrix[i-1][j-1];
						int result = Math.min(insert, del);
						matrix[i][j] = 1 + Math.min(result, replace);
					}
					
			}
		}
		return matrix[m][n];
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result =ed("sunday","saturday","sunday".length(),"saturday".length());
		result = edDP("sunday", "saturday");
		System.out.println(result);

	}

}
