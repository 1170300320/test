package Athletetest;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
	@Test
	public void testremove() {
		Track<Athlete> track = new Track<>();
		a.addtrack(track);
		assertEquals(true,a.removetrack(0));
	}
	@Test
	public void testaddtotrack() {
		Athlete ath = new Athlete();
		ath.setName("n");
		Track<Athlete> track = new Track<>();
		int num = track.getNum();
		a.addtrack(track);
		a.addtotrack(ath, num);
		for(Athlete at:track.getObj()) {
			System.out.println(at.getName());
		}
		//assert track.getObj().contains(ath);
	}
	@Test
    public void testdetail() {
    	AthleteSystem a = new AthleteSystem();
    	a.detail();
    	assert a.type == 100;
    	assert a.total == 7;
    	Set<Athlete> o = a.obj;
    	Set<String> nameset = new HashSet<>();
    	Set<String> nationset = new HashSet<>();
    	Set<Double> bestset = new HashSet<>();
    	Set<Integer> ageset = new HashSet<>();
    	Set<Integer> numset = new HashSet<>();
    	for(Athlete ath:o) {
    		nameset.add(ath.getName());
    		nationset.add(ath.getNation());
    		bestset.add(ath.getBest());
    		ageset.add(ath.getAge());
    		numset.add(ath.getNum());
    	}
    	String name = "Sgg";
    	String nation = "SIN";
    	Double best = 9.57;
    	int age = 18;
    	int num = 999;
    	assert nameset.contains(name);
    	assert nationset.contains(nation);
    	assert bestset.contains(best);
    	assert ageset.contains(age);
    	assert numset.contains(num);
    	
    	
    }
	@Test
    public void testgettotal() {
    	AthleteSystem a = new AthleteSystem();
    	a.detail();
    	assert a.gettotal() == 7;
    }
	@Test
    public void testsettotal() {
    	AthleteSystem a = new AthleteSystem();
    	a.detail();
    	assert a.gettotal() == 7;
    	}
	@Test
    public void testgroup() {
    	AthleteSystem a = new AthleteSystem();
    	a.detail();
    	List<Set<String>> group = a.group();
    	Set<String> groupname = new HashSet<>();
    	Set<Athlete> o = a.obj;
    	Set<String> name = new HashSet<>();
    	for(Athlete ath:o) {
    		name.add(ath.getName());
    	}
    	for(Set<String> single:group) {
    		assert single.size()<=7;
    		for(String str:single) {
    			groupname.add(str);
    		}
    	}
    		
    }
	@Test
    public void testplangroup() {
    	AthleteSystem a = new AthleteSystem();
    	a.detail();
    	List<List<String>> plangroup = a.plangroup();
    	List<Double> bestgroup = new ArrayList<>();
    	Set<String> groupname = new HashSet<>();
    	Set<Athlete> o = a.obj;
    	Set<String> name = new HashSet<>();
    	for(Athlete ath:o) {
    		name.add(ath.getName());
    	}
    	for(List<String> single:plangroup) {
    		assert single.size()<=7;
    		for(String str:single) {
    			groupname.add(str);
    			for(Athlete ath:o) {
    				if(ath.getName().equals(str)) {
    					bestgroup.add(ath.getBest());
    				}
    			}
    		}
    		assert bestgroup.get(3)>=bestgroup.get(0);
    		assert bestgroup.get(3)>=bestgroup.get(1);
    		assert bestgroup.get(3)>=bestgroup.get(2);
    		assert bestgroup.get(3)>=bestgroup.get(4);
    		//assert bestgroup.get(3)>=bestgroup.get(5);
    		assert bestgroup.get(3)>=bestgroup.get(6);
    		bestgroup = new ArrayList<>();
    	}
    	
    	//assert groupname.equals(name);
    }
	@Test
    public void testexchange() {
    	AthleteSystem a = new AthleteSystem();
    	a.detail();
    	int num1 = 0;
    	int num2 = 0;
    	List<List<String>> plangroup = a.plangroup();
    	for(List<String> p:plangroup) {
    		for(String pp:p) {
    			if(pp.equals("Ujehe"))
    		       num1 = plangroup.indexOf(p);
    			else if(pp.equals("Uschht"))
    				num2 = plangroup.indexOf(p);
    		}
    	}
    	a.exchange("Ujehe", "Uschht", plangroup);
    	for(List<String> p:plangroup) {
    		for(String pp:p) {
    			if(pp.equals("Ujehe"))
    		       assert plangroup.indexOf(p) == num2;
    			else if(pp.equals("Uschht"))
    				assert plangroup.indexOf(p) == num1;
    		}
    	}
    }
	@Test
    public void testgetobj() {
    	AthleteSystem a = new AthleteSystem();
    	a.detail();
    	Set<Athlete> o = a.getobj();
    	assert o.size() == 1000; 
    }
}
