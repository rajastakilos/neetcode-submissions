class CountSquares {
    // x -> (y -> how many times point (x, y) was added)
    private Map<Integer, Map<Integer, Integer>> points;

    public CountSquares() {
        points = new HashMap<>();
    }

    public void add(int[] point) {
        int x = point[0];
        int y = point[1];

        points.putIfAbsent(x, new HashMap<>());
        Map<Integer, Integer> yCounts = points.get(x);
        yCounts.put(y, yCounts.getOrDefault(y, 0) + 1);
    }

    public int count(int[] point) {
        int x = point[0];
        int y = point[1];

        // If we have never seen this x column, no square is possible.
        if (!points.containsKey(x)) return 0;

        int totalSquares = 0;

        // All points in the same vertical column as the query point.
        Map<Integer, Integer> sameColumn = points.get(x);

        for (int y2 : sameColumn.keySet()) {
            // Same point -> side length 0 -> not a square.
            if (y2 == y) continue;

            int side = y2 - y;
            int verticalCount = sameColumn.get(y2);

            // Try square to the right
            totalSquares += verticalCount
                    * getCount(x + side, y)
                    * getCount(x + side, y2);

            // Try square to the left
            totalSquares += verticalCount
                    * getCount(x - side, y)
                    * getCount(x - side, y2);
        }

        return totalSquares;
    }

    private int getCount(int x, int y) {
        if (!points.containsKey(x)) return 0;
        return points.get(x).getOrDefault(y, 0);
    }
}