class MyCircularQueue {


    private int[] queue;
    private int front = -1;
    private int rear = 0;
    private int capacity;
    private int size;



    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        queue = new int[k];
        capacity = k;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        if(front == -1) {
            front = 0;
            queue[rear++] = value;
            size++;
            return true;
        }

        if(front%capacity == rear%capacity) return false;

        queue[(rear%capacity)] = value;
        rear = (rear%capacity) +1;
        size++;
        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(front == -1) return false;

        if(size == 1) {
            front = -1;
            rear = 0;
            size--;
            return true;
        }

        size--;
        front = (front%capacity) +1;
        return true;


    }

    /** Get the front item from the queue. */
    public int Front() {
        if(front == -1) return -1;
        return queue[front];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(size == 0) return -1;
        return queue[rear-1];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return size==capacity;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */