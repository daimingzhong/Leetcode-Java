package leetcode_algorithm.class10_Graph;

import java.util.*;

/**
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to],
 * reconstruct the itinerary in order. All of the tickets belong to a man who departs from JFK.
 * Thus, the itinerary must begin with JFK.

 Note:
 If there are multiple valid itineraries, you should return the itinerary that
 has the smallest lexical order when read as a single string. For example,
 the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 All airports are represented by three capital letters (IATA code).
 You may assume all tickets form at least one valid itinerary.

 Example 1:
 tickets = [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 Return ["JFK", "MUC", "LHR", "SFO", "SJC"].

 Example 2:
 tickets = [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 Return ["JFK","ATL","JFK","SFO","ATL","SFO"].

 Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
 But it is larger in lexical order.


 DFS(HashMap) + PriorityQueue

 JFK   SFO
 |
 ATL


 time : O(nlogn)
 space : O(n)

 map.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).add(ticket[1]);
 1. null就执行lambda，返回当前的value
 2. 不是null，就直接返回value
 3. 是null 或者不是 null， 都要add ticket[1].

 hashmap的computIfAbsent方法。
 不存在，新建，然后add
 存在，直接add。
 从三句话省为一句话。

 用hashmap计数是不是也可以简化
 if (! map.contains) {}
 else {put(get + 1)}

 */

public class ReconstructItinerary_332 {
    public List<String> findItinerary(String[][] tickets) {
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();
        List<String> res = new LinkedList<>();
        for (String[] ticket : tickets) {

            map.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).add(ticket[1]);

//            if (map.get(ticket[0]) == null) {
//                map.put(ticket[0], new PriorityQueue<String>()); // 后面不能直接add，因为put返回值是上一次的V。这里是null
//            }
//            map.get(ticket[0]).add(ticket[1]);

        }
        helper("JFK", map, res);
        return res;
    }

    private void helper(String airport, HashMap<String, PriorityQueue<String>> map, List<String> res) {
        while (map.containsKey(airport) && !map.get(airport).isEmpty()) {
            helper(map.get(airport).poll(), map, res);
        }
        res.add(0, airport);
    }

    public List<String> findItinerary2(String[][] tickets) {
        HashMap<String, PriorityQueue<String>> map = new HashMap<>();

        for (String[] ticket : tickets) {
            map.computeIfAbsent(ticket[0], k -> new PriorityQueue<>()).add(ticket[1]);
        }

        List<String> res = new LinkedList<>();
        Stack<String> stack = new Stack<>();
        stack.push("JFK");

        while (!stack.empty()) {
            while (map.containsKey(stack.peek()) && !map.get(stack.peek()).isEmpty()) {
                stack.push(map.get(stack.peek()).poll());
            }
            res.add(0, stack.pop());
        }
        return res;
    }

    public static void main(String[] args) {
        ReconstructItinerary_332 reconstructItinerary_332 = new ReconstructItinerary_332();
        String[][] tickets = new String[][]{{"JFK","SFO"}, {"JFK","ATL"}, {"SFO","ATL"}, {"ATL","JFK"}, {"ATL","SFO"}};
        List<String> res = reconstructItinerary_332.findItinerary(tickets);
        System.out.println(res);
    }
}
