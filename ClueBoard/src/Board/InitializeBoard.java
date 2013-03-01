package Board;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import Board.BadConfigFormatException;
import Board.RoomCell.DoorDirection;

/*
 *  This class takes a fileName and loads the config file the board and legend files
 *  
 *  This class will make a ArrayList of BoardCells and the Map for the characters
 *  
 *  This class throws FileNotFoundException and BadConfigFormatException in function parse()
 *  
 *  Rooms can be named anything but walkways must have the char 'w' as the identifer
 *  
 */
public class InitializeBoard {
	private String boardFileName;
	private String legendFileName;
	// What the class generates
	private ArrayList<BoardCell> cells;
	private Map<Character, String> characerRoomsMap;
	private int numberOfColumns;
	private int numberOfRows;

	// Constructors
	// All constructors must call "__init__" to initialize private variables
	public InitializeBoard()
	{
		__init__("boardConfig.cvs", "legendConfig.txt");
	}
	
	public InitializeBoard(String boardFile, String legendFile)
	{
		__init__(boardFile, legendFile);
	}
	
	// initializes all the attributes of the class;
	private void __init__(String boardConfigFile, String legendConfigFile)
	{
		boardFileName = boardConfigFile;
		legendFileName = legendConfigFile;
		cells = new ArrayList<BoardCell>();
		characerRoomsMap = new HashMap<Character, String>();
		numberOfColumns = 0;
		numberOfRows = 0;
	}
	
	
	// Retrievable variables
	public ArrayList<BoardCell> getBoardCells()
	{
		return cells;
	}
	
	public Map<Character, String> getRoomMap()
	{
		return characerRoomsMap;
	}
	
	public int getNumberOfRows()
	{
		return numberOfRows;
	}
	
	public int getNumberOfColumns()
	{
		return numberOfColumns;
	}
	
	// Parsing functions
	public void loadFiles() throws FileNotFoundException
	{
		loadLegend();
		loadBoard();
	}
	
// LEGEND PARSE FUNCTIONS
	private void loadLegend() throws FileNotFoundException
	{
		File file = new File(legendFileName);
		Scanner scan = new Scanner(file);
		
		while(scan.hasNextLine())
		{
			parseLegend(scan.nextLine());
		}
		scan.close();
	}
	
	public void parseLegend(String line) throws BadConfigFormatException
	{
		// regex string for legend
		String regex = "(\\w) *, *(\\w+)";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(line);
		
		if (matcher.find())
		{
			characerRoomsMap.put(matcher.group(0).charAt(0), matcher.group(1));
		}
		else
		{
			throw new BadConfigFormatException("Legend File not formated Correctly");
		}
		
	}
	
// BOARD PARSE FUNCTONS
	private void loadBoard() throws FileNotFoundException
	{
		File file = new File(boardFileName);
		
		Scanner scan = new Scanner(file);
		
		while(scan.hasNextLine())
		{
			parseBoard(scan.nextLine());
			numberOfRows++;
		}
		
		scan.close();
	}
	
	private void parseBoard(String line)
	{
		String[] split = line.split(";");
		
		if(split.length == 0) throw new BadConfigFormatException("boardConfig file has no attributes in row: " + numberOfRows);
		
		int count = 0;
		for(String s : split)
		{
			count++;
			cells.add(makeCell(s));
		}
		
		if(numberOfColumns == 0) 
			numberOfColumns = count;
		else if (count != numberOfColumns)
			throw new BadConfigFormatException("Not all rows in the boardConfig file are the same length");
	}
	
	private BoardCell makeCell(String cellType)
	{
		if(cellType.length() == 1)
		{
			if(characerRoomsMap.containsKey(cellType.charAt(0)))
			{
				switch(cellType)
				{
				case "w": return new WalkwayCell(cellType.charAt(0));
				default: return new RoomCell(cellType.charAt(0));
				}
			}
			else
				throw new BadConfigFormatException("Cell not containd in legend");
		}
		if(cellType.length() == 2)
		{
			switch(cellType.charAt(1))
			{
			case 'U': return new RoomCell(cellType.charAt(0), DoorDirection.UP);
			case 'D': return new RoomCell(cellType.charAt(0), DoorDirection.DOWN);
			case 'R': return new RoomCell(cellType.charAt(0), DoorDirection.RIGHT);
			case 'L': return new RoomCell(cellType.charAt(0), DoorDirection.LEFT);
			default: throw new BadConfigFormatException("Door Direction is not Valid");
			}
		}
		else
			throw new BadConfigFormatException("A cell in the boardConfig file contains more than two letters");
	}
}
