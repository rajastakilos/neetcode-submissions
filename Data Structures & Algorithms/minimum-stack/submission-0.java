class MinStack {
    ArrayDeque<Integer> minStack;
    ArrayDeque<Integer> stack;

    public MinStack() {
        this.minStack = new ArrayDeque<>();
        this.stack = new ArrayDeque<>();
    }
    
    public void push(int val) {
        if (stack.isEmpty()) {
            this.stack.push(val);
            this.minStack.push(val);
        } else {
            this.stack.push(val);
            if (val < this.minStack.peek()) {
                this.minStack.push(val);
            } else {
                this.minStack.push(this.minStack.peek());
            }
        }
    }
    
    public void pop() {
        this.stack.pop();
        this.minStack.pop();
    }
    
    public int top() {
        return this.stack.peek();
    }
    
    public int getMin() {
        return this.minStack.peek();
    }
}
