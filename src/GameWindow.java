import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class GameWindow extends JFrame {
  // private JLabel lbl[][] = new JLabel[10][10];       // number of buttons - can be changed
   private Container c;
   private GamePanel mainPanel = new GamePanel();


   public GameWindow()   {
      super( "Hacker Man" );
	
      //actionBtn1.setIcon(new ImageIcon("C:\\Users\\Tanzim\\Desktop\\Tej final proj\\star.png"));

      c = getContentPane();
      c.setLayout( new BorderLayout() );

      // create and add buttons
     

	  c.add( mainPanel, BorderLayout.CENTER  );
      setSize( 1162, 740 );                          //size of the window, can be changed
      setVisible(true);
      setResizable(false);
   }  
  
   public static void main( String args[] ) {
      GameWindow app = new GameWindow();

      app.addWindowListener(
         new WindowAdapter() {
            public void windowClosing( WindowEvent e )
            {
               System.exit( 0 );
            }
         }
      );
   } 
}