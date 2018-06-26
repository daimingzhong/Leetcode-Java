package leetcode_basic.class20_Mid;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dai on 2016/11/21.
 */

public class PrintBlocks {
    private List<String> result = new ArrayList<String>();
    private StringBuilder current = new StringBuilder() ;
    private void printBlocks (int num){
        helper (num, 0, 0);
        for (int i = 0; i < result.size(); i++) {
            int blocks = 0;
            for (int j = 0; j < result.get(i).length(); j++) {
                if (result.get(i).charAt(j) ==("{".toCharArray()[0])) {
                    for(int k = blocks; k > 0; k--) {
                        System.out.print("    ");
                    }
                    System.out.print("if {"+ "\n");
                    blocks ++;
                }
                else {
                    for(int k = blocks -1 ; k > 0; k--) {
                        System.out.print("    ");
                    }
                    System.out.print("}" + "\n");
                    blocks --;
                }
            }
            System.out.print("\n");
        }

    }
    private void helper(int num, int left, int right) {
        if (left == num && right == num) {
            result.add(current.toString());
            return;
        } else {
            if (left < num) {
                current.append("{");
                helper(num, left + 1, right);
                current.deleteCharAt(current.length()-1);
            }
            if (right < left) {
                current.append("}");
                helper(num, left, right + 1);
                current.deleteCharAt(current.length()-1);
            }
        }
    }

    public static void main (String[] args) {
        PrintBlocks pb = new PrintBlocks();
        pb.printBlocks(2);
//        pb.printBlocks(3);
    }
}

