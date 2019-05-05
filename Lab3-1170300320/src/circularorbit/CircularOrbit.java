package circularorbit;
//抽象产品的接口
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import track.Track;
/*
 * 该接口大概功能
 * 从txt中读取相应数据，存储到合适的地方
 * 新增一条轨道
 * 取消一条轨道
 * 增加中心点物体
 * 向特定轨道增加一个物体
 * 增加中心点物体和一个轨道物体之间的关系
 * 增加两个轨道物体之间的关系
 * 转移一个物体到t
 * 如果某轨道物体需考虑绝对位置，将某一物体移动到新的sitha角度的位置
 */
public interface CircularOrbit<L,E> {
	//L:center type
	//E:track object type
	public static<L,E> CircularOrbit<L,E> empty() {
		
		return new ConcreteCircularOrbit<L,E>();
	}
	public String read(File f) throws IOException;
	public boolean addtrack(Track<E> track);
	public boolean removetrack(int num);//根据编号删除轨道
	public boolean addtotrack(E obj1,int num);//添加轨道以及他的编号
	public boolean addcrelateo(L obj1, E obj2);//在中心点和轨道物体之间添加关系
	public boolean addorelateo(E obj1, E obj2);//在两个轨道物体之间添加联系
	public boolean transit(E object,int t); //物体越轨到t编号
	public boolean move(E object, double sitha);//物体改变方向到sitha
	public void addcenter(L object);
	public List<Set<E>> getobjects();//得到编号和所属轨道所含有物体的set一一对应
	public L getcenter();//得到这个系统的中心点
	//public void settrack(List<Track<E>> tracks);
	public List<Track<E>> gettrack();//返回编号和轨道一一对应
	public Set<E> getrelation(E obj);
	public int getcrelation(E obj);
    public CircularOrbit<L,E> getit();
    public void setEach(Map<Integer,Integer> m);
    public Map<Integer,Integer> geteach();
}
