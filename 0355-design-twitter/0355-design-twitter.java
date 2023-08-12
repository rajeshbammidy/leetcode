class Twitter {

    static class Tweet {
        int tweetId;
        int time;

        Tweet(int tweetId, int time) {
            this.tweetId = tweetId;
            this.time = time;
        }
    }

    static class User {
        HashSet<Integer> following;
        List<Tweet> tweets;
        int userId;

        User(int userId) {
            this.userId = userId;
            following = new HashSet<>();
            tweets = new ArrayList<>();
        }
    }

    static int timer = 0;
    HashMap<Integer, User> uidToUserMap;

    public Twitter() {
        timer = 0;
        uidToUserMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        if (!uidToUserMap.containsKey(userId)) {
            uidToUserMap.put(userId, new User(userId));
        }
        uidToUserMap.get(userId).tweets.add(new Tweet(tweetId, timer++));
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> list = new ArrayList<>();
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((a, b) -> b.time - a.time);
        if (uidToUserMap.containsKey(userId)) {
            for (Tweet tweet : uidToUserMap.get(userId).tweets) {
                maxHeap.add(tweet);
            }
            for (int following : uidToUserMap.get(userId).following) {
                maxHeap.addAll(uidToUserMap.get(following).tweets);
            }
            while (list.size() < 10 && !maxHeap.isEmpty()) {
                list.add(maxHeap.poll().tweetId);
            }
            return list;
        }
        return list;
    }

    public void follow(int followerId, int followeeId) {
        if (!uidToUserMap.containsKey(followerId)) {
            uidToUserMap.put(followerId, new User(followerId));
        }
        if (!uidToUserMap.containsKey(followeeId)) {
            uidToUserMap.put(followeeId, new User(followeeId));
        }
        uidToUserMap.get(followerId).following.add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (!uidToUserMap.containsKey(followerId)) {
            uidToUserMap.put(followerId, new User(followerId));
        }
        if (!uidToUserMap.containsKey(followeeId)) {
            uidToUserMap.put(followeeId, new User(followeeId));
        }
        if (uidToUserMap.get(followerId).following.contains(followeeId)) {
            uidToUserMap.get(followerId).following.remove(followeeId);
        }
    }
}
/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
