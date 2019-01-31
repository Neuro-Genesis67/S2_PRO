package opgave_4_Mappelæsning;

import java.io.File;

public class DirectoryScanner {

	public static void main(String[] args) {
		//
		DirectoryScanner dc = new DirectoryScanner();
		// dc.scanDirCount("C:\\Users\\Tom Steinmeier\\Documents");
		System.out.println(dc.scanDirCount("C:\\Users\\Tom Steinmeier\\Documents"));
	}

	public static void scanDir(String path) {

		System.out.println("[DIR] " + path);
		File file = new File(path);
		String[] names = file.list();

		for (String name : names) {
			String newPath = path + "/" + name;

			if ((new File(newPath)).isDirectory()) {
				scanDir(newPath);
			}
		}
	}

	public static int scanDirCount(String path) { // UNFINISHED
		int counter = 1;
		// System.out.println(counter);
		File file = new File(path);
		String[] names = file.list();

		for (String name : names) {
			String newPath = path + "/" + name;

			if ((new File(newPath)).isDirectory()) {
				counter += scanDirCount(newPath);

			}
		}
		return counter;
	}

}
