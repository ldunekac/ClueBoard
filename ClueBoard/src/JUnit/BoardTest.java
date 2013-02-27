package JUnit;

import Board.Board;
import Board.BoardCell;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

public class BoardTest {
	Board board;
	
	@Before
	public void  reset()
	{
		board = new Board();
		board.loadConfigFiles();
	}

	@Test
	public void NumberOfRooms()
	{
		Assert.assertTrue(board.numberOfRooms() == 10);
	}
	
	@Test
	public void characterMap()
	{
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
	{
		int totalNumberOfDoors = 13;
		int count = 0;
		for(BoardCell c: board.getBoard())
		{
			if (c.isDoorway())
				count++;
		}
		Assert.assertTrue(count == totalNumberOfDoors);
	}
	
}
