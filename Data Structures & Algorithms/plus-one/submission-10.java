class Solution {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] < 9) { 
                digits[i]++; /// 1,2,3,4 -> 1,2,3,5
                return digits; 
            }

            digits[i] = 0;
        }

        int[] result = new int[digits.length + 1]; // Ex. If 999 -> 0000
        result[0] = 1; // 1000
        return result;
    }
}
