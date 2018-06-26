package leetcode_algorithm.class25_Trie;

import leetcode_algorithm.class0.TrieNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a 2D board and a list of words from the dictionary, find all words in the board.

 Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

 For example,
 board =
 [
 ['o','a','a','n'],
 ['e','t','a','e'],
 ['i','h','k','r'],
 ['i','f','l','v']
 ]
 Given words = ["oath","pea","eat","rain"]

 Return ["eat","oath"].

 time : O(m * n * TrieNode)
 space : TrieNode

 //class TrieNode {
 //    TrieNode[] letter = new TrieNode[26];
 //    String word;
 //}

 */

class BuildTrie {
     static TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode p = root;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (p.letter[i] == null) {
                    p.letter[i] = new TrieNode();
                }
                p = p.letter[i];
            }
            p.curWord = word;
        }
        return root;
    }
}

public class WordSearchII_212 {
    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();
        TrieNode root = BuildTrie.buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    private void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) {
            return;
        }
        char c = board[i][j];
        if (c == '#' || p.letter[c - 'a'] == null) {
            return;
        }
        p = p.letter[c - 'a'];
        if (p.curWord != null) {
            res.add(p.curWord);
            p.curWord = null;
        }
        board[i][j] = '#';
        dfs(board, i - 1, j, p, res);
        dfs(board, i + 1, j, p, res);
        dfs(board, i, j + 1, p, res);
        dfs(board, i, j - 1, p, res);
        board[i][j] = c;
    }


/*
[
['o','a','a','n'],
['e','t','a','e'],
['i','h','k','r'],
['i','f','l','v']
]
*/
    public static void main(String[] args) {
        WordSearchII_212 wordSearchII_212 = new WordSearchII_212();
        char[][] board = new char[][]{{'o','a','a','n'}, {'e','t','a','e'}, {'i','h','k','r'}, {'i','f','l','v'}};
        String[] words = new String[]{"oath","eat","pea","rain"};
        List<String> res = wordSearchII_212.findWords(board, words);
        // 返回的长度是8，有很多null？？？
        for (String tmp : res) {
            System.out.println(tmp);
        }
    }
}
