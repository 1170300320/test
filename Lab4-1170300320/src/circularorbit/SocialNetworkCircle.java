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
	public  ConcreteEdgesGraph<Person> graph = new ConcreteEdgesGraph<>();
	public void checkRep() {
	
	}
	public ConcreteEdgesGraph<Person> detail() {
		
		File f = new File("src/SocialNetworkCircle.txt");
		try {
			
			String str = a.read(f);
			String reg0 = "CentralUser ::= <([\\w]+),([0-9]+),([M|F])>";
			Pattern pattern0 = Pattern.compile(reg0);
			Matcher matcher0 = pattern0.matcher(str);
			if (matcher0.find()) {
				String name = matcher0.group(1);
				String[] n = name.split(" ");
				if(n.length == 1)
				p.setName(matcher0.group(1)); 
				else
				{
					try{
	            		  throw new Exception("姓名格式中不能有空格");
	            	   }   
	            	   catch(Exception a) {
	            		   logging.logException(a);
	            		   //a.printStackTrace();
	            	   }
				}
				friend.add(p);
				for(Person p:friend) {
					System.out.println(p.getName());
				}
				graph.add(p);
				p.setName(matcher0.group(1));
			    p.setAge(Integer.valueOf(matcher0.group(2)));
			    p.setGender(matcher0.group(3));
			    if(matcher0.group(3).equals("F"))
			    {
			    	logging.logFunction("Social:中心人物的名字为"+name+"年龄为"+Integer.valueOf(matcher0.group(2))+"性别为女");
			    }
			    else {
			    	logging.logFunction("Social:中心人物的名字为"+name+"年龄为"+Integer.valueOf(matcher0.group(2))+"性别为男");
			    }
			}
			String reg1 = "Friend ::= <([\\w]+),([0-9]+),([M|F])>";
			String reg10 = "Friend ::= <([\\w]+),([0-9]+)+(\\.)+([0-9]+),([M|F])>";
			String reg11 = "Friend ::= <([\\w]+),([0-9]+),([0-9]+)>";
			Pattern pattern1 = Pattern.compile(reg1);
			Matcher matcher1 = pattern1.matcher(str);
			Pattern pattern10 = Pattern.compile(reg10);
			Matcher matcher10 = pattern10.matcher(str);
			Pattern pattern11 = Pattern.compile(reg11);
			Matcher matcher11 = pattern11.matcher(str);
			if(matcher10.find()) {
				try {
					throw new Exception("Social:请输入正整数年龄");
					
				}
				catch(Exception a) {
					logging.logException(a);
					//a.printStackTrace();
				}
			}
			if(matcher11.find()) {
				try {
					throw new Exception("Social:请输入规范的性别表示：男M；女F");
					
				}
				catch(Exception a) {
					logging.logException(a);
					//a.printStackTrace();
				}
			}
			while(matcher1.find()) {
				Person t = new Person();
				friend.add(t);
				graph.add(t);
				//System.out.println(matcher1.group(1));
				String namef = matcher1.group(1);
				String[] nameff = namef.split(" ");
				if(nameff.length==1)
				t.setName(matcher1.group(1));
				else {
					try{
	            		  throw new Exception("Social:姓名格式中不能有空格");
	            	   }   
	            	   catch(Exception a) {
	            		   logging.logException(a);
	            		   //a.printStackTrace();
	            	   }
				}
				//System.out.println(Integer.valueOf(matcher1.group(2)));
				String agef = matcher1.group(2);
				if(Integer.parseInt(agef)>0&&Integer.parseInt(agef)<200)
			    {
					t.setAge(Integer.valueOf(matcher1.group(2)));
			    }
				else {
					try{
						throw new Exception("Social:请输入正常范围内的年龄0~200");
					}
					catch(Exception a) {
						logging.logException(a);
						//a.printStackTrace();
					}
					
				}
			    t.setGender(matcher1.group(3));
			    if(matcher1.group(3).equals("F"))
			    {
			    	String str1 = "Social:轨道人物的名字为"+namef+"年龄为"+Integer.valueOf(matcher1.group(2))+"性别为女";
			    	logging.logFunction(str1);
			    }
			    else {
			    	logging.logFunction("Social:轨道人物的名字为"+namef+"年龄为"+Integer.valueOf(matcher1.group(2))+"性别为男");
			    }
			}
			
			String reg2 = "SocialTie ::= <([^,]+),([^,]+),([^,]+)>";
			Pattern pattern2 = Pattern.compile(reg2);
			Matcher matcher2 = pattern2.matcher(str);
			
			while(matcher2.find()) {
               String person1 = matcher2.group(1);
               String person2 = matcher2.group(2);
               String[] person11 = person1.split(" ");
               String[] person22 = person2.split(" ");
               if(person11.length!=1) {
            	   try{
             		  throw new Exception("Social:姓名格式中不能有空格");
             	   }   //错误输入5
             	   catch(Exception a) {
             		  logging.logException(a);
                    //a.printStackTrace();
             	   }
               }
               if(person22.length!=1) {
            	   try{
            		  throw new Exception("Social:姓名格式中不能有空格");
            	   }   //错误输入5
            	   catch(Exception a) {
            		   logging.logException(a);
            		  //a.printStackTrace();
            	   }
               }
               if(person1.equals(person2)) {
            	   try {
            		   throw new Exception("Social:关系不能指向自己");
            	   }
            	   catch(Exception a) {
            		   logging.logException(a);
            		  // a.printStackTrace();
            	   }
               }
               String tie = matcher2.group(3);
               String tie0 = "([0|1])+(//.)?+([0-9]){0,3}";
               Pattern tiepattern = Pattern.compile(tie0);
               Matcher tiematcher = tiepattern.matcher(tie);
               Double re = 0.0;
               if(tiematcher.find())
               {
            	   re = Double.parseDouble(matcher2.group(3));
               }
               else {
            	   try{
            		   throw new Exception("Social:亲密度最多三位小数");
            	   }
            	   catch(Exception a) {
            		   logging.logException(a);
            		   //a.printStackTrace();
            	   }
            	  
               }
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
            	   System.out.println(person1+"!");
            	   try{
            		   throw new Exception("Social:设置关系之前并没有创建此人物，警告");//错误输入3
            	   }
            	   catch(Exception a){
            		   logging.logException(a);
            		   //a.printStackTrace();
            	   }
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
            	   System.out.println(person2);
            	   try{
            		   throw new Exception("Social:设置关系之前并没有创建此人物，警告");//错误输入3
            	   }
            	   catch(Exception a){
            		   logging.logException(a);
            		  // a.printStackTrace();
            	   }
            	   p2.setName(person2);
            	   friend.add(p2);
            	   graph.add(p2);
                  }
               flag = 0;
               if(p1.getRelation().containsKey(p2)&&p1.getRelation().get(p2)!=re){
            	   
            		   try {
            			   throw new Exception("Social:输入信息前后矛盾");
            		   }
            		   catch(Exception a) {
            			   logging.logException(a);
            			   //a.printStackTrace();
            		   }
            	   }
               
               else
               {
            	   p1.setRelation(p2, re);
            	   graph.set(p1, p2, 1); 
               }
               logging.logFunction("Social:"+p1.getName()+"与"+p2.getName()+"有亲密度为"+re+"的关系");
			}
			
			
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			logging.logException(e);
			//e.printStackTrace();
		}
		checkRep();
		graph.checkRep();
		return graph;
	}
	public Set<Person> getFriend(){
		checkRep();
		graph.checkRep();
		return friend;
	}
	public void setFriend(Set<Person> friend) {
		this.friend = friend;
		checkRep();
		graph.checkRep();
	}
	public Person getC(){
		checkRep();
		graph.checkRep();
		return p;
	}
	public ConcreteEdgesGraph<Person> getgraph(){
		checkRep();
		graph.checkRep();
		return graph;
	}
    public void setgraph(ConcreteEdgesGraph<Person> graph) {
    	this.graph = graph;
    	checkRep();
		graph.checkRep();
    }
	public double  spread(Person p) {
		SocialNetworkCircle s = new SocialNetworkCircle();
		s.detail();
		Set<Person> pp = new HashSet<>();
		double t = 0;
		if(!p.getRelation().keySet().isEmpty())
		{for(Person l:p.getRelation().keySet()) {
			t+=p.getRelation().get(l);
			if(!l.getRelation().keySet().isEmpty()) {
				{
					pp.add(l);
					for(Person n:pp) {
						spread(n);
					}
					
				}
			}
		}}
		//System.out.println(t);
		checkRep();
		graph.checkRep();
		return t;
		
	}
public int getDistance(Person a, Person b) {
		
		Map<Person,Integer> m1 = new HashMap<>();
		Map<Person,Integer> m2 = new HashMap<>();
		for (Person m:graph.vertices()) {
			for (Person n:graph.vertices()) {
				if (!graph.targets(m).containsKey(n)&&friend.contains(n))
					{
					graph.set(m,n,Integer.MAX_VALUE);// 如果两点之间未直接相连先将其间距离设为无穷大
				
					}
				
			}
		}
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
			{
			checkRep();
			graph.checkRep();
			return 0;
			}
		else if (graph.targets(a).get(b) == Integer.MAX_VALUE)
			{
			checkRep();
			graph.checkRep();
			return -1;
			}
		else
			{
			checkRep();
			graph.checkRep();
			return graph.targets(a).get(b);
			}

	}
	/*public static void main(String[] args)
	{
		SocialNetworkCircle s = new SocialNetworkCircle();
		s.detail();
		Set<Person> ss = s.getFriend();
		
		for(Person pp:ss) {
			for(Person ppp:ss) {
				s.getDistance(pp, ppp);
			}
		}
		Person p = s.getC();
		System.out.println(s.spread(p));
	}*/
	
}
