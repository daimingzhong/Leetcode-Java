package leetcode_algorithm.class27_OOD;

/*
Flatten 2D Vector
Implement an iterator to flatten a 2d vector.

For example,
Given 2d vector =

[
  [1,2],
  [3],
  [4,5,6]
]
By calling next repeatedly until
hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].
 */

import java.util.List;

public class Flatten2DVector_251 {
    int indexList, indexEle;
    List<List<Integer>> vec;
    public Flatten2DVector_251(List<List<Integer>> vec2d) {
        indexList = 0;
        indexEle = 0;
        vec = vec2d;
    }


    public Integer next() {
        return vec.get(indexList).get(indexEle++);
    }


    public boolean hasNext() {
        while (indexList < vec.size()) {
            if (indexEle < vec.get(indexList).size())
                return true;
            else {
                indexList++;
                indexEle = 0;
            }
        }
        return false;
    }
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */