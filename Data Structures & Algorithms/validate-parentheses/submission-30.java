class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                stack.push(s.charAt(i)); // 1. Push the char.
            } else {
                if (stack.isEmpty()) return false; // 2. empty check.
                if (c == ')' && stack.pop() != '(') return false; // 3. Check for the matching bracket.
                if (c == ']' && stack.pop() != '[') return false;
                if (c == '}' && stack.pop() != '{') return false;
            }
        }

        return stack.isEmpty();
    }
}
