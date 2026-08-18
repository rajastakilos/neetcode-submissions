class Solution {
    public boolean isValid(String s) {
        // if (s.length() == 0) return true;
        
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (c == '{' || c == '[' || c == '(') { 
                stack.push(c);
            } else {
                if (stack.isEmpty()) return false;
                if (c == '}' && stack.pop() != '{') return false;
                if (c == ']' && stack.pop() != '[') return false;
                if (c == ')' && stack.pop() != '(') return false;
                
            }
        }

        return stack.isEmpty();
    }
}
