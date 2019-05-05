package circularorbit;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import centralObject.Personcenter;
import physicalObject.Person;

public class SocialNetworkCircle extends ConcreteCircularOrbit<Personcenter<Person>, Person> {
	private final static ConcreteCircularOrbit<Personcenter<Person>,Person> a = ConcreteCircularOrbit.empty();
	Person p = new Person();
	public Set<Person> friend = new HashSet<>();
	public static ConcreteEdgesGraph<Person> graph = new ConcreteEdgesGraph<>();
	public ConcreteEdgesGraph<Person> detail() {
		File f = new File("src/SocialNetworkCircle.txt");
		try {
			String str = a.read(f);
			String reg0 = "CentralUser ::= <([\\w]+),([0-9]+),([M|F])>";
			Pattern pattern0 = Pattern.compile(reg0);
			Matcher matcher0 = pattern0.matcher(str);
			if (matcher0.find()) {
				
				friend.add(p);
				graph.add(p);
				p.setName(matcher0.group(1));
				
			    p.setAge(Integer.valueOf(matcher0.group(2)));
			
			    p.setGender(matcher0.group(3));
			}
			String reg1 = "Friend ::= <([\\w]+),([0-9]+),([M|F])>";
			Pattern pattern1 = Pattern.compile(reg1);
			Matcher matcher1 = pattern1.matcher(str);
			while(matcher1.find()) {
				Person t = new Person();
				friend.add(t);
				graph.add(t);
				//System.out.println(matcher1.group(1));
				t.setName(matcher1.group(1));
				//System.out.println(Integer.valueOf(matcher1.group(2)));
			    t.setAge(Integer.valueOf(matcher1.group(2)));
			    //System.out.println(matcher1.group(3));
			    t.setGender(matcher1.group(2));
			}
			
			String reg2 = "SocialTie ::= <([^,]+),([^,]+),([^,]+)>";
			Pattern pattern2 = Pattern.compile(reg2);
			Matcher matcher2 = pattern2.matcher(str);
			while(matcher2.find()) {
               String person1 = matcher2.group(1);
               String person2 = matcher2.group(2);
               Double re = Double.parseDouble(matcher2.group(3));
               Person p1 = new Person();
               Person p2 = new Person();
               int flag = 0;
               for(Person pp:friend)
               {
            	   if(pp.getName().equals(person1))
            		   {
            		   p1 = pp;
            		   flag = 1;
            		   }
            	   
               }
               if(flag == 0)
               {
            	   p1.setName(person1);
            	   friend.add(p1);
                   graph.add(p1);
               }
               flag = 0;
               for(Person pp:friend)
               {
            	   if(pp.getName().equals(person2))
            		   {
            		   p2 = pp;
            		   flag = 1;
            		   }
               }
               if(flag == 0)
                  {
            	   p2.setName(person2);
            	   friend.add(p2);
                   graph.add(p2);
                  }
               flag = 0;
               p1.setRelation(p2, re);
               graph.set(p1, p2, 1);
           //System.out.println(p1.getName()+" "+p2.getName()+" ");
			}
			
			
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//System.out.println(friend.size());
		return graph;
	}
	public Set<Person> getFriend(){
		return friend;
	}
	
	public Person getC(){
		return p;
	}
	public ConcreteEdgesGraph<Person> getgraph(){
		for(Person per:graph.vertices()) {
			//System.out.println(per.getName());
		}
		return graph;
	}

	public int  spread(Person p) {
		SocialNetworkCircle s = new SocialNetworkCircle();
		s.detail();
		int t = 0;
		for(Person l:p.getRelation().keySet()) {
			t+=p.getRelation().keySet().size();
			p = l;
		}
		System.out.println(t);
		return t;
		
	}
public int getDistance(Person a, Person b) {
		
		Map<Person,Integer> m1 = new HashMap<>();
		Map<Person,Integer> m2 = new HashMap<>();
		
		for (Person m:graph.vertices()) {
			for (Person n:graph.vertices()) {
				if (!graph.targets(m).containsKey(n))
					{
					graph.set(m,n,Integer.MAX_VALUE);// 如果两点之间未直接相连先将其间距离设为无穷大
					
					}
				
			}
		}

		//m->k->n
		List<Person> p =new ArrayList<Person>(graph.vertices());
		for (int i = 0;i<p.size();i++) {
			Person m = p.get(i);
			for (int j = 0;j<p.size();j++) {
				Person n = p.get(j);
				for (int s = 0;s<p.size();s++) {
					Person k = p.get(s);
					m1 = graph.targets(m);					
					m2 = graph.sources(n); 
					if(m!=n&&m!=k&&n!=k&&m1.get(k)!=Integer.MAX_VALUE&& m2.get(k)!=Integer.MAX_VALUE&& (m1.get(k)+m2.get(k))<m1.get(n))
					{
						graph.set(m , n , (m1.get(k)+m2.get(k)));
						//System.out.println(m.getName()+" "+k.getName()+" "+n.getName());
					}

				}
			}

		}

		if (a == b)
			return 0;
		else if (graph.targets(a).get(b) == Integer.MAX_VALUE)
			return -1;
		else
			return graph.targets(a).get(b);

	}
	public static void main(String[] args)
	{
		SocialNetworkCircle s = new SocialNetworkCircle();
		s.detail();
		Set<Person> ss = s.getFriend();
		//ConcreteEdgesGraph<Person> graph = s.getgraph();
		Person p = s.getC();
		/*for(Person per:ss) {
			System.out.println(p.getName()+" "+per.getName()+" "+s.getDistance(p,per));
		}*/
		for(Person pp:ss) {
			for(Person ppp:ss) {
				s.getDistance(pp, ppp);
			}
		}
		//Person p = s.getC();
		//s.spread(p);
	}
	
}
