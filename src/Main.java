import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Problem152 p = new Problem152();
        int[] nums = {0,10,10,10,10,10,10,10,10,10,-10,10,10,10,10,10,10,10,10,10,0};
        int res = p.maxProduct(nums);
        System.out.println(res);
    }
}