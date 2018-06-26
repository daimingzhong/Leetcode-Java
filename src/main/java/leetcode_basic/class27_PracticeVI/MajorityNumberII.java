package leetcode_basic.class27_PracticeVI;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Dai on 2017/1/3.
 * Given an integer array of length L, find all numbers that occur more than 1/3 * L times if any exist.
 A = {1, 2, 1, 2, 1}, return [1, 2]
 A = {1, 2, 1, 2, 3, 3, 1}, return [1]
 A = {1, 2, 2, 3, 1, 3}, return []
 */
public class MajorityNumberII {
    public List<Integer> majority(int[] array) {
        List<Integer> result = new ArrayList<>();
        int i = 0,  j = 0;
        for (int a : array) {
            if (i == 0 && j == 0) {// 向result里添加数字
                    result.add(a);
                    i++;
                }
            else if (!result.get(0).equals(a) && j == 0) {
                result.add(a);
                j++;
            }
            else {// 如果新来的数和result里的数相同，只要相加
                if (result.get(0).equals(a)) {
                    i++;
                }
                else if (result.size() == 2 && result.get(1).equals(a)){
                    j++;
                }
                else {
                    i--;
                    j--;
                    if (i == 0) {
                        result.remove(0);// 如果两个一起消失，就会越界
                        i = j;
                        j = 0;
                        if (i == 0) {
                            result.remove(0);
                        }
                    }
                    else if (j == 0) {
                        result.remove(1);
                    }
                }
            }
        }
        if (result.size() == 0) {
            return result;
        }
        if (result.size() == 1) {
            if (!valid(array, result.get(0))){
                result.remove(0);
            }
            return result;
        }
        if(!valid(array, result.get(1)))  {
            result.remove(1);
        }
        if (!valid(array, result.get(0))) {
            result.remove(0);
        }
        return result;
    }

    private boolean valid(int[] arrray, int i) {
        boolean result = false;
        int countI = 0;
        for (int a : arrray) {
            if (a == i) {
                countI++;
            }
        }
        if (countI > arrray.length /3) {
            result = true;
        }
        return result;
    }

    public int majorityNumber2(ArrayList<Integer> nums) {
        int candidate1 = 0, candidate2 = 0;
        int count1, count2;
        count1 = count2 = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (candidate1 == nums.get(i)) {
                count1 ++;
            } else if (candidate2 == nums.get(i)) {
                count2 ++;
            } else if (count1 == 0) {
                candidate1 = nums.get(i);
                count1 = 1;
            } else if (count2 == 0) {
                candidate2 = nums.get(i);
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
        count1 = count2 = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == candidate1) {
                count1++;
            } else if (nums.get(i) == candidate2) {
                count2++;
            }
        }
        return count1 > count2 ? candidate1 : candidate2;
    }

    public static void main(String[] args) {
        MajorityNumberII mn = new MajorityNumberII();
        List<Integer> result = mn.majority(new int[]{1,1,1,4,3,3});
        System.out.print(result);
    }
}