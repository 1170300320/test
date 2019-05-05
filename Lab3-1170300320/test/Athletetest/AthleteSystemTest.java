package Athletetest;

import static org.junit.Assert.*;

import org.junit.Test;

import circularorbit.AthleteSystem;
import physicalObject.Athlete;
import track.Track;

public class AthleteSystemTest {
	AthleteSystem a = new AthleteSystem();
   //���ɹ���ӹ��Ӧ����true
	@Test
	public void testadd() {
		Track<Athlete> track = new Track<>();
		assertEquals(true,a.addtrack(track));
		
	}
	//��һ������ӵĹ����list��Ӧ�����ڵ�0λ
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
