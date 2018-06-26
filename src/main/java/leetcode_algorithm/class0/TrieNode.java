package leetcode_algorithm.class0;

public class TrieNode {
    public boolean isWord;
    public TrieNode[] letter;
    public String curWord = null;

    public TrieNode() {
        letter = new TrieNode[26];
        isWord = false;
    }

}
