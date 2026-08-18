class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int[position.length][2];
        for (int i = 0; i < position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> Integer.compare(a[0], b[0])); // sort by position.
        Deque<Double> stack = new ArrayDeque<>();

        for (int i = position.length - 1; i >= 0; i--) {
            double carPosition = cars[i][0];
            double carSpeed = cars[i][1];
            double timeToTarget = (target - carPosition) / carSpeed;

            if (stack.isEmpty() || timeToTarget > stack.peek()) {
                stack.push(timeToTarget);
            }
        }

        return stack.size();
    }
}

// Invariant: 
    // After processing cars from right to left, the stack contains the arrival times of fleets formed so far, 
    // and the top is the fleet immediately in front of the next car to process. 
    // A new fleet is created only when the current car’s time is greater than the fleet ahead’s time.
// Time: O(n * log n): We must check each position in speed and position once when constructing the 2d array
    // We also check each position in our 2d array once when sorting. The sort itself is O(n log n) (java quick sort).
// Space: O(n): We create a stack to hold each fleet. We can theoretically hold one value per fleet in cases where none merge. 
    // Our 2D array is 2 x n since we create 2 values in memory per car. 
