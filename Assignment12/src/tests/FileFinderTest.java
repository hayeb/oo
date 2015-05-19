package tests;

import java.io.IOException;

import assignment12a.FileFinder;

public class FileFinderTest {
    public static void main(String[] args) {
        FileFinderTest fft = new FileFinderTest();
    }

    public FileFinderTest() {
        try {
            String goal = "Agents.cfg";
            String root = "/";
            FileFinder ff = new FileFinder(root, goal);
            ff.findFile();
        }
        catch (IOException e) {
            System.err.println(e);
        }

    }
}
