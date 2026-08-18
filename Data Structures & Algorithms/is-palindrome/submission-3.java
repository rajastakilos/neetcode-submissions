class Solution {
    public boolean isPalindrome(String s) {
        int p1 = 0;
        int p2 = s.length() - 1;

        while (p1 < p2) {
            boolean isp1Valid = Character.isLetterOrDigit(s.charAt(p1));
            boolean isp2Valid = Character.isLetterOrDigit(s.charAt(p2));

            if (!isp1Valid) {
                p1++;
                continue;
            } else if (!isp2Valid) {
                p2--;
                continue;
            } 
            // else if (!isp1Valid && !isp2Valid) {
            //     p1++;
            //     p2--;
            //     continue;
            // }

            char char1 = Character.toLowerCase(s.charAt(p1));
            char char2 = Character.toLowerCase(s.charAt(p2));

            if (char1 != char2) return false;
            p1++;
            p2--;
        }

        return true;
    }
}
