package _03_Printing_Binary;

public class _01_BinaryPrinter {
    /*
     * Complete the methods below so they print the passed in parameter in binary.
     * Do not use the Integer.toBinaryString method!
     * Use the main method to test your methods.
     */


    public void printByteBinary(byte b) {
        // We first want to print the bit in the one's place

  for(int i = 7; i>=0; i--) {  	
byte B = (byte)(b>>>i);
B= (byte)(B&0b00000001);
System.out.print(B);
  }
        // Shift b seven bits to the right

        // Use the & operator to "mask" the bit in the one's place
        // This can be done by "anding" (&) it with the value of 1

        // Print the result using System.out.print (NOT System.out.println)

        //Use this method to print the remaining 7 bits of b

    }

    public void printShortBinary(short s) {
        // Create 2 byte variables
byte b;
byte b2;
        // Use bit shifting and masking (&) to save the first
        // 8 bits of s in one byte, and the second 8 bits of
        // s in the other byte
b2 = (byte)(s>>>8);
b = (byte)(s);
        // Call printByteBinary twice using the two bytes
        // Make sure they are in the correct order
printByteBinary(b2);
printByteBinary(b);
    }

    public void printIntBinary(int i) {
        // Create 2 short variables
    	short s2 = (short)(i>>>16);
    	short s = (short)(i);

    	printShortBinary(s2);
    	printShortBinary(s);
        // Use bit shifting and masking (&) to save the first
        // 16 bits of i in one short, and the second 16 bits of
        // i in the other short

        // Call printShortBinary twice using the two short variables
        // Make sure they are in the correct order
    }

    public void printLongBinary(long l) {
    	int i2 = (int)(l>>>32);
    	int i = (int)(l);

    	printIntBinary(i2);
    	printIntBinary(i);
        // Use the same method as before to complete this method
    }

    public static void main(String[] args) {
        // Test your methods here
    	_01_BinaryPrinter bp = new _01_BinaryPrinter();    	
    	byte b = 0b00010011;
bp.printByteBinary(b);
short s = (short)(5555);
System.out.println(" ");
bp.printShortBinary(s);
System.out.println(" ");
int i =  123456789;
bp.printIntBinary(i);
System.out.println(" ");
bp.printIntBinary(7567);
    }
}
