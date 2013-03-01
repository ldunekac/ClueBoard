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
		__init__(roomName, DoorDirection.NONE);
	}
	
	public RoomCell(char roomName, DoorDirection direction)
	{
		__init__(roomName, direction);
	}
	
	private void __init__(char roomName, DoorDirection direction)
	{
		cellIdentifer = roomName;
		doorDirection = direction;
	}
	@Override
	public boolean isRoom() {
		return true;
	}
	
	@Override
	public boolean isDoorway() {
		if(doorDirection == DoorDirection.NONE)
			return false;
		else
			return true;
	}
	
	@Override
	public void draw(Graphics g) {

	}

	// FOR TESTING PURPOSES ONLY
	public String getDirection()
	{
		switch (doorDirection)
		{
			case DOWN : return "DOWN";
			case UP : return "UP";
			case RIGHT: return "RIGHT";
			case LEFT: return "LEFT";
			default: return "NONE";
		}
	}
}
