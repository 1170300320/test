/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P1.graph;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//import org.junit.Test;

/**
 * Tests for ConcreteVerticesGraph.
 * 
 * This class runs the GraphInstanceTest tests against ConcreteVerticesGraph, as
 * well as tests for that particular implementation.
 * 
 * Tests against the Graph spec should be in GraphInstanceTest.
 */
public class ConcreteVerticesGraphTest extends GraphInstanceTest {
    
    /*
     * Provide a ConcreteVerticesGraph for tests in GraphInstanceTest.
     */
    @Override public Graph<String> emptyInstance() {
        return new ConcreteVerticesGraph<String>();
    }
    
    /*
     * Testing ConcreteVerticesGraph...
     */
    
    // Testing strategy for ConcreteVerticesGraph.toString()
    //   TODO
    
    // TODO tests for ConcreteVerticesGraph.toString()
    public void testAdd()
    {
    	emptyInstance().add("a");
    	emptyInstance().add("b");
    	emptyInstance().add("c");
    	assertEquals("a,b,c",emptyInstance().vertices());
    }
    public void testSet()
    {
    	emptyInstance().set("a","b", 1);
    	Map<String,Integer> re1 = new HashMap<String,Integer>();
    	re1.put("a", 1);
    	assertEquals(re1,emptyInstance().sources("b"));
        re1.remove("a", 1);
        re1.put("b", 1);
        assertEquals(re1,emptyInstance().targets("a"));
        Set<String> r = new HashSet<String>();
        r.add("a");
        r.add("b");
        assertEquals(r,emptyInstance().vertices());
        emptyInstance().remove("a");
        r.remove("a");
        assertEquals(r,emptyInstance().vertices());
    }
    /*
     * Testing Vertex...
     */
    
    // Testing strategy for Vertex
    //   TODO
    
    // TODO tests for operations of Vertex
    public void testVertex()
    {
    	Vertex<String> e = new Vertex<String>();
    	Set<String> tar = new HashSet<String>();
    	tar.add("b");
    	tar.add("c");
    	e.setSource("a");
    	e.setTarget("b");
    	e.setTarget("c");
    	e.setWeight("b",1);
    	e.setWeight("c",2);
    	assertEquals("a",e.getSource());
    	assertEquals(tar,e.getTarget());
    	assertEquals(1,e.getWeight("b"));
    	assertEquals(2,e.getWeight("c"));
    }
}
