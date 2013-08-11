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
 *  	java DataTask
 */

import java.nio.file.*;
import java.io.*;
import java.util.*;

public class DataTask {

	private static int MAX = 999;
	private static String DATA_FILE_NAME = "data.txt";

	public static void main (String[] args) {
		/* Array of string to store the content of each file */
		String[] filesContent = new String [MAX];

		int filesContentCount = 0;

		/* Open the directory so we can iterate through all the files in it */
		File file = createFile();
		File directory = file.getParentFile();
		/*Get array of all files in directory*/
		File[] contents = directory.listFiles();
		List<String> strings = new ArrayList<String>();
		String currentData;
		/* Loop through all files in directory */
		for (File f : contents) {
			currentData = getData(f);
			if (!strings.contains(currentData)) {
				strings.add(currentData);
			}
		}

		Collections.sort(strings); 
		strings.remove(0);
		output(strings, file);
	}

	private static String getData(File f) {
		String currentFileName = f.getName();

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
		return "";
	}

	private static void output (List<String> strings, File file) {
		/*For each string in strings, append it to the file, followed by a new line.*/
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			for (String s: strings) {
				writer.write(s,0,s.length());
				writer.newLine();
				writer.newLine();
			}
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static File createFile() {
		try {
			String filename = DATA_FILE_NAME;	
			String completeFile = "";
			DataTask temp = new DataTask();
			String applicationDir = temp.getClass().getProtectionDomain().getCodeSource().getLocation().getPath(); 
			applicationDir = applicationDir.replace("%20", " ");
			completeFile = applicationDir + filename;
			File file = new File(completeFile);
			
			/* Delete the data file */
			Files.deleteIfExists(FileSystems.getDefault().getPath(completeFile));
		
			//file.createNewFile();

			return file;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}