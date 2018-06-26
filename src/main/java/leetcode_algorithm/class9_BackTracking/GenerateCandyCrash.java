package leetcode_algorithm.class9_BackTracking;

/*

给一个 n * n 的 box，RGB三种球。
保证生成的图里，每行每列不会有三个连续的球。

//        // 只能生成第一组正确的解。
//        for (int i = 0; i < n; i++) {
//            for (int j = 0; j < n; j++) {
//                for (Ball ball : colors) {
//                    if (!isValid(cur, i, j)) {
//                        break;
//                    } else {
//                        cur.get(i).add(ball);
//                 }}}
 */

import java.util.ArrayList;
import java.util.List;

class Ball {
    private String color;
    public Ball(String color) {
        this.color = color;
    }
}

public class GenerateCandyCrash {

    private Ball[] colors = {new Ball("R"), new Ball("G"), new Ball("B")};

    public List<List<List<Ball>>> generate(int n) {
        List<List<List<Ball>>> res = new ArrayList<>();
        dfs(n, new ArrayList<>(), res, 0, 0);
        return res;
    }


    // 二维指针不太好写。
    // 多一行的时候，手动add。bt之后，手动删掉一行。另外删一个点。
    public void dfs(int n, List<List<Ball>> cur, List<List<List<Ball>>> res, int row, int col) {
        // row == n, col == 0
        if (row == n) {
            // List<List<Ball>> tmp = new ArrayList<>(cur); 这么写，里面的指针没有变过。cur[0]删掉一个节点，tmp也就丢一个。
            // 这里是错的。要手动建立一个二维的arraylist。
//            List<List<Ball>> tmp = new ArrayList<List<Ball>>(cur);
//            List<List<Ball>> tmp = new ArrayList<>();
//            Collections.copy(tmp, cur);
//            res.add(tmp);
            res.add(new ArrayList<>(cur));
            return;
        }

        for (Ball ball : colors) {
            if (!isValid(cur, row, col)) {
                break;
            } else {
                if (col == 0) {
                    cur.add(new ArrayList<>());
                }
                cur.get(row).add(ball);
            }
            // 这里可以也可以写cur.size() < n - 1
            if (col < n - 1) {
                dfs(n, cur, res, row, col + 1);
            }
            else {
                dfs(n, cur, res, row + 1, 0);
            }
            cur.get(row).remove(cur.get(row).size() - 1);
            if (col == 0) { // 删除一整行的时候
                cur.remove(cur.size() - 1);
            }
        }
    }

    public List<List<Ball>> generate2(int n) {
        List<List<Ball>> res = new ArrayList<>();
        dfs2(n, new ArrayList<>(),res, 0);
        return res;
    }

    // 一维
    public void dfs2(int n, List<Ball> cur, List<List<Ball>> res, int col) {
        // row == n, col == 0
        if (cur.size() == n * n) {
            res.add(new ArrayList<Ball>(cur));
            return;
        }
        for (Ball ball : colors) {
            if (isValid2(cur, col, n)) {
                cur.add(ball);
                dfs2(n, cur, res, col + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }

    private boolean isValid(List<List<Ball>> cur, int i, int j) {
        return true;
    }

    private boolean isValid2(List<Ball> cur, int col, int n) {
        int row = col / n;
        int col2 = col - row * n;
        return true;
    }

    public static void main(String[] args) {
        GenerateCandyCrash generateCandyCrash = new GenerateCandyCrash();
        List<List<List<Ball>>> res = generateCandyCrash.generate(1);
        List<List<Ball>> res2 = generateCandyCrash.generate2(1);
        System.out.println(10);
    }
}
