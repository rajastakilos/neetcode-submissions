public class Solution {
    public int getSum(int a, int b) {
        while (b != 0) { // After 1st iteration b stops meaning original number. if b = 0, no carry digit.
            int carry = (a & b) << 1; // (a & b) find where both bits are 1. 
            // << 1 moves carry to the next column to the left.
            a ^= b; // Ignores carry.
            b = carry;
        }
        return a;
    }
}
// Any addition that produces a carry in decimal will also produce at least one carry in binary.
// And vice versa: if there’s a carry in binary, the addition definitely required a carry in decimal too.