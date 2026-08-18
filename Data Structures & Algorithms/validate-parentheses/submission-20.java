class Solution {
    public boolean isValid(String s) {
        Deque<Character> closedStack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '{' || c == '[') {
                closedStack.push(c);
            } else {
                if (closedStack.isEmpty()) return false;

                if (c == ')' && closedStack.pop() != '(') return false;
                else if (c == '}' && closedStack.pop() != '{') return false;
                else if (c == ']' && closedStack.pop() != '[') return false;
            }
        }

        return closedStack.isEmpty() ? true: false;
    }
}
