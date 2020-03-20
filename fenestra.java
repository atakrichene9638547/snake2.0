package snake;
 
import javax.swing.JFrame;
import javax.swing.JPanel;




public class fenestra extends JFrame   {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
			private int height =600;
			private int width =600;
		public void echec(serpent snake) {
			if (snake.gameOver()) {
				System.exit(-1);
			}
		}
	fenestra() {
		setBounds(250,250,height,width) ;
		setTitle("Snake");
		setVisible(true);
		serpent snake = new serpent() ;
		snake.draw(getGraphics()) ;
		((JPanel)snake).setVisible(true);
		
		
		apple pomme = new apple() ;
		pomme.draw(getGraphics());
		
		/*int col = (height/ snake.getCoef());      // 
		int row = (width/ snake.getCoef()) ;*/
		
		
		
		do {
			snake.update() ;
			if(snake.eatApple(pomme)) {
				snake.changePosition(pomme);
				snake.plusRect(pomme) ;
				System.out.println(snake.getNbPoints());
			}; 
		}while (!snake.gameOver()) ; 

		echec(snake) ;
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE) ;
	}

}
