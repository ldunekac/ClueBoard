package Board;

import java.util.ArrayList;
import java.util.Map;

public class Board {
	private ArrayList<BoardCell> cells;
	private Map<Character, String> rooms;
	private int numRows;
	private int numColums;

	public Board()
	{
		cells = new ArrayList<BoardCell>();
	}
	public Board(String fileName)
	{
		
	}
	
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
		return -1;
	}
	
	public String roomNameWithChar(char c)
	{ // Does not check errors
		return "NOPE SORRY";//rooms.get(c);
	}
	
// FUNCTIONS FOR TESTING ONLY
	
	public ArrayList<BoardCell> getBoard()
	{
		return cells;
	}
	
	public int getNumberRow()
	{
		return -1;// numRows;
	}
	
	public int getNumberColumn()
	{
		return -1;// numColums;
	}
	
	public BoardCell cellAt(int row, int column)
	{ // returns a cell at a row and column
		int location = calcIndex(row, column);
		return cells.get(location);
	}
	
	public String getDoorDirection(int row, int column)
	{
		int location = calcIndex(row, column);
		return "NOPE";//((RoomCell)cells.get(location)).getDirection();
	}
	
	public String getRoomNameAt(int row, int column)
	{
		return "NOT A ROOM";// rooms.get(cells.get(calcIndex(row,column)).getCellCharacter());
	}
}
