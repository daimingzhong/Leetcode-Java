package leetcode_basic.class8_String;

/**
 * Created by Dai on 2016/12/7.
 * “a1c0b2c4” → “abbcccc”
 * The string is not null
 * The characters used in the original string are guaranteed to be ‘a’ - ‘z’
 * There are no adjacent repeated characters with length > 9
 */
public class DecompressStringII{
    public String decompress(String input) {
        char[] array = input.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            char ch = array[i++];
            int count = array[i] - '0';
            for (int c = 0; c < count; c++) {
                sb.append(ch);
            }
        }
        return sb.toString();
    }
    public static void main (String[] args) {
        DecompressStringII ds = new DecompressStringII();
        System.out.print(ds.decompress("a1c0b2c4"));
    }
}
