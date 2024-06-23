//Given two integers a and b, return the sum of the two integers without using the operators + and -

public class Problem371 {
    public int getSum(int a, int b) {
        //b will work as a carry
        while (b != 0) {
            //temporary value to not use altered value in xoring
            int tmp = (a & b) << 1;
            a ^= b;
            b = tmp;
        }
        //value is stored in a
        return a;
    }
}
