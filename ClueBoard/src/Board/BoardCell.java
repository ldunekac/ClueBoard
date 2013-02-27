package Board;

import java.awt.Graphics;

public abstract class BoardCell {
	private int row;
	private int column;

	public boolean isWalkway() {
		return false;
	}

	public boolean isRoom() {
		return false;
	}

	public boolean isDoorway() {
		return false;
	}

	public void draw(Graphics g) {

	}

}
