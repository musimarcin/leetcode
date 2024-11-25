//Given a string s, return true if it is a palindrome, or false otherwise.

import java.util.ArrayList;

public class Problem125
{
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
            left++;
            right--;
        }
        return true;
//        // set left pointer at the beginning and add all alphanumerical characters into array and right pointer
//        // to the end of array
//        int left = 0;
//        ArrayList<Character> arrayList = new ArrayList<>();
//        for (char c : s.toLowerCase().toCharArray())
//        {
//            if (Character.isLetterOrDigit(c)) {
//                arrayList.add(c);
//            }
//        }
//        int right = arrayList.size() - 1;
//        // loop through array with pointers and if left pointer is different from right that means its not a palindrome
//        while (left < right) {
//            if (arrayList.get(left) != arrayList.get(right))
//            {
//                return false;
//            } else {
//                left += 1;
//                right -= 1;
//            }
//        }
//        return true;
    }
}
