package leetcode_basic.class16_Probability;

/**
 * Created by Dai on 2016/11/11.
 */
public class RandomOneThousand {
    public int random1000() {
        while (true) {
            int result = 0;
            for (int i = 0; i<= 4; i++) {
                int a = RandomFive.random5();// static 方法 必须放在里面，每次迭代才会变值
                result = result*5 + a;
            }
            if (result < 3000) {
                return result % 1000;
            }
            //else{ no need to write else
            //}

        }
    }
    public  static void main(String[] args) {
        RandomOneThousand r1000 = new RandomOneThousand();
        System.out.print(r1000.random1000());
    }
}