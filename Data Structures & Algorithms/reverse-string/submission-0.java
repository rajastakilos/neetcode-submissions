class Solution {
    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;

        while (left < right) {
            char currLeft = s[left];
            char currRight = s[right];

            s[left] = currRight;
            s[right] = currLeft;
            
            left++;
            right--;
        }
    }
}