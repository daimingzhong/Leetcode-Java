package leetcode_basic.class24_PracticeIV;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 讲解HashSet
 * http://blog.csdn.net/nvd11/article/details/27716511
 * Created by Dai on 2016/12/2.
 * A = {2, 4, 2, 1}, target = 4, return true (2 + 2 = 4)
 * 实现了Collection接口的容器中，List容器无疑是最常用的, 无论是Arraylist, Linklist, Vector 都不难理解.
 * List容器的特点就是其里面的元素是有序的, 而且允许放入重复的元素
 *
 * 实现Set接口的容器可以与数学上的"集合" 概念相对应.
 *
 * 例如Set容器里的元素没有顺序, 就导致Set容器没有List容器的两个很常用的方法,
 * set(index)  和 object get(index).
 * 因为set() 方法和get()方法都需要1个序号(index)作为参数, 告诉List容器到底想存取哪1个对象.
 * 但是Set()没有index这东西(因为元素无序), 所以自然就没有set(index) 和 get(index) 方法了.
 * Set容器无序，不能有重复值
 * 5. HashSet查找1个对象, 只需要遍历其中1个子链表, 而不需要遍历整个容器, 所
 * 以如果存在大量无序数据.  HashSet的访问性能会比List容器高.

 */
public class TwoSum {
    public boolean existSum(int[] array, int target) {
        // use hashset to record traversed data
        Set<Integer> set = new HashSet<>();
        for (int num : array) {
            // hash 查找的复杂度应该是O(1)。
            // HashSet建立了一个赖皮的内存方式。遍历是否存在时间复杂度为1。
            if (set.contains(target - num)) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
    public boolean existSum2(int[] array, int target) {
        Arrays.sort(array); // 返回值是boolean的。
        int slow = 0;
        int fast = array.length - 1;
        while (slow < fast) {
            if (array[slow] + array[fast] < target) {
                slow++;
            }
            else if (array[slow] + array[fast] > target){
                fast --;
            }
            else {
                return true;
            }
        }
        return false;
    }
    public static void main (String[] args) {
        TwoSum ts = new TwoSum();
        int[] array = {1,2,3,5};
        System.out.println(ts.existSum2(array,8));
    }
}
