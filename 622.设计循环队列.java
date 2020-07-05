/*
 * @lc app=leetcode.cn id=622 lang=java
 *
 * [622] 设计循环队列
 */

// @lc code=start
class MyCircularQueue {
    private int[] data;
    private int head;
    // 任何时刻：tail = (head + count - 1) % capacity;
    private int tail;
    // 初始化容量
    private int capacity;
    // 队列中元素个数
    private int count;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        data = new int[k];
        head = 0;
        count = 0;
        capacity = k;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is
     * successful.
     */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        // 计算当前tail位置
        tail = (head + count - 1) % capacity;
        // 计算元素添加的位置
        tail = (tail + 1) % capacity;
        // 简写：tail = (head + count - 1 + 1) % capacity; ->
        // tail = (head + count) % capacity;
        data[tail] = value;
        count++;

        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is
     * successful.
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        head = (head + 1) % this.capacity;
        count--;

        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }

        return data[head];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        tail = (head + count - 1) % capacity;

        return data[tail];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return count == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return count == capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k); boolean param_1 =
 * obj.enQueue(value); boolean param_2 = obj.deQueue(); int param_3 =
 * obj.Front(); int param_4 = obj.Rear(); boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */
// @lc code=end
