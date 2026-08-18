class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {

            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) { // Invariant
                int day = stack.pop();
                result[day] = i - day;
            }

            stack.push(i);
        }

        return result;
    }
}
// Invariant: Stack holds indices of days whose next warmer day has not been found yet
// Time: O(n). We must check each element in the input array once. 
// Space: O(n). Result array contains as many elements as input array. Stack will at most contain all elements.
