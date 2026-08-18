class Solution {
    
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new ArrayDeque<>();

        for (int i = 0; i < tokens.length; i++) {
            String t = tokens[i];
            if (!t.equals("+") && !t.equals("-") && !t.equals("*") && !t.equals("/")) {
                stack.push(t);
            } else {
                stack.push(calculate(t, stack.pop(), stack.pop()));
            }
        }

        return Integer.parseInt(stack.pop());
    }

    private String calculate(String operator, String op1, String op2) {
        int a = Integer.parseInt(op1);
        int b = Integer.parseInt(op2);
        if (operator.equals("+")) {
            return String.valueOf(b + a);
        } else if (operator.equals("-")) {
            return String.valueOf(b - a);
        } else if (operator.equals("*")) {
            return String.valueOf(b * a);
        } else {
            return String.valueOf(b / a);
        }
    }
}
