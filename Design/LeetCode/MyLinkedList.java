class MyLinkedList {
    
    class Node {
        int val;
        Node next;
        
        Node(int val) {
            this.val = val;
        }
    }
    
    private Node head;
    private Node tail;
    private int size;
    /** Initialize your data structure here. */
    public MyLinkedList() {
    }
    
    /** Get the value of the index-th node in the linked list. If the index is invalid, return -1. */
    public int get(int index) {
      if(index >= size || index < 0) return -1;
      Node node = head;
      while(index > 0) {
          node = node.next;
          index--;
      }
      return node.val;
    }
    
    /** Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked list. */
    public void addAtHead(int val) {
        Node node = new Node(val);
        node.next = head;
        head = node;
        if(tail == null)
            tail = head;
        size++;
    }
    
    /** Append a node of value val to the last element of the linked list. */
    public void addAtTail(int val) {
        if(head == null) {
            addAtHead(val);
            return;
        }
        
        tail.next = new Node(val);
        tail = tail.next;
        size++;
        
    }
    
    /** Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to the end of linked list. If index is greater than the length, the node will not be inserted. */
    public void addAtIndex(int index, int val) {
       if(index > size || index < 0) return;
        
       if(index == 0) {
           addAtHead(val);
           return;
       }
        
       if(index == size) {
           addAtTail(val);
           return;
       }
    
        Node node = new Node(val);
        Node temp = head;
        while(temp != null && index > 1) {
            temp = temp.next;
            index--;
        }
        node.next = temp.next;
        temp.next = node;
        size++;
    }
    
    /** Delete the index-th node in the linked list, if the index is valid. */
    public void deleteAtIndex(int index) {
       if(index >= size) return;
        
       if(index == 0) {
           head = head.next;
           size--;
           return;
       }
        
       Node temp = head;
       while(temp != null && index > 1) {
           temp = temp.next;
           index--;
       }
        
       temp.next = temp.next.next;
        
       if(temp.next == null) {
           tail = temp;
       }
    
        size--;
    }

    public static void main(String[] args) {
        MyLinkedList mylinkedList = new MyLinkedList();
    }
}