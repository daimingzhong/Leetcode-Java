package leetcode_algorithm.class10_Graph;

/*
凹凸叉oa

polygon represented
vector<Point<float_x, float_y>>
vector<Point<float_x, float_y>>
 */

import java.util.ArrayList;
import java.util.List;

class Point {
    float x;
    float y;
    public Point(float x, float y) {
        this.x = x;
        this.y = y;
    }
}

public class InsidePolygon {
    public int numInsidePolygon(List<Point> polygon, List<Point> points) {
        int count = 0;
        for (Point P : points) {
            if(isInsidePolygon(polygon, P)) {
                count++;
            }
        }
        return count;
    }

    public boolean isInsidePolygon(List<Point> polygon, Point P) {
        for (int i = 1; i < polygon.size(); i++) {
            for (int j = 1; j < polygon.size(); j++) {
                if (isInsideTriangle(polygon.get(0), polygon.get(i), polygon.get(j), P)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isInsideTriangle(Point A, Point B, Point C, Point P) {
        float t1 = crossMultiply(P, A, B); // PA * PB
        float t2 = crossMultiply(P, B, C); // PB * PC
        float t3 = crossMultiply(P, C, A); // PC * PA
        if ((t1 > 0 && t2 > 0 && t3 > 0) || (t1 < 0 && t2 < 0 && t3 < 0)) {
            return true;
        };
        if ((t1 == 0 && t2 * t3 > 0 || (t2 == 0 && t1 * t3 >0) || (t3 == 0 && t1 * t2 >0))) {
            return true;
        }
        return false;
    }

    public float crossMultiply(Point P, Point A, Point B) {
        return (A.x - P.x) * (B.y - P.y) - (A.y - P.y) * (B.x - P.x);
    }

    public static void main(String[] args) {
        InsidePolygon polygon = new InsidePolygon();
        List<Point> pointList = new ArrayList<>();
        pointList.add(new Point(0, 0));
        pointList.add(new Point(3, -4));
        pointList.add(new Point(4, 0));
        pointList.add(new Point(3, 4));

        List<Point> myPoint = new ArrayList<>();
        myPoint.add(new Point(2, 2));
        myPoint.add(new Point(2, 1));
        myPoint.add(new Point(2, 0));
        int res = polygon.numInsidePolygon(pointList, myPoint);
        System.out.println(res);
    }
}
