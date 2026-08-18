class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;

        while (start <= end) {
            Character firstChar = s.charAt(start);
            Character secondChar = s.charAt(end);

            if (!Character.isLetterOrDigit(firstChar) && 
                !Character.isLetterOrDigit(secondChar)) {
                start++;
                end--;
                continue;
            }
            if (!Character.isLetterOrDigit(firstChar)) {
                start ++;
                continue;
            }
            if (!Character.isLetterOrDigit(secondChar)) {
                end--;
                continue;
            }

            if (Character.toLowerCase(firstChar) != 
                Character.toLowerCase(secondChar)) return false;

            start++;
            end--;
        }

        return true;
    }
}
