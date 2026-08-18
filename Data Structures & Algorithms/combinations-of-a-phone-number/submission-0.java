class Solution {
    public List<String> letterCombinations(String digits) {        
        if (digits.length() == 0) return new ArrayList<>();

        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        dfs(0, digits, digits.length(), result, sb);
        return result;
    }

    private void dfs(int start, String digits, int maxLength, List<String> result, StringBuilder sb) {
        if (sb.length() > maxLength) return;
        if (sb.length() == maxLength) {
            result.add(sb.toString());
            return;
        }

        int currentDigit = digits.charAt(start) - '0';
        String letters = mapping(currentDigit);

        for (char c : letters.toCharArray()) {
            sb.append(c); // choose
            dfs(start + 1, digits, maxLength, result, sb); // recurse
            sb.deleteCharAt(sb.length() - 1); // backtrack
        }
    }

    private String mapping(int digit) {
        switch (digit) {
            case 2: 
                return "abc";
            case 3:
                return "def";
            case 4:
                return "ghi";
            case 5: 
                return "jkl";
            case 6:
                return "mno";
            case 7:
                return "pqrs";
            case 8:
                return "tuv";
            case 9:
                return "wxyz";
            default:
                throw new IllegalStateException("");
        }

        
    }
}
