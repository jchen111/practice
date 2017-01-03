package leetcode;

import java.util.*;

/**
 * Created by z001ktb on 1/1/17.
 */
public class DesignTweeter {
    public static class Twitter {

        static class Tweet {
            int userId;
            int tweetId;
            int time;
            public Tweet(int u, int t, int time) {
                this.userId = u;
                this.tweetId = t;
                this.time = time;
            }
        }
        Map<Integer,Set<Integer>> followerMap; // user and their followers
        Map<Integer,Set<Integer>> followeeMap; // user and their followees
        Map<Integer,List<Tweet>> userTweets;
        final int capacity = 10;
        int seed;

        /** Initialize your data structure here. */
        public Twitter() {
            this.followerMap = new HashMap<Integer,Set<Integer>>();
            this.followeeMap = new HashMap<Integer,Set<Integer>>();
            this.userTweets = new HashMap<Integer,List<Tweet>>();
            this.seed = 0;
        }

        /** Compose a new tweet. */
        public void postTweet(int userId, int tweetId) {
            LinkedList<Tweet> ownNewsFeed = userTweets.containsKey(userId)? new LinkedList<Tweet>(userTweets.get(userId)) : new LinkedList<Tweet>();
            ownNewsFeed.add(new Tweet(userId,tweetId,seed));
            if(followerMap.containsKey(userId)){
                for(Integer user : followerMap.get(userId)){
                    LinkedList<Tweet> newsfeed = userTweets.containsKey(user)? new LinkedList<Tweet>(userTweets.get(user)): new LinkedList<Tweet>();
                    newsfeed.add(new Tweet(userId,tweetId,seed));
                    // if(newsfeed.size() > capacity) newsfeed.removeLast();
                    userTweets.put(user,newsfeed);
                }
            }
            // if(ownNewsFeed.size() > capacity) ownNewsFeed.removeLast();
            userTweets.put(userId,ownNewsFeed);
            seed++;
        }

        /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
        public List<Integer> getNewsFeed(int userId) {
            List<Integer> result = new ArrayList<Integer>();
            if(!userTweets.containsKey(userId)) return result;
            List<Tweet> newsfeed = userTweets.get(userId);
            PriorityQueue<Tweet> queue = new PriorityQueue<Tweet>(new Comparator<Tweet>(){
                @Override
                public int compare(Tweet t1, Tweet t2){
                    return t2.time - t1.time;
                }
            });
            queue.addAll(newsfeed);
            if(followeeMap.containsKey(userId)){
                for(Integer user : followeeMap.get(userId)){
                    queue.addAll(userTweets.get(user));
                }
            }
            int k = 0;
            while(k < capacity && !queue.isEmpty()){
                Tweet tweet = queue.poll();
                result.add(tweet.tweetId);
                k++;
            }
            return result;
        }

        /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
        public void follow(int followerId, int followeeId) {

            if(!userTweets.containsKey(followerId)) userTweets.put(followerId,new LinkedList<Tweet>());
            if(!userTweets.containsKey(followeeId)) userTweets.put(followeeId,new LinkedList<Tweet>());

            Set<Integer> followers = followerMap.containsKey(followeeId)? followerMap.get(followeeId) : new HashSet<Integer>();
            followers.add(followerId);
            followerMap.put(followeeId,followers);

            Set<Integer> followees = followeeMap.containsKey(followerId)? followeeMap.get(followerId): new HashSet<Integer>();
            followees.add(followeeId);
            followeeMap.put(followerId,followees);
        }

        /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
        public void unfollow(int followerId, int followeeId) {
            if(followerMap.containsKey(followeeId)){
                Set<Integer> followers = followerMap.get(followeeId);
                followers.remove(followerId);
                followerMap.put(followeeId,followers);
            }
            if(followeeMap.containsKey(followerId)){
                Set<Integer> followees = followeeMap.get(followerId);
                followees.remove(followeeId);
                followeeMap.put(followerId,followees);
            }
        }
    }

    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1,5);
        twitter.getNewsFeed(1);
        twitter.follow(1,2);
        twitter.postTweet(2,6);
        twitter.getNewsFeed(1);
        twitter.unfollow(1,2);
        twitter.getNewsFeed(1);
    }
}
