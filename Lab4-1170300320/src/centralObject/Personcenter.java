package centralObject;

import java.util.HashMap;
import java.util.Map;

public class Personcenter<E> {
	private String name;// 2,3(中心原子的名字），4
	private String gender;// 4
	private int age;// 4
	private Map<E, String> relation = new HashMap<>();// 4
	private int valid;
	public String getName() {
		// TODO Auto-generated method stub
		String n = name;
		return n;
	}

	public String getGender() {
		// TODO Auto-generated method stub
		String g = gender;
		return g;
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


	public void setname(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}


	public void setgender(String gender) {
		// TODO Auto-generated method stub
		this.gender = gender;
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

}
