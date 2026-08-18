class Solution {
    public boolean checkValidString(String s) {
        int minOpen = 0; 
        int maxOpen = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') { minOpen++; maxOpen++; }
            if (c == ')') { minOpen--; maxOpen--; }
            if (c != '(' && c != ')') { minOpen--; maxOpen++; }

            if (maxOpen < 0) return false;
            if (minOpen < 0) minOpen = 0;
        }

        return minOpen == 0;
    }
}
// At every index, [minOpen, maxOpen] contains all valid open counts we could have.