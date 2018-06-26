package leetcode_algorithm.class1_Sorting;

/*

88. Merge Sorted Array

Given two sorted integer arrays nums1 and nums2,
merge nums2 into nums1 as one sorted array.

Note:
You may assume that nums1 has enough space
(size that is greater or equal to m + n) to hold additional elements from nums2.
The number of elements initialized in nums1 and nums2 are m and n respectively.
 */

public class MergeTwoSortedArray_88 {
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        // this is wrong. because it has to return nums1.
        int[] result = new int[nums1.length + nums2.length];
        int left = 0, right = 0;
        for(int i = 0; i < result.length; i++) {
            while(left < m && right < n) {
                if(nums1[left] < nums2[right]) {
                    result[i] = nums1[left];
                    left++;
                } else {
                    result[i] = nums2[right];
                    right++;
                }
                if(left < m) {
                    result[i] = nums1[left++];
                } else if(right < n) {
                    result[i] = nums2[right++];
                }
            }
        }
    }

    public void merge2(int A[], int m, int B[], int n) {
        int i = m - 1, j = n - 1, k = m + n - 1;
        while(i >= 0 && j >= 0) {
            A[k--] = A[i] > B[j] ? A[i--] : B[j--];
        }
        while(j >= 0) {
            A[k--] = B[j--];
        }
    }

    public static void main(String[] args) {
//        int[] result = merge(new int[]{}, 0, new int[]{1}, 1);
    }
}