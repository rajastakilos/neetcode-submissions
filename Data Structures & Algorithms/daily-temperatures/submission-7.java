class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Deque<Integer> waitingDays = new ArrayDeque<>();

        for (int today = 0; today < temperatures.length; today++) {
            while (!waitingDays.isEmpty() && 
                    temperatures[today] > temperatures[waitingDays.peek()]) { // 30 < 38  
                
                int prevDay = waitingDays.pop(); // 0
                answer[prevDay] = today - prevDay; // answer[0] = 1 - 0
            }

            // Today waits for a warmer day
            waitingDays.push(today);
        }

        return answer;

    }
}
// [0]

// [1]
