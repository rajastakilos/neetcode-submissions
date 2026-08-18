class Solution {
    public int evalRPN(String[] tokens) {
        Deque<String> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (!token.equals("+") && !token.equals("-") && !token.equals("/") && !token.equals("*")) {
                stack.push(token);
            } else {
                int firstInt = Integer.parseInt(stack.pop());
                int secondInt = Integer.parseInt(stack.pop());
                int answer = this.calculate(secondInt, firstInt, token);
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

        throw new IllegalArgumentException("");
    }
}
