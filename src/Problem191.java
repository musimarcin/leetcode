//Write a function that takes the binary representation of a positive integer and returns the number of set bits
// it has (also known as the Hamming weight).

public class Problem191 {
    int hammingWeight(int n) {
        int result = 0;
        while (n != 0) {
            //if mod2 results in 1 it means theres 1 and add it to the result
            result += n % 2;
            //and shift bit by 1
            n = n >> 1;

            // by substracting 1 its getting rid of one bit e.g. 1001 - 1 = 1000 & 1001 = 1000
            // every loop removes one 1
//            n &= (n - 1);
//            result += 1;
        }
        return result;
    }
}
