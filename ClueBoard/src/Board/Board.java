package Board;

import java.util.ArrayList;
import java.util.Map;

public class Board {
	private ArrayList<BoardCell> cells;
	private Map<Character, String> rooms;
	private int numRows;
	private int numColums;

	public void loadConfigFiles() {

	}

	public int calcIndex(int row, int column) {
		return column + row * numRows;
	}

	public BoardCell GetRoomCellAt(int row, int column) {
		return null;
	}
	
	public int numberOfRooms()
	{
		return rooms.size();
	}
	
	public String roomNameWithChar(char c)
	{ // Does not check errors
		return rooms.get(c);
	}
	
	public ArrayList<BoardCell> getBoard()
	{
		return cells;
	}
	
	public int getNumberRow()
	{
		return numRows;
	}
	
	public int getNumberColumn()
	{
		return numColums;
	}
}
