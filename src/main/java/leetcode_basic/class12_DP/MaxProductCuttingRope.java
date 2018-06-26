package leetcode_basic.class12_DP;

/**
 * Created by Dai on 2016/12/10.
 * n = 12, the max product is 3 * 3 * 3 * 3 = 81
 * cut the rope into 4 pieces with length of each is 3.
 */
public class MaxProductCuttingRope {
        // base case: m[1] = 1 m[2] = 1*1
        // m [3] = max(m2 ,2 )* 1 因为2不会拆分自己。
        // induction rule : m[k] = m[k-1] + 1,
        // if array[k] > array[k-1], else m[k] = 1;
        // m[k] = max(max(m[j],j)) * (k-j)
        public  int maxProduct(int num) {
            int[] m = new int[num+1];
            int flag = 0;
            for (int i = 0; i <= num; i++) {
                for (int j = i-1; j >= 1; j--) {
                    m[i] = (Math.max(m[j],j)) * (Math.max(m[i-j],i-j));
                    if (m[i] > flag){
                        flag = m[i];
                    }
                    m[i] = flag;
                }
            }
            return flag; // 别忘了返回
        }

        public  int maxProduct2(int num) {
            int[] m = new int[num+ 1];
            int max = 0;
            m[0] = 1;
            for (int i = 1; i <= num; i++) {
                for (int j = 1; j <= i; j++) {
                    // m[i] = Math.max(m[i - j], i - j) * j;
                    m[i] = Math.max( Math.max(m[j], j) *(i - j), m[i]);
                    // m[i] 在这里表示曾经出现过的最大值，如果不写的话，m[i]会被最后一次循环顶掉。
                    max = Math.max(max, m[i]);
                }
            }
            return max;
        }

    public static void main(String[] args) {
        MaxProductCuttingRope solution = new MaxProductCuttingRope();
        int length = 10;
        int k =solution.maxProduct2(length);
        System.out.println(k);
    }
}
