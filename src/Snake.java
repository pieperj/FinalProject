import java.awt.Color;
import java.awt.Graphics;

public class Snake {
	
	private int sideLength, x, y;
	
	public Snake(int sideLength, int x, int y) {
		this.sideLength = sideLength;
	}

	public int getSideLength() {
		return sideLength;
	}

	public void setSideLength(int sideLength) {
		this.sideLength = sideLength;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}
