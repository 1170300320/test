package tracktest;

import static org.junit.Assert.*;

import org.junit.Test;

import physicalObject.Person;
import track.Track;

public class tracktest {

	@Test
	public void test() {
		Track<Person> t = new Track<>();
		t.setCrelate(1);
		assertEquals(1,t.getCrelate());
		t.setNum(3);
		assertEquals(3,t.getNum());
		
	}

}
