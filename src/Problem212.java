//Given an m x n board of characters and a list of strings words, return all words on the board.
//
//Each word must be constructed from letters of sequentially adjacent cells, where adjacent cells are horizontally
// or vertically neighboring. The same letter cell may not be used more than once in a word.


import java.util.*;

public class Problem212 {

    class TrieNode {
        //HashMap<Character, TrieNode> children;
        TrieNode[] children;
        boolean isWord;

        public TrieNode() {
            //children = new HashMap<>();
            children = new TrieNode[26];
            isWord = false;
        }
    }

    class Trie {
        TrieNode root;
        public Trie() {
            root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (curr.children[i] == null) curr.children[i] = new TrieNode();
                curr = curr.children[i];
//                //if hashmap's current letter doesnt have a TrieNode we add new
//                curr.children.putIfAbsent(c, new TrieNode());
//                //and move to next
//                curr = curr.children.get(c);
            }
            curr.isWord = true;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        HashSet<String> result = new HashSet<>();
        Trie trie = new Trie();
        //add words to Trie
        for (String word : words) {
            trie.addWord(word);
        }
        //loop through board
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                helper(board, "", i, j, trie.root, result);
            }
        }
        return new ArrayList<>(result);
    }

    private void helper(char[][] board, String prefix, int row, int col, TrieNode tn, HashSet<String> result){

        // check if its outside of the board or character not matching
        if (row < 0 ||
                row >= board.length ||
                col < 0 ||
                col >= board[0].length ||
//                !tn.children.containsKey(board[row][col]) ||
                board[row][col] == '*') {
            return;
        }

        // remove visited letters
        char tmp = board[row][col];

        tn = tn.children[tmp - 'a'];
        //tn = tn.children.get(board[row][col]);
        if (tn == null) return;
        prefix += board[row][col];
        if (tn.isWord) result.add(prefix);

        board[row][col] = '*';

        // look for a letter
        helper(board, prefix, row + 1, col, tn, result); // down
        helper(board, prefix, row - 1, col, tn, result); // up
        helper(board, prefix, row, col + 1, tn, result); // right
        helper(board, prefix, row, col - 1, tn, result);    // left

        // after looking from this position change back the character to normal
        board[row][col] = tmp;
    }
}
