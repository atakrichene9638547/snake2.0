package snake;
import java.awt.*;
public class apple {
	private double x,y,cote ; 
	public apple() {
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x ;
	}
	public double getY() {
		return y;
	}
	public void  setY(double y) {
		this.y = y ; 
	}
	public double getCote() {
		return cote;
	}
	
	
 public void draw(Graphics g ) {
	 g.setColor(Color.red);
	 g.fillRect((int)x,(int)y,(int)cote,(int)cote);
 }
}
