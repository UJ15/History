import java.util.Stack;

class MyQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    private int peek;

    public MyQueue() {
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }
    
    public void push(int x) {
        if (s1.empty())
            peek = x;
        s1.push(x);
    }
    
    public int pop() {
        int size = s1.size();
        int temp;
        for (int i = 0; i < size - 1 ; i++){
            if (i == size - 2)
                peek = s1.peek();
            s2.push(s1.pop());
        }
        
        temp = s1.pop();
        size = s2.size();
        for (int i = 0 ; i < size ; i++){
            s1.push(s2.pop());
        }
        return temp;
    }
    
    public int peek() {
        return peek;
    }
    
    public boolean empty() {
        return s1.empty();
    }
}
