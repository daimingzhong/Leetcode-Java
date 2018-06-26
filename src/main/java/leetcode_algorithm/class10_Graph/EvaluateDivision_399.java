package leetcode_algorithm.class10_Graph;

import java.util.*;


/**
 * Equations are given in the format A / B = k, where A and B are variables represented as strings,
 * and k is a real number (floating point number). Given some queries, return the answers.
 * If the answer does not exist, return -1.0.

 a / b * b / c = a / c

 Example:
 Given a / b = 2.0, b / c = 3.0.
 queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
 return [6.0, 0.5, -1.0, 1.0, -1.0 ].

 The input is: vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries ,
 where equations.size() == values.size(), and the values are positive. This represents the equations. Return vector<double>.

 According to the example above:

 equations = [ ["a", "b"], ["b", "c"] ],
 values = [2.0, 3.0],
 queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].

 equation : "b", "c"

 map : "a" 'b', 2.0
 "b" 'a', 1/2.0
 'c', 3.0
 "c" 'b', 1/3.0

 time : O(V+E)
 space : O(n)


 */

public class EvaluateDivision_399 {

    class GraphNode {
        String den;
        double val;
        GraphNode(String den, double val) {
            this.den = den;
            this.val = val;
        }
    }

//    equations = [ ["a", "b"], ["b", "c"] ],
//    values = [2.0, 3.0],

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        HashMap<String, List<GraphNode>> map = new HashMap<>();
        for (int i = 0; i < equations.length; i++) {
            String[] equation = equations[i];
            if (!map.containsKey(equation[0])) {
                map.put(equation[0], new ArrayList<>());
            }
            map.get(equation[0]).add(new GraphNode(equation[1], values[i]));
            if (!map.containsKey(equation[1])) {
                map.put(equation[1], new ArrayList<>());
            }
            map.get(equation[1]).add(new GraphNode(equation[0], 1 / values[i]));
        }

        double[] res = new double[queries.length];
        for (int i = 0; i < res.length; i++) {
            res[i] = find(queries[i][0], queries[i][1], 1, new HashSet<>(), map);
        }
        return res;
    }

    private double find(String start, String end, double value, HashSet<String> visited, Map<String, List<GraphNode>> map) {
        if (visited.contains(start)) return -1;
        if (!map.containsKey(start)) return -1;
        if (start.equals(end)) return value;

        visited.add(start);
        for (GraphNode next : map.get(start)) {
            double sub = find(next.den, end, value * next.val, visited, map);  // dfs
            if (sub != -1.0) {  // 很高明的写法。
                return sub;
            }
        }
        visited.remove(start);
        return -1.0;
    }
    public static void main(String[] args) {

    }
}


/*
    equations = [ ["a", "b"], ["b", "c"] ],
    values = [2.0, 3.0],
    queries = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ].
 */

class Solution {
    Map<String, HashMap<String, Double>> g = new HashMap<>();

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        for (int i = 0; i < equations.length; ++i) {
            String x = equations[i][0];
            String y = equations[i][1];
            double k = values[i];
            g.computeIfAbsent(x, l -> new HashMap<String, Double>()).put(y, k);
            g.computeIfAbsent(y, l -> new HashMap<String, Double>()).put(x, 1.0 / k);
        }

        double[] ans = new double[queries.length];

        for (int i = 0; i < queries.length; ++i) {
            String x = queries[i][0];
            String y = queries[i][1];
            if (!g.containsKey(x) || !g.containsKey(y)) {
                ans[i] = -1.0;
            } else {
                ans[i] = divide(x, y, new HashSet<String>());
            }
        }

        return ans;
    }

    private double divide(String x, String y, Set<String> visited) {
        if (x.equals(y)) return 1.0;
        visited.add(x);
        if (!g.containsKey(x)) return -1.0;
        for (String n : g.get(x).keySet()) {
            if (visited.contains(n)) continue;
            visited.add(n);
            double d = divide(n, y, visited);
            if (d > 0) return d * g.get(x).get(n);
        }
        return -1.0;
    }
}