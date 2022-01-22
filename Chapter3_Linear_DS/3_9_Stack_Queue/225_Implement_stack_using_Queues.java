import java.util.Queue;
import java.util.LinkedList;

class MyStack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;
    private int top;
    
    public MyStack() {
        q1 = new LinkedList<Integer>();
        q2 = new LinkedList<Integer>();
    }
    
    public void push(int x) {
        top = x;
        q1.add(x);
    }
    
    public int pop() {
        //큐 두 개를 사용해서 하나의 큐에 데이터를 받고 꺼낼때 마지막 전 값까지 두 번째 큐에 복사 그리고 마지막 값 리턴
        //첫 번째 큐에 두 번째 큐를 복사한다음 두 번째 큐 클리어
        int size = q1.size();
        int temp;
        for (int i = 0; i < size - 1; i++){
            if (i == size - 2)
                top = q1.peek();
            q2.add(q1.poll());
        }
        temp = q1.poll();
        q1 = new LinkedList<Integer>(q2);
        q2.clear();
        return temp;
    }
    
    public int top() {
        return top;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}
