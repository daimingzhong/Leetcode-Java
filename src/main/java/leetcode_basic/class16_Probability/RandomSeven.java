package leetcode_basic.class16_Probability;

public class RandomSeven {
    public int random7() {
        while (true) {
            int a = RandomFive.random5();
            int b = RandomFive.random5();
            int result = (a * 5 + b); // a * 5 相当于5进制的高一位，b相当于低一位。
            if (result <= 20) {
                return result % 7;
            }
        }
    }
    public  static void main(String[] args) {
        RandomSeven r7 = new RandomSeven();
        System.out.print(r7.random7());
    }
}



