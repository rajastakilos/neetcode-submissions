class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int carCount = position.length;
        int[][] cars = new int[carCount][2]; // position.length is car Count.
        for (int i = 0; i < carCount; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, (a, b) -> Integer.compare(a[0], b[0]));

        int fleets = 0;
        double slowestFleetTimeAhead = 0.0;

        for (int i = carCount - 1; i >= 0; i--) {
            int carPosition = cars[i][0];
            int carSpeed = cars[i][1];

            double myTimeToTarget = (double) (target - carPosition) / carSpeed;
            
            if (myTimeToTarget > slowestFleetTimeAhead) {
                fleets++;
                slowestFleetTimeAhead = myTimeToTarget;
            } // else you can the fleet and merge into it.
        }

        return fleets;
    }
}
