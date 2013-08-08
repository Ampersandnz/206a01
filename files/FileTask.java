/*
 * University of Auckland
 * SoftEng 206 - Assignment 1 Part 2
 * Language: Java
 *
 * Script by Michael Lo
 * Date: 10/07/2013
 *
 * Description:
 * 		Creates a .contact file.
 * Usage:
 *		./FileTask [DIRECTORY] [CONTACT_NAME] [CONTACT_NUMBER]
 * Example: 
 *		./FileTask . john 123456
 */
import java.util.Scanner;

public class FileTask {
	public static void main (String []args) {
		/* Output directory */
		private String directory;
		/* Name of the contact. Is only one word consisting of letters */
		private String contactName;
		/* Contact phone number. Is only contain digits */
		private String contactNumber

		/* ============= */
		/* Process Input */
		/* ============= */
		if (args.length <= 1) {
			/* === Using standard input === */	
    		Scanner scanner = new Scanner(System.in);
			System.out.println("Output directory: ");
    		directory = scanner.nextLine();
			System.out.println("Name: ");
    		contactName = scanner.nextLine();
			System.out.println("Phone number: ");
    		contactNumber = scanner.nextLine();
		} else {
			/* == Using command line arguments === */
			directory = args[0]);
			contactName = args[1]);
			contactNumber = args[2]);
		}

		/* ============ */
		/* Main Program */
		/* ============ */
		
		/* The file path is in the format of <path to file>/<contact name>.contact */
		private String filePath;
		filePath = directory + "/" + contactName + ".contact"

		Path path = FileSystems.getDefault().getPath(filePath);
#=============================================================================================================================#
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


//		OutputStream out = Files.newOutputStream(path, 

		if (filePointer == NULL) {
			/* === File (or contact) does not exist, so create one and write in correct phone number === */
			filePointer = fopen(filePath, "w");
			fprintf(filePointer, "%s", contactNumber);
			fclose(filePointer);
			
		} else {
			/* === File (or contact) already exists === */
			
			/* Close the file which was opened to test if the file existed */
			out.close();









		OutputStream out = Files.newOutputStream(path, );
		out.close();
	}
}

		if (filePointer == NULL) {
			/* === File (or contact) does not exist, so create one and write in correct phone number === */
			filePointer = fopen(filePath, "w");
			fprintf(filePointer, "%s", contactNumber);
			fclose(filePointer);
			
		} else {
			/* === File (or contact) already exists === */
			
			/* Close the file which was opened to test if the file existed */
			fclose(filePointer);
			
			/* Loop through for example john(1).contact, john(2).contact, john(3).contact and so on... */
			/* until one of them does not exist, then we write the contact number to that file */
			int count = 1;
			for(;;) {
				sprintf(filePath, "%s/%s(%i).contact", directory, contactName, count);
				filePointer = fopen(filePath, "r");
				if (filePointer == NULL) {
					filePointer = fopen(filePath, "w");
					fprintf(filePointer, "%s", contactNumber);
					fclose(filePointer);
					break;
				}
				fclose(filePointer);
				count = count + 1;
			}
		}
	