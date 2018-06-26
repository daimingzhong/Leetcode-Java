package leetcode_algorithm.class10_Graph;

/*
//class Pair {
//    float x;
//    float y;
//    public Pair(float x, float y) {
//        this.x = x;
//        this.y = y;
//    }
//}
判断P是否在ABC组成的三角形内。
*/
import java.util.List;

public class InsideTriangle {
    // polygon has three vertex
    public boolean isInsideTriangle(List<Point> polygon, Point P) {
        Point A = polygon.get(0);
        Point B = polygon.get(1);
        Point C = polygon.get(2);
        float t1 = crossMultiply(P, A, B); // PA ^ PB
        float t2 = crossMultiply(P, B, C); // PB * PC
        float t3 = crossMultiply(P, C, A); // PC * PA
        return ((t1 >= 0 && t2>= 0 && t3 >= 0) || (t1 <= 0 && t2 <= 0 && t3 <= 0));
    }

    public float crossMultiply(Point P, Point A, Point B) {
        return (A.x - P.x) * (B.y - P.y) - (A.y - P.y) * (B.x - P.x);
    }
}
