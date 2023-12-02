#!/bin/bash

# Is necessary to execute this code into the root
# directory of the project.

#Colours
orangeColour="\e[0;32m\033[1m"
greenColour="\033[0m\e[0m"
redColour="\e[0;31m\033[1m"
purpleColour="\e[0;34m\033[1m"
grayColour="\e[0;37m\033[1m"
turquoiseColour="\e[0;36m\033[1m"
endColour="\033[0m"


# Move inside the root directory of the project
cd /media/Kali/home/grimaldi/School/TEC/Semestre2/POO/SudokuSolver
mkdir -p bin

# Delete previous .class files
find . -type f -name "*.class" | xargs rm 2>/dev/null

# Compile the project and reorganize it
echo -e "${turquoiseColour}Compiling the java code...${endColour}"
#javac -d bin src/Classes/*.java src/Main/*.java 
javac -cp ".:bin:lib/opencsv-5.7.1.jar" -d bin src/Classes/*.java src/Main/*.java 

if [ "$?" == "0" ]; then 
	echo -e "${orangeColour}Compiled Successfully!${endColour}"
fi

# Move the files where corresponds
mv bin/Main.class bin/Main 
mv bin/*.class bin/Classes

# Move where is located the Main.class file and execute it
main_path='/media/Kali/home/grimaldi/School/TEC/Semestre2/POO/SudokuSolver/bin/Main'
cd "$main_path"
echo

# echo -e "${turquoiseColour}Executing the program...${endColour}" ] && echo

# java -cp .:../Classes Main 2>/dev/null
java -cp ".:../Classes:lib/opencsv-5.7.1.jar" Main
