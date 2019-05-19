package circularorbit;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;
import java.util.logging.Logger;

public class logging {
	 private static Logger logger = Logger.getLogger("Logging");
	 
	 static String st = new String();
	 //static File f = new File("D:\\eclipse\\Lab4-1170300320\\src\\all.txt");
	static void logException(Exception e) {
		StringWriter trace = new StringWriter();
		e.printStackTrace(new PrintWriter(trace));
			logger.severe(trace.toString());
			File f  = new File("D:\\eclipse\\Lab4-1170300320\\src\\all.txt");
	        FileWriter fw;
			try {
				fw = new FileWriter(f,true);
				fw.write(new Date()+"\t"+e.toString()+"\n");
		        fw.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
	}
	public static void logFunction(String str) {
			logger.info(str);
	        File f  = new File("D:\\eclipse\\Lab4-1170300320\\src\\all.txt");
	        FileWriter fw;
			try {
				fw = new FileWriter(f,true);
				//System.out.println(str);
				fw.write(new Date()+"\t");
				fw.write(str+"\n");
		        fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	
	
	
}
