class Solution {
    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean[] found = new boolean[3];
        for (int[] t : triplets) { 
            if (t[0] <= target[0] && t[1] <= target[1] && t[2] <= target[2]) { // Global safety: “Only consider triplets that won’t break the final result”
                if (t[0] == target[0]) found[0] = true; 
                if (t[1] == target[1]) found[1] = true;
                if (t[2] == target[2]) found[2] = true; 
            } // Collect across all safe triplets. 
            if (found[0] && found[1] && found[2]) return true;
        }

        return false;
    }
}
// Note: purpose of if (t[0] <= target[0] && t[1] <= target[1] && t[2] <= target[2]) 
// is to prevent the situation below.
// target = [5,7,3]

// triplets:
// [5,100,100]   // matches x
// [100,7,100]   // matches y
// [100,100,3]   // matches z
