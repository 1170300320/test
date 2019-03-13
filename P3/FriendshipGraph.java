package P3;

import java.util.ArrayList;
import java.util.List;

//计算图中任意两点的最短路径
public class FriendshipGraph {
	int n = 0;
	int[][] relation = new int[100][100];
	List<String> list = new ArrayList<>();
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
		n++;
		a.num = n;
		list.add(n1);
		
		    return n;
	}

	public int addEdge(Person a, Person b) {
		relation[a.num][b.num] = 1;
		// 两人之间直接连线
		return 1;

	}

	public int getDistance(Person a, Person b) {
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (relation[i][j] != 1)
					relation[i][j] = Integer.MAX_VALUE;// 如果两点之间未直接相连先将其间距离设为无穷大
			}
		}
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= n; i++) {
				for (int j = 1; j <= n; j++) {
					if (relation[i][k] != Integer.MAX_VALUE && relation[k][j] != Integer.MAX_VALUE
							&& relation[i][k] + relation[k][j] < relation[i][j]) {
						relation[i][j] = relation[i][k] + relation[k][j];
					}

				}
			}

		}

		if (a.num == b.num)
			return 0;
		else if (relation[a.num][b.num] == Integer.MAX_VALUE)
			return -1;
		else
			return relation[a.num][b.num];// 如果两点之间未直接相连先将其间距离设为无穷大

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
		graph.addEdge(ross,kramer);
		System.out.println(graph.getDistance(rachel, ross));
		// should print 1
		System.out.println(graph.getDistance(rachel, ben));
		// should print 2
		System.out.println(graph.getDistance(rachel, rachel));
		// should print 0
		System.out.println(graph.getDistance(rachel, kramer));
		// should print -1

	}

}
