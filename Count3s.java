// Name: Tony Tam
// Course: CS177 Software Engineering
// CRN: 75874
// Date: 09/14/2020
// Assignment: Count3s.java

//import necessary libraries
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;

public class Count3s {

	public static void main(String Args[]) {
		try {
			FileInputStream fstream = new FileInputStream("threesData.bin"); // FileInputStream object is used open
																				// binary
																				// data

			byte[] byteArray = new byte[8]; // Instantiate byte Array with 8 bytes or 64 bits

			int i = 0;
			int count = 0; // Instantiate the counter at 0

			while (i != -1) { // always true while loop, probably not a good habit

				try {
					i = fstream.read(byteArray, 4, 4);
					/*
					 * FileInputeStream read() method will copy 32 bits of binary data into the byte
					 * array in Big Endian style starting at byteArray[4]
					 */
					ByteBuffer wrap = ByteBuffer.wrap(byteArray).order(ByteOrder.LITTLE_ENDIAN); // wrap the byteArray
																									// in a
																									// buffer in little
																									// endian style
					long test = wrap.getLong(); // get the 64-bit long number out of the buffer

					test = test >>> 32; // shift operator 32 bits to the right filling in 0s as it goes

					if (test == 3) { // test if the long equals 3

						count++; // increment count
						// System.out.println(count);

					}

				} catch (EOFException e) { // end of file is reached break out of while loop
					break;
				}
			}
			System.out.println("Here");
			System.out.println(count); // print out count
			fstream.close(); // close fstream

			System.exit(0);
		} catch (IOException e) {
			System.out.println("File Not Found");
		}

	}
}
