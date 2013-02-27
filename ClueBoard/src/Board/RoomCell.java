package Board;

import java.awt.Graphics;

public class RoomCell extends BoardCell {
	enum DoorDirection {
		UP, DOWN, LEFT, RIGHT, NONE
	}

	private DoorDirection doorDirection;
	private char roomInitial;

	@Override
	public void draw(Graphics g) {

	}

}
