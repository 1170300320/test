package APIs;

import javax.swing.JFrame;

import applications.AthleteUI;
import applications.AtomStructureUI;
import applications.SocialNetworkCircleUI;
import circularorbit.AtomStructure;
import circularorbit.ConcreteEdgesGraph;
import circularorbit.SocialNetworkCircle;
import physicalObject.Person;

public class CircularOrbitHelpers extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static void visualize(String arg) {
		if(arg.equals("Atom"))
			{
			AtomStructureUI a = new AtomStructureUI();
			AtomStructure atom = new AtomStructure();
			a.draw(atom);
			}
		else if(arg.equals("Athlete"))
			{
			AthleteUI s = new AthleteUI();
			s.draw();
			}
		else if(arg.equals("Social"))
			{
			SocialNetworkCircleUI ss = new SocialNetworkCircleUI();
			SocialNetworkCircle s = new SocialNetworkCircle();
			ConcreteEdgesGraph<Person> graph= s.getgraph();
			ss.draw(graph);
			}
		else
			System.exit(1);
	}
   /*double sqr2 = Math.sqrt(2.0);
   public  void paint(Graphics g)
    {
    	g.setColor(Color.black);
    	g.drawOval(0, 0, 10, 10);
    }
    public  void drawrelation(double r0,double sitha0,List<Double> rr,List<Double> ssitha,Graphics g) 
    {
    	double x1 = r0*(Math.cos(sitha0));
    	double y1 = r0*(Math.sin(sitha0));
    	for(int i = 0;i<rr.size();i++)
    	{
    		double r = rr.get(i);
    		double sitha = ssitha.get(i);
    		double x2 = r*(Math.cos(sitha));
    		double y2 = r*(Math.sin(sitha));
    		g.drawLine((int)(x1), (int)(y1), (int)(x2),(int)(y2));
    	}
    }
    public void drawobjtotrack(double r,double sitha,Graphics g) {
    	int x = (int)(r*(Math.cos(sitha)));
    	int y = (int)(r*(Math.sin(sitha)));
    	g.drawOval(x, y, 20, 20);
    	
    }
    public void drawcore(double r0,double sitha0,Graphics g)
    {
    	double x1 = r0*(Math.sin(sitha0));
    	double y1 = r0*(Math.cos(sitha0));
        g.drawLine((int)(x1), (int)(y1), 0,0);
    } 
	public static void visualize(String arg) {
		if(arg.equals("Atom"))
			AtomStructureUI a = new AtomStructureUI();
		else if(arg.equals("Stellar"))
			StellarSystemUI s = new StellarSystemUI();
		else if(arg.equals("Social"))
			SocialNetworkCircleUI ss = new SocialNetworkCircleUI();
		else
			System.exit(1);
		System.out.println("!");
		JFrame jf = new JFrame();
		jf.setVisible(true);
		JPanel jp = new JPanel();
		jp.setVisible(true);
		jf.add(jp);
		List<Set<E>> objs = c.getobjects();   
        List<Track<E>> track = c.gettrack(); 
        g.setColor(Color.black);
        System.out.println("!");
		g.fillOval(20, 20, 10, 10);	
		System.out.println("!");
		for(Track<E> t:track)
		{
			double r = t.getR();
			g.drawOval((int)(0-r*sqr2), (int)(0-r*sqr2), (int)(2*r),(int)(2*r));
		}
		for(Set<E> s:objs )
		{
			Set<E> ss = s;
			for(E p:ss)
			{
				List<Double> rr = new ArrayList<>();
				List<Double> ssitha = new ArrayList<>();
				double r = c.getrad(p);
				double sitha = c.getsitha(p);
				Set<E> re = c.getrelation(p);
				int cre = c.getcrelation(p);
				if(cre==1){
					drawcore(r,sitha,g);
				}
				for(E target:re)
				{
				   rr.add(c.getrad(target));
				   ssitha.add(c.getsitha(target));
				}
				drawrelation(r,sitha,rr,ssitha,g);
				drawobjtotrack(r,sitha,g);
			}
		}*/
}
