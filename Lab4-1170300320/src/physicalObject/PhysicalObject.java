package physicalObject;
//�����Ʒ��
import java.util.Map;

/*
 * ���������Ľӿ�
 * �ɴ��ʵ��
 * ��ȡ�����������
 * ��ȡ���������ڹ���ı��
 * ��ȡ���������ڹ���İ뾶
 * ��ȡ������������״̬
 * ��ȡ���������ɫ
 * ��ȡ����������İ뾶
 * ��ȡ������ת���ķ���
 * ��ȡ����������λ�õĽǶ�
 * ��ȡ��������й�ϵ���������弰������ʲô��ϵ
 * ��ȡ�����������ĵ��Ƿ��й�ϵ��������ʲô��ϵ,����1Ϊ�й�ϵ��0û�й�ϵ
 */
public interface PhysicalObject<E> {
	    public String getName() ;
	    public void setName(String name);
	    public int getNum();
	    public void setNum(int num);
	    public double getTrarad();	 
	    public void setTrarad(double trarad);	
		public double getR();		
		public void setR(double r);
		public Map<E,Double> getRelation();
		public Map<Integer,Double> getcRelation();					
		public void setcRelation(Map<Integer,Double> crelation);
		public int getAge();
		public void setAge(int age);
		public double getSitha();
		public void setSitha(double sitha);
		
}
