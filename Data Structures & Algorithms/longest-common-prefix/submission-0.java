class Solution {
    public String longestCommonPrefix(String[] strs) {
        String prefix = strs[0]; // Our prefix
        
        for (int i = 1; i < strs.length; i++) { // Skip first character.
            int j = 0; // Pointer for comparing chars. 
            while (j < Math.min(prefix.length(), strs[i].length())) {
                if (prefix.charAt(j) == strs[i].charAt(j)) {
                    j++;
                } else {
                    break;
                }
            }
            prefix = prefix.substring(0, j);
        }

        return prefix;
    }
}