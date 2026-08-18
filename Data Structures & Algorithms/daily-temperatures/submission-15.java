class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Deque<Integer> waitingDays = new ArrayDeque<>();
        
        for (int i = 0; i < temperatures.length; i++) {
            while (!waitingDays.isEmpty() &&
                temperatures[i] > temperatures[waitingDays.peek()]) {

                int waitingDay = waitingDays.pop();
                result[waitingDay] = i - waitingDay;
            }
            waitingDays.push(i);
        }

        return result;
    }
}
