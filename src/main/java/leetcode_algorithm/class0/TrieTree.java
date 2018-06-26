package leetcode_algorithm.class0;

/*
https://www.youtube.com/watch?v=f48wGD-MuQw
implementation of prefix tree  
 */

public class TrieTree {

    private TrieNode root;

    public TrieTree() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode p = root;
        for (int i = 0; i < word.length(); i++) {
            int index = (int) (word.charAt(i) - 'a');
            if (p.letter[index] == null) {
                p.letter[index] = new TrieNode();
            }
            p = p.letter[index];
        }
        p.isWord = true;
    }

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        TrieNode node = find(word);
        return node != null && node.isWord;
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        TrieNode node = find(prefix);
        return node != null;
    }

    private TrieNode find(String prefix) {
        TrieNode p = root;
        for (int i = 0; i < prefix.length(); i++) {
            int index = (int) (prefix.charAt(i) - 'a');
            if (p.letter[index] == null) {
                return null;
            }
            p = p.letter[index];
        }
        return p;
    }
}