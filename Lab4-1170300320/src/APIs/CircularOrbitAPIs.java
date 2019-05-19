package APIs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import centralObject.Atomcenter;
import centralObject.Personcenter;

import java.lang.Math;

import circularorbit.AtomStructure;
import circularorbit.ConcreteCircularOrbit;
import physicalObject.Atom;
import physicalObject.Person;
import physicalObject.PhysicalObject;
import track.Track;

public class CircularOrbitAPIs<L,E> {
	public double getObjectDistributionEntropy(AtomStructure c) {
		double entropy =0;
		int total = 0;
		for(int k:c.geteachnum().keySet())
		{
			total += c.geteachnum().get(k);
			//System.out.println(total);
		}
		
		
		for(int k:c.geteachnum().keySet())
		{
            int i = c.geteachnum().get(k);
			double pi = (double)i/(double)total;
			double logi = Math.log(pi)/Math.log((double)2);
			entropy += -(pi*logi);
		}
		return entropy;
	}
	public int getLogicalDistance (PhysicalObject<E> e1, PhysicalObject<E> e2) {
		int d;
		int num1 = e1.getNum();
		int num2 = e2.getNum();
		d = num2-num1;
		return d;
	}
	public double getPhysicalDistance (PhysicalObject<E> e1, PhysicalObject<E> e2) {
		double d;    
		double sitha1 = e1.getSitha();
		double sitha2 = e2.getSitha();
		double r1 = e1.getTrarad();
		double r2 = e2.getTrarad();
		double y1 = r1*(Math.sin(sitha1));
		double x1 = r1*(Math.cos(sitha1));
		double x2 = r2*(Math.sin(sitha2));
		double y2 = r2*(Math.cos(sitha2));
		double x = Math.abs(x2-x1);
		double y = Math.abs(y2-y1);
		d = Math.sqrt(x*x+y*y);
		return d;
	}
	public Difference<L,E> OtherDifference(ConcreteCircularOrbit<L,E> c1, ConcreteCircularOrbit<L,E> c2){
		int num1 = 0;
    	int num2 = 0;
    	for(Set<E> o:c1.getobjects()) {
    		num1 += o.size();
    	}
    	for(Set<E> o:c2.getobjects()) {
    		num2 += o.size();
    	}
    	Difference<L,E> d =new Difference<>();
    	List<Integer> dif = new ArrayList<>();
    	List<Set<E>> detaildifa = new ArrayList<>();
    	List<Set<E>> detaildifb = new ArrayList<>();
    	d.setNum(num2-num1);
    		int n = Math.max(num1, num2);
    		for(int i = 0;i<=n;i++)
    		{
    			Set<E> a = c1.getobjects().get(i);
    			Set<E> a0 = a;
    			Set<E> b = c2.getobjects().get(i);
    			Set<E> re = new HashSet<>();//全集
    			re.addAll(a);
    			re.addAll(b);
    			Collection<E> aa = new HashSet<>(a);
    			Collection<E> bb = new HashSet<>(b);
    			aa.retainAll(bb);//交集
    			a0.removeAll(aa);
    			b.removeAll(aa);
    			detaildifa.add(i,a0);
    			detaildifb.add(i,b);
    		}
    	
    	d.setDetaildifa(detaildifa);
    	d.setDetaildifb(detaildifb);
    	d.setDif(dif);
    	return d;
	}
    public Difference<Atomcenter<Atom>,Atom> AtomgetDifference (AtomStructure c1, AtomStructure c2) {
    	int num1 = c1.gettotal();
    	int num2 = c2.gettotal();
    	Difference<Atomcenter<Atom>,Atom> d =new Difference<>();
    	List<Integer> dif = new ArrayList<>();
    	List<Set<Atom>> detaildifa = new ArrayList<>();
    	List<Set<Atom>> detaildifb = new ArrayList<>();
    	d.setNum(num2-num1);
    	int n = Math.max(num1, num2);
    		for(int i = 0;i<=n;i++)
    		{
    			int objnum1 = c1.getobjects().size();
    			int objnum2 = c2.getobjects().size();
    			dif.add(i,objnum2-objnum1);
    		}
    	d.setDetaildifa(detaildifa);
    	d.setDetaildifb(detaildifb);
    	d.setDif(dif);
    	return d;
    }
    public static void main(String[] args) {
    	CircularOrbitAPIs<Atomcenter<Atom>,Atom> api = new CircularOrbitAPIs<>();
    	AtomStructure ath = new AtomStructure();
    	ath.detail();
    	double d = api.getObjectDistributionEntropy(ath);
       System.out.println(d);
       CircularOrbitAPIs<Personcenter<Person>,Person> sapi = new CircularOrbitAPIs<>();
       Person p1 = new Person();
       Person p2 = new Person();
       ConcreteCircularOrbit<Personcenter<Person>, Person> s1 = new ConcreteCircularOrbit<Personcenter<Person>, Person>();
   	ConcreteCircularOrbit<Personcenter<Person>, Person> s2 = new ConcreteCircularOrbit<Personcenter<Person>, Person>();
		Set<Person> friend = new HashSet<>();
		friend.add(p1);
		friend.add(p2);
		Track<Person> t1 = new Track<>();
		Track<Person> t2 = new Track<>();
		t1.setNum(0);
		t2.setNum(1);
		t1.setCrelate(0);
		t1.setTotal(1);
		t2.setTotal(1);
		sapi.OtherDifference(s1,s2);
    }
}
