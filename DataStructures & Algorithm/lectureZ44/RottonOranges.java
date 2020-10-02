package graph;

import java.util.LinkedList;

class RPair{
	int row;
	int col;
	RPair(int row, int col){
		this.row = row;
		this.col = col;
	
	}
}

public class RottonOranges {
	
	
	static int oranges(int grid[][]) {
		int rows = grid.length;
		int cols = grid[0].length;
		int min =0;
		int freshOranges = 0;
		LinkedList<RPair> queue = new LinkedList<>();
		for(int i=0;i<rows; i++) {
			for(int j= 0; j<cols; j++) {
				if(grid[i][j]==2) {
					RPair pair = new RPair(i,j);
					queue.add(pair);
				}
				else {
					if(grid[i][j]==1) {
						freshOranges++;
					}
				}
			}
		}
		return min;
	}

	public static void main(String[] args) {
		int grid [][] = {{2,1,1,},{1,1,0},{0,1,1}};
		int min = oranges(grid);
		System.out.println(min);

	}

}
