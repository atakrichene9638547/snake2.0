package snake;
import javax.swing.*;
import java.util.ArrayList; // import the ArrayList class
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class serpent extends JPanel implements KeyListener  {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int x = 100;
	private int y=100;
	private  int cote =20;
	private final int coef =10; 
	private  int vitesseX=1 ; 
	private int vitesseY= 0 ;
	public int nbPoints=0 ; 
	private int total=0;
	private ArrayList<serpent> tab = new ArrayList<>(total) ;
	
	public int getCoef(){
		return coef; 
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x= x;
	}
	public int getY() {
		return y ; 
	}
	public void setY( int y) {
		this.y = y ;
	}

	public void draw(Graphics g) { //tsawer carré
		Graphics graph2 = (Graphics2D) g ;
		graph2.fillRect(x, y, cote, cote);
		graph2.setColor(Color.black);
	}
	
	 serpent () {
	  }
	 
	 
	 private void move() {  //3_change direction
		 this.x = this.x + this.vitesseX; 
		 this.y = this.y + this.vitesseY;
	 }	
	 
	 private void dir(int vitessX, int vitesseY) {   //2_change vitesse
		 this.vitesseX +=vitesseX*coef;
		 this.vitesseY +=vitesseY*coef;
	 }
	 public void plusRect(apple pomme) { // ki yekel toffeha yetwel
			if (this.eatApple(pomme)) {
				++total ; 
			};
			for(int i=0 ;i<total;i++) {
				tab.get(i).draw(null);
			}
		}
	 
	 public void update() { //4_à mettre dans fenestra
	
		 while(true)
		 {
			 this.move() ;
			 }	 
	 }
	@Override
	public void keyPressed(KeyEvent e) { // 1_donne instruction
		// TODO Auto-generated method stub
		int keyCode = e.getKeyCode() ;
		switch(keyCode) {
		case KeyEvent.VK_Z :
			  this.dir(0,-1) ;
			  break ;
		case KeyEvent.VK_S :
			  this.dir(0, 1);
			  break;
		case KeyEvent.VK_D :
			this.dir(1, 0);
			break ; 
		case KeyEvent.VK_Q :
			this.dir(-1, 0);
			break;
		default : 
			
		}
		
	}
	
	//public apple pomme = new apple();
	public boolean eatApple(apple pomme) { 
		double dist =Math.sqrt(Math.pow(this.x-pomme.getX(),2)+
				Math.pow(this.y-pomme.getY(),2));
		
		if (dist <2) {
			return true ;
		}
		return false ; 
		
	}
	
	public int getNbPoints() {
		return nbPoints;
	}
	
	public void changePosition(apple pomme) {
			double x = Math.random()*600;
			double y = Math.random()*600; 
			pomme.setX(x);
			pomme.setY(y);
			++nbPoints;
	}
	
	
	public boolean gameOver() {
		if(this.x>= 600 || this.y>=600 || this.x<=0 || this.y<=0) {
		return true ; 
		}
		else return false ;
	}

	
	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}
}

