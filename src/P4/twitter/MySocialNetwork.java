/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P4.twitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * SocialNetwork provides methods that operate on a social network.
 * 
 * A social network is represented by a Map<String, Set<String>> where map[A] is
 * the set of people that person A follows on Twitter, and all people are
 * represented by their Twitter usernames. Users can't follow themselves. If A
 * doesn't follow anybody, then map[A] may be the empty set, or A may not even exist
 * as a key in the map; this is true even if A is followed by other people in the network.
 * Twitter usernames are not case sensitive, so "ernie" is the same as "ERNie".
 * A username should appear at most once as a key in the map or in any given
 * map[A] set.
 * 
 * DO NOT change the method signatures and specifications of these methods, but
 * you should implement their method bodies, and you may add new public or
 * private methods or classes if you like.
 */
public class MySocialNetwork {

    /**
     * Guess who might follow whom, from evidence found in tweets.
     * 
     * @param tweets
     *            a list of tweets providing the evidence, not modified by this
     *            method.
     * @return a social network (as defined above) in which Ernie follows Bert
     *         if and only if there is evidence for it in the given list of
     *         tweets.
     *         One kind of evidence that Ernie follows Bert is if Ernie
     *         @-mentions Bert in a tweet. This must be implemented. Other kinds
     *         of evidence may be used at the implementor's discretion.
     *         All the Twitter usernames in the returned social network must be
     *         either authors or @-mentions in the list of tweets.
     */
    public static Map<String, Set<String>> guessFollowsGraph(List<Tweet> tweets) {
       Map<String, Set<String>> result = new HashMap<String, Set<String>>();
       for(Tweet t:tweets)
       {
    	   String author = t.getAuthor();
    	   List<Tweet> tmp = new ArrayList<Tweet>();
    	   tmp = Filter.writtenBy(tweets,author);//找出由当前作者编辑的tweet
    	   List<Tweet> tmp0 = new ArrayList<Tweet>(tmp);
    	   Set<String> follow = new HashSet<String>();
    	   follow = Extract.getMentionedUsers(tmp0);//当前人可能关注的
    	   result.put(author, follow);
       }
       return result;
    }

    /**
     * Find the people in a social network who have the greatest influence, in
     * the sense that they have the most followers.
     * 
     * @param followsGraph
     *            a social network (as defined above)
     * @return a list of all distinct Twitter usernames in followsGraph, in
     *         descending order of follower count.按关注者人数递减排列
     */
    public static List<String> influencers(Map<String, Set<String>> followsGraph) {
    	int i = 0;
    	Map<String,Integer> result = new HashMap<String,Integer>(); 
    	List<String> list = new ArrayList<String>();
    	for(String s:followsGraph.keySet())//当前人物的名字
        {
        	       		
           		result.put(s,i);     		
        	
        }
    	for(String s:followsGraph.keySet())
        {
        	Set<String> a = new HashSet<String>();
        	a = followsGraph.get(s);
        	for(String f:a)
         {
        		int k = result.get(f);
        		System.out.println(k++);
        		result.put(f,k++);        		
         }
        }
    	Collection<Integer> c = result.values();
    	Object[] obj = c.toArray();
    	Arrays.sort(obj);
    	for(int m = obj.length-1;m>=0;m--)
    	{
          for(String key:result.keySet())
          {
        	  if(result.get(key).equals(obj[m]))
        	  {
        		  list.add(key);
        		  break;
        	  }
          }
    	}
    	return list;
    	
    }




    public static List<String> sametopic(List<Tweet> tweets)//向用户推荐可能关注的人
    {
    	List<String> result = new ArrayList<String>();
    	Pattern p = Pattern.compile("(^|[^A-Za-z0-9_-]+)#([A-Za-z0-9_-]+)");
        for(Tweet t:tweets)
        {
           String text = t.getText();
      	   Matcher name0 = p.matcher(text);
      	   while(name0.find())
      	   {
      		   String re = t.getAuthor();
      		   result.add(re);
      	   }
        }
        
        return result;
    	
    }

}
