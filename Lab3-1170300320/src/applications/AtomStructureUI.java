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
import java.util.Map;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import APIs.CircularOrbitAPIs;
import centralObject.Atomcenter;
import circularorbit.AtomStructure;
import physicalObject.Atom;
import track.Track;
public class AtomStructureUI extends Panel implements MouseListener, ActionListener{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    JFrame jf = new JFrame();
    Button transit = new Button("TRANSIT");
    Button add = new Button("ADD");
    Button remove = new Button("REMOVE");
    Button e = new Button("E");
	TextField transit1 = new TextField();
	TextField transit2 = new TextField();
	TextField add0 = new TextField();
	TextField remove0 = new TextField();
	TextField e0 = new TextField();
	public static AtomStructure atom ;
	public static AtomStructureUI a;
    public void draw(AtomStructure a){
        atom = a;
	    jf.setVisible(true);
	    jf.setLayout(null);
	    JPanel tr = new tr(atom);
        tr.setVisible(true);
		jf.setSize(600, 600);
		jf.setLocation(0, 0);
		tr.setSize(400, 400);
		jf.addMouseListener(this);
		add.setBounds(50, 450, 100, 26);
		add.addActionListener(this);
		remove.setBounds(50, 500, 100, 26);
		remove.addActionListener(this);
		e.setBounds(450, 200, 100, 26);
		e.addActionListener(this);
		transit.setBounds(250, 450, 100, 26);
		transit.addActionListener(this);
		add0.setBounds(150, 450, 100, 26);
		remove0.setBounds(150, 500, 100, 26);
		add0.addActionListener(this);
		remove0.addActionListener(this);
		e0.setBounds(350, 200, 100, 26);
		e0.addActionListener(this);
		transit1.setBounds(350, 450, 100, 26);
		transit1.addActionListener(this);
		transit1.setEditable(true);
		transit2.setBounds(350, 500, 100, 26);
		transit2.addActionListener(this);
		transit2.setEditable(true);
		jf.add(tr);
		jf.add(transit);
		jf.add(add);
		jf.add(remove);
		jf.add(transit1);
		jf.add(transit2);
		jf.add(add0);
		jf.add(remove0);
		jf.add(e);
		//jf.add(e0);
	}
    
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
		Map<Integer,Integer> each = atom.geteachnum();
		Button eventobj = (Button) e.getSource();
		String labelname = eventobj.getLabel();
		if(labelname.equals("TRANSIT")) {
			int tr1 = Integer.valueOf(transit1.getText());
			int tr2 = Integer.valueOf(transit2.getText());
			int sum1 = each.get(tr1);
			int sum2 = each.get(tr2);	
			each.put(tr1, sum1-1);
			each.put(tr2, sum2+1);
			atom.seteachnum(each);
			System.out.println("电子从"+tr1+"跃迁到"+tr2);
			AtomStructureUI a = new AtomStructureUI();
			a.draw(atom);
				}
		else if(labelname.equals("ADD"))
		{
			int total = atom.gettotal();
			Track<Atom> track = new Track<>();
			atom.addtrack(track);
			atom.settotal(total+1);
			AtomStructureUI a = new AtomStructureUI();
			Map<Integer,Integer> m = atom.eachnum;
			m.put(total+1, 0);
			atom.seteachnum(m);
	    	a.draw(atom);
		}
		else if(labelname.equals("REMOVE")) {
			int num = Integer.valueOf(remove0.getText());
			atom.removetrack(num);
			AtomStructureUI a = new AtomStructureUI();
			Map<Integer,Integer> m = atom.eachnum;
			int d = m.get(num);
			m.put(num, d-1);
			atom.seteachnum(m);
	    	a.draw(atom);
		}
		else if(labelname.equals("E")) {
			new EFrame(atom);
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
	public static void main(String[] args) {
	AtomStructure atom = new AtomStructure();
	AtomStructureUI a = new AtomStructureUI();
	atom.detail();
	a.draw(atom);
	}
	}
class tr extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static AtomStructure atom;
	int total;
	public tr(AtomStructure a) {
		total = a.gettotal();
		atom = a;
	}
	public void paint(Graphics g) {
		// TODO Auto-generated method stub	
	//System.out.println(atom.gettotal());
	Map<Integer,Integer> each = atom.geteachnum();
	g.setColor(Color.black);
	for(int i = 1;i<=total;i++) {
	   g.drawOval(200-20*i, 200-20*i, 40*i, 40*i);
	   for(int j = 1;j<=each.get(i);j++) {
		   g.fillOval(195, 195, 10, 10);//中心点
		   int x = (int)(195-20*i*(Math.cos(5.2*j)));
		   int y = (int)(195-20*i*(Math.sin(5.2*j)));
		   g.fillOval(x,y, 10, 10);
	   }
	}
}
}
class EFrame extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public EFrame(AtomStructure at) {
		String str = new String();
		JTextArea ta =new JTextArea(20, 50); 
		CircularOrbitAPIs<Atomcenter<Atom>,Atom> api = new CircularOrbitAPIs<>();
		double dd = api.getObjectDistributionEntropy(at);
		str = String.valueOf(dd);
		ta.append(str);
		this.add(ta);
		validate();
		this.setSize(380, 245);// 设置此窗口永远为最上方 是window的方法
		this.setAlwaysOnTop(true);			
		this.setResizable(true);			
		this.setLocationRelativeTo(null);
		this.setVisible(true);
	}
}

