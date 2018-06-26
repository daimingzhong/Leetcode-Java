package leetcode_basic.class13_DPII;

/**
 * Created by Dai on 2016/12/11.
 * {3, 3, 1, 0, 4}, the minimum jumps needed is 2 (jump to index 1 then to the end of array)
 * {2, 1, 1, 0, 2}, you are not able to reach the end of array, return -1 in this case.
 *  一种做法，是全都置0，除了第一个能是0，其他遇到0，就是false
 *  另一种做法是全都置-1，第一个置0，如果之后遇到-1了，就false。
 */
public class ArrayHopperII {
    public int minJump(int[] array) {
        int[] result = new int[array.length];
        result[0] = 0;
        for (int i = 0; i < array.length; i++) {
            if (i != 0 && result[i] == 0) { // z这里判断的是result，不是array
                return -1 ;
            }
            for (int j = i + 1; j <= i + array[i] && j < array.length; j++) {
                if (result[j] == 0 || result[i] + 1 < result[j]) {
                    result[j] = result[i] + 1;
                }
            }
        }
        return result[array.length - 1];
    }

    public static void main (String[] args) {
        ArrayHopperII ah = new ArrayHopperII();
        int result = ah.minJump(new int[]{3, 3, 1, 0, 4}); //只有一个0，也算跳到终点
        System.out.println(result);
    }
}
