class Solution {
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int bit = (n >> i) & 1; // 
            // (n >> i) & 1 
                // Right shift n by i so the original i-th bit lands at the rightmost position.
                // AND with 1 extracts that bit as 0 or 1.
                // NOTE: Whole number is shifted. We aren't plucking the value and moving it. 
                // Let’s say i = 4:
                // n        = 00010000
                // n >> 4   = 00000001
            // & 1 
                // 1 if the last bit is 1 (odd number)
                // 0 if the last bit is 0 (even number)
            result |= (bit << (31 - i)); // Set this bit.
            // index:  31 ............... 4 ......... 0
            // 0 0 0 1 0 0 0
            // index:  31 ............... 27 ........ 0
            // 0 0 0 1 0 0 0
        }

        return result; // Return a new integer.
    }
}
// 00000000 00000000 00000000 00010000: Binary representation of 16
// n >> i
    // shift the bits of n to the right by i
// bit << (31 - i)
    // shift this bit to the left by 31 - i;

// Walkthrough with n = 16
// n      = 00000000 00000000 00000000 00010000
// result = 00000000 00000000 00000000 00000000

// Only bit 4 is set.
// That means almost every loop iteration extracts 0, except when i = 4.

// Extract right most bit.
// (n >> 0) & 1
//  00010000
//  & 00000001
// ---------
//  00000000 Rightmost bit is zero

// Iterations i = 0 - 3
// bit = 0
// bit << 31 = 0 << 31 = 0
// n >> 1 = 00000000 00000000 00000000 00001000
// So bit = 0
// 0 << 30 = 0

// Iterations i = 4;
// n >> 4 = 00000000 00000000 00000000 00000001
// 00000001
// & 00000001
// ---------
// 00000001 Rightmost bit is 1
// So bit = 1;
// bit << (31 - 4)
// = 1 << 27
// Answer: 00001000 00000000 00000000 00000000/ 


