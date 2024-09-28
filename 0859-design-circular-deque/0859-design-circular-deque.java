class Node {
    public int val;
    public Node prev;
    public Node next;

    public Node(int val) {
        this.val = val;
        prev = null;
        next = null;
    }
}

class MyCircularDeque {
    Node head = new Node(-1);
    Node tail = new Node(-1);
    int size;
    int currentSize;

    public MyCircularDeque(int k) {
        head.next = tail;
        tail.prev = head;
        size = k;
        currentSize = 0;        
    }
    
    public boolean insertFront(int value) {
        if (isFull()) return false;
        addNode(head, value);
        currentSize++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if (isFull()) return false;
        addNode(tail.prev, value);
        currentSize++;
        return true;
    }
    
    public boolean deleteFront() {
        if (isEmpty()) {
            return false;
        }
        deleteNode(head.next);
        currentSize--;
        return true;
    }
    
    public boolean deleteLast() {
        if (isEmpty()) return false;
        deleteNode(tail.prev);
        currentSize--;
        return true;
    }
    
    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return head.next.val;
    }
    
    public int getRear() {
        if (isEmpty()) return -1;
        return tail.prev.val;
    }
    
    public boolean isEmpty() {
        return currentSize == 0;
    }
    
    public boolean isFull() {
        return currentSize == size;
    }

    public void addNode(Node head, int value) {
        Node after = head.next;
        Node temp = new Node(value);
        head.next = temp;
        temp.prev = head;
        temp.next = after;
        after.prev = temp;
    }

    public void deleteNode(Node head) {
        Node after = head.next;
        Node before = head.prev;
        before.next = after;
        after.prev = before;
    }
}

/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */