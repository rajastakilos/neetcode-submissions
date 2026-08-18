class Solution {
    public boolean checkValidString(String s) {
        int minOpen = 0; // best case: Use * as )
        int maxOpen = 0; // worst case: Use * as (
        for (char c : s.toCharArray()) {
            if (c == '(') { minOpen++; maxOpen++; }
            if (c == ')') { minOpen--; maxOpen--; }
            if (c != '(' && c != ')') { minOpen--; maxOpen++; } 
            // We expand range. Otherwise exploring all options make this exponential.     
            // * → '('
            // * → ')'
            // * → ''          
            // Too many closing parens. 
            if (maxOpen < 0) return false; // Even if every * was '(', we still have too many )
            if (minOpen < 0) minOpen = 0; // In the best case, we closed more than we opened
        }

        return minOpen == 0;
    }
}
// At every index, [minOpen, maxOpen] contains all valid open counts we could have.

// Greedy: 
// At every character, we don’t commit to a specific interpretation of *.
// We collapse all possible choices into a range and keep only what’s still valid.