class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {
            if (!token.equals("+") &&
                !token.equals("-") &&
                !token.equals("*") &&
                !token.equals("/")) {
                stack.push(Integer.valueOf(token));
            } else {
                calculate(token, stack);
            }
        }

        return stack.peek();
    }

    private void calculate(String token, Deque<Integer> stack) {
        int a = stack.pop();
        int b = stack.pop();

        if (token.equals("*")) {
            stack.push(b * a);
        } else if (token.equals("/")) {
            stack.push(b / a);
        } else if (token.equals("-")) {
            stack.push(b - a);
        } else {
            stack.push(b + a);
        }
    }
}
