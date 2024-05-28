//Implement the Trie class:
//
//Trie() Initializes the trie object.
//void insert(String word) Inserts the string word into the trie.
//boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
//boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.

public class Problem208 {
//create trienode structure
    class TrieNode {

        TrieNode[] children;
        boolean isWord;

        public TrieNode() {
            //create an array with every english lowercase character
            children = new TrieNode[26];
            isWord = false;
        }
    }

    class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                //calculate index based on ascii
                int i = c - 'a';
                //if theres no character add a new children
                if (curr.children[i] == null) curr.children[i] = new TrieNode();
                //move current pointer to its child
                curr = curr.children[i];
            }
            curr.isWord = true;
        }

        public boolean search(String word) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (curr.children[i] == null) return false;
                curr = curr.children[i];
            }
            return curr.isWord;
        }

        public boolean startsWith(String prefix) {
            TrieNode curr = root;
            for (char c : prefix.toCharArray()) {
                int i = c - 'a';
                if (curr.children[i] == null) return false;
                curr = curr.children[i];
            }
            return true;
        }
    }
}
