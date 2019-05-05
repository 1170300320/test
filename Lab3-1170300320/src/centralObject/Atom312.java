package centralObject;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Atom312<E> {
	private String name;// 2,3(中心原子的名字），4
	private Map<E, String> relation = new HashMap<>();// 4
	private int valid;
    private Set<proton> pro;
    private Set<neutron> neu;
    
	public String getName() {
		// TODO Auto-generated method stub
		String n = name;
		return n;
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

	public void settrlation(Map<E, String> relation) {
		// TODO Auto-generated method stub
		this.relation = relation;
	}
	public void setvalid(int valid) {
		// TODO Auto-generated method stub
		this.valid = valid;
	}

	public Set<proton> getPro() {
		return pro;
	}

	public void setPro(Set<proton> pro) {
		this.pro = pro;
	}

	public Set<neutron> getNeu() {
		return neu;
	}

	public void setNeu(Set<neutron> neu) {
		this.neu = neu;
	}

}
