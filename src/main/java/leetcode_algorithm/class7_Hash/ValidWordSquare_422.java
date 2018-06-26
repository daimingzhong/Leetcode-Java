package leetcode_algorithm.class7_Hash;

import java.util.List;

/*
Given a sequence of words, check whether it forms a valid word square.

A sequence of words forms a valid word square if the kth row and column read the exact same string, where 0 ≤ k < max(numRows, numColumns).

Note:
The number of words given is at least 1 and does not exceed 500.
Word length will be at least 1 and does not exceed 500.
Each word contains only lowercase English alphabet a-z.
Example 1:

Input:
[
  "abcd",
  "bnrt",
  "crmy",
  "dtye"
]

Output:
true

Explanation:
The first row and first column both read "abcd".
The second row and second column both read "bnrt".
The third row and third column both read "crmy".
The fourth row and fourth column both read "dtye".

Therefore, it is a valid word square.
 */
public class ValidWordSquare_422 {
    public boolean validWordSquare(List<String> words) {
        if(words.size() == 0) {
            return true;
        }
        for(int i = 0; i<words.size(); i++) {
            StringBuilder sb = new StringBuilder();
            for(int j = 0; j < words.size(); j++) {
                if(words.get(j).length() < i + 1) {
                    break;
                }
                sb.append(words.get(j).charAt(i));
            }
            if(!words.get(i).equals(sb.toString())) {
                return false;
            }
        }
        return true;
    }
}
