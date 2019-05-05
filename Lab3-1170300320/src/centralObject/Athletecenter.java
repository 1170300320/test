package centralObject;

import java.util.HashMap;
import java.util.Map;

public class Athletecenter<E>{
	private double stellarrad;// 2
	private String name;// 2,3(中心原子的名字），4
	private double weight;// 2针对stellar
	private double speed;// 2
	private String gender;// 4
	private int age;// 4
	private Map<E, String> relation = new HashMap<>();// 4
	private int valid;
	public String getName() {
		// TODO Auto-generated method stub
		String n = name;
		return n;
	}

	public double getWeight() {
		// TODO Auto-generated method stub
		double w = weight;
		return w;
	}

	public String getGender() {
		// TODO Auto-generated method stub
		String g = gender;
		return g;
	}

	public double getSpeed() {
		// TODO Auto-generated method stub
		double s = speed;
		return s;
	}

	public int getAge() {
		// TODO Auto-generated method stub
		int a = age;
		return a;
	}

	public Map<E, String> getRelation() {
		// TODO Auto-generated method stub
		Map<E,String> re = new HashMap<>();
		re = relation;
		return re;
	}

	public int getValid() {
		// TODO Auto-generated method stub
		int v = valid;
		return v;
	}

	public void setstellarrad(double r) {
		// TODO Auto-generated method stub
		this.setStellarrad(r);
		
	}

	public void setname(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}

	public void setweight(double weight) {
		// TODO Auto-generated method stub
		this.weight = weight;
	}

	public void setgender(String gender) {
		// TODO Auto-generated method stub
		this.gender = gender;
	}

	public void setspeed(double speed) {
		// TODO Auto-generated method stub
		this.speed = speed;
	}

	public void setage(int age) {
		// TODO Auto-generated method stub
		this.age = age;
	}

	public void settrlation(Map<E, String> relation) {
		// TODO Auto-generated method stub
		this.relation = relation;
	}

	public void setvalid(int valid) {
		// TODO Auto-generated method stub
		this.valid = valid;
	}

	public double getStellarrad() {
		return stellarrad;
	}

	public void setStellarrad(double stellarrad) {
		this.stellarrad = stellarrad;
	}

}
