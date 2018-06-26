package leetcode_algorithm.class7_Hash;

/*
408. Valid Word Abbreviation

Given a non-empty string s and an abbreviation abbr, return whether the string matches with the given abbreviation.

A string such as "word" contains only the following valid abbreviations:

["word", "1ord", "w1rd", "wo1d", "wor1", "2rd", "w2d", "wo2", "1o1d", "1or1", "w1r1", "1o2", "2r1", "3d", "w3", "4"]
Notice that only the above abbreviations are valid abbreviations of the string "word". Any other string is not a valid abbreviation of "word".

Note:
Assume s contains only lowercase letters and abbr contains only lowercase letters and digits.

Example 1:
Given s = "internationalization", abbr = "i12iz4n":

Return true.
Example 2:
Given s = "apple", abbr = "a2e":

Return false.

1. digit (check if the next char is digit)
1.1 the next is digit, append while the next is not.
1.2 the next is not.

2. char. check if equals.

 */

public class ValidWordAbbreviation_408 {
    public boolean validWordAbbreviation(String word, String abbr) {
        if(word == null || abbr == null) {
            return false;
        }
        int index = 0;
        for(int i = 0; i < abbr.length(); i++) {
            int count = 0;
            if (isDigit(abbr.charAt(i))) {
                count = abbr.charAt(i);
                if(i < abbr.length() - 1) {
                    while (isDigit(abbr.charAt(++i))) {
                        count = count * 10 + abbr.charAt(i);
                    }
                }
                index += count;
            } else if (word.length() < count + 1 || abbr.charAt(i) != word.charAt(index)) {
                return false;
            }
            index++;
        }
        return true;
    }

    private boolean isDigit(char i) {
        if(i - '0' >= 0 && i - '9' <= 0) {
            return true;
        }
        return false;
    }

    public boolean validWordAbbreviation2(String word, String abbr) {
        int i = 0, j = 0;
        while (i < word.length() && j < abbr.length()) {
            if (word.charAt(i) == abbr.charAt(j)) {
                ++i;++j;
                continue;
            }
            if (abbr.charAt(j) <= '0' || abbr.charAt(j) > '9') {
                return false;
            }
            int start = j;
            while (j < abbr.length() && abbr.charAt(j) >= '0' && abbr.charAt(j) <= '9') {
                ++j;
            }
            int num = Integer.valueOf(abbr.substring(start, j));
            i += num;
        }
        return i == word.length() && j == abbr.length();
    }

    public boolean validWordAbbreviation3(String word, String abbr) {
        int lengthOfWord = word.length();
        int count = 0;
        int index = 0;
        while (index < abbr.length()) {
            int digit = 0;
            while (index < abbr.length() && Character.isDigit(abbr.charAt(index))) {
                if (abbr.charAt(index) == '0' && digit == 0) return false;
                else {
                    digit = digit * 10 + Integer.parseInt(abbr.charAt(index) + "");
                    index++;
                }
            }
            count += digit;
            if (index < abbr.length() && Character.isLetter(abbr.charAt(index))) {
                if (count >= word.length()) return false;
                if (abbr.charAt(index) != word.charAt(count)) return false;
                else {
                    count++;
                    index++;
                }
            }
        }
        return lengthOfWord == count;
    }

    public static void main(String[] args) {
        ValidWordAbbreviation_408 vw = new ValidWordAbbreviation_408();
        boolean res = vw.validWordAbbreviation("word", "w1d");
        System.out.println(res);
    }
}