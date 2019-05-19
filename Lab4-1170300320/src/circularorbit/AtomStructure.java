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
    public int num;
	public  String name;
	private List<Track<Atom>> tracks = new ArrayList<>();
	public  String getName() {
		checkRep();
		return name;
	}
	public  void setName(String name) {
		checkRep();
		this.name = name;
	}
	public  void seteachnum(Map<Integer,Integer> eachnum)
	{
		
		a.setEach(eachnum);
		this.eachnum = eachnum;
		checkRep();
		
	}
    public  Map<Integer,Integer> geteachnum()
    {
    	checkRep();
    	return eachnum;
    }

	public  void settotal(int t) {
		num = t;
		checkRep();
	}
	public  int gettotal() {
		int t = num;
		checkRep();
		return t;
	}
	public List<Track<Atom>> gettracks(){
		checkRep();
		return tracks;
	}
	public void detail() {
	
		File f = new File("src/AtomicStructure_Medium.txt");
		String inf = null;
		try {
			String str = a.read(f);
			//System.out.println(str);
			String reg0 = "ElementName ::=\\s+([A-Z])([A-Za-z0-9])?";
			String reg00 = "ElementName ::=\\s+([a-z])([A-Za-z0-9])?";
			Pattern pattern0 = Pattern.compile(reg0);
			Pattern pattern00 = Pattern.compile(reg00);
			Matcher matcher0 = pattern0.matcher(str);
			Matcher matcher00 = pattern00.matcher(str);
			if(matcher00.find()) {
				try{
					throw new Exception("Atom:输入名称的首字母必须大写");
				}
				catch(Exception a) {
					logging.logException(a);
					//a.printStackTrace();
				}
				System.exit(1);
			}
			if (matcher0.find()) {
				//System.out.println(matcher0.group(1) + matcher0.group(2));
				logging.logFunction("Atom:info:轨道的名字为"+matcher0.group(1) + matcher0.group(2));
				name = matcher0.group(1) + matcher0.group(2);
			}
			String reg1 = "NumberOfTracks ::=\\s+([0-9])";
			String reg10 = "NumberOfTracks ::=\\s+([A-Za-z])";
			String reg11 = "NumberOfTracks ::=\\s+([0-9])+(\\.)+([0-9]+)";
			Pattern pattern1 = Pattern.compile(reg1);
			Pattern pattern10 = Pattern.compile(reg10);
			Pattern pattern11 = Pattern.compile(reg11);
			Matcher matcher1 = pattern1.matcher(str);
			Matcher matcher10 = pattern10.matcher(str);
			Matcher matcher11 = pattern11.matcher(str);
			if (matcher1.find()) {
				num = Integer.valueOf(matcher1.group(1));
				//System.out.println(matcher1.group(1));
				settotal(num);
				logging.logFunction("Atom:info:共"+num+"条轨道");
				//System.out.println(gettotal());
			}
			if(matcher10.find()) {
				try{
					throw new Exception("Atom:请输入数字而不是字母");
				}
				catch(Exception a) {
					logging.logException(a);
					//a.printStackTrace();
				}
				System.exit(1);
			}
			if(matcher11.find()) {
				try{
					throw new Exception("Atom:请输入正整数的轨道数量");
				}
				catch(Exception a) {
					logging.logException(a);
					//a.printStackTrace();
				}
				System.exit(1);
			}
			String reg2 = "NumberOfElectron ::=\\s+(((\\d)/(\\d)+;)+((\\d)/(\\d)+))";
			String reg20 = "NumberOfElectron ::=\\s+([A-Za-z]+)";
			String reg21 = "NumberOfElectron ::=\\s+(((\\d)+(\\.)+(\\d)+;)+((\\d)+(\\.)+(\\d)+))";
			Pattern pattern2 = Pattern.compile(reg2);
			Pattern pattern20 = Pattern.compile(reg20);
			Pattern pattern21 = Pattern.compile(reg21);
			Matcher matcher2 = pattern2.matcher(str);
			Matcher matcher20 = pattern20.matcher(str);
			Matcher matcher21 = pattern21.matcher(str);
			if(matcher20.find()) {
				try{
					throw new Exception("Atom:请输入轨道编号/轨道中电子个数格式的信息");
				}
				catch(Exception a) {
					logging.logException(a);
					//a.printStackTrace();
				}
				System.exit(1);
			}
			if(matcher21.find()) {
				try{
					throw new Exception("Atom:请用/分隔");
				}
				catch(Exception a) {
					logging.logException(a);
					//a.printStackTrace();
				}
				System.exit(1);
			}
			if (matcher2.find()) {
				inf = matcher2.group(1);
				String[] count = inf.split(";");
				if(count.length!=num) {
					try{
						throw new Exception("Atom:输入具体信息数量与轨道总数不符");
					}
					catch(Exception a) {
						logging.logException(a);
						//a.printStackTrace();
					}
					System.exit(1);
				}
				for (String a : count) {
					//System.out.println(a);
					String[] single = a.split("/");
					int tn = Integer.valueOf(single[0]);
					//System.out.println(tn);
					int on = Integer.valueOf(single[1]);
					//System.out.println(on);
					eachnum.put(tn,on);
					logging.logFunction("Atom:info:第"+tn+"条轨道有"+on+"个电子");
					}
				
			}
			seteachnum(eachnum);
			checkRep();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			logging.logException(e);
			//e.printStackTrace();
		}
		
	}
	public void checkRep(){
		assert num>=0;
	}
	/*public static void main(String[] args) {		
		AtomStructure ss = new AtomStructure();
		ss.detail();
		
		
	}*/
	
}
