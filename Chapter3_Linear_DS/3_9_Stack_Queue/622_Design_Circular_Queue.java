class MyCircularQueue {
    final int[] q;
    int front = 0;
    int rear = 0;
    int current_size = 0;

    public MyCircularQueue(int k) {
        q = new int[k];
    }
    
    public boolean enQueue(int value) {
        if (isFull())
            return false;
        q[rear++] = value;
        rearReposition();
        current_size++;
        return true;
    }
    
    public boolean deQueue() {
        if (isEmpty() || q[front] == -1)
            return false;
        q[front++] = -1;
        frontReposition();
        current_size--;
        return true;
    }
    
    public int Front() {
        if (isEmpty()) return -1;
        return q[front];
    }
    
    public int Rear() {
        if (isEmpty()) return -1;
        return q[rearPrint(rear)];
    }
    
    public boolean isEmpty() {
        if (current_size == 0)
            return true;
        return false;
    }
    
    public boolean isFull() {
        if (current_size == q.length)
            return true;
        return false;
    }
    
    public void rearReposition(){
        rear = rear % q.length;
    }
    
    public void frontReposition(){
        front = front % q.length;
    }
    
    public int rearPrint(int index){
        return --index >= 0 ? index : index + q.length;
    }
    
    
}
