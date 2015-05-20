package tests;

import java.io.IOException;

import assignment12a.FileFinder;

/**
 * Test for the FileFinder class. Tries to find a known file in the file system using threading.
 * @author Haye Bohm - 4290402
 * @author Ylja Remmits - 4373510
 *
 */
public class FileFinderTest {
	
	public FileFinderTest() {
		try {
			String goal = "FileFinderTest.java";
			String root = "/";
			FileFinder ff = new FileFinder(root, goal);
			ff.findFile();
		} catch (IOException e) {
			System.err.println(e);
		}

	}
}
