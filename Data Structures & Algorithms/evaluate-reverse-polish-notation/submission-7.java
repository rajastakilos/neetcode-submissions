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

        return Integer.parseInt(stack.peek());
    }

    private void performOperation(String operator) {
        int operand2 = Integer.parseInt(stack.pop());
        int operand1 = Integer.parseInt(stack.pop());
        
        if (operator.equals("+")) {
            stack.push(String.valueOf(operand2 + operand1));
        } else if (operator.equals("*")) {
            stack.push(String.valueOf(operand2 * operand1));
        } else if (operator.equals("-")) {
            stack.push(String.valueOf(operand1 - operand2));
        } else {
            stack.push(String.valueOf(operand1 / operand2));
        }
    }
}
