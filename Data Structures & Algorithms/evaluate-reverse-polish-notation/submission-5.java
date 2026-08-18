class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            switch(token) {
                case "+": case "-": case "/": case "*":
                    int secondInt = stack.pop();
                    int firstInt = stack.pop();
                    int answer = this.calculate(firstInt, secondInt, token);
                    stack.push(answer);
                    break;
                default:
                    stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
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
// Key Invariant: All non-operator push to the stack. When you see an operator pop twice, calculate, and push the result to the stack.
// Time: O(n). We must process every element in the input.
// Space: O(n). We make a stack. It should always hold less than the number of input elements since we can assume 
    // there is always at least one operator and encountering an operator requires us to pop twice.
