package leetcode_basic.class98;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Dai on 2017/1/1.
 the characters used in "abcd" are unique
 the characters used in "aba" are not unique
 */
public class AllUniqueCharactersI {
    public boolean allUnique(String word) {
        Set<Character> set = new HashSet<>(); // 容器内只能是object
        for (int i = 0; i < word.length(); i++) {
            if (set.contains(word.charAt(i))) {
                return false;
            }
            else {
                set.add(word.charAt(i));
            }
        }
        return true;
    }
}
