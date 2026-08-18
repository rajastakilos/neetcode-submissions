class Solution {
    public int[] plusOne(int[] digits) {
        // Traverse from least significant digit (rightmost)
        for (int i = digits.length - 1; i >= 0; i--) {
            // Case 1: No carry needed
            if (digits[i] < 9) {
                digits[i]++;
                return digits;
            }
            // Case 2: digit is 9 → becomes 0, carry continues
            digits[i] = 0;
        }

        // If we get here, all digits were 9 (e.g., 999 → 1000)
        int[] result = new int[digits.length + 1];
        result[0] = 1; // leading carry
        return result;
    }
}
