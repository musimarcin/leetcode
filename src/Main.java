import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Problem139 p = new Problem139();
        List<String> wordDict2 = List.of("apple", "pen");
        System.out.println(p.wordBreak("applepenapple", wordDict2));
    }
}