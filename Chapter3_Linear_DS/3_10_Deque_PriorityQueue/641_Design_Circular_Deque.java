//이중 연결리스트로 구현
class MyCircularDeque {
    class Node {
        int value;
        Node next;
        Node pre;
        public Node(int x){
            value = x;
            next = null;
            pre = null;
        }
    }
    private Node head = new Node(-1);
    private Node tail = new Node(-1);
    private int size;
    private int k;

    public MyCircularDeque(int k) {
        this.size = 0;
        this.k = k;
        head.next = tail;
        tail.pre = head;
    }
    
    public boolean insertFront(int value) {
        if (isFull()) return false;
        Node n = new Node(value);
        if (isEmpty()){
            head.next = n;
            tail.pre = n;
        }else{
            n.next = head.next;
            head.next.pre = n;
            head.next = n;
            n.pre = tail.pre;
            tail.pre.next = n;
        }
        size++;
        return true;
    }
    
    public boolean insertLast(int value) {
        if (isFull()) return false;
        Node n = new Node(value);
        if(isEmpty()){
            head.next = n;
            tail.pre = n;
        }else{
            n.pre = tail.pre;
            tail.pre.next = n;
            tail.pre = n;
            head.next.pre = n;
            n.next = head.next;
        }
        size++;
        return true;
    }
    
    public boolean deleteFront() {
        if (isEmpty()) return false;
        if (size == 1){
            head.next = null;
            tail.pre = null;
        }else{
            head.next.next.pre = tail.pre;
            tail.pre.next = head.next.next;
            head.next = head.next.next;
        }
        size--;
        return true;
    }
    
    public boolean deleteLast() {
        if (isEmpty()) return false;
        if (size == 1){
            head.next = null;
            tail.pre = null;
        }else{
            tail.pre.pre.next = head.next;
            head.next.pre = tail.pre.pre;
            tail.pre = tail.pre.pre;
        }
        size--;
        return true;
    }
    
    public int getFront() {
        if (isEmpty()) return -1;
        return head.next.value;
    }
    
    public int getRear() {
        if (isEmpty()) return -1;
        return tail.pre.value;
    }
    
    public boolean isEmpty() {
        if (size == 0)
            return true;
        else 
            return false;
    }
    
    public boolean isFull() {
        if (size == k)
            return true;
        else
            return false;
    }
}
