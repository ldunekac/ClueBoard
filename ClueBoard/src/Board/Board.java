package Board;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JOptionPane;

public class Board {
	private ArrayList<BoardCell> cells;
	private Map<Character, String> rooms;
	private int numRows;
	private int numColumns;

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
		catch (BadConfigFormatException e)
		{
			String error = "Bad ConfigureationFile.\n See ErrorLog.txt for more information";
			JOptionPane.showMessageDialog(null,error);
			System.exit(1);
		}
		finally  // TODO Close File
		{
			rooms = initBoard.getRoomMap();
			cells = initBoard.getBoardCells();
			numRows = initBoard.getNumberOfRows();
			numColumns = initBoard.getNumberOfColumns();
		}
		
	}
	
	public int calcIndex(int row, int column) {
		int retn = column + row * numRows;
		return retn;
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
		return "NOPE";//((RoomCell)cells.get(location)).getDirection();
	}
	
	public String getRoomNameAt(int row, int column)
	{
		return "NOT A ROOM";// rooms.get(cells.get(calcIndex(row,column)).getCellCharacter());
	}
}
