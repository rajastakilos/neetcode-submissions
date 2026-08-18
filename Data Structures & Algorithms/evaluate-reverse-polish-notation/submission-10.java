class Solution {
    private Deque<String> stack;
    public int evalRPN(String[] tokens) {
        this.stack = new ArrayDeque<>();
        
        for (String t : tokens) {
            if (t.equals("+") || t.equals("*") || t.equals("-") || t.equals("/")) {                 
                performOperation(t);
            } else { 
                stack.push(t);
            }
        }

        return Integer.parseInt(stack.pop());
    }

    private void performOperation(String operator) {
        int a = Integer.parseInt(stack.pop());
        int b = Integer.parseInt(stack.pop());
        
        if (operator.equals("+")) {
            stack.push(String.valueOf(b + a));
        } else if (operator.equals("*")) {
            stack.push(String.valueOf(b * a));
        } else if (operator.equals("-")) {
            stack.push(String.valueOf(b - a));
        } else {
            stack.push(String.valueOf(b / a));
        }
    }
}

// Keys:
// 1. .equals for string comparisons
// 2. Order of operations for subraction and division. 
