class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] result = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && 
                    temperatures[i] > temperatures[stack.peek()]) {
                int day = stack.pop();
                result[day] = i - day;
            }

            stack.push(i);
        }

        return result;
    }
}
// Invariant:
// Time: O(n). We must check each element in the input array once. 
// Space: O(n). Result array contains as many elements as input array. Stack will at most contain all elements.
