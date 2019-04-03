/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P1.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * An implementation of Graph.
 * 
 * <p>PS2 instructions: you MUST use the provided rep.
 * @param <L>
 */
public  class ConcreteVerticesGraph<L> implements Graph<L> {
    
    private final List<Vertex<L>> vertices = new ArrayList<>();

    // Abstraction function:
    //  vertices made up of Vertex<L> listed by adding order
    // Representation invariant:
    // many constructed Vertex<L> listed together
    // Safety from rep exposure:
    //  All fields are private.Vertices are got by copies to keep unexposed.
    
    // TODO constructor
    
    // TODO checkRep
    
    @Override public boolean add(L vertex) {
    	Vertex<L> a = new Vertex<L>();
    	a.setVertex(vertex);
    	if(vertices.contains(a))
        	return false;
        else
        	{
        	vertices.add(a);
        	return true;
        	}
    }
    
    @Override public int set(L source, L target, int weight) {
    	Vertex<L> v = new Vertex<L>();
    	v.setSource(source);
    	v.setTarget(target);
    	v.setWeight(target, weight);
    	return weight;
        }
    
    
    @Override public boolean remove(L vertex) {
        for(Vertex<L> v:vertices)
        {
        	if(v.getVertex()==vertex)
        	{
        		vertices.remove(v);
        		return true;
        	}
        	
        }
        return false;
    }
    
    @Override public Set<L> vertices() {
    	Set<L> result = new HashSet<L>();
    	L s;
        for(Vertex<L> v:vertices)
        {
        	s = v.getVertex();
        	result.add(s);
        }
        return result;
    }
    
    @Override public Map<L, Integer> sources(L target) {
    	Map<L,Integer> m = new HashMap<L,Integer>();
        for(Vertex<L> i:vertices)
        {
     	   if(i.getTarget().contains(target))
     	   {
     		  L s = i.getSource();
     		  int w = i.getWeight(target);
     		  m.put(s, w);
     	   }
        }
        return m;
    }
    
    @Override public Map<L, Integer> targets(L sou) {
    	Set<L> s = new HashSet<L>();
    	Vertex<L> v0 = new Vertex<L>();
    	Map<L, Integer> m = new HashMap<>();
    	for(Vertex<L> v:vertices)
    	{
    		if(v.getSource() == sou)
    		{
    			s = v.getTarget();
    			v0 = v;
    			break;
    		}
    	}
    	for(L a:s)
    	{
    		int weight = v0.getWeight(a);
    		m.put(a, weight);
    	}
    	return m;
    }

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		Vertex<L> v = vertices.get(0);
		Set<L> s = new HashSet<L>();
	    String str;
		L v0 = v.getSource();
		 str = v0 + " ";
	  while((s = v.getTarget())!=null)
	  {
		  List<L> l = new ArrayList<L>();
		  l.addAll(s);
		  if(l.size()!=0)
		  {L sou = l.get(0);
		  str += sou + " ";}
	  }
	  return str;
	}
	
}

/**
 * TODO specification
 * Mutable.
 * This class is internal to the rep of ConcreteVerticesGraph.
 * 
 * <p>PS2 instructions: the specification and implementation of this class is
 * up to you.
 * @param <L>
 */
class Vertex<L> {
	// Abstraction function:
    //  vertices,targets and weights,tw are One-to-one combination of edges and weights
    // Representation invariant:
    // weights>=0;when weights = 0,remove the vertice
    // Safety from rep exposure:
    //  All fields are private.Vertices are got by copies to keep unexposed.
    
    // TODO constructor
    
    // TODO checkRep
    private L  source;
    private Set<L> target = new HashSet<>();   
    private Map<L,Integer> tw  = new HashMap<>();
    //
    public L getVertex() {
    	L source0 = source;
    	return source0;
    }
    public void setVertex(L vertex) {
    	source = vertex;
    }
    public void setSource(L vertex) {
    	source = vertex;
    }  
    public void setTarget(L tar) {
        target.add(tar);
    }
    public void setWeight(L tar,int weight) {
    	Set<L> key = new HashSet<>();
    	key = tw.keySet();
    	for(L s:key) {
    		if(s == tar)
    			tw.put(tar, weight);
    	}
    }
 
    public L getSource()
    {
    	L source0 = source;
    	return source0;
    }

    public Set<L> getTarget() {
    	Set<L> s = new HashSet<L>();
    	s = target;
        return s;
    }
    public int getWeight(L tar) {
    	Set<L> key = new HashSet<>();
    	key = tw.keySet();
    	for(L s:key) {
    		if(s == tar)
    			return tw.get(s);
    	}
    	return -1;
    }
    public void remove()
    {
    	for(L tar:target)
    	{
    		tw.remove(tar);
    	}
    	
    }
   public String toString(L vertex) {
        String str = vertex + " ";
        return str;
    }
    
}
