package P2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import P1.graph.Graph;

//计算图中任意两点的最短路径
public class FriendshipGraph {
	
	List<String> list = new ArrayList<>();
	
	private final Graph<Person> graph = Graph.empty();
	public int addVertex(Person a) {
		
		
		String n1 = a.name;
		for(String n2:list)
			{
			if(n1.equals(n2))
			{
				System.out.println("名字输入重复");
				return 0;
				
			}
		
			}
		
		list.add(n1);
		graph.add(a);
		graph.set(a , a , 0);
		    return 1;
	}

	public int addEdge(Person a, Person b) {
		
		graph.set(a , b, 1);		
		
		return 1;

	}

	public int getDistance(Person a, Person b) {
		
		Map<Person,Integer> m1 = new HashMap<>();
		Map<Person,Integer> m2 = new HashMap<>();
		
		for (Person m:graph.vertices()) {
			for (Person n:graph.vertices()) {
				if (!graph.targets(m).containsKey(n))
					graph.set(m,n,Integer.MAX_VALUE);// 如果两点之间未直接相连先将其间距离设为无穷大
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

	public  static void main(String[] args) {
		FriendshipGraph graph = new FriendshipGraph();
		Person rachel = new Person("Rachel");
		Person ross = new Person("Ross");
		Person ben = new Person("Ben");
		Person kramer = new Person("Kramer");
		int a = graph.addVertex(rachel);
		if(a == 0)
			System.exit(0);
		a =graph.addVertex(ross);
		if(a == 0)
			System.exit(0);
		a =graph.addVertex(ben);
		if(a == 0)
			System.exit(0);
		a =graph.addVertex(kramer);
		if(a == 0)
			System.exit(0);
		graph.addEdge(rachel, ross);
		graph.addEdge(ross, rachel);
		graph.addEdge(ross, ben);
		graph.addEdge(ben, ross);
		graph.addEdge(ben, rachel);
		graph.addEdge(kramer, rachel);
		graph.addEdge(ben, kramer);
		System.out.println(graph.addVertex(rachel));
		System.out.println(graph.getDistance(rachel, ross));
		// should print 1
		//System.out.println(graph.getDistance(ross, rachel));
		System.out.println(graph.getDistance(rachel, ben));
		// should print 2
		System.out.println(graph.getDistance(rachel, rachel));
		// should print 0
		System.out.println(graph.getDistance(rachel, kramer));
		// should print -1

	}

}
