package leetcode_basic.class99_Others;

class Budong {
/* 不懂的题
    class 5 Bipartile 不懂怎么做
    class 6 AllSubsetsI for 和 递归结合的写法。
    class 6 Permutation_swap_46 for 和 递归 结合
    class 7 Determine substring ，计算hash值不懂
    class 8 All Anatages， hasamap的维护没看懂
    class 10 SpiraOrderTraveseI 递归，循环两种写法
    class 10 lowest common ancestorI
    class 11 AllUniqueCharsII  答案看不懂。逻辑不明白
    class 16 perfect shuffle
    class 21 merge k sorted arrays. 多抄几遍答案
    iterable string不可以，int[] array可以
 */
}


class Arrays{
/*
    Arrays.copyOf() // static int[]	 copyOf(int[] original, int newLength)
    List<Integer> list = Arrays.asList(new Integer[] {1,2,3,4,5}); // 可以作为ArrayList
    // static <T> List<T>	asList(T... a)Returns a fixed-size list backed by the specified array
    int[] input = new int[array.length];
    input[input.length - 1] = array[array.length - 1];
    //创建和赋值的时候，最后一个下标不一样
*/
}

class ArrayList {
/*
    ArrayList<Integer> a = new ArrayList<>();
    a.size()
    a.add();
    a.get(int x) ////返回x处的值 从0开始
 */
}


class HashSet {
/*
    Set<Integer> set = new HashSet<>();
    set.add(1); // boolean. 如果重复加，不会改变，并返回false
    set,contains(i);

*/
}

class HashMap {
/*
    HashMap<Integet, Integer> map = new HashMap<>();
    map.put(K key, V value) //添加
    map.size()
    map.containsKey() // boolean
    map.containsValue()
    map.get(key)// Returns the value of key, or null

    Map.Entry<> a
    a.getKey(); // 	Returns the key corresponding to this entry. 这个是一组key-value对，key只有一个值
    a.getValue(); //
    for (Map.Entry<Integer, Integer> entry : mapA.entrySet()) {}
*/
}

public class MoreCheck {}

class String {
/*
    a.length();
    a.chatAt(0); //
    a.substring(1,3)//返回1-3的a, new string
    array[] b = a.toCharArray;
    for (int i = 0; i < t.length(); i++) // 遍历String
    a.indexOf("cat", 10)//int, 从第10个位置开始，返回第一个找到cat的下标


    // SubString 问题：
	"hamburger".substring(4, 8) returns "urge"
    int	indexOf(String str, int fromIndex) //Returns the index within this string of the first occurrence
	substring(int beginIndex, int endIndex) //Returns a new string that is a substring of this string.

	//字符串数组和字符串互相转换；字符串转字符，只能用new String(); 初始化重新生成一个
    String[] a = new String[]{"a","b"};
    String[] a = new String[5];
    String[] a = {"a","b"}
    a.lengh;

    int[] m = {"a","b"};
    new String(m); //字符串数组转字符串  打印字符串ok

    http://www.cnblogs.com/ningvsban/p/3955483.html
*/
}

class StringBuilder {
/*
     StringBuilder sb = new StringBuilder();
     String a = sb.toString();
     sb.append("abcde",1,2)// append从1到2的范围。
     //StringBuilder	Appends a subsequence of the specified CharSequence to this sequence.
      */
}

class PriorityQueue {
/*
public PriorityQueue(int initialCapacity, Comparator<? super E> comparator)
Parameters:
initialCapacity - the initial capacity for this priority queue
comparator - the comparator that will be used to order this priority queue.
If null, the natural ordering of the elements will be used.

     PriorityQueue<Entry> minHeap = new PriorityQueue<>(11, new MyComparator());// 传进一个比较器的对象

*/
}

class Queue {
    // 判断queue是不是空，两种方法：
    //queue.size() == 0 queue.isEmpty()
}
