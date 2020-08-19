import java.awt.Rectangle;

public class Player implements Players {

		public int PX=0;
		public int PY=0;
		
	//Gets where the agent is allowed to move depending on position (Player collisions):
	@Override
	public boolean[] getMove(Rectangle[][] wall,Rectangle[][] path,int mapArray1[][],Rectangle player, Rectangle up,Rectangle down,Rectangle left,Rectangle right) {
		
		boolean[]move = new boolean[4];
		move[0]=true;//up
		move[1]=true;//down
		move[2]=true;//left
		move[3]=true;//right
		
		for (int i=0; i<path.length; i++)
			for (int k=0; k<path[0].length; k++)
				if	(mapArray1[i][k]==1)
					if (player.intersects(path[i][k])) {
						PX=i;
						PY=k;
					}
		
		for (int i=0; i<wall.length; i++)
			for (int k=0; k<wall[0].length; k++) {
				if	(mapArray1[i][k]==2) {
					if (up.intersects(wall[i][k]))
						move[0]=false;
					if (down.intersects(wall[i][k]))
						move[1]=false;
					if (left.intersects(wall[i][k]))
						move[2]=false;
					if (right.intersects(wall[i][k]))
						move[3]=false;
				}
			}
		
		return move;
	}

	@Override
	public boolean[][] agentPath(int[][] map,int StartX, int StartY, int EndX, int EndY) {
		// TODO Auto-generated method stub
		return null;
	}
	
	//Gets the player position on the map:
	public int getPos(int num) {
		if	(num==1) {
			return PX;
		}
		else
			return PY;
	}

	@Override
	public boolean[] getmove(Rectangle player, Rectangle[][] path, boolean[][] Path, int l, int m) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
