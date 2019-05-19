package circularorbit;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import centralObject.Personcenter;
import physicalObject.Athlete;
import physicalObject.Person;

public class filter {
	StringBuffer buffer = new StringBuffer();
	StringBuffer buffer1 = new StringBuffer();
	StringBuffer buffer2 = new StringBuffer();
	private final static ConcreteCircularOrbit<Personcenter<Person>,Athlete> a = ConcreteCircularOrbit.empty();
	File f = new File("D:\\eclipse\\Lab4-1170300320\\src\\all.txt");
	public String exceptionfilt() throws IOException {  
		String str = a.read(f);
	
		if(!f.exists())
			   return null;
		   try {
			   String exp ="java.lang.Exception:([^(M,T,W,F,S)]+)";
			   Pattern p = Pattern.compile(exp);
			   Matcher matcherexp = p.matcher(str);
			   while(matcherexp.find()) {
				   //System.out.println("!");
				   String s = matcherexp.group(0);
				   System.out.println(matcherexp.group(0));
				   buffer.append(s.trim());
					buffer.append("\n");
			   }
			 
			   String st = buffer.toString();
		
				try {
		            File file = new File("D:\\eclipse\\Lab4-1170300320\\src\\exception.txt");
		            FileWriter fw = new FileWriter(file);
		            fw.append(st);
		            fw.close();
		        } catch (FileNotFoundException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }
			
		   }
			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
			}
	public String classfilt() throws IOException {   
		String str = a.read(f);
		if(!f.exists())
			   return null;
		   try {
			   String exp ="Atom:([^(M,T,W,F,S)]+)";
			   String exp1 = "Athlete:([^(M,T,W,F,S)]+)";
			   String exp2 = "Social:([^(M,T,W,F,S)]+)";
			   Pattern p = Pattern.compile(exp);
			   Pattern p1 = Pattern.compile(exp1);
			   Pattern p2 = Pattern.compile(exp2);
			   Matcher matcherexp = p.matcher(str);
			   Matcher matcherexp1 = p1.matcher(str);
			   Matcher matcherexp2 = p2.matcher(str);
			   while(matcherexp.find()) {
				   //System.out.println("!");
				   String s = matcherexp.group(0);
				   System.out.println(matcherexp.group(0));
				   buffer.append(s.trim());
				   buffer.append("\n");
			   }
			   while(matcherexp1.find()) {
				   //System.out.println("!");
				   String s = matcherexp1.group(0);
				   System.out.println(matcherexp1.group(0));
				   buffer1.append(s.trim());
					buffer1.append("\n");
			   }
			   while(matcherexp2.find()) {
				   String s = matcherexp2.group(0);
				   System.out.println(matcherexp2.group(0));
				   buffer2.append(s.trim());
					buffer2.append("\n");
			   }
			   String st = buffer.toString();
		       String st1 = buffer1.toString();
		       String st2 = buffer2.toString();
				try {
		            File file = new File("D:\\eclipse\\Lab4-1170300320\\src\\atom.txt");
		            FileWriter fw = new FileWriter(file);
		            fw.append(st);
		           
		            File file1 = new File("D:\\eclipse\\Lab4-1170300320\\src\\athlete.txt");
		            FileWriter fw1 = new FileWriter(file1);
		            fw1.append(st1);
		           
		            File file2 = new File("D:\\eclipse\\Lab4-1170300320\\src\\social.txt");
		            FileWriter fw2 = new FileWriter(file2);
		            fw2.append(st2);
		            fw1.close();
		            fw.close();
		            fw2.close();
		        } catch (FileNotFoundException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }
			
		   }
			catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	}
	public String infofilt() throws IOException {  
		String str = a.read(f);
		if(!f.exists())
			   return null;
		   try {
			   String exp ="info:([^(M,T,W,F,S)]+)";
			   Pattern p = Pattern.compile(exp);
			   Matcher matcherexp = p.matcher(str);
			   while(matcherexp.find()) {
				   //System.out.println("!");
				   String s = matcherexp.group(0);
				   System.out.println(matcherexp.group(0));
				   buffer.append(s.trim());
					buffer.append("\n");
			   }
			   String st = buffer.toString();
				try {
		            File file = new File("D:\\eclipse\\Lab4-1170300320\\src\\info.txt");
		            FileWriter fw = new FileWriter(file);
		            fw.append(st);
		            fw.close();
		        } catch (FileNotFoundException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }
			
		   }
		   catch (FileNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
		   return null;}
	public String timefilt(String time0) throws IOException {   
		String str = a.read(f);
		if(!f.exists())
			   return null;
		   try {
			   String reg = time0+"\\t+([^(M,T,W,F,S)]+)";
			   Pattern p = Pattern.compile(reg);
			   //Pattern p1 = Pattern.compile(time1);
			   Matcher matcherexp = p.matcher(str);
			  // Matcher matcherexp1 = p1.matcher(str);
			   while(matcherexp.find()) {
				   String s = matcherexp.group(0);
				  // String s1 = matcherexp1.group(0);
				   
				   buffer.append(s.trim());
				   //buffer.append(s1.trim());
					buffer.append("\n");
					System.out.println(matcherexp.group(0));
					//System.out.println(matcherexp1.group(0));
			   }
			   String st = buffer.toString();
				try {
		            File file = new File("D:\\eclipse\\Lab4-1170300320\\src\\time.txt");
		            FileWriter fw = new FileWriter(file);
		            fw.append(st);
		            fw.close();
		        } catch (FileNotFoundException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }
			
		   }
		   catch (FileNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
		   return null;
			}
	public String funcfilt() throws IOException {   
		String str = a.read(f);
		if(!f.exists())
			   return null;
		   try {
			   String exp ="²Ù×÷£º([^(M,T,W,F,S)]+)";
			   Pattern p = Pattern.compile(exp);
			   Matcher matcherexp = p.matcher(str);
			   while(matcherexp.find()) {
				   //System.out.println("!");
				   String s = matcherexp.group(0);
				   System.out.println(matcherexp.group(0));
				   buffer.append(s.trim());
					buffer.append("\n");
			   }
			   String st = buffer.toString();
				try {
		            File file = new File("D:\\eclipse\\Lab4-1170300320\\src\\function.txt");
		            FileWriter fw = new FileWriter(file);
		            fw.append(st);
		            fw.close();
		        } catch (FileNotFoundException e) {
		            // TODO Auto-generated catch block
		            e.printStackTrace();
		        }
			
		   }
		   catch (FileNotFoundException e) {
	            // TODO Auto-generated catch block
	            e.printStackTrace();
	        }
		   return null;
			}
	public static void main(String[] args) {
		filter f = new filter();
		try {
			//f.exceptionfilt();
			String t = "Sat May 18 18:22:18 CST 2019";
			f.timefilt(t);
			f.classfilt();
			f.funcfilt();
			f.infofilt();
			f.exceptionfilt();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
