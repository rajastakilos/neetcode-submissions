class Solution {
    public int majorityElement(int[] nums) {
        int candidate = 0;
        int count = 0;

        for (int num : nums) {
            // if (candidate == 0) candidate = num;
            // if (count == 0) count++;
            if (count == 0) {
                candidate = num;
                count++;
            }

            if (candidate == num) count++;
            if (candidate != num) count--;
        }

        return candidate;
    }
}