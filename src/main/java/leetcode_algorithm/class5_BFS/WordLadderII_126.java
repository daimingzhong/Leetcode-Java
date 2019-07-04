package leetcode_algorithm.class5_BFS;

import java.util.*;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list,
 * find all shortest transformation sequence(s) from beginWord to endWord, such that:
 * 要找出所有最短的。
 * <p>
 * Only one letter can be changed at a time
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * For example,
 * <p>
 * Given:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * Return
 * [
 * ["hit","hot","dot","dog","cog"],
 * ["hit","hot","lot","log","cog"]
 * ]
 * <p>
 * BFS + DFS
 * <p>
 * 无向图 -> BFS -> 树 -> DFS -> 结果
 * <p>
 * hit -> hot -> dot -> dog - cog
 * -> lot -> log - cog
 * <p>
 * map : hot (hit)
 * dot (hot)
 * lot (hot)
 * dog (dot)
 * log (lot)
 * cog (dog,log)
 * <p>
 * time : O(V + E) * wordList(max(length))  不确定
 * O(n ^ 2)
 * space : O(n)
 * <p>
 * 把find neightbor抽出来变成函数比较好
 */

public class WordLadderII_126 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> res = new ArrayList<>();
        if (wordList.size() == 0) return res;

        int curNum = 1;
        int nextNum = 0;
        boolean found = false;

        Queue<String> queue = new LinkedList<>();
        HashSet<String> unvisited = new HashSet<>(wordList);  // list to set. unvisited只减不增
        HashSet<String> visited = new HashSet<>();

        HashMap<String, List<String>> map = new HashMap<>();

        queue.offer(beginWord);
        while (!queue.isEmpty()) {
            String word = queue.poll();
            curNum--;
            for (int i = 0; i < word.length(); i++) {
                StringBuilder builder = new StringBuilder(word);
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    builder.setCharAt(i, ch);
                    String newWord = builder.toString();
                    if (unvisited.contains(newWord)) {  // 没有访问过newWord
                        if (visited.add(newWord)) {
                            nextNum++;
                            queue.offer(newWord);
                        }
                        if (map.containsKey(newWord)) {
                            map.get(newWord).add(word);  // 到某一个地方有两条路，就存两个值。e.x cog: [dog,log]
                        } else {
                            List<String> list = new ArrayList<>();  // 之前value是空的，就新建一个list
                            list.add(word);
                            map.put(newWord, list);
                        }
                        if (newWord.equals(endWord)) {
                            found = true;
                        }
                    }
                }
            }
            if (curNum == 0) {
                if (found) {  // 等遍历完当前层，如果found了，就break。更新下面的参数其实没意义。
                    break;
                }
                curNum = nextNum;
                nextNum = 0;
                unvisited.removeAll(visited);
                visited.clear();
            }
        }
        //  if (found) {dfs(res, new ArrayList<>(), map, endWord, beginWord); } 没有found 没必要dfs
        dfs(res, new ArrayList<>(), map, endWord, beginWord);
        return res;
    }

    private void dfs(List<List<String>> res, List<String> list, HashMap<String, List<String>> map, String word, String start) {
        if (word.equals(start)) {
            list.add(0, start);
            res.add(new ArrayList<>(list));
            // list.remove(list.size - 1)
            list.remove(0);
            return;
        }
        list.add(0, word);
        if (map.get(word) != null) {
            for (String s : map.get(word)) {
                dfs(res, list, map, s, start);
            }
        }
        list.remove(0);
    }

    /*
    Given:
    beginWord = "hit"
    endWord = "cog"
    wordList = ["hot","dot","dog","lot","log","cog"]

    Return
    ["hit","hot","dot","dog","cog"], ["hit","hot","lot","log","cog"]
     */
    public static void main(String[] args) {
        WordLadderII_126 wordLadderII_126 = new WordLadderII_126();
        String beginWord = "hit";
        String endWord = "cog";
        String[] wordList = {"hot", "dot", "dog", "lot", "log", "cog"};
        List<List<String>> res = wordLadderII_126.findLadders(beginWord, endWord, new ArrayList<String>(Arrays.asList(wordList)));
        for (List<String> list : res) {
            System.out.println(list);
        }
    }
}
