package ch13.worked_example_1;

import java.io.File;

public class FileFinderDemo {
    public static void main(String[] args) {
        File startingDirectory = new File("/home/myname");
        FileFinder finder = new FileFinder(startingDirectory);
        finder.find(".java");
    }
}
