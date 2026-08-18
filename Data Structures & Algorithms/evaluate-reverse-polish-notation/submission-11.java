class Solution {
    Deque<String> stack;

    public int evalRPN(String[] tokens) {
        this.stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("/") || token.equals("*")) { 
                this.performOperation(token);
            } else {
                this.stack.push(token);
            }
        }

        return Integer.parseInt(stack.pop());
    }

    private void performOperation(String operator) {
        Integer a = Integer.parseInt(stack.pop());
        Integer b = Integer.parseInt(stack.pop());

        if (operator.equals("*")) {
            this.stack.push(String.valueOf(b * a));
        } else if (operator.equals("/")) {
            this.stack.push(String.valueOf(b / a));
        } else if (operator.equals("+")) {
            this.stack.push(String.valueOf(b + a));
        } else {
            this.stack.push(String.valueOf(b - a));
        }
    }
}
