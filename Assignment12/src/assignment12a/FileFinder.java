package assignment12a;

import java.io.File;
import java.io.IOException;

/**
 * Recursively finds a file, beginning from the root directory and creating a thread for each sub directory.
 * @author Haye Bohm - 4290402
 * @author Ylja Remmits - 4373510
 *
 */
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

	/**
	 * Start the thread.
	 */
	public void run() {
		find();
	}

	public void findFile() {
		find();
	}
	
	/**
	 * Find a file with a filename in fileName and from root directory rootDir.
	 */
	private void find() {
		File[] files = rootDir.listFiles();
		if (files != null) {
			for (File file : files) {
				if (file.getName().equals(fileName)) {
					System.out.println("Found at: " + file.getAbsolutePath());
					System.exit(0);
				} else if (file.isDirectory()) {
					try {
						FileFinder filefinder = new FileFinder(
								file.getAbsolutePath(), fileName);
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
