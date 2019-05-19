package debug;

import static org.junit.Assert.*;

import org.junit.Test;

public class test3 {

	@Test
	public void test() {
		int[] persons = {0,1,1,0,0,1,0};
		int[] times = {0,5,10,15,20,25,30};
		TopVotedCandidate t = new TopVotedCandidate(persons,times);
		assertEquals(1,t.q(12));
		assertEquals(0,t.q(3));
	}

}
