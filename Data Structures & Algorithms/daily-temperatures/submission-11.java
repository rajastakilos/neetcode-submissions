class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<Integer> waitingDays = new ArrayDeque<>();

        for (int today = 0; today < temperatures.length; today++) {
            while (!waitingDays.isEmpty() && 
                    temperatures[today] > temperatures[waitingDays.peek()]) {

                int waitingDay = waitingDays.pop();
                result[waitingDay] = today - waitingDay;
            }
            waitingDays.push(today);
        }

        return result;
    }
}
// Stack: days that are still waiting for a warmer future day.

// For each popped waitingDay, 
// today becomes the first warmer day after waitingDay, 
// so you set result[waitingDay] = today - waitingD
