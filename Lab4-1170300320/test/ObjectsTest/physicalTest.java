package ObjectsTest;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import physicalObject.Atom;

public class physicalTest {

	@Test
	public void atomtest() {
		String name = "n";
		Atom atom = new Atom();
		atom.setName(name);
		atom.setAge(20);
		atom.setNum(0);
		atom.setR(2.0);
		atom.setSitha(2.0);
		atom.setTrarad(3.0);
		Map<Integer,Double> mm = new HashMap<>();
		mm.put(2, 1.0);
		atom.setcRelation(mm);
		assertEquals(0,atom.getAge());
		assertEquals(0,atom.getNum());
		assertTrue(2.0==atom.getR());
		assertTrue(0==atom.getSitha());
		assertTrue(3.0==atom.getTrarad());
		assertEquals(atom.getcRelation(),mm);
		
	}

}
