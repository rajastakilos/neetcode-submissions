class Solution {
    public boolean isHappy(int n) {
        int slow = n;
        int fast = next(n); // fast starts ahead to avoid immediate equality

        while (slow != fast) {
            slow = next(slow);            // 1 step
            fast = next(next(fast));      // 2 steps
        }

        return slow == 1; // if cycle is 1 → happy
    }

    private int next(int n) {
        int sum = 0;

        while (n > 0) {
            int digit = n % 10;   // extract last digit
            sum += digit * digit; // square it
            n = n / 10;              // remove last digit
        }

        return sum;
    }
}