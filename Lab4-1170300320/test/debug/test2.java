package debug;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class test2 {

	@Test
	public void test() {
		
	    	String[] source = {"/*","Test program ", "int main()", "{ ", "   variable declaration ", "int a, b, c;","This is a test", "   multiline  ", "   comment for ", "   testing ", "a = b + c;",  "*/","}"};
	    	String[] source1 = {"//","dsgsdz","frdes","\n","a"};
	    	RemoveComments remove = new RemoveComments();
			List<String> str = remove.removeComments(source);
			//System.out.println("!");
			String s = "}";
			String a = "a";
			List<String> ss  = new ArrayList<>();
			ss.add(s);
			//ss.add("\n");
			assertEquals(ss,str);
			List<String> str1 = remove.removeComments(source1);
			List<String> ss1 = new ArrayList<>();
			ss1.add("\n");
			ss1.add(a);
			assertEquals(ss1,str1);
	    }
	

}
