package DifferenceTest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import APIs.Difference;
import physicalObject.Person;

public class DifferenceTest {

	@Test
	public void test() {
		Difference<Person,Person> d = new Difference<>();
		d.setNum(3);
		assertEquals(d.getNum(),3);
		List<Integer> dif = new ArrayList<>();
		dif.add(0);
		d.setDif(dif);
		assertEquals(d.getDif(),dif);
		Set<Person> p = new HashSet<>();
		//Person a = new Person();
		//Person b = new Person();
		List<Set<Person>> persons = new ArrayList<>();
		persons.add(p);
		d.setDetaildifa(persons);
		d.setDetaildifb(persons);
		assertEquals(d.getDetaildifa(),persons);
		assertEquals(d.getDetaildifb(),persons);
	}

}
