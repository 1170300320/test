package circularorbit;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import centralObject.Athletecenter;
import physicalObject.Athlete;

public class Athlete312 extends ConcreteCircularOrbit<Athletecenter<Athlete>, Athlete>{
	private final static ConcreteCircularOrbit<Athletecenter<Athlete>,Athlete> a = ConcreteCircularOrbit.empty();
	Set<Athlete> obj = new HashSet<>();
	int total;
	int type;
	public void detail() {
		File f = new File("src/TrackGame_Medium.txt");
		try {
			String str = a.read(f);
			//System.out.println(str);
			String reg0 = "Game ::= ([0-9]+)";
			Pattern pattern0 = Pattern.compile(reg0);
			Matcher matcher0 = pattern0.matcher(str);
			if (matcher0.find()) {
				//System.out.println(matcher0.group(1));
				type = Integer.valueOf(matcher0.group(1));
			}
			String reg1 = "NumOfTracks ::= ([0-9]+)";
			Pattern pattern1 = Pattern.compile(reg1);
			Matcher matcher1 = pattern1.matcher(str);
			if (matcher1.find()) {
				//System.out.println(matcher1.group(1));
				total = Integer.valueOf(matcher1.group(1));
			}
			String reg2 = "Athlete ::= <([^,]+),([^,]+),([^,]+),([^,]+),([^,]+)>";
			Pattern pattern2 = Pattern.compile(reg2);
			Matcher matcher2 = pattern2.matcher(str);
			while(matcher2.find()) {
				Athlete p = new Athlete();
				p.setName(matcher2.group(1)); 
				//System.out.println(matcher2.group(1));
				p.setNum(Integer.valueOf(matcher2.group(2)));
				//System.out.println(Integer.valueOf(matcher2.group(2)));
				p.setNation(matcher2.group(3));
				//System.out.println(matcher2.group(3));
				p.setAge(Integer.valueOf((matcher2.group(4))));
				//System.out.println(Integer.valueOf((matcher2.group(4))));
				p.setBest(Double.parseDouble(matcher2.group(5)));
				//System.out.println(Double.parseDouble(matcher2.group(5)));
				obj.add(p);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public int gettotal() {
		return total;
	}
	public void settotal(int total) {
		this.total = total;
	}
	public List<Set<String>> group(){
		Set<String> s = new HashSet<>();
		List<Set<String>> g = new ArrayList<>();
		for(Athlete a :obj) {
			s.add(a.getName());
			if(s.size()==total) {
				g.add(s);
				s = new HashSet<>();
			}
		}
		return g;
	}
	public List<Set<String>> plangroup(){
		List<Set<String>> re = new ArrayList<>();
		Map<String,Double> Best = new HashMap<>();
		//int flag = 0;
		for(Athlete a:obj) {
			Best.put(a.getName(), a.getBest());
		}
		System.out.println(total);
		Set<String> ss = new HashSet<>();
		Collection<Double> d = Best.values();
		Set<String> copy = new HashSet<>();
		Object[] o = d.toArray();
		   Arrays.sort(o);
		   
		   for(int i = 1;i<=o.length;i++) {
			   Object k = o[o.length-i];
			   for(String name:Best.keySet()) {
				 //  System.out.println(name);
				   if(Best.get(name).equals(k)&&!copy.contains(name)) {
					   ss.add(name);
					   copy.add(name);
					   if(ss.size() == total*4) {
							  // System.out.println(ss.size());
							   re.add(ss);
							   ss = new HashSet<>();
							   //flag = 0;
						   }
					   
				   }
				   
			   }
		   }
		  
		  return re;
	}
	public List<Set<String>> exchange(String a,String b,List<Set<String>> group) {
		int num1 = 0;
		int num2 = 0;
		for(int i = 0;i<group.size();i++) {
			for(String ss:group.get(i)) {
				if(ss.equals(a))
				{
					num1 = i;
				}
				else if(ss.equals(b)) {
					num2 = i;
				}
			}
		}
		for(String s:group.get(num1))
		{
			System.out.print(s+" ");
		}
		System.out.print("\n");
		for(String s:group.get(num2))
		{
			System.out.print(s+" ");
		}
		System.out.print("\n");
		group.get(num1).remove(a);
		group.get(num2).remove(b);
		group.get(num1).add(b);
		group.get(num2).add(a);
		for(String s:group.get(num1))
		{
			System.out.print(s+" ");
		}
		System.out.print("\n");
		for(String s:group.get(num2))
		{
			System.out.print(s+" ");
		}
		System.out.print("\n");
		return group;
	}
	public Set<Athlete> getobj(){
		return obj;
	}
	public static void main(String[] args) {
		AthleteSystem ss = new AthleteSystem();
		ss.detail();
		List<Set<String>> l = ss.plangroup();
		ss.exchange("Ujehe", "Uschht", l);
	}
}
