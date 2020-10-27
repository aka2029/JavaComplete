package dp;

public class MCP {

	static int mcp(int cost[][], int m , int n) {
		if(n<0 || m<0) {
			return Integer.MAX_VALUE;
		}
		else
		if(m==0 && n==0) {
			return cost[m][n];
		}
		return cost[m][n] + Math.min(Math.min(mcp(cost, m-1, n-1), mcp(cost, m-1, n)), mcp(cost, m, n-1));
	}
	
	static int mcpTab(int cost[][]) {
		int result [][] = new int[cost.length][cost.length];
		result[0][0] = cost[0][0];
		for(int i = 1; i<result.length; i++) {
			result[i][0] = result[i-1][0] + cost[i][0];
		}
		for(int i = 1; i<result.length; i++) {
			result[0][i] = result[0][i-1] + cost[0][i];
		}
		for(int i = 1; i<result.length; i++) {
			for(int j= 1; j<result.length; j++) {
				result[i][j]= Math.min(Math.min(result[i-1][j-1], result[i-1][j]),result[i][j-1]) + cost[i][j];
			}
		}
		return result[result.length-1][result.length-1];
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int matrix [][]= {
				{2,0,6},
				{3,1,7},
				{4,5,9}
		};
		System.out.println(mcp(matrix,matrix.length-1,matrix[0].length-1));
		System.out.println(mcpTab(matrix));
	}

}
