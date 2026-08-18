class Solution {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (c == '(' || c == '[' || c == '{') {
                stack.push(s.charAt(i));
            } else {
                if (stack.isEmpty()) return false;
                if (c == ')' && stack.pop() != '(') return false;
                if (c == ']' && stack.pop() != '[') return false;
                if (c == '}' && stack.pop() != '{') return false;
            }

            // if (c == ')') {
            //    if (stack.isEmpty() || stack.pop() != '(') return false; 
            // }

            // if (c == ']') {
            //    if (stack.isEmpty() || stack.pop() != '[') return false; 
            // }

            // if (c == '}') {
            //    if (stack.isEmpty() || stack.pop() != '{') return false; 
            // }
        }

        return stack.isEmpty();
    }
}
