package physicalObject;

import java.util.HashMap;
import java.util.Map;

public class Atom implements PhysicalObject<Atom> {
    private String name;
    private int num;
    private double trarad;
    private double r;
    private Map<Atom, Double> relation;
    private Map<Integer,Double> crelation;
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		String n = name;
		return n;
	}

	@Override
	public int getNum() {
		// TODO Auto-generated method stub
		int n =num;
		return n;
	}

	@Override
	public double getTrarad() {
		// TODO Auto-generated method stub
		double t = trarad;
		return t;
	}


	@Override
	public double getR() {
		// TODO Auto-generated method stub
		double rad = r;
		return rad;
	}


	public Map<Atom, Double> getRelation() {
		// TODO Auto-generated method stub
		Map<Atom, Double> r = new HashMap<>(relation);
		return r;
	}

	@Override
	public Map<Integer, Double> getcRelation() {
		// TODO Auto-generated method stub
		Map<Integer, Double> c = crelation;
		return c;
	}

	@Override
	public void setName(String name) {
		// TODO Auto-generated method stub

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
		this.r = r;
	}


	@Override
	public void setcRelation(Map<Integer, Double> crelation) {
		// TODO Auto-generated method stub
		this.crelation = crelation;
	}

	@Override
	public int getAge() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void setAge(int age) {
		// TODO Auto-generated method stub
		
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

	
}
