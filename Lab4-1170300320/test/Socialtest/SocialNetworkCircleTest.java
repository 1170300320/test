package Socialtest;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import centralObject.Personcenter;
import circularorbit.AthleteSystem;
import circularorbit.ConcreteEdgesGraph;
import circularorbit.SocialNetworkCircle;
import physicalObject.Athlete;
import physicalObject.Person;
import track.Track;

public class SocialNetworkCircleTest {
	SocialNetworkCircle a = new SocialNetworkCircle();
	   //若成功添加轨道应返回true
		@Test
		public void testadd() {
			Track<Person> track = new Track<>();
			assertEquals(true,a.addtrack(track));
			
		}
		//第一条被添加的轨道在list中应该排在第0位
		@Test
		public void testremove() {
			Track<Person> track = new Track<>();
			a.addtrack(track);
			assertEquals(true,a.removetrack(0));
		}
		@Test
		public void testaddtotrack() {
			Person ath = new Person();
			Track<Person> track = new Track<>();
			int t = track.getTotal();
			a.addtrack(track);
			a.addtotrack(ath, 0);
			assert track.getTotal() == t+1;
		}
		@Test
		public void testcrelation() {
			Person p0 = new Person();
			Personcenter<Person> p = new Personcenter<>();
			Track<Person> track = new Track<>();
			a.addtrack(track);
			a.addcrelateo(p, p0);
			a.addcenter(p);
			Map<Integer,Double> m = new HashMap<>();
			m.put(1, 0.1);
			p0.setcRelation(m);
			assertEquals(m,p0.getcRelation());
		}
		@Test
		public void testorelation() {
			Person p1 = new Person();
			Person p2 = new Person();
			p1.setRelation(p2, 0.1);
			Double s = 0.1;
			assertEquals(s,p1.getRelation().get(p2));
		}
        @Test
        public void testdetail() {
        	a.detail();
            String c = "TommyWong";
            String z = "PonyMa";
            Set<String> nameset = new HashSet<>();
            Set<Integer> ageset = new HashSet<>();
            for(Person p:a.getFriend()) {
            	nameset.add(p.getName());
            	ageset.add(p.getAge());
            }
            assertTrue (nameset.contains(c));
            assertTrue (nameset.contains(z));
            assertTrue (ageset.contains(30));
            assertTrue (ageset.contains(47));
        }
        @Test
        public void testgetFriend() {
        	a.detail();
            String c = "TommyWong";
            String z = "PonyMa";
            Set<String> nameset = new HashSet<>();
            Set<Integer> ageset = new HashSet<>();
            for(Person p:a.getFriend()) {
            	nameset.add(p.getName());
            	ageset.add(p.getAge());
            }
            assert nameset.contains(c);
            assert nameset.contains(z);
            assert ageset.contains(30);
            assert ageset.contains(47);
        }
        @Test
        public void testsetFriend() {
        	Person ab = new Person();
        	ab.setName("ab");
        	ab.setAge(50);
        	Set<Person> p = new HashSet<>();
        	p.add(ab);
        	a.setFriend(p);
        	assertEquals(a.getFriend(),p);
        }
        @Test
        public void testgetC() {
        	a.detail();
        	Person c = a.getC();
        	String name = "TommyWong";
        	int age = 30;
        	System.out.println(c.getAge());
        	assertEquals(c.getAge(),30);
        	assertEquals(c.getName(),name);
        }
        @Test
        public void testgetgraph() {
        	a.detail();
        	assert a.getgraph()!=null;
        }
        @Test
        public void testsetgraph() {
        	a.detail();
        	ConcreteEdgesGraph<Person> g = new ConcreteEdgesGraph<Person>();
        	a.setgraph(g);
        	assertEquals(a.getgraph(),g);
        }
        @Test
        public void testspread() {
        	a.detail();
        	double s = 1.612;
        	double ss = a.spread(a.getC());
        	assert ss == s;
        }  
        @Test
        public void testgetDistance() {
        	a.detail();
        	//List<Person> fri = new ArrayList<>();
        	Person Tom = new Person();
        	Person David = new Person();
        	Person Lisa = new Person();
        	for(Person p:a.getFriend()) {
        		assertEquals(a.getDistance(p,p),0);
        		if(p.getName().equals("TomWong")) {
        			System.out.println("!");
        			Tom = p;
        		}
        		if(p.getName().equals("LisaWong")) {
        			Lisa = p;
        		}
        		if(p.getName().equals("DavidChen")) {
        			David = p;
        		}
        	}
        	
        	assertEquals(a.getDistance(Tom, Tom),0);
        	assertEquals(a.getDistance(Tom, David),2);
        	//System.out.println(a.getDistance(Tom, Lisa));
        	assertEquals(a.getDistance(Tom, Lisa),-1);
        }

}
