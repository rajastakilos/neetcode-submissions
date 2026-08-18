class Solution {
    public int mySqrt(int x) {
        int left = 0;
        int right = x;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if ((long) mid * mid > x) { // Avoid overflow
                right = mid - 1;
            } else if ((long) mid * mid < x) { // Avoid overflow
                left = mid + 1;
            } else {
                return mid;
            }
        }

        return right; // when loop ends left < right.
        //  right is the largest value seen that satisfies 
        //  right^2 <= x (and thus is a valid floor(sqrt(x)))
    }
}