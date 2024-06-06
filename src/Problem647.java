//Given a string s, return the number of palindromic substrings in it.
//
//A string is a palindrome when it reads the same backward as forward.
//
//A substring is a contiguous sequence of characters within the string.


import java.util.ArrayList;

public class Problem647 {
    int palindrome = 0;
    public int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            //odd len
            helper(i,i,s);
            //even len
            helper(i,i+1,s);
        }
        return palindrome;
    }

    private void helper(int left, int right, String s) {
        //if left and right pointers are inbound and string is still a palindrome
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            palindrome++;
            //move pointers outwards
            left -= 1;
            right += 1;
        }
    }
}
