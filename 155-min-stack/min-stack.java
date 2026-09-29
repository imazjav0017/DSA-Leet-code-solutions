class MinStack {
    Deque<Integer>stack,mono;//monotonic stack with increasing order
    public MinStack() {
        stack=new ArrayDeque<>();
        mono=new ArrayDeque<>();
    }
    
    public void push(int value) {
        stack.push(value);
        if(mono.isEmpty()|| value<=mono.peek()){
            mono.push(value);
        }
    }
    
    public void pop() {
        if(mono.peek().equals(stack.peek())){
            mono.pop();
        }
        stack.pop();
    }
    
    public int top() {
        return stack.isEmpty()?-1:stack.peek();
    }
    
    public int getMin() {
        return mono.isEmpty()?-1:mono.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(value);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */