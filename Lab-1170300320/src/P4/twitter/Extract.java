/* Copyright (c) 2007-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P4.twitter;

import java.time.Instant;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Extract consists of methods that extract information from a list of tweets.
 * 
 * DO NOT change the method signatures and specifications of these methods, but
 * you should implement their method bodies, and you may add new public or
 * private methods or classes if you like.
 */
public class Extract {

    /**
     * Get the time period spanned by tweets.获取推文所涵盖的时间段
     * 
     * @param tweets
     *            list of tweets with distinct ids, not modified by this method.
     * @return a minimum-length time interval that contains the timestamp of
     *         every tweet in the list.
     */
    public static Timespan getTimespan(List<Tweet> tweets) {
    	Instant start = null;
    	Instant end = null;
        for(int i = 0;i<tweets.size();i++)
        {
        	start = tweets.get(i).getTimestamp();
        	end = tweets.get(i).getTimestamp();
        	for(int j = 0;j<tweets.size();j++)
        	{
        		if(tweets.get(j).getTimestamp().isAfter(end))
        			end = tweets.get(j).getTimestamp();
        		else if(tweets.get(j).getTimestamp().isBefore(start))
        			start = tweets.get(j).getTimestamp();
        	}
        }
        Timespan result = new Timespan(start,end);      
        return result;
    }

    /**
     * Get usernames mentioned in a list of tweets.
     * 
     * @param tweets
     *            list of tweets with distinct ids, not modified by this method.
     * @return the set of usernames who are mentioned in the text of the tweets.
     *         A username-mention is "@" followed by a Twitter username (as
     *         defined by Tweet.getAuthor()'s spec).
     *         The username-mention cannot be immediately preceded or followed by any
     *         character valid in a Twitter username.
     *         For this reason, an email address like bitdiddle@mit.edu does NOT 
     *         contain a mention of the username mit.
     *         Twitter usernames are case-insensitive, and the returned set may
     *         include a username at most once.
     */
    public static Set<String> getMentionedUsers(List<Tweet> tweets) {
        Set<String> name = new HashSet<String>();
        Pattern p = Pattern.compile("(^|[^A-Za-z0-9_-]+)@([A-Za-z0-9_-]+)");
        Pattern p1 = Pattern.compile("(^|[^A-Za-z0-9_-]+)@([A-Za-z0-9_-]+\\.)");
        
       for(Tweet t:tweets)
       {
    	   String text = t.getText();
    	   Matcher name0 = p.matcher(text);
    	   Matcher name1 = p1.matcher(text);
    	   while(name0.find()&&!name1.find())
    	   {
    		   String re = new String(name0.group(2).toString().toLowerCase());
    		   name.add(re);
    	   }
       }
        return name;
        
    }

}
