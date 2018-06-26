package leetcode_basic.class12_DP;

/**
 * Created by Dai on 2016/12/10.
 * {1, 3, 2, 0, 3}, we are able to reach the end of array
 * (jump to index 1 then reach the end of the array)
 * {2, 1, 1, 0, 2}, we are not able to reach the end of array
 * // 从前往后，从后往前都可以
 */
public class ArrayHopperI {
    private boolean canJump(int[] array) {
        if (array.length == 0) {
            return true;
        }
        boolean[] result = new boolean[array.length];
        result[0] = true;
        for (int i = 0; i < array.length; i++) {
            if (!result[i]) {
                return false;
            }
            if (i + array[i] < array.length) {
                for (int j = i; j <= i + array[i]; j++) {
                    result[j] = true;
                }
            } else {
                result[array.length - 1] = true;
            }
        }
        return result[array.length - 1];
    }

    private boolean canJumpIII(int[] array) {
        if(array.length == 1) {
            return true;
        }
        int cur = 0;
        int next = 0;
        for(int i = 0; i < array.length; i++) {
            if(i > cur) {
                if (cur == next) {
                    return false;
                }
                cur = next;
            }
            next = Math.max(next, i + array[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        ArrayHopperI ah = new ArrayHopperI();
        boolean result = ah.canJumpIII(new int[]{1, 3, 2, 0, 3}); //只有一个0，也算跳到终点
        System.out.println(result);
    }
}
