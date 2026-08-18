class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        // “Is there at least one 1 bit somewhere in n?”
        while (n != 0) {
            // (1) ID n's rightmost 1, (2) convert that 1 to 0 and all 0's after to 1, 
            // (3) n - 1 removes rightmost 1. 
            n = n & (n - 1); // n - 1 flips lowest 1, & deletes it.
            // Removing a single trailing 1 from n per iteration.
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


// Walk through of :n & (n - 1): It removes the lowest (rightmost) 1 bit from n
// Step 1: Shape of n
// xxxx1000...000
//      ↑
//    rightmost 1
// everything to the right of that 1 is 0

// Step 2: What does n - 1 do?
// xxxx1000...000
// -
//           1 
// ----------------
// xxxx0111...111

// Two things happen:

// that rightmost 1 → becomes 0
// everything to the right → becomes 1

// Step 3: Apply AND
// n       = xxxx1000...000
// n - 1   = xxxx0111...111
// ------------------------
// n&(n-1) = xxxx0000...000

// ONLY rightmost 1 is removed. 