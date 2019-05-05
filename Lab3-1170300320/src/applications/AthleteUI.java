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
import java.util.List;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

import circularorbit.AthleteSystem;

public class AthleteUI extends Panel implements MouseListener, ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame jf = new JFrame();
	Button add = new Button("ADD");
    Button remove = new Button("REMOVE");
    Button e = new Button("E");
    Button random = new Button("RANDOM");
    Button plan = new Button("PLAN");
    TextField add0 = new TextField();
	TextField remove0 = new TextField();
	TextField e0 = new TextField();
	public static AthleteSystem atom = new AthleteSystem();
    public void draw(){
	    jf.setVisible(true);
	    jf.setLayout(null);
	    JPanel ar = new ar();
        ar.setVisible(true);
		jf.setSize(600, 600);
		jf.setLocation(0, 0);
		ar.setSize(400, 400);
		jf.addMouseListener(this);
		remove.addActionListener(this);
		add.addActionListener(this);
		random.addActionListener(this);
		plan.addActionListener(this);
		e.addActionListener(this);
		add.setBounds(50, 450, 100, 26);
		remove.setBounds(50, 500, 100, 26);
		e.setBounds(450, 200, 100, 26);
		random.setBounds(250, 450, 100,26);
		plan.setBounds(250, 500, 100, 26);
		add0.setBounds(150, 450, 100, 26);
		remove0.setBounds(150, 500, 100, 26);
		e0.setBounds(350, 200, 100, 26);
		jf.add(ar);
		//jf.add(add);
		//jf.add(remove);
		//jf.add(add0);
		//jf.add(remove0);
		//jf.add(e);
		//jf.add(e0);
		jf.add(random);
		jf.add(plan);
	}
    public int getadd() {
    	int num = Integer.valueOf(add0.getText());
    	return num;
    }
    public int getremove() {
    	int num = Integer.valueOf(remove0.getText());
    	return num;
    }
    
public static void main(String[] args) {
	AthleteUI a = new AthleteUI();
	a.draw();
	
}

@Override
public void actionPerformed(ActionEvent e) {
	// TODO Auto-generated method stub
	Button eventobj = (Button) e.getSource();
	String labelname = eventobj.getLabel();
	if(labelname.equals("RANDOM")) {

		new OpenJFrame();
	}
	else if(labelname.equals("PLAN")) {
		new OpenJFrame0();
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
class ar extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static AthleteSystem atom = AthleteUI.atom;
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
	atom.detail();
	int total = atom.gettotal();
	g.setColor(Color.black);
	for(int i = 1;i<=total;i++) {
	   g.drawOval(200-20*i, 200-20*i, 40*i, 40*i);
	   g.fillOval(200-15*i, 200-15*i, 10, 10);
	   }
	} 
	
}
class OpenJFrame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public  OpenJFrame() {				
		String str = new String();
		JTextArea ta =new JTextArea(20, 50);
		JScrollPane scroll = new JScrollPane(ta); 
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);  
		AthleteSystem at = new AthleteSystem();
		at.detail();
		List<Set<String>> randomgroup = at.group();
		//System.out.println(randomgroup.size());
		for(int i = 0;i<randomgroup.size();i++) {
			ta.append("\n第"+(i+1)+"组");
			str = new String();
			for(String a:randomgroup.get(i)) {
				String name = a;
				//System.out.println(name);
				str += name +" ";
				//System.out.println(str);
			}
			ta.append(str);
		}
		add(scroll);
		//add(ta);
		validate();
		this.setSize(380, 245);// 设置此窗口永远为最上方 是window的方法
		this.setAlwaysOnTop(true);			
		this.setResizable(true);			
		this.setLocationRelativeTo(null);
		this.setTitle("分组情况");
		this.setVisible(true);
	}
}
class OpenJFrame0 extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public  OpenJFrame0() {				
		String str = new String();
		JTextArea ta =new JTextArea(20, 50);
		JScrollPane scroll = new JScrollPane(ta);
		AthleteSystem at = new AthleteSystem();
		at.detail();
		List<Set<String>> group = at.plangroup();
		scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS); 
		//System.out.println(randomgroup.size());
		for(int i = 0;i<group.size();i++) {
			ta.append("\n第"+(i+1)+"组");
			str = new String();
			//System.out.println(group.get(i).size());
			for(String a:group.get(i)) {
				
				str += a +" ";
			}
			//System.out.println(str);
			ta.append(str);
		}
		add(scroll);
		//add(ta);
		validate();
		this.setSize(380, 245);// 设置此窗口永远为最上方 是window的方法
		this.setAlwaysOnTop(true);			
		this.setResizable(true);			
		this.setLocationRelativeTo(null);
		this.setTitle("分组情况");
		this.setVisible(true);
	}
} 
/*class EFrame extends JFrame{
	public EFrame() {
		AthleteSystem at = new AthleteSystem();
		at.detail();
		String str = new String();
		JTextArea ta =new JTextArea(20, 50);
		CircularOrbitAPIs<Athletecenter<Athlete>, Athlete> api = new CircularOrbitAPIs<>();
		double e = api.getObjectDistributionEntropy(at);
		System.out.println(e);
		String str0 = new String();
		str0 = e+" ";
		ta.append(str0);
		validate();
		this.setSize(380, 245);// 设置此窗口永远为最上方 是window的方法
		this.setAlwaysOnTop(true);			
		this.setResizable(true);			
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
	
}*/
/*class addframe extends JPanel{
	
	private static final long serialVersionUID = 1L;
	AthleteUI a = new AthleteUI();
	int num = a.getadd();
	
	public void paint(Graphics g) {
		g.fillOval(200-15*num, 200-15*num, 10, 10);
	}
}
class removeframe extends JPanel{
	
	private static final long serialVersionUID = 1L;
	AthleteUI a = new AthleteUI();
	int num = a.getremove();
	public void paint(Graphics g) {
		g.fillOval(200-15*num, 200-15*num, 10, 10);
	}
}
*/


