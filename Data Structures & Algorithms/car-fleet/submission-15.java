class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        double[][] cars = new double[position.length][2];
        for (int i = 0; i < position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = (double) (target - position[i]) / speed[i];
        }

        Arrays.sort(cars, (a, b) -> Double.compare(a[0], b[0]));

        int fleets = 0;
        double timeAhead = 0;
        for (int i = position.length - 1; i >= 0; i--) {
            if (cars[i][1] > timeAhead) {
                fleets++;
                timeAhead = cars[i][1];
            }
        }

        return fleets;
    }
}
