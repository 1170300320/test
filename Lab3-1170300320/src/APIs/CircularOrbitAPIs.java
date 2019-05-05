package APIs;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import centralObject.Atomcenter;

import java.lang.Math;

import circularorbit.AtomStructure;
import circularorbit.CircularOrbit;
import physicalObject.Atom;
import physicalObject.PhysicalObject;

public class CircularOrbitAPIs<L,E> {
	public double getObjectDistributionEntropy(AtomStructure c) {
		double entropy =0;
		int total = 0;
		for(int k:c.geteachnum().keySet())
		{
			total += c.geteachnum().get(k);
			//System.out.println(total);
		}
		//System.out.println(total);
		/*for(int i = 0;i<c.gettrack().size();i++)
		{
			int to = c.gettrack().get(i).getTotal();
			eachnum.add(i,to);
		}*/
		
		for(int k:c.geteachnum().keySet())
		{
            int i = c.geteachnum().get(k);
			//System.out.println("!");
			//System.out.println(i);
			double pi = (double)i/(double)total;
			double logi = Math.log(pi)/Math.log((double)2);
			//p.set(i,pi);
			//log.set(i, logi);
			entropy += -(pi*logi);
			//System.out.println(entropy);
		}
		return entropy;
	}
	public int getLogicalDistance (CircularOrbit<L,E> c, PhysicalObject<E> e1, PhysicalObject<E> e2) {
		int d;
		int num1 = e1.getNum();
		int num2 = e2.getNum();
		d = num2-num1;
		return d;
	}
	public double getPhysicalDistance (CircularOrbit<L,E> c, PhysicalObject<E> e1, PhysicalObject<E> e2) {
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
	public Difference<L,E> OtherDifference(CircularOrbit<L,E> c1, CircularOrbit<L,E> c2){
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
    	
    }
}
