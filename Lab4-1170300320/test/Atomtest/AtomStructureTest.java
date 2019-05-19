package Atomtest;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;
import java.util.Map;

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
		@Test
		public void testremove() {
			
			Track<Atom> track = new Track<>();
			a.addtrack(track);
			assertEquals(true,a.removetrack(0));
		}
		@Test
		public void testaddtotrack() {
			Atom ath = new Atom();
			Track<Atom> track = new Track<>();
			int t = track.getTotal();
			a.addtrack(track);
			a.addtotrack(ath, 0);
			assert track.getTotal() == t+1;
		}
		//m电子原来在1轨道上跃迁到2轨道上
		//n电子原来在2轨道上跃迁到1轨道上
		@Test
		public void testtransit() {
			Atom m = new Atom();
			Atom n = new Atom();
			Track<Atom> track1 = new Track<>();
			Track<Atom> track2 = new Track<>();
			a.addtrack(track1);
			a.addtrack(track2);
			a.addtotrack(m, 0);
			a.addtotrack(n, 1);
			a.transit(m, 1);
			//System.out.println(track1.getTotal());
			//System.out.println(track2.getTotal());
			assert track1.getTotal() == 1;
			assert track2.getTotal() == 1;
		}
		@Test
		public void testgetName() {
			a.detail();
			a.setName("N");
			assert a.getName().equals("N");
		}
		@Test
		public void testsetName() {
			a.detail();
			a.setName("N");
			assert a.getName().equals("N");
		}
		@Test
		public void testseteachnum() {
			Map<Integer,Integer> mm = new HashMap<>();
			mm.put(1, 2);
			mm.put(2, 8);
			mm.put(3, 18);
			mm.put(4, 30);
			mm.put(5, 8);
			mm.put(6, 2);
			a.detail();
			a.setEach(mm);
            assert a.geteachnum().equals(mm);
		}
		@Test
		public void testgeteachnum() {
			Map<Integer,Integer> mm = new HashMap<>();
			mm.put(1, 2);
			mm.put(2, 8);
			mm.put(3, 18);
			mm.put(4, 30);
			mm.put(5, 8);
			mm.put(6, 2);
			a.detail();
			
            assert a.geteachnum().equals(mm);
		}
		@Test
		public void testsettotal() {
			a.detail();
			a.settotal(6);
			assert a.gettotal()==6;
		}
		@Test
		public void testgettotal() {
			a.detail();
			assert a.gettotal()==6;
		}
		@Test
		public void testgettracks() {
			a.detail();
			
			assert a.gettracks()!=null;
		}
		@Test
		public void testdetail() {
			AtomStructure a = new AtomStructure();
			a.detail();
			String name = "Er";
			System.out.println(a.name);
			assert a.name.equals(name);
			assert a.num == 6;
			Map<Integer,Integer> mm = new HashMap<>();
			mm.put(1, 2);
			mm.put(2, 8);
			mm.put(3, 18);
			mm.put(4, 30);
			mm.put(5, 8);
			mm.put(6, 2);
			assert a.geteachnum().equals(mm);
		}
		
		
}
