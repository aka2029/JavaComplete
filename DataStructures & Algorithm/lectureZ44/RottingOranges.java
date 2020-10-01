package interviews;

import java.util.LinkedList;

class RPair{
	int row, col;
	RPair(int row, int col){
		this.row = row;
		this.col = col;
	}
	@Override
	public String toString() {
		return "Row "+row+" Col "+col;
	}
}
class Solution{
	 public static int orangesRotting(int[][] grid) {
	        int rows = grid.length;
	        int cols = grid[0].length;
	        int freshOranges = 0;
	        LinkedList<RPair> queue = new LinkedList<>();
	        for(int i = 0; i<rows; i++) {
	        	for(int j =0; j<cols; j++) {
	        		if(grid[i][j]==2) {
	        			RPair pair = new RPair(i,j);
	        			queue.addLast(pair);
	        			
	        		}
	        		else {
	        			if(grid[i][j]==1) {
	        				freshOranges++;
	        			}
	        		}
	        	}
	        }
	        // First Pick the Rotton Orange (e.g Queue)
	     // Check the Neighbours
	        int directions [][] = {{-1,0}, {0,1},{1,0},{0,-1}};
	        
	        // minute Compute
	        int mins = -1;
	        queue.addLast(new RPair(-1, -1));
	        while(!queue.isEmpty()) {
	        	RPair pair = queue.removeFirst();
	        	if(pair.row==-1) {
	        		mins++;
	        		if(!queue.isEmpty()) {
	        			queue.addLast(new RPair(-1, -1));
	        		}
	        	}
	        	for(int direction = 0; direction<directions.length; direction++) {
	        		int neighbourRow = pair.row + directions[direction][0];
	        		int neighbourCol = pair.col + directions[direction][1];
	        		if((rows>neighbourRow && neighbourRow>=0) && (cols>neighbourCol && neighbourCol>=0)) {
	        			if(grid[neighbourRow][neighbourCol]==1) {
	        				grid[neighbourRow][neighbourCol] = 2;
	        				freshOranges--;
	        				RPair p= new RPair(neighbourRow, neighbourCol);
	        				queue.addLast(p);
	        			}
	        		}
	        	}
	        }
	        
	       
	       return freshOranges==0? mins : -1;
	    }
}
public class RottingOranges {

	public static void main(String[] args) {
		int grid [][] = {{2,1,1},{1,1,0},{0,1,1}};
		int result = Solution.orangesRotting(grid);
		System.out.println(result);
		// TODO Auto-generated method stub

	}

}
