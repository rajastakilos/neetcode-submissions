class Solution {
    public boolean isValid(String s) {
        Deque<Character> closedStack = new ArrayDeque<>();
        char[] openBrackets = new char[]{'(', '{', '['};

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == openBrackets[0]) closedStack.push('(');
            else if (s.charAt(i) == openBrackets[1]) closedStack.push('{');
            else if (s.charAt(i) == openBrackets[2]) closedStack.push('[');

            if (closedStack.isEmpty()) return false;

            if (s.charAt(i) == ')' && closedStack.pop() != '(') return false;
            else if (s.charAt(i) == '}' && closedStack.pop() != '{') return false;
            else if (s.charAt(i) == ']' && closedStack.pop() != '[') return false;
        }

        return closedStack.isEmpty() ? true: false;
    }
}
