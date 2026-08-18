class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        // Eulerian? Means what.
        // Hierholzer's algorithm: when to use?
        Map<String, PriorityQueue<String>> adj = new HashMap<>(); // an adj that has a PQ?
        for (List<String> ticket : tickets) { // ?
            adj.computeIfAbsent(ticket.get(0),k -> new PriorityQueue<>())
                .add(ticket.get(1));
        }

        LinkedList<String> result = new LinkedList<>(); // ?
        Stack<String> stack = new Stack<>(); // ?
        stack.push("JFK"); // Can we initialize stack by new Stack<>("JFK")?

        while (!stack.isEmpty()) {
            if (!adj.containsKey(stack.peek()) || 
                adj.get(stack.peek()).isEmpty()) {
                    result.addFirst(stack.pop());
            } else {
                stack.push(adj.get(stack.peek()).poll());
            }
        }

        return result;
    }
}
