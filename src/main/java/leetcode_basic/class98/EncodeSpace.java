package leetcode_basic.class98;

/**
 * Created by Dai on 2017/1/1.

 In URL encoding, whenever we see an space " ", we need to replace it with "20%".
 Provide a method that performs this encoding for a given string.

 "google/q?flo wer market" → "google/q?flo20%wer20%market"

 */
public class EncodeSpace {
    public String encode(String input) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i)  != ' ') {
                result.append(input.charAt(i));
            }
            else {
                result.append("20%");
            }
        }
        return result.toString();
    }

    public static void main (String[] args) {
        EncodeSpace es = new EncodeSpace();
        String result = es.encode("ab ab");
        System.out.println(result);
    }
}