class Solution {
    public int reverseBits(int n) {
        int result = 0; 
        //      31                              0
        // res = 00000000000000000000000000000000 -> 32 bits
        for (int i = 0; i < 32; i++) {
            // Step 1: n >> i
            // Shift n right by i places.
            // Step 2: & 1
            // Mask everything except the last bit.
            int bit = (n >> i) & 1; 
            // Step 3:
            // Now we place that extracted bit into its reversed position inside res.
            // bit from 0 goes to 31
            // bit from 1 goes to 30
            result += (bit << (31 - i));
            // res |= (bit << (31 - i));
        }

        return result;
    }
}
