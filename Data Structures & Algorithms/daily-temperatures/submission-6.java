class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] answer = new int[temperatures.length];
        Deque<Integer> waitingDays = new ArrayDeque<>();

        for (int today = 0; today < temperatures.length; today++) {
            while (!waitingDays.isEmpty() && 
                    temperatures[today] > temperatures[waitingDays.peek()]) {
                int prevDay = waitingDays.pop();
                answer[prevDay] = today - prevDay;
            }

            // Today waits for a warmer day
            waitingDays.push(today);
        }

        return answer;

    }
}
