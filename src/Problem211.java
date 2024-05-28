//Design a data structure that supports adding new words and finding if a string matches any previously added string.
//
//Implement the WordDictionary class:
//
//WordDictionary() Initializes the object.
//void addWord(word) Adds word to the data structure, it can be matched later.
//bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise.
// word may contain dots '.' where dots can be matched with any letter.

public class Problem211 {
    class TrieNode {

        TrieNode[] children;
        boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];
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
                int i = c - 'a';
                if (curr.children[i] == null) curr.children[i] = new TrieNode();
                curr = curr.children[i];
            }
            curr.isWord = true;
        }

        public boolean search(String word) {
            return helper(0, root, word);
        }

        private boolean helper(int j, TrieNode tn, String word) {
            TrieNode curr = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (c == '.') {
                    for (TrieNode t : curr.children) {
                        if (helper(j + 1, tn, word)) return true;
                    }
                    return false;
                } else {
                    if (curr.children[c] == null) return false; //TODO: not working
                    curr = curr.children[c];
                }
            }
            return curr.isWord;
        }
    }
}
