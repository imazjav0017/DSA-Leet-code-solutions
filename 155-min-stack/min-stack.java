class MinStack {
    private Stack<Integer>minList=new Stack<>();
    private Stack<Integer>stack=new Stack<>();
    public MinStack() {
    }
    
    public void push(int val) {
        stack.push(val);
        if(minList.isEmpty()||val<=minList.peek()){
            minList.push(val);
        }
    }
    
    public void pop() {
        if(stack.peek().equals(minList.peek()))
            minList.pop();
        stack.pop();
    }
    
    public int top() {
        return stack.isEmpty()?-1:stack.peek();
    }
    
    public int getMin() {
        return minList.empty()?-1:minList.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */