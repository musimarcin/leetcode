import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Problem424 problem = new Problem424();
        String s = "KRSCDCSONAJNHLBMDQGIFCPEKPOHQIHLTDIQGEKLRLCQNBOHNDQGHJPNDQPERNFSSSRDEQLFPCCCARFMDLHADJADAGNNSBNCJQOF";
        int[] nums = {7,1,5,3,6,4};
        System.out.println(problem.characterReplacement(s, 4));
    }
}