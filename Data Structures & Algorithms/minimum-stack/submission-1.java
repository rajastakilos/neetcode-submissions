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

// Time: push, pop, top, getMin are all O(1) worst-case (just a constant number of deque ops).
// Space: O(n) extra space overall (yes, two stacks, but constants don’t matter asymptotically). More precisely: stack is O(n) and minStack is O(n), so total is O(n).