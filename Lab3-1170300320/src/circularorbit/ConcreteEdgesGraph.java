package circularorbit;


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
public class ConcreteEdgesGraph<L> implements Graph<L> {
    
    private final Set<L> vertices = new HashSet<>();
    private final List<Edge<L>> edges = new ArrayList<>();
    
    // Abstraction function:
    // non-repeating L in vertices
    // a coherent Edge<L> composed of L in edges
    // Representation invariant:
    // non-repeating strings in vertices
    //a coherent edge composed of dots in edges
    // Safety from rep exposure:
    // All fields are private,make get functions to return copies make things keep private
    
    // TODO constructor
    
    // TODO checkRep
    public void checkRep() {    	
    	assert vertices.size()>=edges.size();  
    }
    @Override public boolean add(L vertex) {
        checkRep();
    	if(vertices.contains(vertex))
        	return false;
        else
        	{vertices.add(vertex);
        	return true;}
    }
    
    @Override public int set(L source, L target, int weight) {
    	checkRep();
    	Edge<L> cur = new Edge<L>();
    	cur.setSource(source);
    	cur.setTarget(target);
    	cur.setWeight(weight);
    	edges.add(cur);
        for(Edge<L> i:edges)
        {
        	if(cur.getSource() == source&&cur.getTarget() == target)
        	{
        		int w = i.getWeight();
                if(w == 0)
                {
                i.setSource(null);
                i.setTarget(null);
                return -1;
                }
                else
                {
                i.setWeight(weight);
                return weight;
                }
                 
             }
         	}
        return 0;
        }   
    @Override public boolean remove(L vertex) {
    	checkRep();
    	int k = 0;
    	for(Edge<L> i :edges)
        {
        	if(i.getSource() == vertex||i.getTarget() == vertex)
        	{
        		i.setSource(null);
        		i.setTarget(null);
        		i.setWeight(0);
        		k = 1;
        	}
        	
        }
    	if(k == 0)
        return false;
    	else 
    	return true;
    }
    
    @Override public Set<L> vertices() {
    	checkRep();
    	return vertices;
    }
    
    @Override public Map<L, Integer> sources(L target) {
    	checkRep();
    	Map<L,Integer> m = new HashMap<L,Integer>();
       for(Edge<L> i :edges)
       {
    	   if(i.getTarget() == target)
    	   {
    		  L s = i.getSource();
    		  int w = i.getWeight();
    		  m.put(s, w);
    	   }
       }
       return m;
    }
    
    @Override public Map<L, Integer> targets(L source) {
    	checkRep();
    	Map<L,Integer> m = new HashMap<L,Integer>();
    	
        for(Edge<L> a :edges)
        {
     	   if(a.getSource() == source)
     	   {
     		  L s = a.getTarget();
     		  int w = a.getWeight();
     		  m.put(s, w);
     	   }
        }
        return m;
    }	
   
    @Override public String toString() {
    	checkRep();
    	String str = new String();
    	Edge<L> k  = edges.get(0);
    	str = k.getSource().toString();
    	while(k.getTarget()!=null)
    	{    		
    		for(Edge<L> a:edges)
    		{
    			if(a.getSource()==k)
    				k = a;
    			break;
    		}
    		str += k.toString(k.getSource() , k.getTarget());
    	}
    	return str;
    }

}

/**
 * TODO specification
 * Immutable.
 * This class is internal to the rep of ConcreteEdgesGraph.
 * 
 * <p>PS2 instructions: the specification and implementation of this class is
 * up to you.
 */
class Edge<L> {

    // TODO fields
    private L source;
    private L target;
    private int weight;

    // Abstraction function:
    // vertices are valid strings,edges one-to-one vertice,the two vertices can't be the same,weights>=0
    // Representation invariant:
    // weights>=0;when weights = 0,remove the vertice
    // Safety from rep exposure:
    //  All fields are private.Vertices are got by copies to keep unexposed.
    public L getSource() {
    	checkRep();
    	L source0 = source;
        return source0;
    }

    public L getTarget() {
    	checkRep();
    	L target0 = target;
    	return target0;
    }

    public int getWeight() {
    	checkRep();
    	int w = weight;
        return w;
    }

    public void setSource(L sou) {
    	checkRep();
    	source = sou;
    }

    public void setTarget(L tar) {
    	checkRep();
    	target = tar;
    }

    public void setWeight(int w) {
    	checkRep();
    	weight = w;
    }

    public void setEdge(L s, L t, int w) {
    	checkRep();
        this.source = s;
        this.target = t;
        this.weight = w;
    }

    public String toString(L source, L target) {
    	checkRep();
        String str = target + " ";
        return str;
    }
    public void checkRep() {
    	
    	assert weight>=0;
    }
   
}

