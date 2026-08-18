class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1); // Removing a single trailing 1 from n per iteration.
            count++;
        }

        return count; 
    }
}
// An unsigned integer is a whole number that cannot be negative—it 
// represents only values ≥ 0, using all its bits for magnitude (no sign bit)

// Signed vs Unsigned (quick contrast)
// Signed (like Java int)
    // 32 bits total
    // 1 bit is reserved for sign (positive/negative)
    // Remaining 31 bits store the value
// Unsigned
    // 32 bits total
    // ALL 32 bits store the value
    // No space wasted on sign


// n & (n - 1): It removes the lowest (rightmost) 1 bit from n