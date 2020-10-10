package dp;

public class KnapSackProblem {
	
	static int knapSack(int weights[], int values[], int maxWeight, int index){
		if(index == weights.length || maxWeight==0) {
			return 0;
		}
		if(weights[index]>maxWeight) {
			return knapSack(weights,values, maxWeight , index + 1);
		}
		else {
			int optionA = values[index] + knapSack(weights, values, maxWeight - weights[index], index+1);
			int optionB = knapSack(weights, values, maxWeight, index+1);
			return Math.max(optionA, optionB);
		}
	}
	
	static int knapSackDP(int maxWeight, int wt[], int val[], int n) {
		int matrix[] [] = new int[n+1][maxWeight+1];
		for(int i = 0; i<=n ; i++) {
			for(int w =0; w<=maxWeight; w++) {
				if(i==0 || w==0) {
					matrix[i][w] = 0;
				}
				else
				if(wt[i-1]<=w) {
					matrix[i][w]= Math.max(val[i-1]+matrix[i-1][maxWeight-wt[i-1]], matrix[i-1][w]);
				}
				else {
					matrix[i][w]  = matrix[i-1][w];
				}
			}
		}
		return matrix[n][maxWeight];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int weights[] = {1,2,2};
		int values [] = {60,100,120};
		int maxWeight = 3;
		int result = knapSack(weights, values, maxWeight,0);
		result = knapSackDP(maxWeight, weights,values,values.length);
		System.out.println(result);
	}

}
