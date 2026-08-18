class MinStack {
    private final Deque<Integer> stack = new ArrayDeque<>();
    private final Deque<Integer> minStack = new ArrayDeque<>();

    public MinStack() {}
    
    public void push(int val) {
        stack.push(val);
        minStackPush(val);
    }
    
    public void pop() {
        this.minStack.pop();
        this.stack.pop();
        
    }
    
    public int top() {
        return this.stack.peek();
    }
    
    public int getMin() {
        return this.minStack.peek();
    }

    private void minStackPush(int val) {
        if (this.minStack.isEmpty()) { 
            this.minStack.push(val);
            return;
        }

        if (val < this.minStack.peek()) { 
            this.minStack.push(val);
        } else {
            this.minStack.push(this.minStack.peek());
        }

        return;
    }
}
