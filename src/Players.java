import java.awt.Rectangle;

public interface Players {
	boolean[][] agentPath(int[][]map,int StartX, int StartY, int EndX, int EndY);
	int getPos(int num);
	boolean[] getMove(Rectangle[][] wall, Rectangle[][] path, int[][] mapArray1, Rectangle player, Rectangle up,
			Rectangle down, Rectangle left, Rectangle right);
	boolean[] getmove(Rectangle player, Rectangle[][] path, boolean[][] Path, int l, int m);
}
