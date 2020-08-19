import java.awt.Rectangle;

public class Map {
	
	
	//Set the Map:
	protected int mapArray1 [][] = {{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
			{2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,2},
			{2,2,2,2,2,2,1,2,2,1,2,2,2,2,2,2,2,2,2,2,2,2,2,1,2,2,1,2,2,2,2,2,2,2},
			{2,2,1,1,1,1,1,2,2,1,2,2,2,2,2,2,2,2,2,2,2,2,2,1,2,2,1,1,1,1,1,2,2,2},
			{2,2,1,2,2,2,1,2,2,1,2,1,1,1,1,1,1,1,1,1,1,1,2,1,2,2,1,2,2,2,1,2,2,2},
			{2,2,1,2,2,2,1,2,2,1,2,1,2,2,2,2,1,2,2,2,2,1,2,1,2,2,1,2,2,2,1,2,2,2},
			{2,2,1,2,2,2,1,2,2,2,2,1,1,2,2,2,1,2,2,2,1,1,2,2,2,2,1,2,2,2,1,2,2,2},
			{2,2,1,2,1,1,1,1,1,1,2,2,1,2,2,2,1,2,2,2,1,2,2,1,1,1,1,1,1,2,1,2,2,2},
			{2,2,1,2,1,2,2,2,2,1,1,1,1,2,2,2,1,2,2,2,1,1,1,1,2,2,2,2,1,2,1,2,2,2},
			{2,2,1,2,1,2,2,2,2,1,2,2,2,2,2,1,1,1,2,2,2,2,2,1,2,2,2,2,1,2,1,2,2,2},
			{2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2},
			{2,2,1,2,1,2,2,2,2,1,2,2,2,2,2,1,1,1,2,2,2,2,2,1,2,2,2,2,1,2,1,2,2,2},
			{2,2,1,2,1,2,2,2,2,1,2,1,1,1,1,2,1,2,1,1,1,1,2,1,2,2,2,2,1,2,1,2,2,2},
			{2,2,1,2,1,1,1,1,1,1,2,1,2,2,1,2,1,2,1,2,2,1,2,1,1,1,1,1,1,2,1,2,2,2},
			{2,2,1,2,2,2,1,2,2,2,2,1,2,2,1,2,1,2,1,2,2,1,2,2,2,2,1,2,2,2,1,2,2,2},
			{2,2,1,1,1,1,1,2,2,2,2,1,2,2,1,2,1,2,1,2,2,1,2,2,2,2,1,1,1,1,1,2,2,2},
			{2,2,2,2,2,2,1,2,2,2,2,1,2,2,2,2,1,2,2,2,2,1,2,2,2,2,1,2,2,2,2,2,2,2},
			{2,2,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,2},
			{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2},
			{2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2,2}};	
	
	//Get Map:
	public int[][] getMap1(){
		return mapArray1;
	}
	
	//Set the boundaries for where the Player is not allowed to move:
	public Rectangle[][] setWalls(){
		Rectangle rect[][] = new Rectangle[20][34];
		for (int i=0; i<mapArray1.length; i++)
			for (int k=0; k<mapArray1[0].length; k++)
					if (mapArray1 [i][k] == 2) 
						rect[i][k] = new Rectangle(k*35,i*35,35,35);
		
		return rect;
	}
	
	//Set the boundaries for where the Player is not to move and to find can be used to find position of Player:
	public Rectangle[][] setPath(){
		Rectangle rect[][] = new Rectangle[20][34];
		for (int i=0; i<mapArray1.length; i++)
			for (int k=0; k<mapArray1[0].length; k++)
					if (mapArray1 [i][k] == 1) 
						rect[i][k] = new Rectangle(k*35,i*35,35,35);
		
		return rect;
	}
	
	public Rectangle[][] setagentWalls(boolean[][]path){
		Rectangle rect[][] = new Rectangle[20][34];
		for (int i=0; i<mapArray1.length; i++)
			for (int k=0; k<mapArray1[0].length; k++)
					if (path [i][k]==false) 
						rect[i][k] = new Rectangle(k*35,i*35,35,35);
		
		return rect;
	}
	public Rectangle[][] setagentPaths(boolean[][]path){
		Rectangle rect[][] = new Rectangle[20][34];
		for (int i=0; i<mapArray1.length; i++)
			for (int k=0; k<mapArray1[0].length; k++)
					if (path [i][k]) 
						rect[i][k] = new Rectangle(k*35,i*35,35,35);
		
		return rect;
	}
}
