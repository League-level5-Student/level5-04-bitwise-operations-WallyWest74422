package _05_Base64_Decoder;

/*
 * Base 64 is a way of encoding binary data using text.
 * Each number 0-63 is mapped to a character.
 * NOTE: THIS IS NOT THE SAME AS ASCII OR UNICODE ENCODING!
 * 
 * The base64Chars array below maps the index to a character
 * in the array. For example,
 *      0 -> 'A'    // 'A' is at index 0 in the array, so 0 maps to 'A'
 *      1 -> 'B'    // 'B' is at index 1 in the array, so 1 maps to 'B'
 *      2 -> 'C'    // 'C' is at index 1 in the array, so 2 maps to 'C'
 *      ...
 *      63 -> '/'   // '/' is at index 63 in the array, so 63 maps to '/'
 * 
 * Since the numbers 0 through 63 can be represented using 6 bits,
 * every four (4) characters will represent twenty four (24) bits of data.
 *      0b111111    // 63 decimal, all 6 bits set to 1
 *      4 * 6 = 24  // 4 characters * (6 bits / character)
 * 
 * Even though only 6 bits are needed to represent each character in the
 * base64Chars array, the minimum number of bits a computer can transfer
 * is 8 bits, i.e. a byte.
 * 
 * This means that for every Base64 character there will be 2 bits that aren't
 * used. Those 2 bits are the two leftmost bits, bits 6 and 7.
 * bit # 7 6 5 4 3 2 1 0
 *       0 0 1 1 1 1 1 1    // binary 0b00111111, decimal 63, character '/'
 *       \_\_unused bits
 * 
 * If there are 4 bytes (32 bits) transferred, each byte will have 2 unused
 * bits for a total of 8 unused bits. We can shift the bits in each byte to
 * to fit into 3 bytes with no unused bits.
 *       Byte 3      Byte 2      Byte 1       Byte 0    // 4 total bytes (32 bits)
 *      00111111    00111111    00111111     00111111   // "////"
 *               ____// |__|  ___/___/ \\__  __|____|
 *        111111 11     1111 1111        11  111111     // 3 total bytes (24 bits)
 *         Byte 2         Byte 1           Byte 0
 * 
 * For this exercise, we won't worry about what happens if the total bits
 * being converted do not divide evenly by 24.
 * 
 * View this link for a full description of Base64 encoding
 * https://en.wikipedia.org/wiki/Base64
 */
public class Base64Decoder {

    final static char[] base64Chars = {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M',
            'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm',
            'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'
    };

    //1. Complete this method so that it returns the index in
    //   the base64Chars array that corresponds to the passed in char.
    public static byte convertBase64Char(char c){
    	for(int i = 0; i<base64Chars.length; i++) {
    		if(base64Chars[i]==c) {
return (byte)(i);
    		}
    	}
        return (byte)(-1);
    }

    //2. Complete this method so that it will take in a string that is 4
    //   characters long and return an array of 3 bytes (24 bits). The byte
    //   array should be the binary value of the encoded characters.
    public static byte[] convert4CharsTo24Bits(String s){
    	String fullBinary = "";
    	for(int i = 0; i<s.length(); i++) {
    		int index = convertBase64Char(s.charAt(i));
            String binary = "";
            while(index/2!=0){
                binary = index%2 + binary;
                index/=2;
            }
                binary = index%2 + binary;

while(binary.length()<6) {
	binary = 0+binary;
}
   fullBinary+=binary;
    	}  

    	 String uno = fullBinary.substring(0,8);
    	 String dos = fullBinary.substring(8,16);
    	 String tres =fullBinary.substring(16);
    	 int one = 0;
    	 int two = 0;
    	 int three = 0;
    	 for(int i = uno.length()-1; i>=0; i--) {
    			if(uno.substring(i,i+1).equals("1")){
    				one += Math.pow(2, (uno.length()-1-i));

    			}
    		}
    	 for(int i = dos.length()-1; i>=0; i--) {
 			if(dos.substring(i,i+1).equals("1")){
 				two += Math.pow(2, (dos.length()-1-i));

 			}
 		}
    	 for(int i = tres.length()-1; i>=0; i--) {
 			if(tres.substring(i,i+1).equals("1")){
 				three += Math.pow(2, (tres.length()-1-i));

 			}
 		}
    	 byte[] bytes = {(byte) one, (byte) two, (byte) three};
        return bytes;
    }

    //3. Complete this method so that it takes in a string of any length
    //   and returns the full byte array of the decoded base64 characters.
    public static byte[] base64StringToByteArray(String file) {     //16 chars->12 bytes
//int times = (file.length()/4)*3;
//byte[] decoded = new byte[times];
//int counter = 0;
//for(int i = 0; i<times/3; i++) {
//	byte[] temp = convert4CharsTo24Bits(file.substring(4*i, (4*i)+1));
//	decoded[counter] = temp[0];
////	System.out.println(decoded[counter]);
//	counter++;
//	decoded[counter] = temp[1];
////	System.out.println(decoded[counter]);
//	counter++;
//	decoded[counter] = temp[2];
////	System.out.println(decoded[counter]);
//	counter++;
//}
        return decoded;
    }
}
