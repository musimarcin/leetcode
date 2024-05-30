//Design a data structure that supports adding new words and finding if a string matches any previously added string.
//
//Implement the WordDictionary class:
//
//WordDictionary() Initializes the object.
//void addWord(word) Adds word to the data structure, it can be matched later.
//bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise.
// word may contain dots '.' where dots can be matched with any letter.

import java.util.HashMap;

public class Problem211 {
    class TrieNode {

        HashMap<Character, TrieNode> children;
        boolean isWord;

        public TrieNode() {
            //this time using hashmap
            children = new HashMap<>();
            isWord = false;
        }
    }
    class WordDictionary {
        TrieNode root;

        public WordDictionary() {
            root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                //if hashmap's current letter doesnt have a TrieNode we add new
                if (!curr.children.containsKey(c)) curr.children.put(c, new TrieNode());
                //and move to next
                curr = curr.children.get(c);
            }
            curr.isWord = true;
        }

        public boolean search(String word) {
            return helper(0, root, word);
        }

        private boolean helper(int i, TrieNode curr, String word) {
            //base case if index is at the end of word
            if (i == word.length()) return curr.isWord;
            char c = word.charAt(i);
            if (c == '.') {
                //loop through every node on current TrieNode level if input is a dot
                for (TrieNode tn : curr.children.values()) {
                    if (helper(i + 1, tn, word)) return true;
                }
                return false;
            } else {
                //if not a dot move to next child's letter
                TrieNode child = curr.children.get(c);
                //return false if there's no letter
                if (child == null) return false;
                return helper(i+1, child, word);
            }
        }
    }
}
