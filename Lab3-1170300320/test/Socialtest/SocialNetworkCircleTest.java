package Socialtest;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import centralObject.Personcenter;
import circularorbit.AthleteSystem;
import circularorbit.SocialNetworkCircle;
import physicalObject.Athlete;
import physicalObject.Person;
import track.Track;

public class SocialNetworkCircleTest {
	SocialNetworkCircle a = new SocialNetworkCircle();
	   //���ɹ���ӹ��Ӧ����true
		@Test
		public void testadd() {
			Track<Person> track = new Track<>();
			assertEquals(true,a.addtrack(track));
			
		}
		//��һ������ӵĹ����list��Ӧ�����ڵ�0λ
		public void testremove() {
			Track<Person> track = new Track<>();
			a.addtrack(track);
			assertEquals(true,a.removetrack(0));
		}
		public void testaddtotrack() {
			Person ath = new Person();
			Track<Person> track = new Track<>();
			a.addtrack(track);
			a.addtotrack(ath, 0);
			assertEquals(true,track.getObj().contains(ath));
		}
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
		public void testorelation() {
			Person p1 = new Person();
			Person p2 = new Person();
			p1.setRelation(p2, 0.1);
			Double s = 0.1;
			assertEquals(s,p1.getRelation().get(p2));
		}


}
