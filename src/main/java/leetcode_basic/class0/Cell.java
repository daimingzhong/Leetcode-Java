package leetcode_basic.class0;

/**
 * Created by Dai on 2016/10/22.
 */

/*
1. Initial state A[0]+B[0]
2. Expansion A[i]+B[j]
   Generate A[i+1]+B[j+1]
            A[i]+B[j+1]
3. Temination: k-th element is poped out
*/

public class Cell {
    public int aldx;
    public int bldx;
    public Cell(int aldx, int bldx) {
        this.aldx = aldx;
        this.bldx = bldx;
    }
}
