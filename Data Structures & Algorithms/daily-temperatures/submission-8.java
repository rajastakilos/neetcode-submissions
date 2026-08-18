class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Deque<Integer> waitingDays = new ArrayDeque<>();

        for (int today = 0; today < temperatures.length; today++) {
            while (!waitingDays.isEmpty() && 
                    temperatures[today] > temperatures[waitingDays.peek()]) { // warmer than waiting day?
                
                // int waitingDay = waitingDays.pop(); // Day waiting for a warmer day.
                answer[waitingDays.peek()] = today - waitingDays.pop(); // This is how long that day waited.
            }

            // Today waits for a warmer day
            waitingDays.push(today);
        }

        return answer;

    }
}

