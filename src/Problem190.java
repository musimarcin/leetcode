//Reverse bits of a given 32 bits unsigned integer.
//
//Note that in some languages, such as Java, there is no unsigned integer type.
// In this case, both input and output will be given as a signed integer type.
// They should not affect your implementation, as the integer's internal binary representation is the same,
// whether it is signed or unsigned.

//In Java, the compiler represents the signed integers using 2's complement notation.

public class Problem190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        //becasue we get 32bit integer
        for (int i = 0; i < 32; i++) {
//            //make room for next bit
//            result <<= 1;
//            //set next bit for result as a least significant bit of n and move n by 1 bit
//            result |= (n & 1);
//            n >>= 1;
            //get last bit
            int bit = (n >> i) & 1;
            //update corresponding result bit with least significant bit of n
            result |= (bit << (31 - i));
        }
        return result;
    }
}
