package leetcode_basic.class8_String;

/**
 * Created by Dai on 2016/12/6.
 */
public class ReverseString {
    public String reverse (String input) {
        char[] array = input.toCharArray();
        for (int i = 0; i < array.length / 2; i++) { // 最多只能转一般，如果全转了，就等于没转
            swap(array, i, array.length - i - 1);
        }
        return new String(array);
    }
    private void swap (char[] array, int a ,int b) {
        char tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }
    
    public static void main (String[] args) {
        String a = "hello";
        ReverseString rs = new ReverseString();
        System.out.println(rs.reverse(a));
    }
}
