class Solution {
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (!token.equals("+") && !token.equals("-") && !token.equals("/") && !token.equals("*")) {
                stack.push(token);
            } else {
                int secondInt = Integer.parseInt(stack.pop());
                int firstInt = Integer.parseInt(stack.pop());
                int answer = this.calculate(firstInt, secondInt, token);
                stack.push(String.valueOf(answer));
            }
        }

        return Integer.parseInt(stack.pop());
    }

    private int calculate(int first, int second, String token) {
        if (token.equals("+")) {
            return first + second;
        } else if (token.equals("-")) {
            return first - second;
        } else if (token.equals("/")) {
            return first / second;
        } else if (token.equals("*")) {
            return first * second;
        }

        throw new IllegalArgumentException("Received a token that isn't an operator.");
    }
}
// Key Invariant: All non-operands push to the stack. When you see an operand pop twice, calculate, and push the result to the stack.
// Time: O(n). We must process every element in the input.
// Space: O(1). No new collections are created.
