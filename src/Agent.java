import java.awt.Point;
import java.awt.Rectangle;

public class Agent implements Players {
	
	public int PX=17;
	public int PY=30;

	//Sets the Path of the agent to the Player:
	public boolean[][] agentPath(int[][]map, int StartX, int StartY, int EndX, int EndY) {
		 int[][] myMap = {{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1},
					{1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,0,1,1,1,1,1,1,1},
					{1,1,0,0,0,0,0,1,1,0,1,1,1,1,1,1,1,1,1,1,1,1,1,0,1,1,0,0,0,0,0,1,1,1},
					{1,1,0,1,1,1,0,1,1,0,1,0,0,0,0,0,0,0,0,0,0,0,1,0,1,1,0,1,1,1,0,1,1,1},
					{1,1,0,1,1,1,0,1,1,0,1,0,1,1,1,1,0,1,1,1,1,0,1,0,1,1,0,1,1,1,0,1,1,1},
					{1,1,0,1,1,1,0,1,1,1,1,0,0,1,1,1,0,1,1,1,0,0,1,1,1,1,0,1,1,1,0,1,1,1},
					{1,1,0,1,0,0,0,0,0,0,1,1,0,1,1,1,0,1,1,1,0,1,1,0,0,0,0,0,0,1,0,1,1,1},
					{1,1,0,1,0,1,1,1,1,0,0,0,0,1,1,1,0,1,1,1,0,0,0,0,1,1,1,1,0,1,0,1,1,1},
					{1,1,0,1,0,1,1,1,1,0,1,1,1,1,1,0,0,0,1,1,1,1,1,0,1,1,1,1,0,1,0,1,1,1},
					{1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1},
					{1,1,0,1,0,1,1,1,1,0,1,1,1,1,1,0,0,0,1,1,1,1,1,0,1,1,1,1,0,1,0,1,1,1},
					{1,1,0,1,0,1,1,1,1,0,1,0,0,0,0,1,0,1,0,0,0,0,1,0,1,1,1,1,0,1,0,1,1,1},
					{1,1,0,1,0,0,0,0,0,0,1,0,1,1,0,1,0,1,0,1,1,0,1,0,0,0,0,0,0,1,0,1,1,1},
					{1,1,0,1,1,1,0,1,1,1,1,0,1,1,0,1,0,1,0,1,1,0,1,1,1,1,0,1,1,1,0,1,1,1},
					{1,1,0,0,0,0,0,1,1,1,1,0,1,1,0,1,0,1,0,1,1,0,1,1,1,1,0,0,0,0,0,1,1,1},
					{1,1,1,1,1,1,0,1,1,1,1,0,1,1,1,1,0,1,1,1,1,0,1,1,1,1,0,1,1,1,1,1,1,1},
					{1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1,1,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1},
					{1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1}};


		 boolean[][]Find = new boolean[20][34];

		    Point[] path = new BFS().findPath(myMap, new Point(StartY, StartX), new Point(EndY, EndX));
		    for (Point point : path) {
		       // System.out.println(point.x + ", " + point.y);
		        Find[point.y][point.x]=true;
		    }
		    Find[PX][PY]=false;
		return Find;
	}
	//Gets the position of the Agent on the map:
	@Override
	public int getPos(int num) {
		if	(num==1)
			return PX;
		else
			return PY;
	}
	
	
	@Override
	public boolean[] getmove(Rectangle player, Rectangle[][]path, boolean[][]Path, int l, int m) {
		boolean[]move = new boolean[4];
		move[0]=true;//up
		move[1]=true;//down
		move[2]=true;//left
		move[3]=true;//right
		
		PX=l;
		PY=m;
		
		//System.out.print(PX+" "+PY);
		
		for (int i=0; i<Path.length; i++)
			for (int k=0; k<Path[0].length; k++) {
				if	(Path[PX-1][PY]==false)
					move[0]=false;
				if	(Path[PX+1][PY]==false)
					move[1]=false;
				if	(Path[PX][PY-1]==false) {
					//System.out.print(Path[PX-1][PY]);
					move[2]=false;
				}
				if	(Path[PX][PY+1]==false)
					move[3]=false;
			}
		
		return move;
	}

	@Override
	public boolean[] getMove(Rectangle[][] wall, Rectangle[][] path, int[][] mapArray1, Rectangle player, Rectangle up,
			Rectangle down, Rectangle left, Rectangle right) {
		// TODO Auto-generated method stub
		return null;
	}


}
