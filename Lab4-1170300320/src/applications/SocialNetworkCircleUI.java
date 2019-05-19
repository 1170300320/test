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
import java.io.IOException;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import circularorbit.ConcreteEdgesGraph;
import circularorbit.SocialNetworkCircle;
import circularorbit.filter;
import circularorbit.logging;
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
    Button funclog = new Button("functionlog");
    Button personinfo = new Button("personinfo");
    Button exception = new Button("exceptionlog");
    Button time = new Button("timelog");
    Button all = new Button("all");
    TextField add0 = new TextField();
	TextField remove0 = new TextField();
	TextField e0 = new TextField();
	TextField spread0 = new TextField();
	TextField time0 = new TextField();
	TextField time1 = new TextField();
	public static SocialNetworkCircle so = new SocialNetworkCircle();
	
	public void draw(SocialNetworkCircle so){
	    jf.setVisible(true);
	    jf.setLayout(null);
	    JPanel sr = new sr(so);
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
		funclog.addActionListener(this);
		personinfo.addActionListener(this);
		exception.addActionListener(this);
		time.addActionListener(this);
		all.addActionListener(this);
		funclog.setBounds(450, 80, 100, 26);
		personinfo.setBounds(450, 120, 100, 26);
		exception.setBounds(450, 160, 100, 26);
		time.setBounds(450, 240, 100, 26);
		all.setBounds(450,200,100,26);
		time0.setBounds(450, 280, 100, 26);
		time1.setBounds(450, 320, 100, 26);
		jf.add(funclog);
		jf.add(personinfo);
		jf.add(exception);
		jf.add(time);
		jf.add(all);
		jf.add(time0);
		jf.add(time1);
		jf.add(sr);
		jf.add(add);
		jf.add(remove);
		jf.add(add0);
		jf.add(remove0);
		jf.add(spread);
		jf.add(spread0);
	}
	
	public static void main(String[] args) {
	SocialNetworkCircleUI so = new SocialNetworkCircleUI();
	SocialNetworkCircle s = new SocialNetworkCircle();
	s.detail();
	so.draw(s);
    }

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	Button eventobj = (Button) e.getSource();
	String labelname = eventobj.getLabel();
	if(labelname.equals("SPREAD")) {
		new Open();
	}
	else if(labelname.equals("ADD")) {
		ConcreteEdgesGraph<Person> graph = so.getgraph();
		Person vertex = new Person();
		vertex.setName(add0.getText());
	
	    graph.add(vertex);
	    so.detail();
	    so.setgraph(graph);
	    Set<Person> friend = so.getFriend();
	    friend.add(vertex);
	    so.setFriend(friend);
		SocialNetworkCircleUI ui = new SocialNetworkCircleUI();
		logging.logFunction("向社交网络添加人物"+add0.getText());
		ui.draw(so);
		
	}
	else if(labelname.equals("REMOVE")) {
		Set<Person> friend = so.getFriend();
		so.detail();
		Person remove = new Person();
		ConcreteEdgesGraph<Person> graph = so.getgraph();
		for(Person pr:graph.vertices()) {
			if(pr.getName().equals(remove0.getText()))
			{
				logging.logFunction("删除此社交网路中的"+remove0.getText());
				remove = pr;
				break;
			}
		}
		for(Person p:friend) {
			
			if(graph.sources(remove).containsKey(p)){
				graph.set(p, remove, Integer.MAX_VALUE);
			}
			else if(graph.targets(remove).containsKey(p)) {
				graph.set(remove, p, Integer.MAX_VALUE);
			}
		}
		graph.vertices().remove(remove);
		friend.remove(remove);
		for(Person per:friend) {
			System.out.println(per.getName());
		}
		so.setgraph(graph);
		so.setFriend(friend);
		SocialNetworkCircleUI ui = new SocialNetworkCircleUI();
		ui.draw(so);
	}
	else if(labelname.equals("functionlog")) {
		try {
			Runtime.getRuntime().exec("cmd /c \"D:\\eclipse\\Lab4-1170300320\\src\\function.txt");
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
	}
	else if(labelname.equals("personinfo")) {
		filter f = new filter();
		try {
			f.infofilt();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			Runtime.getRuntime().exec("cmd /c \"D:\\eclipse\\Lab4-1170300320\\src\\info.txt");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	else if(labelname.equals("exceptionlog")) {
		filter f = new filter();
		try {
			f.exceptionfilt();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			Runtime.getRuntime().exec("cmd /c \"D:\\eclipse\\Lab4-1170300320\\src\\exception.txt");
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	else if(labelname.equals("time")) {
		String t0 = time0.getText();
		//String t1 = time1.getText();
		filter f = new filter();
		try {
			f.timefilt(t0);
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			Runtime.getRuntime().exec("cmd /c \"D:\\eclipse\\Lab4-1170300320\\src\\time.txt");
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	else if(labelname.equals("all")) {
		filter f = new filter();
		try {
			f.classfilt();
		} catch (IOException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			Runtime.getRuntime().exec("cmd /c \"D:\\eclipse\\Lab4-1170300320\\src\\social.txt");
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
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
	public SocialNetworkCircle so;
	public ConcreteEdgesGraph<Person> graph;
	public sr(SocialNetworkCircle s) {
		so = s;
		graph = s.getgraph();
	}
	public void checkRep() {
		for(Person p:so.getFriend()) {
			for(Person pp:so.getFriend()) {
				assert so.getDistance(p,pp) == p.getNum();
			}
		}
	}
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
    Set<Person> friend = so.getFriend();
    Person p = so.getC();   
    g.setColor(Color.black);
	g.fillOval(195, 195, 10, 10);//中心点
	p.setPositon(195, 195);
    int max = -1;
    int a = 0;
    int flag = 0;
    
    for(Person pp:friend) {
    	a = so.getDistance(p,pp);
    	if(max<a) {
    		max = a;
    	}
    	if(a<0&&flag == 0) {
    		
    		flag = 1;
    	}
    	pp.setValid(0);
    }
    if(flag == 1)
    {
		max = max+1;
    }
    p.setValid(1);
    int j = 0;
    for(int i = 1;i<=max;i++) {
    	g.drawOval(200-20*i,200-20*i,40*i, 40*i);
    	for(Person ppp:friend) {
    //312change只有中心人物关系		
    		if(so.getDistance(p,ppp) == -1&&ppp.getValid()==0) {
    			
    			int x = (int)(195-20*max*(Math.cos(5.2*j)));
    			int y = (int)(195-20*max*(Math.sin(5.2*j)));
    			g.fillOval(x,y, 10, 10);
    			ppp.setValid(1);
    			ppp.setNum(i);
    			//System.out.println(ppp.getName()+"-1");
    			ppp.setPositon(x, y);
    		}
    		else if(p.getRelation().keySet().contains(ppp)&&ppp.getValid()==0)
    		{
    			int x = (int)(195-20*(Math.cos(5.2*j)));
    			int y = (int)(195-20*(Math.sin(5.2*j)));
    			g.fillOval(x,y, 10, 10);
    			ppp.setValid(1);
    			ppp.setNum(i);
    		
    			g.drawLine(200, 200, x+5, y+5);
    			ppp.setPositon(x,y);
    		}
    		else if(so.getDistance(p,ppp)==i&&ppp.getValid()==0) {
    			
    			int x = (int)(195-20*i*(Math.cos(5.2*j)));
    			int y = (int)(195-20*i*(Math.sin(5.2*j)));
    			g.fillOval(x,y, 10, 10);
    			ppp.setValid(1);
    			ppp.setNum(i);
    			//System.out.println(ppp.getName()+" "+i);
    			ppp.setPositon(x,y);
    		}
    		j++;
    		
    	}
    }
    for(Person p1:friend) {
    	for(Person p2:friend) {
    		if(so.getDistance(p1, p2) == 1) {
    			g.drawLine(p1.getX()+5, p1.getY()+5, p2.getX()+5, p2.getY()+5);
    		}
    	}
    }
	
	for(Person pper:friend) {
		int x = pper.getX();
		int y = pper.getY();
		g.drawString(pper.getName(), x, y);;
	}
		 
	 checkRep();  
	  
		   
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

	

