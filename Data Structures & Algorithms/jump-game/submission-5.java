class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;

        for (int i = 0; i < nums.length; i++) { // Note: Last number in index doesn't matter. We still process it. 
            if (maxReach >= nums.length) return true;
            if (i > maxReach) return false;
            maxReach = Math.max(maxReach, i + nums[i]);
        }

        return true;
    }
}

// if i > maxReach we've reached an index that is physically 
// impossible to get to from any of the previous positions.

// If we can move past the current index we aren't wrong
// If we can keep extending maxReach, we preserve all possible valid paths forward.
// What we are doing optimistically: At each reachable index, we extend maxReach as far as possible.

// Example (where it works)

// [2, 3, 1, 1, 4]

// i = 0 → maxReach = 2
// i = 1 → maxReach = 4
// i = 2 → maxReach = 4
// i = 3 → maxReach = 4
// i = 4 → done

// We never get stuck → ✅ true

// Example (where it fails)

// [3, 2, 1, 0, 4]

// i = 0 → maxReach = 3
// i = 1 → maxReach = 3
// i = 2 → maxReach = 3
// i = 3 → maxReach = 3
// i = 4 → ❌ i > maxReach → return false