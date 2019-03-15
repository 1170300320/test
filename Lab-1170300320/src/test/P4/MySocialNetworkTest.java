package test.P4;

import static org.junit.Assert.*;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import P4.twitter.MySocialNetwork;
import P4.twitter.Tweet;

public class MySocialNetworkTest {

	final Instant d1 = Instant.parse("2016-02-17T10:00:00Z");
    final Instant d2 = Instant.parse("2016-02-17T11:00:00Z");
    final Instant d3 = Instant.parse("2016-02-17T11:00:00Z");        
    final Tweet tweet1 = new Tweet(1, "alyssa", "is it reasonable to talk about rivest @bbitdiddle #hype?", d1);
    final Tweet tweet2 = new Tweet(2, "bbitdiddle", "rivest talk in 30 minutes @alyssa #hype", d2);
    final Tweet tweet3 = new Tweet(3, "c", "rivest talk in 30 minutes @alyssa ", d3);
    List<Tweet> tweets = new ArrayList<Tweet>();
    List<String> result = MySocialNetwork.sametopic(tweets);
	       
	@Test
	public void test() {
		final Instant d1 = Instant.parse("2016-02-17T10:00:00Z");
	    final Instant d2 = Instant.parse("2016-02-17T11:00:00Z");
	    final Instant d3 = Instant.parse("2016-02-17T11:00:00Z");        
	    final Tweet tweet1 = new Tweet(1, "alyssa", "is it reasonable to talk about rivest @bbitdiddle #hype?", d1);
	    final Tweet tweet2 = new Tweet(2, "bbitdiddle", "rivest talk in 30 minutes @alyssa #hype", d2);
	    final Tweet tweet3 = new Tweet(3, "c", "rivest talk in 30 minutes @alyssa ", d3);
	    List<Tweet> tweets = new ArrayList<Tweet>();
	    tweets.add(tweet1);
	    tweets.add(tweet2);
	    tweets.add(tweet3);
	    List<String> result = MySocialNetwork.sametopic(tweets);
	    List<String> ex = new ArrayList<String>();
	    ex.add("alyssa");
	    ex.add("bbitdiddle");
		assertEquals(ex,result);
	}

}
