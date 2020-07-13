import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=146 lang=java
 *
 * [146] LRU缓存机制
 */

// @lc code=start
class LRUCache {
    private int capacity;
    private int size;
    private Map<Integer, LinkNode> cache;
    private LinkNode head, tail;

    public LRUCache(int capacity) {
        this.cache = new HashMap<>(capacity);
        this.capacity = capacity;
        this.size = 0;
        this.head = new LinkNode();
        this.tail = new LinkNode();
        this.head.next = this.tail;
        this.tail.prev = this.head;
    }

    public int get(int key) {
        // 1. 判断cache中是否存在：
        LinkNode node = cache.get(key);
        // 1.1 如果存在，先删除当前节点，然后将该节点添加至头节点，然后返回节点value；
        if (node != null) {
            removeNode(node);
            addNodeToHead(node);

            return node.value;
        }
        // 1.2 如果不存在，直接返回-1；
        return -1;
    }

    public void put(int key, int value) {
        // 1. 判断cache中是否存在：
        LinkNode node = cache.get(key);
        // 1.1 如果存在，更新该节点的value，先删除当前节点，然后将该节点添加至头节点；
        if (node != null) {
            node.value = value;
            removeNode(node);
            addNodeToHead(node);
        }
        // 1.2 如果不存在，进入下一步；
        else {
            // 2. 创建新节点，并加入cache，判断当前cache的大小是否已满：
            node = new LinkNode(key, value);
            cache.put(key, node);

            // 2.1 缓存未满，则将该节点添加至头节点；
            if (size < capacity) {
                addNodeToHead(node);
                size++;
            }
            // 2.2 缓存已满，则删除尾节点，然后将该节点添加至头节点；
            else {
                removeTail();
                addNodeToHead(node);
            }
        }
    }

    public void removeNode(LinkNode node) {
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public void addNodeToHead(LinkNode node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    public void removeTail() {
        cache.remove(tail.prev.key);
        tail.prev = tail.prev.prev;
        tail.prev.next = tail;
    }

    class LinkNode {
        private int key;
        private int value;
        private LinkNode prev;
        private LinkNode next;

        public LinkNode() {
        }

        public LinkNode(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }
}

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */

/**
 * Your LRUCache object will be instantiated and called as such: LRUCache obj =
 * new LRUCache(capacity); int param_1 = obj.get(key); obj.put(key,value);
 */
// @lc code=end
