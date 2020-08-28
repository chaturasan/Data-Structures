class MyHashMap {

    class Node {
        int key;
        int val;
        Node next;

        Node(int key, int val) {
            this.key= key;
            this.val = val;
        }
    }

    private static final int TABLE_SIZE = 1024;
    private Node[] hashTable = new Node[TABLE_SIZE];
    /** Initialize your data structure here. */
    public MyHashMap() {

    }

    /** value will always be non-negative. */
    public void put(int key, int value) {
        int index = getHash(key);
        Node head = hashTable[index];
        Node node = head;
        while (node != null) {
            if (node.key == key) {
                node.val = value;
                return;
            }
            node = node.next;
        }
        Node newNode = new Node(key, value);
        newNode.next = head;
        hashTable[index] = newNode;
    }

    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int hash = getHash(key);
        Node head = hashTable[hash];
        while(head != null) {
            if(head.key == key) return head.val;
            head = head.next;
        }
        return -1;
    }

    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int index = getHash(key);
        Node node = hashTable[index];
        while (node != null) {
            if (node.key == key) {
                node.val = -1;
                return;
            }
            node = node.next;
        }
    }

    private int getHash(int key) {
        return key%TABLE_SIZE;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */