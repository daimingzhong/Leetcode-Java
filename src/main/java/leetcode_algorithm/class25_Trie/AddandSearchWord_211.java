package leetcode_algorithm.class25_Trie;

import leetcode_algorithm.class0.TrieNode;

/**
 * 211. Add and Search Word - Data structure class27_OOD
 * class27_OOD a data structure that supports the following two operations:

 void addWord(word)
 bool search(word)
 search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

 For example:

 addWord("bad")
 addWord("dad")
 addWord("mad")
 search("pad") -> false
 search("bad") -> true
 search(".ad") -> true
 search("b..") -> true
 */

public class AddandSearchWord_211 {

    private TrieNode root = new TrieNode();

    public AddandSearchWord_211() {
    }

    public void addWord(String word) {   // bad
        TrieNode node = root;
        for (int i = 0; i < word.length(); i++) {
            int j = word.charAt(i) - 'a';
            if (node.letter[j] == null) {
                node.letter[j] = new TrieNode();
            }
            node = node.letter[j];
        }
        node.isWord = true;
        node.curWord = word;
    }

    public boolean search(String word) {
        return find(word, root, 0);
    }

    public boolean find(String word, TrieNode node, int index) {
        if (index == word.length()) {
            return node.isWord;  //!node.word.equals("");
        }
        if (word.charAt(index) == '.') {
            for (TrieNode temp : node.letter) {
                if (temp != null && find(word, temp, index + 1)) {
                    return true;
                }
            }
            // 遍历完了才有false，其中任意一个挂掉了，并没有返回值。
            return false;
        } else {
            int j = word.charAt(index) - 'a';  //
            // child其实是个array，所以可以直接索引。类似hashmap。存的位置其实是几乎绝对的。
            TrieNode temp = node.letter[j];
            return temp != null && find(word, temp, index + 1);
        }
    }

    public static void main(String[] args) {
        AddandSearchWord_211 addandSearchWord = new AddandSearchWord_211();
        addandSearchWord.addWord("bad");
        addandSearchWord.addWord("bap");
        System.out.println(addandSearchWord.search("bad"));
        System.out.println(addandSearchWord.search(".ad"));
        System.out.println(addandSearchWord.search(".aa"));
    }
}
