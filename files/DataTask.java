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
 *  	./DataTask
 */

import java.nio.Path;
import java.nio.file.*

public class DataTask {
	public static void main (String[] args) {
		private static int MAX = 999;
		private static char DATA_FILE_NAME = "data.txt";

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
		/* Loop through all files in directory */
		for ( File f : contents) {
			String currentFileName = f.getname();

			/* Filter out files that do not contain "contact" in its file name */
			if (currentFileName.toLowerCase().contains("contact")) {
				
			}
		}
	}
}

		/* Open the file and get its content */
		char fileContent[MAX];		
		FILE *filePointer = fopen(fileEntry->d_name, "r");
		fgets(fileContent, MAX, filePointer);
		fclose(filePointer);
		
		/* Loop through existing contents stored in filesContent, checking for duplicates with current content */
		int i;
		int foundDuplicate = 0;
		for(i=0; i<filesContentCount; i++)
		{
			if(strcmp(fileContent, filesContent[i]) == 0)
			{
				foundDuplicate=1;
				break;
			}
		}
		if (foundDuplicate == 1)
		{
			continue;
		}
		
		/* Add the data to the array if it passed all above checks */
		filesContent[filesContentCount] = malloc(strlen(fileContent)+1);
		strcpy(filesContent[filesContentCount], fileContent);
		filesContentCount++;
	}
	closedir(directoryPointer);

	/* Sort the filesContent array. (Hint: Equivalent to the bash sort command) */
	qsort(filesContent, filesContentCount, sizeof(*filesContent), comparator);
	
	/* Write the each file content as to the array separated by new lines */
	FILE *filePointer = fopen(DATA_FILE_NAME, "w");	
	int i;
	for(i=0; i<filesContentCount; i++)
	{
		fprintf(filePointer, "%s", filesContent[i]);
	}
	fclose(filePointer);
}

/* Used for comparing strings when sorting */
/* (You do not need to fully understand this function to complete the assignment) */
int comparator(const void *left, const void *right)
{
	return (strcmp(*(char **)left, *(char **)right));
}