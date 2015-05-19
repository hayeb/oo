package assignment12a;

import java.io.File;
import java.io.IOException;

public class FileFinder implements Runnable {
    private File rootDir;
    private String fileName;

    public FileFinder(String root, String file) throws IOException {
        rootDir = new File(root);
        fileName = file;
        if (!(rootDir.exists() && rootDir.isDirectory())) {
            throw new IOException(root + " is not a directory.");
        }
    }

    public void run() {
        find();
    }

    public void findFile() {
        find();
    }

    private void find () {
        File[] files = rootDir.listFiles();
        if (files != null) {
            for (File file: files) {
                if (file.getName().equals(fileName)) {
                    System.out.println("Found at: " + file.getAbsolutePath());
                    System.exit(0);
                }
                else if (file.isDirectory()) {
                    try {
                        FileFinder filefinder = new FileFinder(file.getAbsolutePath(), fileName);
                        Thread t = new Thread(filefinder);
                        t.start(); 
                    } catch (IOException e) {
                        System.err.print(e);
                    }
                }
            }
        }
    }
}
