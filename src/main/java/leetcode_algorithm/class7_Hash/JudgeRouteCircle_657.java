package leetcode_algorithm.class7_Hash;

/*

657. Judge Route Circle

Initially, there is a Robot at position (0, 0).
Given a sequence of its moves, judge if this robot makes a circle, which means it moves back to the original place.
The move sequence is represented by a string.
And each move is represent by a character. The valid robot moves are R (Right), L (Left), U (Up) and D (down). The output should be true or false representing whether the robot makes a circle.

Example 1:
Input: "UD"
Output: true
Example 2:
Input: "LL"
Output: false

u 0  +
d 0
l 1  +
r 1
 */

public class JudgeRouteCircle_657 {
    public boolean judgeCircle(String moves) {
        if(moves == null) {
            return false;
        }
        int[] count = new int[2];
        for(int i = 0; i < moves.length(); i++) {
            if(moves.charAt(i) == 'U') {
                count[0]++;
            }
            if(moves.charAt(i) == 'D') {
                count[0]--;
            }
            if(moves.charAt(i) == 'L') {
                count[1]++;
            }
            if(moves.charAt(i) == 'R') {
                count[1]--;
            }
        }
        if(count[0] == 0 && count[1] == 0) {
            return true;
        } else{
            return false;
        }
    }
}