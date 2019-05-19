package APIs;

import javax.swing.JFrame;

import applications.AthleteUI;
import applications.AtomStructureUI;
import applications.SocialNetworkCircleUI;
import circularorbit.AtomStructure;
import circularorbit.SocialNetworkCircle;

public class CircularOrbitHelpers extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int visualize(String arg) {
		if(arg.equals("Atom"))
			{
			AtomStructureUI a = new AtomStructureUI();
			AtomStructure atom = new AtomStructure();
			atom.detail();
			a.draw(atom);
			return 1;
			
			}
		else if(arg.equals("Athlete"))
			{
			AthleteUI s = new AthleteUI();
			s.draw();
			return 1;
			}
		else if(arg.equals("Social"))
			{
			SocialNetworkCircleUI ss = new SocialNetworkCircleUI();
			SocialNetworkCircle s = new SocialNetworkCircle();
			//ConcreteEdgesGraph<Person> graph= s.getgraph();
			ss.draw(s);
			return 1;
			}
		else
			System.exit(1);
		return 0;
	}
  
}
