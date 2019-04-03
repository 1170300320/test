/* Copyright (c) 2015-2016 MIT 6.005 course staff, all rights reserved.
 * Redistribution of original or derived work requires permission of course staff.
 */
package P1.poet;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import P1.graph.Graph;

/**
 * A graph-based poetry generator.
 * 
 * <p>GraphPoet is initialized with a corpus of text, which it uses to derive a
 * word affinity graph.
 * Vertices in the graph are words. Words are defined as non-empty
 * case-insensitive strings of non-space non-newline characters. They are
 * delimited in the corpus by spaces, newlines, or the ends of the file.
 * Edges in the graph count adjacencies: the number of times "w1" is followed by
 * "w2" in the corpus is the weight of the edge from w1 to w2.
 * 
 * <p>For example, given this corpus:
 * <pre>    Hello, HELLO, hello, goodbye!    </pre>
 * <p>the graph would contain two edges:
 * <ul><li> ("hello,") -> ("hello,")   with weight 2
 *     <li> ("hello,") -> ("goodbye!") with weight 1 </ul>
 * <p>where the vertices represent case-insensitive {@code "hello,"} and
 * {@code "goodbye!"}.
 * 
 * <p>Given an input string, GraphPoet generates a poem by attempting to
 * insert a bridge word between every adjacent pair of words in the input.
 * The bridge word between input words "w1" and "w2" will be some "b" such that
 * w1 -> b -> w2 is a two-edge-long path with maximum-weight weight among all
 * the two-edge-long paths from w1 to w2 in the affinity graph.
 * If there are no such paths, no bridge word is inserted.
 * In the output poem, input words retain their original case, while bridge
 * words are lower case. The whitespace between every word in the poem is a
 * single space.
 * 
 * <p>For example, given this corpus:
 * <pre>    This is a test of the Mugar Omni Theater sound system.    </pre>
 * <p>on this input:
 * <pre>    Test the system.    </pre>
 * <p>the output poem would be:
 * <pre>    Test of the system.    </pre>
 * 
 * <p>PS2 instructions: this is a required ADT class, and you MUST NOT weaken
 * the required specifications. However, you MAY strengthen the specifications
 * and you MAY add additional methods.
 * You MUST use Graph in your rep, but otherwise the implementation of this
 * class is up to you.
 */
public class GraphPoet {
    
    private final Graph<String> graph = Graph.empty();
    private final Graph<String> graph0 = Graph.empty();
    public static String[] a;  
    // Abstraction function:
    // Graph made up of vertices edges and weights
    //weights>=0,edges are composed of vertices
    // Representation invariant:
    // no repeated vertices no repeated edges,but the turned is excepted
    // Safety from rep exposure:
    //  graph0 are the system in sentence while graph are sentences in the Corpus,they are private
    //string[] a is only used temporarily so it's public
    
    /**
     * Create a new poet with the graph from corpus (as described above).
     * 
     * @param corpus text file from which to derive the poet's affinity graph
     * @throws IOException if the corpus file cannot be found or read
     */
    public GraphPoet(File corpus) throws IOException {
    	String cor = corpus.getPath();
    	InputStream is = new FileInputStream(cor);
    	String line;
    	BufferedReader reader = new BufferedReader(new InputStreamReader(is));
    	line = reader.readLine();
    	StringBuffer buffer = new StringBuffer();
    	while(line!=null)
    	{
    		buffer.append(line);
    		buffer.append("\n");
    		line = reader.readLine();
    	}
    	reader.close();
    	is.close();
    	String xml = buffer.toString();
    	a = xml.split(" ");
    	 for(int i = 0;i<a.length;i++)
         {
      	   graph.add(a[i]);
      	   if((i+1)<a.length)
      	   {
      		   graph.set(a[i], a[i+1] , 1);
      	   }
      	   
         }
    	 }
    
    
    // TODO checkRep
    
    /**
     * Generate a poem.
     * 
     * @param input string from which to create the poem
     * @return poem (as described above)
     */
    //input0 输入分开数组；a语料库分开数组
    //graph0输入成图，graph语料成图
    public String poem(String input) {       
       String[] input0 = input.split(" ");    
       String p = new String();  
       String c0n = new String();
       for(int i = 0;i<input0.length;i++)
       {
    	   graph0.add(input0[i]);
    	   if((i+1)<input0.length)
    	   {
    		   graph0.set(input0[i], input0[i+1] , 1);
    	   }
    	  
       }
       
       for(int j = 0;j<input0.length-1;j++)//遍历看语料中是否有输入中的字符串
	   {   		  
    	   Map<String,Integer> m = new HashMap<>();
    	   int flag = 0;
    	   String c0 = input0[j];
		   String c01 = input0[j+1];
		   String c0l = c0.toLowerCase();
		   String c01l = c01.toLowerCase();
		   for(int i = 0;i<a.length-2;i++)//遍历语料库中的字符串
	       {    	  
	    	   
			   String c = a[i];//语料前一个词
	    	   String c1 = a[i+2];//语料后一个词
	    	   String cl = c.toLowerCase();
	    	   String c1l = c1.toLowerCase();
    		   if(c0l.equals(cl)&&c01l.equals(c1l))
    		   {
    			   flag += 1;
    			   graph0.add(a[i+1]);
    			   graph0.set(c0 , a[i+1] , flag);
    			   m.put(a[i+1] , flag);    			     			   			   
    		   }    
    		   
    	   }
		   if(flag!=0)
		   {
			   Collection<Integer> v = m.values();
			   Object[] obj = v.toArray();
    		   Arrays.sort(obj);
    		   Object k = obj[obj.length-1];
    		   for(String str:m.keySet())
    		   {   			
				if(m.get(str).equals(k))
    				c0n = c0 + " " + str+" ";
    		   }   		    
    		   p += c0n;
		   }
		   else 
		   {
		   p += c0 +" ";
		   }    	   
       }
       p += input0[input0.length-1];
       return p;
    }    
   
   
}
