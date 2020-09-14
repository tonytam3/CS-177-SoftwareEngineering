// Name: Tony Tam
// Course: CS177 Software Engineering
// CRN: 75874
// Date: 09/11/2020
// Assignment: Count3s.cpp

//Include libraries
#include <iostream>
#include <string>
#include <fstream>
#include <cstdint>

//using namespace std, reduce code verbage
using namespace std;

int main() {

	//initialize counter starting at 0
	int counter = 0;

	//setup empty unintiallize uint32_t variable from cstdint library
	uint32_t theNumber;

	//setup input stream using ifstream variable with name of file in first parameter and input modes in the second
	ifstream inputStream("threesData.bin", ios::in | ios::binary);

	//handle file opening errors
	if (!inputStream.is_open()) {
		cout << "Cannot Open File";
	}
	else {

		inputStream.seekg(0, ios::end); //seekg() sets fileposition from the EndOfFile direction to Begining at position 0
		int sizeOfFile = (int)inputStream.tellg(); //cast filesize position as integer
		inputStream.seekg(0, ios::beg); //reset streampos to the beginning
		
		int numberOfNumbers = 0;

		while (inputStream.tellg() < sizeOfFile) { //tellg returns current file position
			inputStream.read((char*) &theNumber, sizeof(theNumber)); //read size of uint32_t into "theNumber"
			//cout << theNumber << endl;
			if (theNumber == 3) { //if theNumber is equal to 3 increment the counter by 1
				//cin;
				counter++;
				//cin.ignore(std::numeric_limits<std::streamsize>::max(), '\n');
				//cin.clear();
			}

			numberOfNumbers++;
		}

		cout << numberOfNumbers << endl;
		cout << counter << endl; //print out counter

		inputStream.close(); //close input stream
	}

}