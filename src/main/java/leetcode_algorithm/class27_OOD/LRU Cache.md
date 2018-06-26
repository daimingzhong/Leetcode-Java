### 题意

设计并实现[Least Recently Used(LRU) Cache](https://en.wikipedia.org/wiki/Cache_replacement_policies#LRU) 的数据结构。数据结构需要支持两种操作：`get` 与`put`。 

`get(key)` 若`key`存在于cache中，则取出`key`对应的`value`，否则返回`-1`，该值总为正数。

`put(key, value)` 若`value` 不存在，则将`value`插入cache。当cache容量不够时，需要将最后一次调用过的值清除，然后插入。

Example:

```
LRUCache cache = new LRUCache( 2 /* capacity */ );

cache.put(1, 1);
cache.put(2, 2);
cache.get(1);       // returns 1
cache.put(3, 3);    // evicts key 2
cache.get(2);       // returns -1 (not found)
cache.put(4, 4);    // evicts key 1
cache.get(1);       // returns -1 (not found)
cache.get(3);       // returns 3
cache.get(4);       // returns 4
```

### 思路

首先，为了实现`get`与`put`方法，我们需要一个`HashMap`，用来表示cache里所有的`key-value`。 其次，还要用一个双向链表来表示每个键值对使用的顺序。当容量不够时，我们就可以将顺序排在链表最后的键值对从`HashMap`里清除。最后，用`head`与`tail`两个链表上的指针来表示链表上的头和尾部，这样方便我们的更新与删除操作。

`put`分类讨论：

- 若插入的节点不存在于`HashMap`中：

  - 当`HashMap`为空时，将`head`指针指向`put`的值。


  - 当`HashMap`不为空，但是容量仍然足够时，将`tail`的`next`指向该节点，该节点的`pre`也指向`tail`，这样就将节点放到了链表的尾部。
  - 当`HashMap`的容量不够时，将`head`指向自己的下个节点，并从`HashMap`中删除`head`值。
  - 最后将`tail`指针指向该节点，并在`HashMap`中添加该值。

- 若插入的节点存在于`HashMap`中：

  - 更新该节点的值。

  - 若节点在尾部，则不需要改变。

  - 若节点不在尾部

    - 若节点在头部，则将`head`指向下个节点，将其从链表中删除。


    - 若节点不在头部，则将节点的`prev`与`next`节点相连，将其从链表中部删除。
    - 将链表的尾部更新为该节点。

`get`分类讨论：

- 若`HashMap`中存在该节点，则返回该节点的值，并更新`tail`指针的位置。
- 若`HashMap`不存在该节点，则返回-1。

### 复杂度

时间复杂度：O(1)

空间复杂度：O(n)

```java
public class LRUCache {

    class Node {
        int key;
        int value;
        Node next;
        Node pre;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<Integer, Node> map;
    private int capacity;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        // 初始化HashMap，capacity与head/tail指针
        map = new HashMap<>();
        this.capacity = capacity;
        head = null;
        tail = null;
    }

    public int get(int key) {
        Node node = map.get(key);
        // 若hashmap中不存在该值，则返回-1
        if (node == null) {
            return -1;
        }
        // 若存在该值，则更新节点位置到tail
        if (node != tail) {
            if (node == head) {
                head = head.next;
            } else {
                node.pre.next = node.next;
                node.next.pre = node.pre;
            }
            tail.next = node;
            node.pre = tail;
            node.next = null;
            tail = node;
        }
        return node.value;
    }

    public void put(int key, int value) {
        // 从HashMap中取key
        Node node = map.get(key);
        
        // 若map中该节点已存在
        if (node != null) {
            node.value = value;
            if (node != tail) {
                if (node == head) {
                    head = head.next;
                } else {
                    node.pre.next = node.next;
                    node.next.pre = node.pre;
                }
                tail.next = node;
                node.pre = tail;
                node.next = null;
                tail = node;
            }
        } else {
            // 若map中不存在该节点
            Node newNode = new Node(key, value);
            if (capacity == 0) {
                Node temp = head;
                head = head.next;
                map.remove(temp.key);
                capacity++;
            }
            if (head == null && tail == null) {
                head = newNode;
            } else {
                tail.next = newNode;
                newNode.pre = tail;
                newNode.next = null;
            }
            tail = newNode;
            map.put(key, newNode);
            capacity--;
        }
    }
}
```

