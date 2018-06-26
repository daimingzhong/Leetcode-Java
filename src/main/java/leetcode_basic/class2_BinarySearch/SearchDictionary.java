package leetcode_basic.class2_BinarySearch;

import leetcode_basic.class0.Dictionary;

import java.util.ArrayList;

/*
  Given a integer dictionary A of unknown size, where the numbers in the dictionary are sorted in ascending order,
 determine if a given target integer T is in the dictionary. Return the index of T in A, return -1 if T is not in A.
 A = {1, 2, 5, 9, ......}, T = 5, return 2
 A = {1, 2, 5, 9, 12, ......}, T = 7, return -1

interface  Dictionary {
    public abstract Integer get(int index); // 默认public abstract
    public abstract void input(int num);
}

*/


public class SearchDictionary implements Dictionary {
    private ArrayList<Integer> array = new ArrayList<Integer>();
    @Override
    public Integer get(int index){
        if (index < array.size()) {
            return array.get(index);
        }
        else {
            return null;
        }
    }
    @Override
    public void input (int num) {
        array.add(num);
    }

    public int searchDictionary(Dictionary dict, int target) {
        if (dict == null) {
            return -1;
        }
        int left = 0;
        int right = 1;
        while (dict.get(right) != null && dict.get(right) < target) {
            left = right;
            right = right * 2;
        }
        return binarySearch(dict, target, left, right);
    }

    public int binarySearch(Dictionary dict, int target, int left, int right) {
        while (left <= right) {
            int mid = left + (right - left)/2;
            if (dict.get(mid) == null || dict.get(mid) > target) {
                right = mid - 1;
            }
            else if (dict.get(mid) < target) {
                left = mid + 1;
            }
            else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        SearchDictionary sd = new SearchDictionary();
        Dictionary dict = new SearchDictionary();
        dict.input(1);
        dict.input(3);
        dict.input(5);
        dict.input(6);
        int result = sd.searchDictionary(dict, 5);
        System.out.println(result);
    }
}
