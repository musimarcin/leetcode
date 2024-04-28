//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
//
//An input string is valid if:
//
//Open brackets must be closed by the same type of brackets.
//Open brackets must be closed in the correct order.
//Every close bracket has a corresponding open bracket of the same type.
//

import java.util.HashMap;
import java.util.Objects;
import java.util.Stack;

public class Problem20 {
    public boolean isValid(String s) {
        Stack<Character> stringStack = new Stack<>();
        HashMap<Character, Character> hashMap = new HashMap<>();
        hashMap.put(')', '(');
        hashMap.put(']', '[');
        hashMap.put('}', '{');

        for (char c : s.toCharArray()) {
            if (hashMap.containsKey(c)) {
                if (!stringStack.isEmpty() && stringStack.peek() == hashMap.get(c)) {
                    stringStack.pop();
                } else {
                    return false;
                }
            } else {
                stringStack.add(c);
            }
        }
        return stringStack.isEmpty();
    }
}
