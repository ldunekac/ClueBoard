package clueGame;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Map;

import javax.swing.JOptionPane;

import clueGame.RoomCell.DoorDirection;


/* DESCRIPTION
 * 
 * This class keeps tracks of all the cells in the game
 * 
 * Board calls InitializeBoard to get all of the board contents
 * 
 * and handles any error that are thrown by the InitializeBoard class
 */

public class Board {
	private ArrayList<BoardCell> cells;
	private Map<Character, String> rooms;
	private int numRows;
	private int numColumns;
	private int numberOfRooms;

	private String boardConfigFile;
	private String legendConfigFile;
	
	// THE ONLY REASION THE CONSTRUCTORS THROW AN EXCEPTION IS FOR 
	// THE TEACHERS TESTS ONLY
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
	
	public void __init__(String boardFileName, String legendFileName)
	{
		boardConfigFile = boardFileName;
		legendConfigFile = legendFileName;
			//try {

	//	} 
		// THIS IS COMMENTED OUT FOR TESTING PURPOSES
		//catch (FileNotFoundException e) 
		//{
		//	String error = boardFileName + " or " +  logFileName + " was not found.";
		//	JOptionPane.showMessageDialog(null,error);
		//	System.exit(1);
		//} 
		// THIS IS COMMENTED OUT FOR TESTING PURPOSES
	//	catch (BadConfigFormatException e)
	//	{
	//		String error = "Bad ConfigureationFile.\n See ErrorLog.txt for more information";
	//		JOptionPane.showMessageDialog(null,error);
	//		System.exit(1);
	//	}
		//finally 
		//{
		
		//}
		
	}
	
	
	public void loadConfigFiles() throws FileNotFoundException
	{
		BoardFactory initBoard = new BoardFactory(boardConfigFile, legendConfigFile);
		initBoard.loadFiles();
		rooms = initBoard.getRoomMap();
		cells = initBoard.getBoardCells();
		numRows = initBoard.getNumberOfRows();
		numColumns = initBoard.getNumberOfColumns();
		numberOfRooms = initBoard.getNumberOfRooms();
	}
	public int calcIndex(int row, int column) {
		row = row + 1;
		column = column + 1;
		return (column - 1) + (row - 1) * (numRows + 1);
	}

	public BoardCell GetRoomCellAt(int row, int column) {
		return null;
	}
	
	public int numberOfRooms()
	{ 
		return numberOfRooms;
	}
	
	public String roomNameWithChar(char c)
	{ // Does not check errors
		return rooms.get(c);
	}
	
// FOR TESTING ONLY
	
	public ArrayList<BoardCell> getBoard()
	{ // Returns the board
		return cells;
	}
	
	public Map<Character,String> getRooms()
	{
		return rooms;
	}
	
	public int getNumRows()
	{
		return numRows;
	}
	
	public int getNumColumns()
	{
		return numColumns;
	}
	
	public RoomCell getRoomCellAt(int row, int column) 
	{
		int location = calcIndex(row, column);
		return (RoomCell) cells.get(location);
	}
	public BoardCell getCellAt(int location)
	{
		return cells.get(location);
	}
	
	public BoardCell cellAt(int row, int column)
	{ // returns a cell at a row and column
		int location = calcIndex(row, column);
		return cells.get(location);
	}
	
	//For test purposes only
	public DoorDirection getDoorDirection(int row, int column)
	{ // Returns the Door Direction as a string
	  // It is returned as a string and not a DoorDirection because making DoorDirection
		int location = calcIndex(row, column);
		if (cells.get(location) instanceof RoomCell )
			return ((RoomCell)cells.get(location)).getDoorDirection();
		return DoorDirection.NONE;
			
	}
	
	public String getRoomNameAt(int row, int column)
	{ // Return the room name of a given cell
		int cal = calcIndex(row, column);
		String s = rooms.get(cells.get(calcIndex(row,column)).getCellCharacter());
		return s;
	}
}
