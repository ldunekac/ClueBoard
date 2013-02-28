package Board;

import java.awt.Graphics;

public class RoomCell extends BoardCell {
	enum DoorDirection {
		UP, DOWN, LEFT, RIGHT, NONE
	}

	private DoorDirection doorDirection;
	private char roomInitial;

	public RoomCell(char roomName)
	{
		cellCharacter = roomName;
	}
	
	@Override
	public void draw(Graphics g) {

	}

	// FOR TESTING PURPOSES ONLY
	public String getDirection()
	{
		if(doorDirection == DoorDirection.UP) return "UP";
		if(doorDirection == DoorDirection.DOWN) return "DOWN";
		if(doorDirection == DoorDirection.LEFT) return "LEFT";
		if(doorDirection == DoorDirection.RIGHT) return "RIGHT";
		return "NONE";
	}
}
