class Solution {
    private static int maxLength;
    private static String digits;

    public List<String> letterCombinations(String digits) {        
        if (digits.length() == 0) return new ArrayList<>();
        
        this.maxLength = digits.length();
        this.digits = digits;

        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        dfs(0, result, sb);
        return result;
    }

    private void dfs(int start, List<String> result, StringBuilder sb) {
        if (sb.length() > this.maxLength) return;
        if (sb.length() == this.maxLength) {
            result.add(sb.toString());
            return;
        }

        int currentDigit = this.digits.charAt(start) - '0';
        String letters = mapping(currentDigit);

        for (char c : letters.toCharArray()) {
            sb.append(c); // choose
            dfs(start + 1, result, sb); // recurse
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
