package leetcode_algorithm.class3_Stack_Queue;

/*
383. Ransom Note

Given an arbitrary ransom note string and another string containing letters from all the magazines,
write a function that will return true if the ransom note can be constructed from the magazines ; otherwise, it will return false.

Each letter in the magazine string can only be used once in your ransom note.

Note:
You may assume that both strings contain only lowercase letters.

canConstruct("a", "b") -> false
canConstruct("aa", "ab") -> false
canConstruct("aa", "aab") -> true
 */

public class RansomNote_383 {
    public boolean canConstruct(String ransomNote, String magazine) {
        char[] countA = new char[26];
        char[] countB = new char[26];
        for(char i : magazine.toCharArray()) {
            countB[i - 'a']++;
        }
        for(char i : ransomNote.toCharArray()) {
            countA[i - 'a']++;
            if(countA[ i- 'a'] > countB[i - 'a']) {
                return false;
            }
        }
        return true;
    }
}
