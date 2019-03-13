/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package twitter;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * SocialNetwork provides methods that operate on a social network.
 * 
 * A social network is represented by a Map<String, Set<String>> where map[A] is
 * the set of people that person A follows on Twitter, and all people are
 * represented by their Twitter usernames. Users can't follow themselves. If A
 * doesn't follow anybody, then map[A] may be the empty set, or A may not even
 * exist as a key in the map; this is true even if A is followed by other people
 * in the network. Twitter usernames are not case sensitive, so "ernie" is the
 * same as "ERNie". A username should appear at most once as a key in the map or
 * in any given map[A] set.
 * 
 * DO NOT change the method signatures and specifications of these methods, but
 * you should implement their method bodies, and you may add new public or
 * private methods or classes if you like.
 */
public class SocialNetwork {

	/**
	 * Guess who might follow whom, from evidence found in tweets.
	 * 
	 * @param tweets a list of tweets providing the evidence, not modified by this
	 *               method.
	 * @return a social network (as defined above) in which Ernie follows Bert if
	 *         and only if there is evidence for it in the given list of tweets. One
	 *         kind of evidence that Ernie follows Bert is if Ernie
	 * @-mentions Bert in a tweet. This must be implemented. Other kinds of evidence
	 *            may be used at the implementor's discretion. All the Twitter
	 *            usernames in the returned social network must be either authors
	 *            or @-mentions in the list of tweets.
	 */
	public static Map<String, Set<String>> guessFollowsGraph(List<Tweet> tweets) {
		Map<String, Set<String>> result = new HashMap<String, Set<String>>();
		for (Tweet t : tweets) {
			String author = t.getAuthor();
			List<Tweet> tmp = new ArrayList<Tweet>();
			tmp = Filter.writtenBy(tweets, author);// 找出由当前作者编辑的tweet
			List<Tweet> tmp0 = new ArrayList<Tweet>(tmp);
			Set<String> follow = new HashSet<String>();
			follow = Extract.getMentionedUsers(tmp0);// 当前人可能关注的
			result.put(author, follow);
		}
		return result;
	}

	/**
	 * Find the people in a social network who have the greatest influence, in the
	 * sense that they have the most followers.
	 * 
	 * @param followsGraph a social network (as defined above)
	 * @return a list of all distinct Twitter usernames in followsGraph, in
	 *         descending order of follower count.按关注者人数递减排列
	 */
	public static List<String> influencers(Map<String, Set<String>> followsGraph) {

		Map<String, Integer> result = new HashMap<String, Integer>();
		Set<String> a = new HashSet<String>();
		List<String> list = new ArrayList<String>();
		for (String s : followsGraph.keySet())// 当前人物的名字
		{
			a = followsGraph.get(s);
			for (String f : a)
		{   
				
				result.put(f, 0);}
		}
		for (String s : followsGraph.keySet()) {
			a = followsGraph.get(s);
				for (String f : a) {		
					int k = result.get(f);
					int m = k+1;
					result.put(f, m);
				}
			
		}
		Collection<Integer> c = result.values();
		Object[] obj = c.toArray();
		Arrays.sort(obj);
		for (int m = obj.length - 1; m >= 0; m--) {
			for (String key : result.keySet()) {
				if (result.get(key).equals(obj[m])) {
					list.add(key);
					//System.out.println(result.get(key));
				}
				
			}
		}
		
			for ( int i = 0 ; i < list.size() - 1 ; i ++ ) {
			for ( int j = list.size() - 1 ; j > i; j -- ) {
			if (list.get(j).equals(list.get(i))) {
			list.remove(j);}}}
		    return list;

	}

	private static URL makeURLAssertWellFormatted(String urlString) {
		try {
			return new URL(urlString);
		} catch (MalformedURLException murle) {
			throw new AssertionError(murle);
		}
	}

	public static void main(String[] args) {
		List<Tweet> tweets = null;

		final URL SAMPLE_SERVER = makeURLAssertWellFormatted(
				"https://raw.githubusercontent.com/rainywang/Spring2019_HITCS_SC_Lab1/master/P4/src/tweetPoll.py");
		try {
			tweets = TweetReader.readTweetsFromWeb(SAMPLE_SERVER);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int count = 10;
		Map<String, Set<String>> followsGraph = SocialNetwork.guessFollowsGraph(tweets);
		final List<String> influencers = SocialNetwork.influencers(followsGraph);
		for (String username : influencers.subList(0, Math.min(count, influencers.size()))) {
			System.out.println(username);
			
		}
	}

}
