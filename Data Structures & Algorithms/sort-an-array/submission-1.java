class Solution {
    private int[] temp; // Note Not to be used if solution is concurrent. Not thread safe.
    // Not final. Buffer size depends on input array.

    public int[] sortArray(int[] nums) {
        if (nums == null || nums.length == 0) return new int[]{};

        temp = new int[nums.length];
        sort(nums, 0, nums.length - 1);
        return nums;
    }

    private void sort(int[] nums, int left, int right) {
        if (left >= right) return;

        int mid = left + (right - left) / 2; // Mid
        sort(nums, left, mid); // Left portion
        sort(nums, mid + 1 , right); // Right portion
        merge(nums, left, mid, right);
    }

    private void merge(int[] nums, int left, int mid, int right) {
        int i = left; // left unsorted half.
        int j = mid + 1; // right unsorted half. 
        int k = left; // left of temp.

        while (i <= mid && j <= right) { // Once one side is exhausted, the rest can be copied directly.
            temp[k++] = nums[i] <= nums[j] ? nums[i++] : nums[j++];
        }

        while (i <= mid) temp[k++] = nums[i++];
        while (j <= right) temp[k++] = nums[j++];

        for (int p = left; p <= right; p++) nums[p] = temp[p]; // temp[left..right] contains the correctly merged, sorted values for this subproblem. We copy this over to nums.
    }
}

// Merge sort

// Time: O(n log n) — always
// No special cases
// No dependence on input order

// Quicksort

// Average: O(n log n)
// Worst case: O(n²)
// (already sorted array, many duplicates, bad pivot)
