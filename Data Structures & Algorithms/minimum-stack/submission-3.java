class MinStack {
    Deque<Integer> stack;
    Deque<Integer> minStack;

    public MinStack() {
        this.stack = new ArrayDeque<>();
        this.minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        this.stack.push(val);
        pushMinStack(val);
    }
    
    public void pop() {
        this.stack.pop();
        popMinStack();
    }
    
    public int top() {
        return this.stack.peek();
    }
    
    public int getMin() {
        return this.minStack.peek();
    }

    private void pushMinStack(int val) {
        if (this.minStack.isEmpty()) { 
            this.minStack.push(val); 
        } else if (this.minStack.peek() < val) {
            this.minStack.push(this.minStack.peek());
        } else {
            this.minStack.push(val);
        }
    }

    private void popMinStack() {
        this.minStack.pop();
    }
}
