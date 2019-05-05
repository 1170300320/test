package Atomtest;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import circularorbit.AtomStructure;
import physicalObject.Atom;
import track.Track;

public class AtomStructureTest {
	AtomStructure a = new AtomStructure();
	   //若成功添加轨道应返回true
		@Test
		public void testadd() {
			Track<Atom> track = new Track<>();
			assertEquals(true,a.addtrack(track));
			
		}
		//第一条被添加的轨道在list中应该排在第0位
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
		//m电子原来在1轨道上跃迁到2轨道上
		//n电子原来在2轨道上跃迁到1轨道上
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
