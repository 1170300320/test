package P3;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Game extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public void ff(){
		this.setTitle("��ʼ��Ϸ");
		Button bgo = new Button("��������");
		Button bchess = new Button("�й�Χ��");
		JTextField jtp1 = new JTextField("                 ");
		JTextField jtp2 = new JTextField("                 ");
		JLabel jl1 = new JLabel("���1��");
		JLabel jl2 = new JLabel("���2��");		
		this.setSize(500, 200);
		this.setLocation(300, 50);
		this.add(jl1);
		this.add(jtp1);
		this.add(jl2);
		this.add(jtp2);
		this.add(bchess);
		this.add(bgo);
		jtp1.setEditable(true);
		jtp2.setEditable(true);
		//bchess.setBounds(10, 40, 50, 26);
		//bgo.setBounds(10, 10, 10, 20);
		this.setVisible(true);
        this.setLayout(new FlowLayout());
        this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
        bgo.addActionListener(new ActionListener()
        {
        public void actionPerformed(ActionEvent e)
        {Button temp=(Button)e.getSource();
        
        if(temp.getLabel() == "��������")
        	{
        	new Go();
        	setVisible(false);
        	}
        }
        }
        );
        bchess.addActionListener(new ActionListener()
        {
        public void actionPerformed(ActionEvent e)
        {Button temp=(Button)e.getSource();
        if(temp.getLabel() == "�й�Χ��")
        	{
        	new Chess();
        	setVisible(false);
            }
        }
        }
        );
        
		}
        
public static void main(String[] args)
{
	Game f = new Game();
	f.ff();
}
	}

