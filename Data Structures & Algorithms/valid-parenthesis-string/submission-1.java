class Solution {
    public boolean checkValidString(String s) {
        int minOpen = 0; 
        int leftMax = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') { minOpen++; leftMax++; }
            if (c == ')') { minOpen--; leftMax--; }
            if (c != '(' && c != ')') { minOpen--; leftMax++; }

            if (leftMax < 0) return false;
            if (minOpen < 0) minOpen = 0;
        }

        return minOpen == 0;
    }
}
// At every index, [minOpen, leftMax] contains all valid open counts we could have.