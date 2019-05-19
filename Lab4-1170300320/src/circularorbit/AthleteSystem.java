package circularorbit;

import static org.junit.Assert.assertTrue;

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

import centralObject.Personcenter;
import physicalObject.Athlete;
import physicalObject.Person;

public class AthleteSystem extends ConcreteCircularOrbit<Personcenter<Person>, Athlete>{
	private final static ConcreteCircularOrbit<Personcenter<Person>,Athlete> a = ConcreteCircularOrbit.empty();
	public Set<Athlete> obj = new HashSet<>();
	public int total;
	public int type;
	public void checkRep(){
		assertTrue(total>=0);
		assertTrue(type == 100||type == 200||type == 300);
	}
	public void detail() {
		
		File f = new File("src/TrackGame_Medium.txt");
		try {
			String str = a.read(f);
			//System.out.println(str);
			String reg0 = "Game ::= ([0-9]+)";
			String reg00 = "Game ::= ([A-Za-z]+)";
			Pattern pattern0 = Pattern.compile(reg0);
			Pattern pattern00 = Pattern.compile(reg00);
			Matcher matcher0 = pattern0.matcher(str);
			Matcher matcher00 = pattern00.matcher(str);
			if(matcher00.find()) {
				try {
					throw new Exception("Athlete:比赛类型请输入正确数字：100；200；300");
				}
				catch(Exception a) {
					logging.logException(a);
					//a.printStackTrace();
				}
			}
			if (matcher0.find()) {
				//System.out.println(matcher0.group(1));
				type = Integer.valueOf(matcher0.group(1));
				logging.logFunction("Athlete:此次比赛类型为"+type+"米");
			}
			String reg1 = "NumOfTracks ::= ([0-9]+)";
			String reg10 = "NumOfTracks ::= ([A-Za-z]+)";
			Pattern pattern1 = Pattern.compile(reg1);
			Pattern pattern10 = Pattern.compile(reg10);
			Matcher matcher1 = pattern1.matcher(str);
			Matcher matcher10 = pattern10.matcher(str);
			if(matcher10.find()) {
				try{
					throw new Exception("Athlete:跑道个数请输入数字而不是字母");//错误输入2
				}
				catch(Exception a)
				{
					logging.logException(a);
					//a.printStackTrace();
				}
				System.exit(1);
			}
			if (matcher1.find()) {
				//System.out.println(matcher1.group(1));
				total = Integer.valueOf(matcher1.group(1));
				logging.logFunction("Athlete:共有"+total+"条跑道");
			}
			String reg2 = "Athlete ::= <([^,]+),([^,]+),([^,]+),([^,]+),([^,]+)>";
			Pattern pattern2 = Pattern.compile(reg2);
			Matcher matcher2 = pattern2.matcher(str);
			while(matcher2.find()) {
				Athlete p = new Athlete();
				String name = matcher2.group(1);
				String[] n = name.split(" ");
				if(n.length == 1)
				p.setName(matcher2.group(1)); 
				else
				{
					try{
						throw new Exception("Athlete:姓名中不能含有空格");//错误输入3
					}
					catch(Exception a) {
						logging.logException(a);
						//a.printStackTrace();
					}
					System.exit(1);
				}
				//System.out.println(matcher2.group(1));
				p.setNum(Integer.valueOf(matcher2.group(2)));
				//System.out.println(Integer.valueOf(matcher2.group(2)));
				String nation = matcher2.group(3);
				String nation0 = "([A-Z][A-Z][A-Z])";
				Pattern nationpattern = Pattern.compile(nation0);
				Matcher matchernation = nationpattern.matcher(nation);
				//System.out.println(matcher2.group(3));
				if(matchernation.find())
				p.setNation(matcher2.group(3));
				else {
					try{
						throw new Exception("Athlete:国籍请输入三个大写字母");//错误输入4
					}
					catch(Exception a) {
						logging.logException(a);
						//a.printStackTrace();
					}
					System.exit(1);
				}
				p.setAge(Integer.valueOf((matcher2.group(4))));
				String best = matcher2.group(5);
				String best0 = "([0-9]{0,2})+(\\.)+([0-9][0-9])";
				Pattern bestpattern = Pattern.compile(best0);
				Matcher bestmatcher = bestpattern.matcher(best);
				//System.out.println(best);
				if(bestmatcher.find())
				p.setBest(Double.parseDouble(matcher2.group(5)));
				else {
					try{
						throw new Exception("Athlete:最好成绩输入必须含有两位小数");
					}
					catch(Exception a) {
						logging.logException(a);
						//a.printStackTrace();
					}
					
				}
				if(!obj.contains(p))
				obj.add(p);
				else{
					System.out.println("Athlete:已添加过此姓名的人物");
					System.exit(1);
				}
			}
			checkRep();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logging.logException(e);
			//e.printStackTrace();
		}
		
	}
	public int gettotal() {
		checkRep();
		return total;
	}
	public void settotal(int total) {
		this.total = total;
		checkRep();
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
	    for(Set<String> ss :g) {
	    	assert ss.size()<=total;
	    }
		checkRep();
		return g;
	}
	public List<List<String>> plangroup(){
		List<List<String>> re = new ArrayList<>();
		Map<String,Double> Best = new HashMap<>();
		//int flag = 0;
		for(Athlete a:obj) {
			Best.put(a.getName(), a.getBest());
		}
		System.out.println(total);
		List<String> sss = new ArrayList<>();
		List<String> ss = new ArrayList<>();
		Collection<Double> d = Best.values();
		Set<String> copy = new HashSet<>();
		Object[] o = d.toArray();
		   Arrays.sort(o);
		   for(int i = 1;i<=o.length;i++) {
			   Object k = o[o.length-i];
			   for(String name:Best.keySet()) {
				   if(Best.get(name).equals(k)&&!copy.contains(name)) {
					   sss.add(name);
					   copy.add(name);
					   if(sss.size() == total) {
							 if(total%2 ==0) {
								 int i1 = total/2;
								 int i2 = total/2+1;
								 while(ss.size()!=sss.size())
								 {
								 ss.add(sss.get(i1));
								 ss.add(sss.get(i2));
								 i1--;
								 i2++;}
								 
							 }
							 else {
								 //System.out.println("!");
								 int i1 = (total+1)/2;
								 ss.add(sss.get(i1-1));
								 int i11 = i1-2;
								 int i12 = i1;
								 while(ss.size()!=sss.size()&&i12<total) {
									 ss.add(sss.get(i11));
									 ss.add(sss.get(i12));
									 i11--;
									 i12++; 
								 }
							 }
							   re.add(ss);
							   sss = new ArrayList<>();
							   ss = new ArrayList<>();
							   //flag = 0;
						   }
					   
				   }
				   
			   }
		   }
		   checkRep();
		  return re;
	}
	public List<List<String>> exchange(String a,String b,List<List<String>> l) {
		int num1 = 0;
		int num2 = 0;
		for(int i = 0;i<l.size();i++) {
			for(String ss:l.get(i)) {
				if(ss.equals(a))
				{
					num1 = i;
				}
				else if(ss.equals(b)) {
					num2 = i;
				}
			}
		}
		
		l.get(num1).remove(a);
		l.get(num2).remove(b);
		l.get(num1).add(b);
		l.get(num2).add(a);
		
		checkRep();
		return l;
	}
	public Set<Athlete> getobj(){
		checkRep();
		return obj;
	}
	/*public static void main(String[] args) {
		AthleteSystem ss = new AthleteSystem();
		ss.detail();
		List<List<String>> l = ss.plangroup();
		ss.exchange("Ujehe", "Uschht", l);
	}*/
}
