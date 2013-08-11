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
	/* Output directory */
	private String _directory;
	/* Name of the contact. Is only one word consisting of letters */
	private String _contactName;
	/* Contact phone number. Only contains digits */
	private String _contactNumber;

	public static void main (String []args) {
		/* ============= */
		/* Process Input */
		/* ============= */
		if (args.length <= 1) {
			/* === Using standard input === */	
    		Scanner scanner = new Scanner(System.in);
			System.out.println("Output directory: ");
    		_directory = scanner.nextLine();
			System.out.println("Name: ");
    		_contactName = scanner.nextLine();
			System.out.println("Phone number: ");
    		_contactNumber = scanner.nextLine();
		} else {
			/* == Using command line arguments === */
			_directory = args[0]);
			_contactName = args[1]);
			_contactNumber = args[2]);
		}

		/* ============ */
		/* Main Program */
		/* ============ */
		
		/* The file path is in the format of <path to file>/<contact name>.contact */
		private String filePath;
		filePath = _directory + "/" + _contactName + ".contact";

		Path path = FileSystems.getDefault().getPath(filePath);
 
		try {
			OutputStream out = Files.newOutputStream(path, CREATE_NEW);
		} catch (IOException e) {
			/* === File (or contact) already exists === */
			/* Close the file which was opened to test if the file existed */
			out.close();
			/* Loop through for example john(1).contact, john(2).contact, john(3).contact and so on... */
			/* until one of them does not exist, then we write the contact number to that file */
			int count = 1;
			while (1) {
				filePath = _directory + "/" + _contactName + "(" + i + ").contact";
				path = FileSystems.getDefault().getPath(filePath);
 				try {
					OutputStream out = Files.newOutputStream(path, CREATE_NEW);
					break;
				} catch (IOException e) {
					count += 1;
				}
			}
			out.write(_contactNumber, 0, _contactNumber.length);
			out.close();
		}
	}
}