class MyStack {
    private Queue<Integer> q1;
    private Queue<Integer> q2;
    private int top;

    public MyStack() {
        q1=new LinkedList<>();;
        q2=new LinkedList<>();
    }
    
    public void push(int x) {
        top=x;
        q1.add(x);
    }
    
    public int pop() {
        int size=q1.size();
        
        for(int i=1;i<size;i++){
            if(i==size-1)top=q1.peek();
            q2.add(q1.poll());
        }
        
        int last=q1.poll();
        q1=new LinkedList<>(q2);
        q2.clear();
        
        return last;
    }
    
    public int top() {
       return top;
    }
    
    public boolean empty() {
        return q1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */