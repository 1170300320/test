package physicalObject;

import java.util.HashMap;
import java.util.Map;

public class Person implements PhysicalObject<Person>{
	private String name;
    private int num;
    private double trarad;   
    private Map<Person, Double> relation = new HashMap<>();
    private Map<Integer,Double> crelation;
    private String gender;
    private int age;
    private double x;
    private double y;
    private int valid;
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		String n = name;
		return n;
	}

	@Override
	public int getNum() {
		// TODO Auto-generated method stub
		int n = num;
		return n;
	}

	@Override
	public double getTrarad() {
		// TODO Auto-generated method stub
		double r = trarad;
		return r;
	}


	@Override
	public double getR() {
		// TODO Auto-generated method stub
		return 0;
	}


	@Override
	public Map<Person, Double> getRelation() {
		// TODO Auto-generated method stub
		//Map<Person, Double> re = relation;
		return relation;
	}

	@Override
	public Map<Integer, Double> getcRelation() {
		// TODO Auto-generated method stub
		Map<Integer,Double> c = crelation;
		return c;
	}

	public String getGender() {
		String g = gender;
		return g;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}
	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub
		this.name = name;
	}

	@Override
	public void setNum(int num) {
		// TODO Auto-generated method stub
		this.num = num;
	}

	@Override
	public void setTrarad(double trarad) {
		// TODO Auto-generated method stub
		this.trarad = trarad;
	}

	@Override
	public void setR(double r) {
		// TODO Auto-generated method stub

	}

	@Override
	public void setcRelation(Map<Integer, Double> crelation) {
		// TODO Auto-generated method stub
		this.crelation = crelation;
	}


	@Override
	public int getAge() {
		// TODO Auto-generated method stub
		int a = age;
		return a;
	}

	@Override
	public void setAge(int age) {
		// TODO Auto-generated method stub
		this.age = age;
	}

	@Override
	public double getSitha() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setSitha(double sitha) {
		// TODO Auto-generated method stub
		
	}

	public void setRelation(Person p ,Double r) {
		Map<Person,Double> m = new HashMap<>();
		 m =relation;
		m.put(p, r);
		relation = m;
	}
	public void setPositon(int x,int y) {
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return (int)x;
	}
	public int getY() {
		return (int)y;
	}
	public void setValid(int i) {
		this.valid = i;
	}
	public int getValid() {
		int i = valid;
		return i;
	}

}
