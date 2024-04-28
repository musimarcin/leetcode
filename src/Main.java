import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Problem20 problem = new Problem20();
        String s = "()[]{}";
        int[] nums = {7,1,5,3,6,4};
        System.out.println(problem.isValid(s));
    }
}