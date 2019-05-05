package Atomtest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import circularorbit.AtomStructure;
import physicalObject.Atom;
import track.Track;

public class AtomStructureTest {
	AtomStructure a = new AtomStructure();
	   //���ɹ���ӹ��Ӧ����true
		@Test
		public void testadd() {
			Track<Atom> track = new Track<>();
			assertEquals(true,a.addtrack(track));
			
		}
		//��һ������ӵĹ����list��Ӧ�����ڵ�0λ
		public void testremove() {
			
			Track<Atom> track = new Track<>();
			a.addtrack(track);
			assertEquals(true,a.removetrack(0));
		}
		public void testaddtotrack() {
			Atom ath = new Atom();
			Track<Atom> track = new Track<>();
			a.addtrack(track);
			a.addtotrack(ath, 0);
			assertEquals(true,track.getObj().contains(ath));
		}
		//m����ԭ����1�����ԾǨ��2�����
		//n����ԭ����2�����ԾǨ��1�����
		public void testtransit() {
			Atom m = new Atom();
			Atom n = new Atom();
			Track<Atom> track1 = new Track<>();
			Track<Atom> track2 = new Track<>();
			a.addtrack(track1);
			a.addtrack(track2);
			a.addtotrack(m, 0);
			a.addtotrack(n, 1);
			assertEquals(true,track1.getObj().contains(m));
			assertEquals(true,track2.getObj().contains(n));
			a.transit(m, 1);
			a.transit(n, 0);
			assertEquals(true,track1.getObj().contains(n));
			assertEquals(true,track2.getObj().contains(m));
		}
		
}
