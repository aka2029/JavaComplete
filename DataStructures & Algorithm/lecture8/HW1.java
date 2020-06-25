//	Pg-18 Doing maze problem using void

package lecture8;

public class HW1 {
	static void mazeProb(int startx, int starty, int endx, int endy, String resultVal) {
		if(startx > endx || starty > endy) {
			return;
		}
		
		if(startx == endx && starty == endy) {
			System.out.print(resultVal + " ");
			return;
		}
		
		//Horizontal
		mazeProb(startx + 1, starty, endx, endy, resultVal + "H");
		
		//Vertical
		mazeProb(startx, starty + 1, endx, endy, resultVal + "V");
		
		//Diagnol
		mazeProb(startx + 1, starty + 1, endx, endy, resultVal + "D");
	}
	
	public static void main(String[] args) {
		mazeProb(0,0,2,2,"");
	}

}
