package track;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
/*����ɵĹ���
 * ��ȡ��ǰ�켣�ı��
 * ��ȡ��ǰ�켣���ж��ٸ�����
 * ��ȡ��ǰ�켣�İ뾶��С
 * ��ȡ��ǰ�켣�ϵ����嶼��˭�������set��ʽ����
 */
public class Track<E> {
	private int num;
	private int total;
	private double r;
	private Map<E,Double> sitha = new HashMap<>();
	private Set<E> obj = new HashSet<>();
	private Map<E,Set<E>> relate = new HashMap<>();
	private int crelate;
	
	public Set<E> getObj()
	{
		Set<E> objs = new HashSet<>();
		objs = obj;
		return objs;
	}
	
	public double getR() {
		double d = r;
		return d;
	}
	
	public void setNum(int num) {
		this.num = num;
	}
	public int getNum() {
		int num0 = num;
		return num0;
	}
    
	public void setTotal(int to) {
		this.total = to;
	}
	public int getTotal() {
		int t = total;
		return t;
	}

	public Map<E,Double> getSitha() {
		Map<E,Double> s = sitha;
		return s;
	}

	public void setSitha(Map<E,Double> sitha) {
		this.sitha = sitha;
	}

	public Map<E,Set<E>> getRelate() {
		Map<E,Set<E>> r = new HashMap<>();
		r = relate;
		return r;
	}

	public void setRelate(Map<E,Set<E>> relate) {
		this.relate = relate;
	}

	public int getCrelate() {
		int i = crelate;
		return i;
	}

	public void setCrelate(int crelate) {
		this.crelate = crelate;
	}

	
}
