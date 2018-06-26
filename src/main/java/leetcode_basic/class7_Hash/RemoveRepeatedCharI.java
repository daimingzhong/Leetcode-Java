package leetcode_basic.class7_Hash;

/**
 * Created by Dai on 2016/12/4.
 * “aaaabbbc” is transferred to “abc”
 */
public class RemoveRepeatedCharI {
    public String deDup(String input) {
        if (input == null) {
            return null;
        }
        char[] array = input.toCharArray();
        int i = 0;
        for (int j = 0; j <input.length();j++) {
            if (i == 0) {
                array[i] = array[j];
                i++;
            }
            else if (array[j] != array[i - 1]) {
                array[i] = array[j];
                i++;
            }
        }
        return new String(array, 0 ,i);
    }

    public static void main(String[] args){
        RemoveRepeatedCharI rp = new RemoveRepeatedCharI();
        System.out.println(rp.deDup("aaaaabb"));
    }
}