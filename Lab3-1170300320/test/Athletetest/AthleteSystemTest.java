package Athletetest;

import static org.junit.Assert.*;

import org.junit.Test;

import circularorbit.AthleteSystem;
import physicalObject.Athlete;
import track.Track;

public class AthleteSystemTest {
	AthleteSystem a = new AthleteSystem();
   //若成功添加轨道应返回true
	@Test
	public void testadd() {
		Track<Athlete> track = new Track<>();
		assertEquals(true,a.addtrack(track));
		
	}
	//第一条被添加的轨道在list中应该排在第0位
	public void testremove() {
		
		Track<Athlete> track = new Track<>();
		a.addtrack(track);
		assertEquals(true,a.removetrack(0));
	}
	public void testaddtotrack() {
		Athlete ath = new Athlete();
		Track<Athlete> track = new Track<>();
		a.addtrack(track);
		a.addtotrack(ath, 0);
		assertEquals(true,track.getObj().contains(ath));
	}

}
