package Board;

public class WalkwayCell extends BoardCell {

	public WalkwayCell(char type)
	{
		cellIdentifer = type;
	}
	
	@Override
	public boolean isWalkway() {
		return true;
	}
}
