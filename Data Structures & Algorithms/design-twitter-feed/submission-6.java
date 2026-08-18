
class Twitter {
    private int time = 0;
    private Map<Integer, Set<Integer>> following = new HashMap<>();
    private Map<Integer, Tweet> tweets = new HashMap<>();

    public Twitter() {}

    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(tweetId, time++);
        tweet.next = tweets.get(userId); // Newest tweets first.
        tweets.put(userId, tweet);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();

        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>(
            (a, b) -> Integer.compare(b.time, a.time)
        );

        Tweet ownHead = tweets.get(userId);
        if (ownHead != null) maxHeap.offer(ownHead);

        for (int followeeId : following.getOrDefault(userId, Collections.emptySet())) {
            Tweet followeeHead = tweets.get(followeeId);
            if (followeeHead != null) maxHeap.offer(followeeHead);
        }

        while (!maxHeap.isEmpty() && feed.size() < 10) {
            Tweet newest = maxHeap.poll();
            feed.add(newest.tweetId);

            if (newest.next != null) {
                maxHeap.offer(newest.next);
            }
        }

        return feed;
    }

    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;

        following
            .computeIfAbsent(followerId, k -> new HashSet<>())
            .add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followees = following.get(followerId);
        if (followees != null) followees.remove(followeeId);
    }

    private static class Tweet {
        int tweetId;
        int time;
        Tweet next; // Implicit Linked List.

        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }
}

// linked-list-per-user + heap-only-in-getNewsFeed approach 
// is better than using persistent heaps as your main storage.

// postTweet = prepend to your own tweet list, O(1)
// follow = add to set, O(1)
// unfollow = remove from set, O(1)
// getNewsFeed = do the merge here, where ordering actually matters

// Use a linked list per user for tweet storage,
//  and a heap only in getNewsFeed to do a k-way merge across followed users.