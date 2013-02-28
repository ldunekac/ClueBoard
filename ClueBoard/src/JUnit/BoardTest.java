package JUnit;

import Board.Board;
import Board.BoardCell;
import Board.RoomCell;
import Board.BadConfigFormatException;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

/*
 * These test are designed to test the board its self 
 * 
 * All tests are made for the current legend and board config files
 * found in the JUnit directory
 * Loading the config files are hard coded
 * 
 * Type of tests
 *  x	- Dimensions of board
 *  		- rows and columns are correct
 * 	x	- calc Index
 *  x	- Number of rooms
 *  x	- Character mapping to room names
 *  x	- Correct Number of Doors
 *  		- isDoorway
 *  x	- Door direction
 *  x	- isValid room
 *  		- Make sure that all same letters are connecting for rooms
 *		- Exception is thrown when appropriate
 *			- Invalid board file
 */

public class BoardTest {
	Board board;
	
	
	@Before
	public void  reset()
	{ // Reset the board to original state
		board = new Board(); // TODO input file name
		board.loadConfigFiles();
	}
	
	@Test
	public void dimensionsOfBoard()
	{// make sure that when loading the board correct dimensions are calculated 
		Assert.assertTrue(board.getNumberRow() == 22);
		Assert.assertTrue(board.getNumberColumn() == 23);
	}
	
	@Test
	public void testCalcIndex()
	{
		Assert.assertTrue(board.calcIndex(0,0) == 0);
		Assert.assertTrue(board.calcIndex(0,22) == 22);
		Assert.assertTrue(board.calcIndex(21,0) == 21*23+0);
		Assert.assertTrue(board.calcIndex(11,13) == 11*23+13);
		Assert.assertTrue(board.calcIndex(21,22) == 21*23+22);
	}

	@Test
	public void NumberOfRooms()
	{ // Make sure that rooms loaded correctly
		Assert.assertTrue(board.numberOfRooms() == 10);
	}
	
	@Test
	public void characterMap()
	{ // test if characters map to the correct room
		Assert.assertTrue(board.roomNameWithChar('R') == "Trophy Room");
		Assert.assertTrue(board.roomNameWithChar('T') == "Toilet");
		Assert.assertTrue(board.roomNameWithChar('C') == "Crown Gem Room");
		Assert.assertTrue(board.roomNameWithChar('D') == "Dungeon Room");
		Assert.assertTrue(board.roomNameWithChar('A') == "Animal Room");
		Assert.assertTrue(board.roomNameWithChar('M') == "Computer Room");
		Assert.assertTrue(board.roomNameWithChar('O') == "Deadly Objects Room");
		Assert.assertTrue(board.roomNameWithChar('S') == "Server Room");
		Assert.assertTrue(board.roomNameWithChar('P') == "Python");
		Assert.assertTrue(board.roomNameWithChar('X') == "Closet");
	}
	
	@Test
	public void correctNumberOfDoors()
	{ // Checks if the doors got loaded correctly
		// does not check direction of the doors
		// check the isDorway function
		int totalNumberOfDoors = 13;
		int count = 0;
		for(BoardCell c: board.getBoard())
		{
			if (c.isDoorway())
				count++;
		}
		Assert.assertTrue(count == totalNumberOfDoors);
	}
	
	@Test
	public void DoorDirection()
	{
		Assert.assertTrue(board.getDoorDirection(2, 5) == "RIGHT");
		Assert.assertTrue(board.getDoorDirection(5,2) == "DOWN");
		Assert.assertTrue(board.getDoorDirection(4,21) == "DOWN");
		Assert.assertTrue(board.getDoorDirection(1,18) == "LEFT");
		Assert.assertTrue(board.getDoorDirection(19,13) == "UP");
	}
	
	@Test
	public void ValidRoom()
	{
		Assert.assertTrue(board.getRoomNameAt(8, 0) == "Toilet");
		Assert.assertTrue(board.getRoomNameAt(8, 1) == "Toilet");
		Assert.assertTrue(board.getRoomNameAt(9, 0) == "Toilet");
		Assert.assertTrue(board.getRoomNameAt(9, 1) == "Toilet");
		Assert.assertTrue(board.getRoomNameAt(7, 0) != "Toilet");
	}
	
	@Test
	public void invalidBoardConfiguration()
	{
		board = null;
		try 
		{
			board = new Board("badBoardSize.csv");
			Assert.assertTrue(false);
		}
		catch(BadConfigFormatException e)
		{
			Assert.assertTrue(true);
		}
		
		board = null;
		try 
		{
			board = new Board("badBoardParse.csv");
			Assert.assertTrue(false);
		}
		catch(BadConfigFormatException e)
		{
			Assert.assertTrue(true);
		}
	}
	
}
