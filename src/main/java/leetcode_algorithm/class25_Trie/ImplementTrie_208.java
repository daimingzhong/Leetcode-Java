package leetcode_algorithm.class25_Trie;

import leetcode_algorithm.class0.TrieNode;

/*
time : O(n)  n: word.length();
O(num of TrieNode * 26) = O(num of Words * word.length() * 26)

每一个方法都要能够access到root。所以变成instance varibale
*/


public class ImplementTrie_208 {

    // 重点是一开始简历了一个dummy node。之后也不要修改dummy node，直接复制引用。
    private TrieNode root =  new TrieNode();

    public void insert(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int j = word.charAt(i) - 'a';
            if (node.letter[j] == null) {
                node.letter[j] = new TrieNode();
            }
            node = node.letter[j];
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int j = word.charAt(i) - 'a';
            if (node.letter[j] == null) {
                return false;
            }
            node = node.letter[j];
        }
        return node.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (int i = 0; i < prefix.length(); i++) {
            int j = prefix.charAt(i) - 'a';
            if (node.letter[j] == null) {
                return false;
            }
            node = node.letter[j];
        }
        return true;
    }

    public static void main(String[] args) {
        ImplementTrie_208 implementTrie_208 = new ImplementTrie_208();
        implementTrie_208.insert("abc");
        implementTrie_208.insert("abcd");
        implementTrie_208.insert("abd");
        System.out.println(implementTrie_208.search("ab"));  // false
        System.out.println(implementTrie_208.search("abc"));  // true
        System.out.println(implementTrie_208.startsWith("b"));  // false
        System.out.println(implementTrie_208.startsWith("ab"));  // true

//        ImplementTrie_208.TrieNode trieNode = implementTrie_208.new TrieNode();
    }

}
