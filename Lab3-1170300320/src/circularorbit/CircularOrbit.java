package circularorbit;
//�����Ʒ�Ľӿ�
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;

import track.Track;
/*
 * �ýӿڴ�Ź���
 * ��txt�ж�ȡ��Ӧ���ݣ��洢�����ʵĵط�
 * ����һ�����
 * ȡ��һ�����
 * �������ĵ�����
 * ���ض��������һ������
 * �������ĵ������һ���������֮��Ĺ�ϵ
 * ���������������֮��Ĺ�ϵ
 * ת��һ�����嵽t
 * ���ĳ��������迼�Ǿ���λ�ã���ĳһ�����ƶ����µ�sitha�Ƕȵ�λ��
 */
public interface CircularOrbit<L,E> {
	//L:center type
	//E:track object type
	public static<L,E> CircularOrbit<L,E> empty() {
		
		return new ConcreteCircularOrbit<L,E>();
	}
	public String read(File f) throws IOException;
	public boolean addtrack(Track<E> track);
	public boolean removetrack(int num);//���ݱ��ɾ�����
	public boolean addtotrack(E obj1,int num);//��ӹ���Լ����ı��
	public boolean addcrelateo(L obj1, E obj2);//�����ĵ�͹������֮����ӹ�ϵ
	public boolean addorelateo(E obj1, E obj2);//�������������֮�������ϵ
	public boolean transit(E object,int t); //����Խ�쵽t���
	public boolean move(E object, double sitha);//����ı䷽��sitha
	public void addcenter(L object);
	public List<Set<E>> getobjects();//�õ���ź�������������������setһһ��Ӧ
	public L getcenter();//�õ����ϵͳ�����ĵ�
	//public void settrack(List<Track<E>> tracks);
	public List<Track<E>> gettrack();//���ر�ź͹��һһ��Ӧ
	public Set<E> getrelation(E obj);
	public int getcrelation(E obj);
    public CircularOrbit<L,E> getit();
    public void setEach(Map<Integer,Integer> m);
    public Map<Integer,Integer> geteach();
}
