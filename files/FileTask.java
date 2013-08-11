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
import java.nio.file.*;
import java.io.*;

public class FileTask {
	/* Output directory */
	private static String _directory;
	/* Name of the contact. Is only one word consisting of letters */
	private static String _contactName;
	/* Contact phone number. Only contains digits */
	private static String _contactNumber;

	public static void main (String []args) {
		input(args);

		/* ============ */
		/* Main Program */
		/* ============ */
		
		/* The file path is in the format of <path to file>/<contact name>.contact */
		String filePath;
		filePath = _directory + "/" + _contactName + ".contact";

		File file = getFile();

		output(file);
	}

	private static void input(String []args) {
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
			_directory = args[0];
			_contactName = args[1];
			_contactNumber = args[2];
		}
	}

	private static File getFile() {	
		String completeFile = "";
		FileTask temp = new FileTask();
		String applicationDir = temp.getClass().getProtectionDomain().getCodeSource().getLocation().getPath(); 
		applicationDir = applicationDir.replace("%20", " ");
		completeFile = applicationDir + _directory + System.getProperty("file.separator") + _contactName + ".contact";
		File file = new File(completeFile);
		return file;
	}

	private static void output (File file) {
		File temp = file;
		String filePath;

		try {
			while (true) {
				temp = temp.getParentFile();
				if (!temp.mkdir()) {
					break;
				}
			}

			if (!file.createNewFile()) {
				/* === File (or contact) already exists === */
				/* Loop through for example john(1).contact, john(2).contact, john(3).contact and so on... */
				/* until one of them does not exist, then we write the contact number to that file */
				int count = 1;
				while (true) {

				String completeFile = "";
				FileTask task = new FileTask();
				String applicationDir = task.getClass().getProtectionDomain().getCodeSource().getLocation().getPath(); 
				applicationDir = applicationDir.replace("%20", " ");
				completeFile = applicationDir + _directory + System.getProperty("file.separator") + _contactName + "(" + count + ").contact";
				file = new File(completeFile);

				if (!file.createNewFile()) {
						count += 1;
					} else {
						break;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			writer.write(_contactNumber, 0, _contactNumber.length());
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}