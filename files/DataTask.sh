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

function containedIn {
	local c
	for c in "${@:2}" 
	do 
		[[ "$c" == "$1" ]] && return 1
	done
	return 0
}

function printArray {
	local l
	for l in "${@:1}"
	do 
		echo $l>>$fileName
	done
	return
}

fileName="data.txt"
arraySize=0

# Delete the data file
rm -f $fileName
touch $fileName

#For all files in directory that contain "contact":
for f in $(ls | grep "contact")
do
	# Open the file and get its content
	read line < $f
  	data=$line

	# Loop through existing contents stored in fileContent, checking for duplicates with current content
	if containedIn $data ${fileContent[@]}
	then	
		# Add data to fileContent if it passed all above checks
		fileContent[$arraySize]=$data
		arraySize=$[arraySize + 1]
	fi
done

# Write fileContent to data.txt
printArray "${fileContent[@]}"

# Sort fileContent.
sort -u $fileName -o $fileName

# Separate entries in data.txt by new lines
sed '/$/G' $fileName>tmp && mv tmp $fileName