class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }

        return count;
    }
}
// Ex. 16 -> 000010000
// 000010000
//   - 1
// 000001111

// 000010000
// &
// 000001111
// 000000000

// Only 1 zero.