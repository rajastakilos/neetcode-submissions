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
