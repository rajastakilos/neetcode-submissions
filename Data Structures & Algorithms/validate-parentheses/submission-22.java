class Solution {
    public boolean isValid(String s) {
        Deque<Character> closedStack = new ArrayDeque<>();

        // for (int i = 0; i < s.length(); i++) {
        //     char c = s.charAt(i);

        //     if (c == '(' || c == '{' || c == '[') {
        //         closedStack.push(c);
        //     } else {
        //         if (closedStack.isEmpty()) return false;

        //         char top = closedStack.pop();
        //         if (c == ')' && top != '(') return false;
        //         else if (c == '}' && top != '{') return false;
        //         else if (c == ']' && top != '[') return false;
        //     }
        // }

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') closedStack.push(')');
            if (c == '[') closedStack.push(']');
            if (c == '{') closedStack.push('}');

            if (c != '(' && c != '[' && c != '{') {
                if (closedStack.isEmpty()) return false;
                if (c != closedStack.pop()) return false;
            }

        }

        return closedStack.isEmpty() ? true: false;
    }
}
// Time: O(n). We must do a single pass of the whole string.
// Space: O(n). 

