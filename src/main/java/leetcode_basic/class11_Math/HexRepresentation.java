package leetcode_basic.class11_Math;

/**
 * Created by Dai on 2016/12/1.
 * 0's hex representation is "0x0"
 255's hex representation is "0xFF"
 */
public class HexRepresentation {
    public String hex(int number) {
        String prefix = "0x";
        if (number == 0) {
            return prefix + "0";
        }
        StringBuilder sb = new StringBuilder();
        while (number > 0) {
            // 取低4位，就像10进制，对10取余，只有最后一位决定了余数。
            // 低四位小于10，在char里加入‘0’的相对大小
            // 低四位大于10，在char里加入'A'的大小 - 10 右移4位
            int rem = number % 16;
            if (rem < 10) {
                sb.append((char)('0' + rem));
            }
            else {
                sb.append((char)(rem - 10 + 'A'));
            }
            number >>>= 4 ;
        }
        return prefix + sb.reverse().toString();
    }
    public static void main (String[] args) {
        HexRepresentation hp = new HexRepresentation();
        String result = hp.hex(255);
        System.out.println(result);
        System.out.println(8 % 16);
    }
}
