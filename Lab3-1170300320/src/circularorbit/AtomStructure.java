package circularorbit;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import centralObject.Atomcenter;
import physicalObject.Atom;
import track.Track;

public class AtomStructure extends ConcreteCircularOrbit<Atomcenter<Atom>, Atom>{
	public static ConcreteCircularOrbit<Atomcenter<Atom>, Atom> a = ConcreteCircularOrbit.empty();
	public   Map<Integer,Integer> eachnum = new HashMap<>();
    int num;
	private  String name;
	private List<Track<Atom>> tracks = new ArrayList<>();
	public  String getName() {
		return name;
	}
	public  void setName(String name) {
		this.name = name;
	}
	public  void seteachnum(Map<Integer,Integer> eachnum)
	{
		a.setEach(eachnum);
		this.eachnum = eachnum;
		
	}
    public  Map<Integer,Integer> geteachnum()
    {
    	return eachnum;
    }

	public  void settotal(int t) {
		num = t;
	}
	public  int gettotal() {
		int t = num;
		return t;
	}
	public List<Track<Atom>> gettracks(){
		return tracks;
	}
	public void detail() {
		File f = new File("src/AtomicStructure_Medium.txt");
		String inf = null;
		try {
			String str = a.read(f);
			//System.out.println(str);
			String reg0 = "ElementName ::=\\s+([A-Z])([A-Za-z0-9])?";
			Pattern pattern0 = Pattern.compile(reg0);
			Matcher matcher0 = pattern0.matcher(str);
			if (matcher0.find()) {
				//System.out.println(matcher0.group(1) + matcher0.group(2));
			}
			String reg1 = "NumberOfTracks ::=\\s+([0-9])";
			Pattern pattern1 = Pattern.compile(reg1);
			Matcher matcher1 = pattern1.matcher(str);
			if (matcher1.find()) {
				num = Integer.valueOf(matcher1.group(1));
				//System.out.println(matcher1.group(1));
				settotal(num);
				//System.out.println(gettotal());
			}
			String reg2 = "NumberOfElectron ::=\\s+(((\\d)/(\\d)+;)+((\\d)/(\\d)+))";
			Pattern pattern2 = Pattern.compile(reg2);
			Matcher matcher2 = pattern2.matcher(str);
			if (matcher2.find()) {
				inf = matcher2.group(1);
				String[] count = inf.split(";");
				for (String a : count) {
					//System.out.println(a);
					String[] single = a.split("/");
					int tn = Integer.valueOf(single[0]);
					//System.out.println(tn);
					int on = Integer.valueOf(single[1]);
					//System.out.println(on);
					eachnum.put(tn,on);
					
					}
				
			}
			seteachnum(eachnum);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public static void main(String[] args) {		
		AtomStructure ss = new AtomStructure();
		ss.detail();
		
	}
	
}
