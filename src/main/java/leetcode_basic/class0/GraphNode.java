package leetcode_basic.class0;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dai on 2016/12/1.
 */

public class GraphNode {
    public int key;
    public List<GraphNode> neighbors;
    public GraphNode(int key) {
        this.key = key;
        this.neighbors = new ArrayList<GraphNode>();
    }
}