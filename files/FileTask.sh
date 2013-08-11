##
 # University of Auckland
 # SoftEng 206 - Assignment 1 Part 2
 # Language: Bash
 #
 # Script by Michael Lo
 # Date: 10/07/2013
 #
 # Description:
 # 		Creates a .contact file.
 # Usage:
 #		./FileTask.sh [DIRECTORY] [CONTACT_NAME] [CONTACT_NUMBER]
 # Example: 
 #		./FileTask . john 123456
##

	# ============= #
	# Process Input #
	# ============= #

if [ $# -le 2 ]
then
	# === Using standard input === #	
	echo "Directory: "
	read dir
	directory=$dir
	echo "Contact Name: "
	read name
	contactName=$name
	echo "Contact Number: "
	read number
	contactNumber=$number
else
	# == Using command line arguments === #
	directory=$1
	contactName=$2
	contactNumber=$3
fi

	# ============ #
	# Main Program #
	# ============ #
	
# The file path is in the format of <path to file>/<contact name>.contact #
filePath="./$directory/$contactName.contact";
	
if [ ! -e $filePath ]; then
	# === File (or contact) does not exist, so create one and write in correct phone number === #
	mkdir -p $directory
	touch $filePath || exit
	echo $contactNumber>$filePath
else	
	# === File (or contact) already exists === #
	i=1
	# Loop through for example john(1).contact, john(2).contact, john(3).contact and so on... #
	# until one of them does not exist, then we write the contact number to that file #
	for (( ; ; ))
	do
		if [ ! -e $filePath ]; then
			mkdir -p $directory
			touch $filePath || exit
   			echo $contactNumber>$filePath
			break
		else
			filePath="./$directory/$contactName($i).contact"
		fi
   	i=$[i + 1]
	done
fi
echo "Created " + $filePath