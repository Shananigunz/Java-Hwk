package test;

import java.io.File;

/**
 * Displays all files using recursion given a root path.
 * Usage: java ListFiles <path>
 * Example: Display the list of files from the current directory.
 *   java ListFiles .
 */
public class ListFiles {
    public static void main(String[] args) {
        if (args.length == 0) {
            System.err.println("Usage: java ListFiles <path>");
           System.exit(2);
        }

        // This assumes you provided a directory not a file.
        File rootPath = new File(args[0]);
        displayFile(rootPath);
    }

    public static void displayFile(File path) {
        // Retrieve the list of files in an array.
    	try {
        File[] fileList = path.listFiles();
        
        for(int i=0; i<fileList.length; i++) {
        	if(fileList[i].isDirectory()) {

            	displayFile(fileList[i]);
            }
            
            else {
            	System.out.println(fileList[i].getPath());
            	
            	
            	
            }
        }	
    	}
        catch(java.lang.NullPointerException e) {
        	System.out.println("An error occured. Try scanning a smaller file or scanning different parts of the file.");
        	
        }	
        
                /*
         * Fill in the code here.
         * Hint:
         * 1. Iterate through the list of files.
         * 2. If it's a directory, do recursion.
         * 3. Otherwise, call file.getPath() to display the file path.
         */
    }
}