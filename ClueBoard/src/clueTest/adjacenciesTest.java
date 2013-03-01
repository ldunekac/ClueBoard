package clueTest;

import java.io.FileNotFoundException;

import org.junit.Before;

import clueGame.Board;

public class adjacenciesTest {
	Board board;
	
	@Before
	public void setUp()
	{
		board = new Board();
		try {
			board.loadConfigFiles();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
	
	
}
