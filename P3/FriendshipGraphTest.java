package P3;

import static org.junit.Assert.*;

import org.junit.Test;

public class FriendshipGraphTest {

	@Test
	
	public void addVertextest()
	{
		FriendshipGraph graph = new FriendshipGraph();
		Person rachel = new Person("Rachel");
		Person ross = new Person("Ross");
		Person ben = new Person("Ben");
		Person kramer = new Person("Kramer");
		assertEquals(1,graph.addVertex(rachel));
		assertEquals(2,graph.addVertex(ross));
		assertEquals(3,graph.addVertex(ben));
		assertEquals(4,graph.addVertex(kramer));
		assertEquals(0,graph.addVertex(rachel));
	}
	public void addEdgetest()
	{
		FriendshipGraph graph = new FriendshipGraph();
		Person rachel = new Person("Rachel");
		Person ross = new Person("Ross");
		Person ben = new Person("Ben");
		Person kramer = new Person("Kramer");
		graph.addVertex(rachel);
		graph.addVertex(ross);
		graph.addVertex(ben);
		graph.addVertex(kramer);
		graph.addEdge(rachel, ross);
		graph.addEdge(ross, rachel);
		graph.addEdge(ross, ben);
		graph.addEdge(ben, ross);
		graph.addEdge(ben, rachel);
		graph.addEdge(kramer, rachel);
		graph.addEdge(ben, kramer);
		assertEquals(1,graph.addEdge(rachel, ross));
		assertEquals(1,graph.addEdge(ross, rachel));
		assertEquals(1,graph.addEdge(ross, ben));
		assertEquals(1,graph.addEdge(ben, ross));
		assertEquals(1,graph.addEdge(kramer, rachel));
		assertEquals(1,graph.addEdge(ben, kramer));
		assertEquals(1,graph.addEdge(ben, rachel));
		
	}
	public void getDistancetest() {
		FriendshipGraph graph = new FriendshipGraph();
		Person rachel = new Person("Rachel");
		Person ross = new Person("Ross");
		Person ben = new Person("Ben");
		Person kramer = new Person("Kramer");
		graph.addVertex(rachel);
		graph.addVertex(ross);
		graph.addVertex(ben);
		graph.addVertex(kramer);
		graph.addEdge(rachel, ross);
		graph.addEdge(ross, rachel);
		graph.addEdge(ross, ben);
		graph.addEdge(ben, ross);
		graph.addEdge(ben, rachel);
		graph.addEdge(kramer, rachel);
		graph.addEdge(ben, kramer);
		assertEquals(1,graph.getDistance(rachel, ross));
		assertEquals(1,graph.getDistance(ross, rachel));
		assertEquals(2,graph.getDistance(rachel, ben));
		assertEquals(0,graph.getDistance(rachel, rachel));
		assertEquals(3,graph.getDistance(rachel, kramer));
	}

}
