class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) {
                digits[i] = digits[i] + 1;
                return digits;
            } else {
                digits[i] = 0;
            }
        }

        int[] updatedArray = new int[digits.length + 1];
        updatedArray[0] = 1;

        for (int i = 1; i < digits.length - 1; i++) updatedArray[i] = digits[i];

        return updatedArray;
    }
}
