class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) return findMedianSortedArrays(nums2, nums1);
        
        int[] A = nums1;
        int[] B = nums2;
        int total = A.length + B.length;
        int half = (total + 1) / 2; // Why total + 1?

        int left = 0;
        int right = A.length;

        while (left <= right) {
            int i = (left + right) / 2; // Why divide like this
            int j = half - i; // Why divide like this? 

            int Aleft = i > 0 ? A[i - 1] : Integer.MIN_VALUE; // Explain
            int Bleft = j > 0 ? B[j - 1] : Integer.MIN_VALUE; // Explain
            int Aright = i < A.length ? A[i] : Integer.MAX_VALUE; // Explain
            int Bright = j < B.length ? B[j] : Integer.MAX_VALUE; // Explain

            if (Aleft <= Bright && Bleft <= Aright) { // Explain whole block
                int leftMax = Math.max(Aleft, Bleft);
                if (total % 2 != 0) return leftMax;
                if (total % 2 == 0) return (leftMax + Math.min(Aright, Bright)) / 2.0;

            } else if (Aleft > Bright) {
                right = i - 1;
            } else {
                left = i + 1;
            }
        }

        return -1;
    }
}
