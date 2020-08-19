import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

 @SuppressWarnings("serial")
class GamePanel extends JPanel implements ActionListener, KeyListener {
	 
	int counter = 0;
	int Score;
	int pointScore;
	
	boolean dead = false;
	boolean Ply = false;
	boolean hack = false;
	
	Players P = new Player();
	Players A = new Agent();
	
	boolean[]Pc = new boolean[7];
	Rectangle[] PC = new Rectangle[7];
	
	boolean[][]agentpath = new boolean[20][34];
	boolean[][]agentpath2 = new boolean[20][34];
	boolean Amove = false;
	//initializing map:
	Map map = new Map();
	int[][]mapArray;
	
	int[][]pointArray;
	Rectangle pointRec[][] = new Rectangle[20][34];
	
	//Player initial coordinates:
	int x = 73, y = 38;
	
	//Agent initial coordinates:
	int Ax = 1050, Ay = 595;
	
	//Walls and paths available:
	Rectangle wall[][] = map.setWalls();
	Rectangle[][] path = map.setPath();
	
	Rectangle Agentpath[][];
	Rectangle AgentWalls[][];
	
	//Agent Directions
	boolean[] direction;
	boolean[] Adirection=new boolean[4];
	boolean[] Pdirection=new boolean[4];
	
	//All Agent blocks:
	Rectangle agent = new Rectangle(Ax, Ay+1, 35, 35);

	
	//All player blocks:
	Rectangle player = new Rectangle(x,y,20,20);
	Rectangle right = new Rectangle(x+20, y+1, 2, 17);
	Rectangle left = new Rectangle(x-2, y+1, 2, 17);
	Rectangle up = new Rectangle(x+3, y-3, 15, 2);
	Rectangle down = new Rectangle(x+3, y+20, 15, 2);

	 //Main menu gif:
	 Image image = Toolkit.getDefaultToolkit().createImage("ezgif.com-resize (1).gif");
	 
	 ImageIcon wallImage = new ImageIcon("block1.png");
	 
	 ImageIcon playImage= new ImageIcon("play.png");
	 ImageIcon pauseImage= new ImageIcon("pause.png");
	 ImageIcon PCImage= new ImageIcon("PC.png");
	 ImageIcon gameOver= new ImageIcon("gameover.jpg");
	 
	 ImageIcon PRight= new ImageIcon("right.png");
	 ImageIcon PLeft= new ImageIcon("left.png");
	 ImageIcon PUp= new ImageIcon("up.png");
	 ImageIcon PDown= new ImageIcon("down.png");
	 
	 //Buttons:
	 JButton playButton = new JButton("PLAY");
	 
	 JButton startButton = new JButton("Start");
	 JButton pauseButton = new JButton("Pause");
	 JButton controlButton = new JButton("Controls");
	 
	 //Animation Timer:
	 private Timer myTimer= new Timer( 30, this );
	 
	 JLabel JL = new JLabel("Score: "+Integer.toString(Score));
	 JLabel JL2 = new JLabel("Score: "+Integer.toString(Score));
	 Font bigFont = new Font("Arial", Font.BOLD, 18);
	 
	 //Different JPanel cards for different menus (ex: Game menu where the game takes place)
	 CardLayout cards;
		
		JPanel  HomeCard,menuCard, gameCard, gameoverCard, winnerCard, controlCard;
	 
	 public  GamePanel() { 
		  
		playButton.setForeground(new Color(94,30,156));
		playButton.setContentAreaFilled(false);
		playButton.setOpaque(false);
		playButton.setFocusPainted(false);
		playButton.setBorderPainted(false);
		playButton.setContentAreaFilled(false);
		setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		 
		startButton.setForeground(new Color(159,0,240));
		startButton.setContentAreaFilled(false);
		startButton.setOpaque(false);
		startButton.setFocusPainted(false);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		
		pauseButton.setForeground(new Color(159,0,240));
		pauseButton.setContentAreaFilled(false);
		pauseButton.setOpaque(false);
		pauseButton.setFocusPainted(false);
		pauseButton.setBorderPainted(false);
		pauseButton.setContentAreaFilled(false);
		setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
		 
		 controlButton.setBackground(Color.white);
		 controlButton.setForeground(new Color(110,217,161));
		 controlButton.setContentAreaFilled(false);
	          
	        
	        setBackground(new Color(0,0,0));				 
			addKeyListener(this);	
	        cards=new CardLayout();
			this.setLayout(cards);
			
			Music m = new Music();
			m.musicPlay();
			
			playButton.setFont(new Font("Arial Black", Font.BOLD, 15));
	        
			//The main Menu:
			HomeCard = new JPanel(){
			  
			  public void paintComponent(Graphics gr){
				  super.paintComponent(gr);
				  setBackground(new Color(4,2,5));
					playButton.setBounds(400, 240, 100, 130);
					
					if (image != null) {
					      gr.drawImage(image, 180, 45, this);
					    }
					
			  }
			};
			
			menuCard = new JPanel(){  
				  public void paintComponent(Graphics gr){		  
					super.paintComponent(gr);
					
					setBackground(new Color(41,54,63));
					//JL.setBounds(417, 570, 371, 101);
						
				  }
				  
				};
			
	        //Where the game takes place:
			gameCard = new JPanel(){
	           public void paintComponent(Graphics gr){
			      	super.paintComponent(gr);
			      	setBackground(new Color(0,0,0));
			      	m.musicStop();
			      	for (int i=0; i<mapArray.length; i++){
						 for (int k=0; k<mapArray[0].length; k++){
							 if (mapArray [i][k] == 2)
								gr.drawImage(wallImage.getImage(),k*35, i*35, null );
					
							 if (agentpath[i][k])
								 if	(Agentpath[i][k]!=null) {
									 //gr.fillRect(Agentpath[i][k].x, Agentpath[i][k].y,  (int)Agentpath[i][k].getWidth(), (int)Agentpath[i][k].getHeight());
								 }
						 	}
						}
			      	
			      	for (int i=0; i<pointArray.length; i++)
						 for (int k=0; k<pointArray[0].length; k++) {
							 if (pointArray [i][k] == 1) {
								 gr.fillRect(k*35+14, i*35+14, 7, 7);
								 pointRec[i][k]=new Rectangle(k*35+14, i*35+14, 7, 7);
							 }
							 else
								 pointRec[i][k]=null;
						 }
							 
			      	startButton.setBounds(6, 668, 40, 40);
			      	pauseButton.setBounds(42, 668, 40, 40);
					
			      	//Palyer box
			      	//gr.fillRect(x, y, 20, 20);
			      	if	((Pdirection[0]==Pdirection[1])&&(Pdirection[1]==Pdirection[2])&&(Pdirection[2]==Pdirection[3]))
			      		gr.drawImage(PRight.getImage(),x, y,null);
			      	if	(Pdirection[3])
			      		gr.drawImage(PRight.getImage(),x, y,null);
			      	if	(Pdirection[2])
			      		gr.drawImage(PLeft.getImage(),x, y,null);
			      	if	(Pdirection[1])
			      		gr.drawImage(PDown.getImage(),x, y,null);
			      	if	(Pdirection[0])
			      		gr.drawImage(PUp.getImage(),x, y,null);
			      	
			      	//Agent box
			      	gr.setColor(Color.WHITE);
			      	gr.fillRect(Ax, Ay, 35, 35);
			      	gr.setColor(Color.BLACK);
			      	gr.fillRect(0, 665, 1162, 40);
			      	gr.drawImage(playImage.getImage(),9,672,null);
			      	gr.drawImage(pauseImage.getImage(),49,672,null);
			      	
			      	if(Pc[0])
			      		gr.drawImage(PCImage.getImage(),16*35,10*35,null);
			        if(Pc[1])
			            gr.drawImage(PCImage.getImage(),0*35,10*35,null);
			        if(Pc[2])
			            gr.drawImage(PCImage.getImage(),32*35,10*35,null);
			        if(Pc[3])
			            gr.drawImage(PCImage.getImage(),13*35,15*35,null);
			        if(Pc[4])
			            gr.drawImage(PCImage.getImage(),19*35,15*35,null);
			        if(Pc[5])
			            gr.drawImage(PCImage.getImage(),8*35,5*35,null);
			        if(Pc[6])
			            gr.drawImage(PCImage.getImage(),24*35,5*35,null);
			        
			        gr.setColor(Color.white);
			       
			        JL2.setFont(bigFont);
			        JL2.setForeground(new Color(159,0,240));
			        JL2.setText("Score: "+Integer.toString(Score+pointScore));
			        JL2.setBounds(550, 660, 120, 50);
					
			        repaint();
					
				}	
			};

			gameoverCard = new JPanel(){ 
				public void paintComponent(Graphics gr){ 
			      super.paintComponent(gr);
			      setBackground(new Color(0,0,0));
			      gr.drawImage(gameOver.getImage(),330,230,null);
			      Font temp = new Font("Arial", Font.BOLD, 50);
			      JL.setFont(temp);
			      JL.setForeground(new Color(255,255,255));
			      JL.setText(Integer.toString(Score+pointScore));
			      JL.setBounds(550, 390, 500, 50);
			  }
	        };

	       winnerCard = new JPanel(){ 
				public void paintComponent(Graphics gr){
			      super.paintComponent(gr);
			      setBackground(new Color(0,0,0));
			  }
	        };

			controlCard = new JPanel(){ 
				public void paintComponent(Graphics gr){
			      super.paintComponent(gr);
			      setBackground(new Color(0,0,0));

			  }
	        };

			HomeCard.setLayout(new FlowLayout());
			HomeCard.add(playButton);
			playButton.addActionListener(this);
			
			gameCard.add(startButton);
			startButton.addKeyListener(this);
			startButton.addActionListener(this);
			gameCard.add(pauseButton);
			gameCard.add(JL2);
			pauseButton.addKeyListener(this);
			pauseButton.addActionListener(this);
			
			menuCard.setLayout(new FlowLayout());
			
			gameoverCard.setLayout(new FlowLayout());
			gameoverCard.add(JL);
			
			winnerCard.setLayout(new FlowLayout());
			
			addKeyListener(this);
			
		//Assigning names to cards to call upon:
	    add(HomeCard, "HomeName");
		add(menuCard, "MenuName");
	  	add(gameCard, "GameName");
	  	add(gameoverCard, "GameoverName");
		add(winnerCard, "WinName");
		
		//Add Keylistener to a specific JPanel:
		gameCard.addKeyListener(this);
		
		//The main Map:
		mapArray = map.getMap1();
		Map ma = new Map();
		pointArray = ma.getMap1();
		pointArray[1][2]=2;
		pointArray[17][30]=2;
		
		PC[0]=new Rectangle(16*35,10*35,35,35);
		PC[1]=new Rectangle(0*35,10*35,35,35);
		PC[2]=new Rectangle(32*35,10*35,35,35);
		PC[3]=new Rectangle(13*35,15*35,35,35);
		PC[4]=new Rectangle(19*35,15*35,35,35);
		PC[5]=new Rectangle(8*35,5*35,35,35);
		PC[6]=new Rectangle(24*35,5*35,35,35);
		Pc[0]=Pc[1]=Pc[2]=Pc[3]=Pc[4]=Pc[5]=Pc[6]=true;
		}

	@Override
	public void keyPressed(KeyEvent ev) {
		System.out.println(ev.getKeyCode() );
		if (ev.getKeyCode()==68){
				Pdirection[3]=true;
				Pdirection[1]=Pdirection[2]=Pdirection[0]=false;
				//x+=4;
			//Move right key: D
		}
		if (ev.getKeyCode()==83){			
				Pdirection[1]=true;
				Pdirection[3]=Pdirection[2]=Pdirection[0]=false;
				//y+=4;
			//Move down key: S
		}
		if (ev.getKeyCode()==87){			
				Pdirection[0]=true;
				Pdirection[3]=Pdirection[2]=Pdirection[1]=false;
				//y-=4;
			//Move up key: W
		}
		if (ev.getKeyCode()==65){
				Pdirection[2]=true;
				Pdirection[3]=Pdirection[1]=Pdirection[0]=false;
				//x-=4;
			//Move left key: A
		}
		if (ev.getKeyCode()==80)
			hack = true;
		//Hack PC key: P
	}

	@Override
	public void keyReleased(KeyEvent arg0) {
	}

	@Override
	public void keyTyped(KeyEvent arg0) {		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if (e.getSource()==myTimer){
			if	(Ply&&!dead) {
			//levelButton.doClick();
			player = new Rectangle(x,y,20,20);
			agent = new Rectangle(Ax, Ay, 35, 35);
			
			//Player Collision Blocks:
			right = new Rectangle(x+20, y+1, 2, 17);
			left = new Rectangle(x-2, y+1, 2, 17);
			up = new Rectangle(x+3, y-3, 15, 2);
			down = new Rectangle(x+3, y+20, 15, 2);
			
			
			//Set the directions the player is allowed to move:
			direction = P.getMove(wall,path,mapArray,player,up,down,left,right);
			
			agentpath[A.getPos(1)][ A.getPos(2)]=true;
			AgentWalls = map.setagentWalls(agentpath);
			Agentpath = map.setagentPaths(agentpath);
			

			for (int i=0; i<Agentpath.length; i++){
				 for (int k=0; k<Agentpath[0].length; k++){
					 if	(Agentpath[i][k]!=null) {
						 if	((Agentpath[i][k].x==agent.x)&&(Agentpath[i][k].y==agent.y)) {
							 agentpath = A.agentPath(mapArray, P.getPos(1), P.getPos(2), A.getPos(1), A.getPos(2));
							 //System.out.print("TRU "+i+" "+k);
							 Adirection = A.getmove(agent, Agentpath, agentpath, i, k);
						 }
					 }
				 }
			}
			
			if	(counter==0) {
				if	(Amove) {
					if	(Adirection[2])
						Ax-=5;
					else if	(Adirection[0])
						Ay-=5;
					else if	(Adirection[3])
						Ax+=5;
					else if	(Adirection[1])
						Ay+=5;
				}
			}
			
			if	(Pdirection[2])
				if	(direction[2])
					x-=4;
			if	(Pdirection[0])
				if	(direction[0])
					y-=4;
			if	(Pdirection[3])
				if	(direction[3])
					x+=4;
			if	(Pdirection[1])
				if	(direction[1])
					y+=4;
			
			for (int i=0;i<PC.length;i++)
				if (player.intersects(PC[i])||right.intersects(PC[i])||left.intersects(PC[i])||up.intersects(PC[i])||down.intersects(PC[i]))
					if	(hack) {
						counter = 100;
						Pc[i]=false;
						hack=false;
						Score+=10;
					}
			
			if	(counter>0)
				counter--;
			
			if (player.intersects(agent)) {
				dead = true;
				cards.show(this, "GameoverName");
			}
			
			for (int i=0; i<pointArray.length; i++){
				 for (int k=0; k<pointArray[0].length; k++){
					if(pointRec[i][k]!=null)
						if	(player.intersects(pointRec[i][k])) {
							pointScore++;
							pointArray[i][k]=2;
						}
							
				 }
			}
			
			}
		}
		
		else{
			JButton b= (JButton)e.getSource();	   
		if (b.getText().equals("PLAY")){
			cards.show(this, "GameName");
			
			myTimer.start();
			
			}
		if (b.getText().equals("Start")){
			Amove=true;
			Ply=true;
			}
		if (b.getText().equals("Pause")){
			Amove=false;
			Ply=false;
			}
		}
	}
	
 }