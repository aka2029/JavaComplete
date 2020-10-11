package interviews;

public class NumberOfIslands {
public static int numIslands(int[][] grid) {
        int rows= grid.length;
        int cols = grid[0].length;
        if(rows==0) {
        	return 0;
        }
        int noofIslands = 0;
        for(int row= 0; row<rows; row++) {
        	for(int col = 0; col<cols; col++) {
        		if(grid[row][col]==1) {
        			checkArea(grid, row, col, rows, cols);
        			noofIslands++;
        		}
        	}
        }
        return noofIslands;
    }
static void checkArea(int grid[][], int row, int col , int rows, int cols) {
	grid[row][col]=0;
	// Check on all 4 direction
	// Up
	if(row-1>=0 && grid[row-1][col]==1) {
		checkArea(grid, row-1, col, rows, cols);
	}
	// down
	if(row+1<rows && grid[row+1][col]==1) {
		checkArea(grid, row+1, col, rows, cols);
	}
	//left
	if(col-1>=0 && grid[row][col-1]==1) {
		checkArea(grid, row, col-1, rows, cols);
	}
	// right
	if(col+1<cols && grid[row][col+1]==1) {
		checkArea(grid, row, col+1, rows, cols);
	}
}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int grid[][] =  {
				{1,1,0,0,0},
				{1,1,0,0,0},
				{0,0,1,0,0},
				{0,0,0,1,1}
		};
		int result = numIslands(grid);
		System.out.println(result);

	}

}
