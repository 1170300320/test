package physicalObject;

import java.util.Map;

public class Athlete implements PhysicalObject<Athlete>{
	//private String name;
    private int num;
    private double trarad;
    private double r;
    //private Map<Athlete, Double> relation;
    private Map<Integer,Double> crelation;
    private String nation;
    private double best;
    private int age;
    private String name;
	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return name;
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
		double ra = r;
		return ra;
	}


	public Map<Athlete, Double> getRelation() {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public Map<Integer, Double> getcRelation() {
		// TODO Auto-generated method stub
		Map<Integer,Double> c = crelation;
		return c;
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
		return age;
	}

	@Override
	public void setAge(int age) {
		// TODO Auto-generated method stub
		this.age = age;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public double getBest() {
		return best;
	}

	public void setBest(double best) {
		this.best = best;
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
