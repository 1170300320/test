package circularorbit;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import track.Track;
//抽象产品类
public class ConcreteCircularOrbit<L,E> implements CircularOrbit<L,E> {
	private L center;
	public List<Track<E>> tracks = new ArrayList<>();
    public Set<E> co = new HashSet<>();//中心点及其信息
    public Set<Map<E,E>> oo = new HashSet<>();//轨道上点及其信息
    public List<Set<E>> objects = new ArrayList<>();
    private Map<E,Double> det = new HashMap<>();//非
    private Map<Integer,Integer> each = new HashMap<>();
    @Override
	public  String read(File f) throws IOException{		
	   StringBuffer buffer = new StringBuffer();
	   String path = f.getPath();
	   if(!f.exists())
		   return null;
	   try {
		FileReader fr = new FileReader(path);
		BufferedReader bf = new BufferedReader(fr);
		String s = null;		   
			while((s = bf.readLine())!=null)
			   {
				   buffer.append(s.trim());
			   }
			String str = buffer.toString();
			bf.close();
	        return str;	   
	}
	catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return null;
	}
	@Override
	public boolean addtrack(Track<E> track) {
		tracks.add(track);
		return true;
	}

	@Override
	public boolean removetrack(int num) {
		for(Track<E> tra:tracks)
		{
			if(tra.getNum() == num)
				{
				tracks.remove(tra);
				return true;
				}			
		}
		return false;
	}

	@Override
	public void addcenter(L object) {
	   this.center = object;
	}

	@Override
	public boolean addtotrack(E obj1, int num) {
		//objects.get(num).add(obj1);
	    int total = tracks.get(num).getTotal();
	    tracks.get(num).setTotal(total+1);
	    
		return true;		
	}

	@Override
	public boolean addcrelateo(L obj1, E obj2) {
		
		co.add(obj2);
		
		return true;
	}

	@Override
	public boolean addorelateo(E obj1, E obj2) {
		Map<E,E> m = new HashMap<E,E>();
		oo.add(m);
		m.put(obj1, obj2);
		return true;
	}

	@Override
	public boolean transit(E object, int t) {
		for(Track<E> s:tracks)
		{
			if(s.getObj().contains(object))
				{
				s.getObj().remove(object);
				break;
				}
		}
		
		for(Track<E> s:tracks)
		{
			if(s.getNum()== t)
				{
				objects.get(t).add(object);
				break;
				}
		}
		return true;
	}

	@Override
	public boolean move(E object, double sitha) {
		for(Track<E> s:tracks)
		{
			for(E m:s.getObj())
			{
				if(m.equals(object))
				{
				det.put(m, sitha);
				return true;
				}
			}
		}
		return false;
	}
	@Override
	public List<Set<E>> getobjects() {	
		for(Track<E> tra:tracks)
		{
			int num = tra.getNum();
			objects.add(num, tra.getObj());
		}
		return objects;
	}
	public L getCenter() {
		L c = center;
		return c;
	}
	
	@Override
	public L getcenter() {
		// TODO Auto-generated method stub
		L c = center;
		return c;
	}
	@Override
	public List<Track<E>> gettrack() {
		// TODO Auto-generated method stub
		List<Track<E>> t = tracks;
		return t;
	}
	
	@Override
	public Set<E> getrelation(E obj) {
		// TODO Auto-generated method stub
		
		for(Track<E> t:tracks)
		{
			Set<E> o = new HashSet<>();
			for(E oo:o)
			{
				if(oo.equals(obj))
					return t.getRelate().get(oo);
			}
		}
		return null;
	}
	@Override
	public int getcrelation(E obj) {
		// TODO Auto-generated method stub
		for(Track<E> t:tracks)
		{
			Set<E> o = new HashSet<>();
			for(E oo:o)
			{
				if(oo.equals(obj))
					return t.getCrelate();
			}
		}
		return -1;
	}
	
	@Override
	public CircularOrbit<L, E> getit() {
		// TODO Auto-generated method stub
		return null;
	}
	public static <L,E> ConcreteCircularOrbit<L,E> empty() {
		// TODO Auto-generated method stub
		return new ConcreteCircularOrbit<>();
	}
	@Override
	public void setEach(Map<Integer, Integer> m) {
		// TODO Auto-generated method stub
		each = m;
	}
	@Override
	public Map<Integer, Integer> geteach() {
		// TODO Auto-generated method stub
		return each;
	}
	
	
	
}
