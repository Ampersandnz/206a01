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
 #		./FileTask [DIRECTORY] [CONTACT_NAME] [CONTACT_NUMBER]
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
	directory = read year
	echo "Contact Name: "
	contactName = read year	
	echo "Contact Number: "
	contactNumber = read year
else
	# == Using command line arguments === #
	while getopts d:c:n: flag; 
	do
		case $flag in
		d)
			directory = $OPTARG;;
		c)
			contactName = $OPTARG;;
		n)
			contactNumber = $OPTARG;;
		?)
			exit;;
		esac
	done
fi

	# ============ #
	# Main Program #
	# ============ #
	
# The file path is in the format of <path to file>/<contact name>.contact #
filePath = "/$directory/$contactName.contact";
	
if [ ! -e $filePath ]; then
	# === File (or contact) does not exist, so create one and write in correct phone number === #
	echo $contactNumber > $filePath
else	
	# === File (or contact) already exists === #
	i = 1;
	# Loop through for example john(1).contact, john(2).contact, john(3).contact and so on... #
	# until one of them does not exist, then we write the contact number to that file #
	for (( ; ; ))
	do
		filePath = "/$directory/$contactName($i).contact"
   		echo $contactNumber > $filePath
   	i = $i + 1
	done
fi