package Board;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JOptionPane;

import Board.RoomCell.DoorDirection;

public class Board {
	private ArrayList<BoardCell> cells;
	private Map<Character, String> rooms;
	private int numRows;
	private int numColumns;
	private int numberOfRooms;

	public Board()
	{
		__init__("boardConfig.csv", "legendConfig.txt");
	}
	
	public Board(String boardFileName)
	{
		__init__(boardFileName, "legendConfig.txt");
	}
	public Board(String boardFileName, String logFileName)
	{
		__init__(boardFileName, logFileName);
	}
	
	public void __init__(String boardFileName, String logFileName)
	{
		InitializeBoard initBoard = new InitializeBoard(boardFileName, logFileName);
		try {
			initBoard.loadFiles();
		} 
		catch (FileNotFoundException e) 
		{
			String error = boardFileName + " or " +  logFileName + " was not found.";
			JOptionPane.showMessageDialog(null,error);
			System.exit(1);
		} 
		// THIS IS COMMENTED OUT FOR TESTING PURPOSES
	//	catch (BadConfigFormatException e)
	//	{
	//		String error = "Bad ConfigureationFile.\n See ErrorLog.txt for more information";
	//		JOptionPane.showMessageDialog(null,error);
	//		System.exit(1);
	//	}
		finally  // TODO Close File
		{
			rooms = initBoard.getRoomMap();
			cells = initBoard.getBoardCells();
			numRows = initBoard.getNumberOfRows();
			numColumns = initBoard.getNumberOfColumns();
			numberOfRooms = initBoard.getNumberOfRooms();
		}
		
	}
	
	public int calcIndex(int row, int column) {
		int retn = (column - 1) + (row - 1) * (numRows + 1);
		return retn;
	}

	public BoardCell GetRoomCellAt(int row, int column) {
		return null;
	}
	
	public int numberOfRooms()
	{ 
		int rtn = numberOfRooms;
		return rtn;
	}
	
	public String roomNameWithChar(char c)
	{ // Does not check errors
		String rtn = rooms.get(c);
		return rtn;
	}
	
// FUNCTIONS FOR TESTING ONLY
	
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
		return numColumns;
	}
	
	public BoardCell cellAt(int row, int column)
	{ // returns a cell at a row and column
		int location = calcIndex(row, column);
		return cells.get(location);
	}
	
	public String getDoorDirection(int row, int column)
	{
		int location = calcIndex(row, column);
		if (cells.get(location) instanceof RoomCell )
			return ((RoomCell)cells.get(location)).getDirection();
		return "NONE";
			
	}
	
	public String getRoomNameAt(int row, int column)
	{
		int cal = calcIndex(row, column);
		String s = rooms.get(cells.get(calcIndex(row,column)).getCellCharacter());
		return s;
	}
}
