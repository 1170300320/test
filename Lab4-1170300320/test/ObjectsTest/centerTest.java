package ObjectsTest;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import APIs.CircularOrbitAPIs;
import APIs.CircularOrbitHelpers;
import centralObject.Atomcenter;
import centralObject.Personcenter;
import circularorbit.AthleteSystem;
import circularorbit.AtomStructure;
import circularorbit.CircularOrbit;
import circularorbit.ConcreteCircularOrbit;
import circularorbit.SocialNetworkCircle;
import physicalObject.Atom;
import physicalObject.Person;
import track.Track;

public class centerTest {

	@Test
	public void Personcentertest() {
		Personcenter<Person> p = new Personcenter<>();
		p.setage(20);
		assertEquals(p.getAge(), 20);
		p.setgender("F");
		assertEquals(p.getGender(),"F");
		p.setname("n");
		assertEquals(p.getName(),"n");
		p.setvalid(0);
		assertEquals(p.getValid(),0);
		Person pp = new Person();
		String str = "no";
		Map<Person,String> mm = new HashMap<>();
		mm.put(pp, str);
		p.settrlation(mm);
		assertEquals(p.getRelation(),mm);
	}
	@Test
	public void AtomcenterTest() {
		Atomcenter<Atom> a = new Atomcenter<>();
	    String name = "n";
	    a.setname(name);
	    assertEquals(a.getName(),name);
	    a.setvalid(0);
	    assertEquals(a.getValid(),0);
	    Atom atom = new Atom();
	    String re = "re";
	    Map<Atom,String> m = new HashMap<>();
	    m.put(atom, re);
	    a.settrlation(m);
	    assertEquals(a.getRelation(),m);
	}
    @Test
    public void  helpertest() {
    	assertEquals(1,CircularOrbitHelpers.visualize("Atom"));
    	assertEquals(1,CircularOrbitHelpers.visualize("Social"));
    	assertEquals(1,CircularOrbitHelpers.visualize("Athlete"));
    	
    	
    	
    }
    @Test
    public void APItest() {
    	//AthleteSystem a = new AthleteSystem();
    
    	AtomStructure atom1 = new AtomStructure();
    	AtomStructure atom2 = new AtomStructure();
    	
    	CircularOrbitAPIs<Personcenter<Person>,Person> sapi = new CircularOrbitAPIs<>();
    	CircularOrbitAPIs<Atomcenter<Atom>,Atom> api = new CircularOrbitAPIs<>();
    	Person p1 = new Person();
    	Person p2 = new Person();
    	p1.setNum(1);
    	p2.setNum(2);
    	assertEquals(1,sapi.getLogicalDistance(p1, p2));
    	p1.setTrarad(5);
    	p2.setTrarad(6);
    	p1.setSitha(2.0);
    	p2.setSitha(2.0);
    	assertTrue(7.810249675906654==sapi.getPhysicalDistance(p1, p2));
    	assertTrue(api.AtomgetDifference(atom1, atom2)!=null);
    	
    	
    }
}
