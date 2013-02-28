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
	public void draw(Graphics g) {

	}

	// FOR TESTING PURPOSES ONLY
	public DoorDirection getDirection()
	{
		return doorDirection;
	}
}
