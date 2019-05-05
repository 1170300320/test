package applications;

import java.awt.Button;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import circularorbit.ConcreteEdgesGraph;
import circularorbit.SocialNetworkCircle;
import physicalObject.Person;

public class SocialNetworkCircleUI extends Panel implements MouseListener, ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame jf = new JFrame();
	Button add = new Button("ADD");
    Button remove = new Button("REMOVE");
    Button e = new Button("E");
    Button spread = new Button("SPREAD");
    TextField add0 = new TextField();
	TextField remove0 = new TextField();
	TextField e0 = new TextField();
	TextField spread0 = new TextField();
	public static SocialNetworkCircle so = new SocialNetworkCircle();
	
	public void draw(ConcreteEdgesGraph<Person> graph){
	    jf.setVisible(true);
	    jf.setLayout(null);
	    JPanel sr = new sr();
        sr.setVisible(true);
		jf.setSize(600, 600);
		jf.setLocation(0, 0);
		sr.setSize(400, 400);
		jf.addMouseListener(this);
		remove.addActionListener(this);
		add.addActionListener(this);
		spread.addActionListener(this);
		e.addActionListener(this);
		add.setBounds(50, 450, 100, 26);
		remove.setBounds(50, 500, 100, 26);
		e.setBounds(450, 200, 100, 26);
		spread.setBounds(250, 450, 100,26);
		add0.setBounds(150, 450, 100, 26);
		remove0.setBounds(150, 500, 100, 26);
		e0.setBounds(450, 300, 100, 26);
		jf.add(sr);
		jf.add(add);
		jf.add(remove);
		jf.add(add0);
		jf.add(remove0);
		//jf.add(e);
		//jf.add(e0);
		jf.add(spread);
		jf.add(spread0);
	}
	
	public static void main(String[] args) {
	SocialNetworkCircleUI so = new SocialNetworkCircleUI();
	SocialNetworkCircle s = new SocialNetworkCircle();
	s.detail();
	ConcreteEdgesGraph<Person> graph = s.getgraph();
	so.draw(graph);
    }

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	Button eventobj = (Button) e.getSource();
	String labelname = eventobj.getLabel();
	if(labelname.equals("SPREAD")) {
		//System.out.println("!");
		new Open();
	}
	else if(labelname.equals("ADD")) {
		ConcreteEdgesGraph<Person> graph = so.getgraph();
		Person vertex = new Person();
		vertex.setName(add0.getText());
		graph.add(vertex);
		SocialNetworkCircleUI ui = new SocialNetworkCircleUI();
		ui.draw(graph);
	}
	else if(labelname.equals("REMOVE")) {
		ConcreteEdgesGraph<Person> graph = so.getgraph();
		for(Person p:graph.vertices()) {
			if(p.getName().equals(remove0.getText())){
				graph.remove(p);
				break;
			}
		}
		SocialNetworkCircleUI ui = new SocialNetworkCircleUI();
		ui.draw(graph);
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
class sr extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//public SocialNetworkCircle so = SocialNetworkCircleUI.so;
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
    SocialNetworkCircle so = SocialNetworkCircleUI.so;
	so.detail();
	ConcreteEdgesGraph<Person> graph = so.getgraph();
    Set<Person> friend = graph.vertices();
    Person p = so.getC();
    
    g.setColor(Color.black);
	g.drawString(p.getName(), 195, 195);
	g.fillOval(195, 195, 10, 10);//中心点
	p.setPositon(195, 195);
    int max = 0;
    int a = 0;
    int flag = 0;
    for(Person pp:friend) {
    	a = so.getDistance(p,pp);
    	//System.out.println(a);
    	if(max<a) {
    		max = a;
    	}
    	if(a<0&&flag == 0) {
    		max = max+1;
    		flag = 1;
    	}
    	pp.setValid(0);
    }
    p.setValid(1);
    int j = 0;
    for(int i = 1;i<=max;i++) {
    	g.drawOval(200-20*i,200-20*i,40*i, 40*i);
    	
    	for(Person ppp:friend) {
    		if(p.getRelation().keySet().contains(ppp)&&ppp.getValid()==0)
    		{
    			j++;
    			//System.out.println(ppp.getName());
    			int x = (int)(195-20*(Math.cos(5.2*j)));
    			int y = (int)(195-20*(Math.sin(5.2*j)));
    			g.fillOval(x,y, 10, 10);
    			ppp.setValid(1);
    			g.drawString(ppp.getName(), x, y);
    			ppp.setPositon(x,y);
    			g.drawLine(200, 200, x+5,y+5);
    		}
    		if(so.getDistance(p,ppp)==i&&ppp.getValid()==0) {
    			j++;
    			//System.out.println(ppp.getName());
    			int x = (int)(195-20*i*(Math.cos(5.2*j)));
    			int y = (int)(195-20*i*(Math.sin(5.2*j)));
    			g.fillOval(x,y, 10, 10);
    			ppp.setValid(1);
    			g.drawString(ppp.getName(), x, y);
    			ppp.setPositon(x,y);
    		}
    		if(so.getDistance(p,ppp) == -1&&ppp.getValid()==0) {
    			int x = (int)(195-20*max*(Math.cos(5.2*j)));
    			int y = (int)(195-20*max*(Math.sin(5.2*j)));
    			g.fillOval(x,y, 10, 10);
    			g.drawString(ppp.getName(), x, y);
    			ppp.setValid(1);
    			ppp.setPositon(x, y);
    		}
    	}
    }
    for(Person p1:friend) {
    	for(Person p2:friend) {
    		if(so.getDistance(p1, p2) == 1) {
    			g.drawLine(p1.getX()+5, p1.getY()+5, p2.getX()+5, p2.getY()+5);
    		}
    	}
    }
	
	
		 
	   
	  
		   
	}} 
	

class Open extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Open() {
		SocialNetworkCircle s = new SocialNetworkCircle();
		s.detail();
		JTextArea ta =new JTextArea(20, 50);
		double e = s.spread(s.getC());
		//System.out.println(e);
		String str0 = new String();
		str0 = e+" ";
		ta.append(str0);
		this.add(ta);
		validate();
		this.setSize(380, 245);// 设置此窗口永远为最上方 是window的方法
		this.setAlwaysOnTop(true);			
		this.setResizable(true);			
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}

	

