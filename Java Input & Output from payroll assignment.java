package payroll;
import java.io.*;

public class InputOutput {
	
	public static String getFilename() throws IOException {
		//Gets filename from user input
		String filename = "";
		
		try {
			System.out.println("Please enter the filename: ");
			InputStreamReader input = new InputStreamReader(System.in);
			BufferedReader in = new BufferedReader(input);
			filename = in.readLine();
			
		} catch (Exception error) {
			System.err.println("Error: " + error.getMessage());
		}
		return filename;
	}
	
	public static String[] readFile(String filename) {
		//Reads the file one line at a time and returns it in a string array
		String currentLine;
		String[] toSystem = new String[100];
		int i = 0;
		char test;
		
		try {
			FileInputStream file = new FileInputStream(filename);
			DataInputStream input = new DataInputStream(file);
			BufferedReader read = new BufferedReader(new InputStreamReader(input));
		
			while ((currentLine = read.readLine()) != null)   {
				test = currentLine.charAt(0);
				if ((("" + test).equals("#")) == false) {
					currentLine = currentLine.replace("$", "");
					toSystem[i] = currentLine;
				}
				
				i++;
			}
			  
			input.close();
			
		} catch (Exception error) {
			System.err.println("Error: " + error.getMessage());
		}
		
		return toSystem;
	}
	
	
	public static void print(String [] toPrint) {
		for (int i = 0; i < toPrint.length; i++) {
			System.out.println(toPrint[i]);
		}
	}
}