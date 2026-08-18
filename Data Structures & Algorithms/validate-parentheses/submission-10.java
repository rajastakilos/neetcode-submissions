class Solution {
    public boolean isValid(String s) {
        // if (s.length() == 1) return false;
        Deque<Character> closedStack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') closedStack.push('(');
            else if (s.charAt(i) == '{') closedStack.push('{');
            else if (s.charAt(i) == '[') closedStack.push('[');

            if (s.charAt(i) == ')') {
                if (closedStack.isEmpty() || closedStack.pop() != '(') return false;
            } else if (s.charAt(i) == '}') {
                if (closedStack.isEmpty() || closedStack.pop() != '{') return false;
            } else if (s.charAt(i) == ']') {
                if (closedStack.isEmpty() || closedStack.pop() != '[') return false;
            }

        }

        return closedStack.isEmpty() ? true: false;
    }
}
