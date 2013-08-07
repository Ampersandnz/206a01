##
 # University of Auckland
 # SoftEng 206 - Assignment 1 Part 1
 # Language: Bash

 # Script by Michael Lo
 # Date: 3/08/2013

 # Description:  
 #  	The program will first list out all files in the current directory.
 # 		It will only look at files which contain "contact" in its file name.
 #		It will read the content of each file, remove any duplicate content and sort them in lexicographic order.
 #		(To simplify things, a file will only contain one word all in lower case and is no longer than 999 characters)
 # 		It will write the output to data.txt in the same directory.
 # 		If a data.txt already exists, it is over written.
 # 		
 # Usage:
 #  	./DataTask
##

# Delete the data file
rm -f data.txt













	# Array of string to store the content of each file 
	char *filesContent[MAX];
	
	int filesContentCount = 0;

	# Loop through all files in directory 
	for(;;)
	{
		# Read the next file 
		struct dirent *fileEntry = readdir(directoryPointer);
		# If there are no more files left to loop through, then break out of the loop
		if (fileEntry == NULL)
		{
			break;
		}
		
		# Filter out files that do not contain "contact" in its file name
		if (!strstr(fileEntry->d_name, "contact"))
		{
			continue;
		}
		
		# Open the file and get its content
		char fileContent[MAX];		
		FILE *filePointer = fopen(fileEntry->d_name, "r");
		fgets(fileContent, MAX, filePointer);
		fclose(filePointer);
		
		# Loop through existing contents stored in filesContent, checking for duplicates with current content
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
		
		# Add the data to the array if it passed all above checks
		filesContent[filesContentCount] = malloc(strlen(fileContent)+1);
		strcpy(filesContent[filesContentCount], fileContent);
		filesContentCount++;
	}
	closedir(directoryPointer);

	# Sort the filesContent array. (Hint: Equivalent to the bash sort command)
	qsort(filesContent, filesContentCount, sizeof(*filesContent), comparator);
	
	# Write the each file content as to the array separated by new lines
	FILE *filePointer = fopen(DATA_FILE_NAME, "w");	
	int i;
	for(i=0; i<filesContentCount; i++)
	{
		fprintf(filePointer, "%s", filesContent[i]);
	}
	fclose(filePointer);
}