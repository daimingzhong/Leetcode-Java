package leetcode_basic.class1_sorting;

public class QuickSort {
    public int[] quickSort(int[] array) {
        // corner case
        if (array == null) {
            return array;
        }
        quickSort(array, 0, array.length - 1);
        return array;
    }

    private void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivotPos = partition(array, left, right);
        quickSort(array, left, pivotPos - 1);
        quickSort(array, pivotPos + 1, right);
    }

    private int partition(int[] array, int left, int right) {
        int pivotIndex = pivotIndex(left, right);
        int pivot = array[pivotIndex];
        // swap the pivot element to the rightmost position first.
        swap(array, pivotIndex, right);
        int leftBound = left;
        int rightBound = right - 1;
        while (leftBound <= rightBound) {
            if (array[leftBound] < pivot) {
                leftBound++;
            } else if (array[rightBound] >= pivot) {
                rightBound--;
            } else {
                swap(array, leftBound++, rightBound--);
            }
        }
        // swap back the pivot element
        swap(array, leftBound, right);
        return leftBound;
    }

    // pick random element in the range of [left, right]
    private int pivotIndex(int left, int right) {
        return left + (int) (Math.random() * (right - left + 1));
    }

    private void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

    public static void main(String[] args) {
        QuickSort solution = new QuickSort();
        int[] array = {3, 2, 4, 7, 6, 9, 1};
        array = solution.quickSort(array);
        for (int i = 0; i <= array.length - 1; i++) {
            System.out.println(array[i]);
        }
    }
}

