/*
 * University of Auckland
 * SoftEng 206 - Assignment 1 Part 1
 * Language: Java

 * Script by Michael Lo
 * Date: 31/07/2013

 * Description:  
 *  	The program will first list out all files in the current directory.
 * 		It will only look at files which contain "contact" in its file name.
 *		It will read the content of each file, remove any duplicate content and sort them in lexicographic order.
 *		(To simplify things, a file will only contain one word all in lower case and is no longer than 999 characters)
 * 		It will write the output to data.txt in the same directory.
 * 		If a data.txt already exists, it is over written.
 * 		
 * Usage:
 *  	java DataTask >./data.txt
 */

import java.nio.Path;
import java.nio.file.*;
import java.io.*;

public class DataTask {
	public static void main (String[] args) {
		private static int MAX = 999;
		private static String DATA_FILE_NAME = "data.txt";

		/* Delete the data file */
		Path path = FileSystems.getDefault().getPath(DATA_FILE_NAME);
		Files.deleteIfExists(path);

		/* Array of string to store the content of each file */
		String[] filesContent = new String {MAX};

		int filesContentCount = 0;

		/* Open the directory so we can iterate through all the files in it */

		File directory = new File(<STRING REPRESENTING DIRECTORY>);

		/*Get array of all files in directory*/
		File[] contents = directory.listFiles();

		List<String> strings = new ArrayList<String>();
		String currentData;
		/* Loop through all files in directory */
		for ( File f : contents) {
			currentData = getData(f);
			if (!strings.contains(currentData)) {
				strings.add(currentData);
			}
		}

		Collections.sort(strings); 
		output(strings, DATA_FILE_NAME);
	}

	private String getData(File f) {
		String currentFileName = f.getname();

		/* Filter out files that do not contain "contact" in its file name */
		if (currentFileName.toLowerCase().contains("contact")) {
			StringBuffer contents = new StringBuffer();
			BufferedReader reader = null;
			try {
				reader = new BufferedReader(new FileReader(f));
				return reader.readLine();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				try {
					if (reader != null) {
						reader.close();
					}
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

	private Static output (String [] strings, String DATA_FILE_NAME) {
		Path path = FileSystems.getDefault().getPath(DATA_FILE_NAME);
		OutputStream out = Files.newOutputStream(path, CREATE, APPEND);
		String newLine = System.getProperty("line.separator");

		/*For each string in strings, append it to the file, followed by a new line.*/
		for (String s: strings) {
			out.write(s, 0, s.length);
			out.write(newLine, 0, newLine.length);
		}
		out.close();
	}
}



/*
     // truncate and overwrite an existing file, or create the file if
     // it doesn't initially exist
     OutputStream out = Files.newOutputStream(file);

     // append to an existing file, fail if the file does not exist
     out = Files.newOutputStream(file, APPEND);

     // append to an existing file, create file if it doesn't initially exist
     out = Files.newOutputStream(path, CREATE, APPEND);

     // always create new file, failing if it already exists
     out = Files.newOutputStream(file, CREATE_NEW); 
*/