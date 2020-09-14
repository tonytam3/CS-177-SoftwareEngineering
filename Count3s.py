# Name: Tony Tam
# Course: CS177 Software Engineering
# CRN: 75874
# Date: 09/11/2020
# Assignment: Count3s.py

import struct

#open the file with file name in read and binary mode
inputStream = open("threesData.bin", "rb")
inputStream.seek(0,2) #set file pointer to end of file
sizeOfFile = inputStream.tell() # get size of file
inputStream.seek(0,0) #reset file pointer to begin

counter = 0 #set counter to 0

while inputStream.tell() < sizeOfFile:

    data = inputStream.read(4) #read 4 Bytes into data
        
    integer = struct.unpack('I', data) #using stuct unpack function to convert data to tuple containing an integer.
    
    if int(integer[0]) == 3: # access tuple position 0 and compare to 3
        counter += 1 # increment counter

        
print(counter) # print counter