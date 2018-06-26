package leetcode_basic.class27_PracticeVI;

/**
 * Created by Dai on 2016/12/3.
 * A = {1, 2, 1, 2, 1}, return 1
 * 这个题是我小米的面试题。
 * majority number不是众数，而是大于0.5*总次数。
 * 摩尔投票法，
 */
public class MajorityNumberI {
    public int majority(int[] array) {
        int time = 1;
        int result = array[0];
        for (int i = 1; i < array.length; i++ ) {
            if (time == 0) {
                result = array[i];
                time = 1;
            }
            //else if (time > 0) {
                if (array[i] == result) {
                    time++;
                }
                else
                    time--;

            }
        //}
        return result;
    }
    public int majority2(int[] array) {
        int time = 0;
        int result = -1;
        for (int i = 1; i < array.length; i++ ) {
            if (time == 0) {
                result = array[i];
                time = 1;
            }
            if (array[i] == result) {
                time++;
            }
            else
                time--;
        }
        return result;
    }

    public static void main (String[] args) {
        MajorityNumberI mn = new MajorityNumberI();
        int result = mn.majority(new int[]{1,2,5,1,1,1});
        System.out.print(result);
    }
}
