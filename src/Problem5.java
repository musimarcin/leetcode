//Given a string s, return the longest palindromic substring in s.

public class Problem5 {
    String result = "";
    int resLen = 0;
    public String longestPalindrome(String s) {
        for (int i = 0; i < s.length(); i++) {
            //odd strings
            helper(i, i, s);
            //even strings
            helper(i, i+1, s);
        }
        return result;
    }

    private void helper(int left, int right, String s) {
        //if left and right pointers are inbound and string is still a palindrome
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            //update result if necessary
            if (right - left + 1 > resLen) {
                result = s.substring(left, right+1);
                resLen = right - left + 1;
            }
            //move pointers outwards
            left -= 1;
            right += 1;
        }
    }
}