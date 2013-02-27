package Board;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class BadConfigFormatException extends RuntimeException {

	public BadConfigFormatException(String message) {
		super(message);
		createLog(message);
	}

	public void createLog(String message) {
		try {
			FileWriter fw = new FileWriter("ErrorLog.txt", true);
			fw.write(message);
			fw.close();
		} catch (IOException e) {
			System.err.println("IOException cannot open file: ErrorLog.txt");
		}
	}

}
