class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1); // ?

        int[] A = nums1;
        int[] B = nums2;
        int total = A.length + B.length;
        int half = (total + 1) / 2; // Force left side to hold median when length is odd. 
        // [1, 2, 3, 4, 5]
        // Ex. 5. left gets 3 elements, right gets 2 elements. median is 3

        int left = 0;
        int right = A.length;

        while (left <= right) {
            int i = (left + right) / 2; // From A
            int j = half - i; // From B
            // Largest Element on A's left.
            int Aleft = i > 0 ? A[i - 1] : Integer.MIN_VALUE;
            // Largest Element on B's left.
            int Bleft = j > 0 ? B[j - 1] : Integer.MIN_VALUE;
            // Smallest Element on A's right.
            int Aright = i < A.length ? A[i] : Integer.MAX_VALUE;
            // Smallest Element on B's right.
            int Bright = j < B.length ? B[j] : Integer.MAX_VALUE;

            if (Aleft <= Bright && Bleft <= Aright) { // ?
                int leftMax = Math.max(Aleft, Bleft); // ?
                if (total % 2 != 0) return leftMax; // ?
                if (total % 2 == 0) return (leftMax + Math.min(Aright, Bright)) / 2.0; // ? 
            } else if (Aleft > Bright) { // ?
                right = i - 1; // ?
            } else { // ?
                left = i + 1; // ?
            }
        }

        return -1;
    }
}
