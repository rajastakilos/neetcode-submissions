class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[][] cars = new double[position.length][2];
        for (int i = 0; i < position.length; i++) {
            cars[i][0] = position[i];
            // Time for each car to reach the target. distance / speed = time. 
            cars[i][1] = (double) (target - position[i]) / speed[i];
            // Time normalizes them as though they were all being measured from the same finish line at the same moment.
        }

        Arrays.sort(cars, (a, b) -> Double.compare(b[0], a[0])); // Sort descending
        // Cars closest to the end are first. 

        int fleets = 0;
        double timeAhead = 0;
        for (int i = 0; i < position.length; i++) {
            double currentTime = cars[i][1];
            // If a car takes longer than the car ahead, it never catches up.
            // If a car takes <= time it catches up and joins the fleet. 
            // A car behind can only merge if it would arrive sooner or at the same time as the car ahead when driving alone
            if (currentTime > timeAhead) {
                fleets++;
                timeAhead = currentTime;
            }
        }

        return fleets;
    }
}
// [12, 8, 10, 26].
// 12  -> new fleet
// 8   -> catches up, merges. Passing is forbidden
// 10  -> catches up, merges. Passing is forbidden
// 26  -> cannot catch up, new fleet
