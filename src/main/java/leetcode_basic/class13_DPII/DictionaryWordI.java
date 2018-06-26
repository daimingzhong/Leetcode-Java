package leetcode_basic.class13_DPII;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dai on 2016/12/11.
 * Dictionary: {“bob”, “cat”, “rob”}
 * Word: “ro bob” return false
 * Word: "rob cat bob" return true since it can be composed by "rob", "cat", "bob"
 */
public class DictionaryWordI {
    public boolean canBreak(String input, String[] dict) {
        Set<String> dic = helper(dict);
        boolean[] canBreak = new boolean[input.length() + 1];
        canBreak[0] = true;// 第0个标志位，用于判断第一个输入是否正确。
        for(int i = 1; i < canBreak.length; i++) {
            for (int j = 0; j < i; j++) {
                if (dic.contains(input.substring(j,i)) && canBreak[j]) {
                    canBreak[i] = true;// 优化解法，j只检查最大长度
                    break;
                }
            }
        }
        return canBreak[input.length()];
    }

    private Set<String> helper(String[] dict) {
        Set<String> set = new HashSet<>();
        for (String s : dict) {
            set.add(s);
        }
        return set;
    }

    public static void main (String[] args) {
        DictionaryWordI dw = new DictionaryWordI();
        String[] dict = {"ab", "cd"};
        String input = "abcde";
        System.out.print(dw.canBreak(input, dict));
    }
}
