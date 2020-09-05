class MinStack {

    class Node {
        int data;
        int minVal;
        Node next;

        Node(int data, int minVal) {
            this.data = data;
            this.minVal = minVal;
        }
    }

    private Node head = null;
    private int length;

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        Node node = null;
        if(length == 0) {
            node = new Node(x, x);
            head = node;
            length++;
            return;
        }

        int headMinVal = head.minVal;
        if(x < headMinVal) {
            node = new Node(x, x);
        } else {
            node = new Node(x, headMinVal);
        }
        node.next = head;
        head = node;
        length++;
    }

    public void pop() {
        if(length == 0) return;
        head = head.next;
        length--;
    }

    public int top() {
        if(length == 0) return -1;
        return head.data;
    }

    public int getMin() {
        if(length == 0) return -1;
        return head.minVal;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */