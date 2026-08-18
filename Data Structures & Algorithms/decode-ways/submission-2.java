class Solution {
    public int numDecodings(String s) {
        int next1 = 1;
        int next2 = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int current;

            if (s.charAt(i) == '0') {
                current = 0;
            } else {
                current = next1;

                if (i + 1 < s.length() &&
                    (s.charAt(i) == '1' || (s.charAt(i) == '2' && s.charAt(i + 1) < '7'))) {
                    current += next2;
                }
            }

            next2 = next1;
            next1 = current;
        }

        return next1;

    }
}