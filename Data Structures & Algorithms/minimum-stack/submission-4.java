class MinStack {
    private Deque<Integer> stack;
    private Deque<Integer> minStack;

    public MinStack() {
        this.stack = new ArrayDeque<>();
        this.minStack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        this.stack.push(val);
        this.pushToMinStack(val);
    }
    
    public void pop() {
        this.stack.pop();
        popFromMinStack();
    }
    
    public int top() {
        return this.stack.peek();
    }
    
    public int getMin() {
        return this.minStack.peek();
    }

    private void pushToMinStack(int val) {
        if (this.minStack.isEmpty()) {
            this.minStack.push(val);
        } else if (this.minStack.peek() > val) {
            this.minStack.push(val);
        } else {
            this.minStack.push(this.minStack.peek());
        }
    }

    private void popFromMinStack() {
        this.minStack.pop();
    }
}
