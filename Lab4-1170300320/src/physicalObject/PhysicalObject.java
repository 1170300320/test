package physicalObject;
//抽象产品类
import java.util.Map;

/*
 * 轨道上物体的接口
 * 可大概实现
 * 获取该物体的名字
 * 获取该物体所在轨道的编号
 * 获取该物体所在轨道的半径
 * 获取该物体所处的状态
 * 获取该物体的颜色
 * 获取该物体自身的半径
 * 获取该物体转动的方向
 * 获取该物体所在位置的角度
 * 获取与该物体有关系的其他物体及他们是什么关系
 * 获取该物体与中心点是否有关系及他们是什么关系,其中1为有关系，0没有关系
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
