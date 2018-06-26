package leetcode_basic.class7_Hash;

/**
 * Created by Dai on 2016/10/22.
 * “   I     love MTV ” --> “I love MTV”
 */
public class RemoveSpaces {
    public String removeSpaces(String input) {
        if(input.isEmpty()) {
            return input; //不是null。因为返回需要“”，不等于null
        }
        char[] array = input.toCharArray();
        int end =0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == ' ' && (i==0 || array[i-1] == ' ')) {
                continue; //结束本次for循环，跳出stack一次？
            }
            array[end++] = array[i];
        }
        if (end > 0 && array[end -1] == ' ') {
            return new String(array, 0, end-1);
        }
        else {
            return new String(array,0,end);
        }
    }

    public static void main(String[] args) {
        RemoveSpaces rem = new RemoveSpaces();
        System.out.println(rem.removeSpaces("  I  have a   book   "));
    }
}
