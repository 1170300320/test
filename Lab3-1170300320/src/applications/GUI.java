package applications;

import java.awt.Button;
import java.awt.Color;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;

import circularorbit.AtomStructure;
import circularorbit.ConcreteEdgesGraph;
import circularorbit.SocialNetworkCircle;
import physicalObject.Person;

public class GUI extends Panel implements MouseListener, ActionListener{
   /**
	 * 
	 */
   private static final long serialVersionUID = 1L;
   Button atom = new Button("AtomStructure");
   Button athlete = new Button("Athlete");
   Button social = new Button("SocialNetworkCircle");
   JFrame jf = new JFrame();
   GUI() {
	    jf.setVisible(true);
		jf.setSize(440, 440);
		jf.setLayout(null);
		jf.setBackground(Color.orange);
		jf.addMouseListener(this);
		jf.add(atom);
		jf.add(athlete);
		jf.add(social);
		atom.setBounds(40, 20, 200, 26);
		athlete.setBounds(40, 120, 200, 26);
		social.setBounds(40, 220, 200, 26);
		atom.addActionListener(this);
		athlete.addActionListener(this);
		social.addActionListener(this);

	}   
  
   public static void main(String[] args) {
	   new GUI();
   }
@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	Button eventobj = (Button) e.getSource();
	String labelname = eventobj.getLabel();
	if(labelname.equals("AtomStructure"))
	{
		AtomStructureUI a = new AtomStructureUI();
		AtomStructure atom = new AtomStructure();
		//System.out.println("!");
		atom.detail();
		a.draw(atom);
		//System.out.println("!");
	}
	else if(labelname.equals("Athlete"))
	{
		AthleteUI a = new AthleteUI();
		//AthleteSystem atom = new AthleteSystem();
		//System.out.println("!");
		a.draw();
		//System.out.println("!");
	}
	else if(labelname.equals("SocialNetworkCircle"))
	{
		SocialNetworkCircleUI a = new SocialNetworkCircleUI();
		SocialNetworkCircle s = new SocialNetworkCircle();
		ConcreteEdgesGraph<Person> graph = s.getgraph();
		a.draw(graph);
	}
}
@Override
public void mouseClicked(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}
}
