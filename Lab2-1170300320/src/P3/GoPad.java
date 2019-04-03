package P3;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class GoPad extends JFrame implements MouseListener, ActionListener {
	String white = new String();
	String black = new String();
	int  x;
	int y;
	Button button = new Button("重新开局");
	Button button0 = new Button("历史纪录");
	JLabel bw = new JLabel(new ImageIcon("src/P3/白王.jpg"));
	JLabel bm1 = new JLabel(new ImageIcon("src/P3/白马.jpg"));
	JLabel bm2 = new JLabel(new ImageIcon("src/P3/白马.jpg"));
	JLabel bh = new JLabel(new ImageIcon("src/P3/白后.jpg"));
	JLabel bx1 = new JLabel(new ImageIcon("src/P3/白象.jpg"));
	JLabel bx2 = new JLabel(new ImageIcon("src/P3/白象.jpg"));
	JLabel bb1 = new JLabel(new ImageIcon("src/P3/白兵.jpg"));
	JLabel bb2 = new JLabel(new ImageIcon("src/P3/白兵.jpg"));
	JLabel bb3 = new JLabel(new ImageIcon("src/P3/白兵.jpg"));
	JLabel bb4 = new JLabel(new ImageIcon("src/P3/白兵.jpg"));
	JLabel bb5 = new JLabel(new ImageIcon("src/P3/白兵.jpg"));
	JLabel bb6 = new JLabel(new ImageIcon("src/P3/白兵.jpg"));
	JLabel bb7 = new JLabel(new ImageIcon("src/P3/白兵.jpg"));
	JLabel bb8 = new JLabel(new ImageIcon("src/P3/白兵.jpg"));
	JLabel bc1 = new JLabel(new ImageIcon("src/P3/白车.jpg"));
	JLabel bc2 = new JLabel(new ImageIcon("src/P3/白车.jpg"));
	JLabel hw = new JLabel(new ImageIcon("src/P3/黑王.jpg"));
	JLabel hh = new JLabel(new ImageIcon("src/P3/黑后.jpg"));
	JLabel hm1 = new JLabel(new ImageIcon("src/P3/黑马.jpg"));
	JLabel hm2 = new JLabel(new ImageIcon("src/P3/黑马.jpg"));
	JLabel hc1 = new JLabel(new ImageIcon("src/P3/黑车.jpg"));
	JLabel hc2 = new JLabel(new ImageIcon("src/P3/黑车.jpg"));
	JLabel hx1 = new JLabel(new ImageIcon("src/P3/黑象.jpg"));
	JLabel hx2 = new JLabel(new ImageIcon("src/P3/黑象.jpg"));
	JLabel hb1 = new JLabel(new ImageIcon("src/P3/黑兵.jpg"));
	JLabel hb2 = new JLabel(new ImageIcon("src/P3/黑兵.jpg"));
	JLabel hb3 = new JLabel(new ImageIcon("src/P3/黑兵.jpg"));
	JLabel hb4 = new JLabel(new ImageIcon("src/P3/黑兵.jpg"));
	JLabel hb5 = new JLabel(new ImageIcon("src/P3/黑兵.jpg"));
	JLabel hb6 = new JLabel(new ImageIcon("src/P3/黑兵.jpg"));
	JLabel hb7 = new JLabel(new ImageIcon("src/P3/黑兵.jpg"));
	JLabel hb8 = new JLabel(new ImageIcon("src/P3/黑兵.jpg"));

	GoPad() {
		this.setName("国际象棋");
		button.setSize(160, 40);
		button.setLocation(820, 200);
		button0.setSize(160, 40);
		button0.setLocation(820, 110);
		button.addActionListener(this);
		button0.addActionListener(this);
		add(button);
		add(button0);
		bw.setSize(100, 100);
		bw.setLocation(300, 700);
		bm1.setSize(100, 100);
		bm1.setLocation(100, 700);
		bm2.setSize(100, 100);
		bm2.setLocation(600, 700);
		bh.setSize(100, 100);
		bh.setLocation(400, 700);
		bx1.setSize(100, 100);
		bx1.setLocation(200, 700);
		bx2.setSize(100, 100);
		bx2.setLocation(500, 700);
		bb1.setSize(100, 100);
		bb1.setLocation(0, 600);
		bb2.setSize(100, 100);
		bb2.setLocation(100, 600);
		bb3.setSize(100, 100);
		bb3.setLocation(200, 600);
		bb4.setSize(100, 100);
		bb4.setLocation(300, 600);
		bb5.setSize(100, 100);
		bb5.setLocation(400, 600);
		bb6.setSize(100, 100);
		bb6.setLocation(500, 600);
		bb7.setSize(100, 100);
		bb7.setLocation(600, 600);
		bb8.setSize(100, 100);
		bb8.setLocation(700, 600);
		bc1.setSize(100, 100);
		bc1.setLocation(0, 700);
		bc2.setSize(100, 100);
		bc2.setLocation(700, 700);
		hw.setSize(100, 100);
		hw.setLocation(300, 0);
		hh.setSize(100, 100);
		hh.setLocation(400, 0);
		hm1.setSize(100, 100);
		hm1.setLocation(100, 0);
		hm2.setSize(100, 100);
		hm2.setLocation(600, 0);
		hc1.setSize(100, 100);
		hc1.setLocation(0, 0);
		hc2.setSize(100, 100);
		hc2.setLocation(700, 0);
		hx1.setSize(100, 100);
		hx1.setLocation(200, 0);
		hx2.setSize(100, 100);
		hx2.setLocation(500, 0);
		hb1.setSize(100, 100);
		hb1.setLocation(0, 100);
		hb2.setSize(100, 100);
		hb2.setLocation(100, 100);
		hb3.setSize(100, 100);
		hb3.setLocation(200, 100);
		hb4.setSize(100, 100);
		hb4.setLocation(300, 100);
		hb5.setSize(100, 100);
		hb5.setLocation(400, 100);
		hb6.setSize(100, 100);
		hb6.setLocation(500, 100);
		hb7.setSize(100, 100);
		hb7.setLocation(600, 100);
		hb8.setSize(100, 100);
		hb8.setLocation(700, 100);
		setSize(1000, 1420);
		setLocation(400, 0);
		setLayout(null);
		int m = 8;
		int n = 100;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < m; j++) {
				JLabel jLabel = new JLabel();
				jLabel.setSize(n, n);
				jLabel.setLocation(i * n, j * n);
				if ((i + j) % 2 == 0) {
					jLabel.setBackground(Color.BLACK);
					jLabel.setOpaque(true);
				
				} else {
					jLabel.setBackground(Color.WHITE);
					jLabel.setOpaque(true);
					
				}
				jLabel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
				add(jLabel);
			}
		}

		this.getLayeredPane().add(bw, Integer.MAX_VALUE);
		this.getLayeredPane().add(bc1, Integer.MAX_VALUE);
		this.getLayeredPane().add(bc2, Integer.MAX_VALUE);
		this.getLayeredPane().add(hc1, Integer.MAX_VALUE);
		this.getLayeredPane().add(hc2, Integer.MAX_VALUE);
		this.getLayeredPane().add(bb1, Integer.MAX_VALUE);
		this.getLayeredPane().add(bb2, Integer.MAX_VALUE);
		this.getLayeredPane().add(bb3, Integer.MAX_VALUE);
		this.getLayeredPane().add(bb4, Integer.MAX_VALUE);
		this.getLayeredPane().add(bb5, Integer.MAX_VALUE);
		this.getLayeredPane().add(bb6, Integer.MAX_VALUE);
		this.getLayeredPane().add(bb7, Integer.MAX_VALUE);
		this.getLayeredPane().add(bb8, Integer.MAX_VALUE);
		this.getLayeredPane().add(bh, Integer.MAX_VALUE);
		this.getLayeredPane().add(bx1, Integer.MAX_VALUE);
		this.getLayeredPane().add(bx2, Integer.MAX_VALUE);
		this.getLayeredPane().add(bm1, Integer.MAX_VALUE);
		this.getLayeredPane().add(bm2, Integer.MAX_VALUE);
		this.getLayeredPane().add(hw, Integer.MAX_VALUE);
		this.getLayeredPane().add(hh, Integer.MAX_VALUE);
		this.getLayeredPane().add(hx1, Integer.MAX_VALUE);
		this.getLayeredPane().add(hx2, Integer.MAX_VALUE);
		this.getLayeredPane().add(hm1, Integer.MAX_VALUE);
		this.getLayeredPane().add(hm2, Integer.MAX_VALUE);
		this.getLayeredPane().add(hb1, Integer.MAX_VALUE);
		this.getLayeredPane().add(hb2, Integer.MAX_VALUE);
		this.getLayeredPane().add(hb3, Integer.MAX_VALUE);
		this.getLayeredPane().add(hb4, Integer.MAX_VALUE);
		this.getLayeredPane().add(hb5, Integer.MAX_VALUE);
		this.getLayeredPane().add(hb6, Integer.MAX_VALUE);
		this.getLayeredPane().add(hb7, Integer.MAX_VALUE);
		this.getLayeredPane().add(hb8, Integer.MAX_VALUE);
		this.setVisible(true);
		
		hw.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point point = hw.getLocation();
				if(x>=0&&x<=710&&y>=0&&y<=710) {
				x = e.getPoint().x + point.x;
				y = e.getPoint().y + point.y;
				if((x%100==0||y%100 ==0)&&e.getX()!=x&&e.getY()!=y)
					{					
					x= x/100*100;
					y = y/100*100;
					black += "King "+x+" "+y+"\n";
					}
				hw.setLocation(x, y);
				
				}}
			
		});
		hw.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				if(e.getClickCount()>=2)
					hw.setVisible(false);
			}
		});
		
		hh.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point point = hh.getLocation();
				if(x>=0&&x<=710&&y>=0&&y<=710) {
				x = e.getPoint().x + point.x;
				y = e.getPoint().y + point.y;
				if(x%100==0||y%100 ==0)
				{
				x= x/100*100;
				y = y/100*100;
				black += "Queen "+x+" "+y+"\n";
				}
			hh.setLocation(x, y);
			
			}}
				
				
		});
		hh.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				if(e.getClickCount()>=2)
					hh.setVisible(false);
			}
		});
		hm1.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point point = hm1.getLocation();
				if(x>=0&&x<=710&&y>=0&&y<=710) {
				hm1.setLocation(e.getPoint().x + point.x, e.getPoint().y + point.y);
				x = e.getPoint().x + point.x;
				y = e.getPoint().y + point.y;
				if(x%100==0||y%100 ==0)
				{
				x= x/100*100;
				y = y/100*100;
				black += "Knight "+x+" "+y+"\n";
				}
			hm1.setLocation(x, y);}
		}});
		hm1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				if(e.getClickCount()>=2)
					hm1.setVisible(false);
			}
		});
		hm2.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point point = hm2.getLocation();
				if(x>=0&&x<=710&&y>=0&&y<=710) {
				hm2.setLocation(e.getPoint().x + point.x, e.getPoint().y + point.y);
				x = e.getPoint().x + point.x;
				y = e.getPoint().y + point.y;
				if(x%100==0||y%100 ==0)
				{
				x= x/100*100;
				y = y/100*100;
				black += "Knight "+x+" "+y+"\n";
				}
			hm2.setLocation(x, y);}
		}});
		hm2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				if(e.getClickCount()>=2)
					hm2.setVisible(false);
			}
		});
		hx1.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point point = hx1.getLocation();
				if(x>=0&&x<=710&&y>=0&&y<=710) {
				hx1.setLocation(e.getPoint().x + point.x, e.getPoint().y + point.y);
				x = e.getPoint().x + point.x;
				y = e.getPoint().y + point.y;
				if(x%100==0||y%100 ==0)
				{
				x= x/100*100;
				y = y/100*100;
				black += "Bishop "+x+" "+y+"\n";
				}
			hx1.setLocation(x, y);}
		}});
		hx1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				if(e.getClickCount()>=2)
					hx1.setVisible(false);
			}
		});
		hx2.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point point = hx2.getLocation();
				if(x>=0&&x<=710&&y>=0&&y<=710) {
				hx2.setLocation(e.getPoint().x + point.x, e.getPoint().y + point.y);
				x = e.getPoint().x + point.x;
				y = e.getPoint().y + point.y;
				if(x%100==0||y%100 ==0)
				{
				x= x/100*100;
				y = y/100*100;
				black += "Bishop "+x+" "+y+"\n";
				}
			hx2.setLocation(x, y);}
		}});
		hx2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				if(e.getClickCount()>=2)
					hx2.setVisible(false);
			}
		});
		hc1.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point point = hc1.getLocation();
				if(x>=0&&x<=710&&y>=0&&y<=710) {
				hc1.setLocation(e.getPoint().x + point.x, e.getPoint().y + point.y);
				x = e.getPoint().x + point.x;
				y = e.getPoint().y + point.y;
				if(x%100==0||y%100 ==0)
				{
				x= x/100*100;
				y = y/100*100;
				black += "Rook "+x+" "+y+"\n";
				}
			hc1.setLocation(x, y);}
		}});
		hc1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				if(e.getClickCount()>=2)
					hc1.setVisible(false);
			}
		});
		hc2.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point point = hc2.getLocation();
				if(x>=0&&x<=710&&y>=0&&y<=710) {
				hc2.setLocation(e.getPoint().x + point.x, e.getPoint().y + point.y);
				x = e.getPoint().x + point.x;
				y = e.getPoint().y + point.y;
				if(x%100==0||y%100 ==0)
				{
				x= x/100*100;
				y = y/100*100;
				black += "Rook "+x+" "+y+"\n";
				}
			hc2.setLocation(x, y);}
		}});
		hc2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				if(e.getClickCount()>=2)
					hc2.setVisible(false);
			}
		});
		hb1.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point point = hb1.getLocation();
				if(x>=0&&x<=710&&y>=0&&y<=710) {
				hb1.setLocation(e.getPoint().x + point.x, e.getPoint().y + point.y);
				x = e.getPoint().x + point.x;
				y = e.getPoint().y + point.y;
				if(x%100==0||y%100 ==0)
				{
				x= x/100*100;
				y = y/100*100;
				black += "Pawn "+x+" "+y+"\n";
				}
			hb1.setLocation(x, y);}
		}});
		hb1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				if(e.getClickCount()>=2)
					hb1.setVisible(false);
			}
		});
		hb2.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point point = hb2.getLocation();
				if(x>=0&&x<=710&&y>=0&&y<=710) {
				hb2.setLocation(e.getPoint().x + point.x, e.getPoint().y + point.y);
				x = e.getPoint().x + point.x;
				y = e.getPoint().y + point.y;
				if(x%100==0||y%100 ==0)
				{
				x= x/100*100;
				y = y/100*100;
				black += "Pawn "+x+" "+y+"\n";
				}
			hb2.setLocation(x, y);}
		}});
		hb2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				if(e.getClickCount()>=2)
					hb2.setVisible(false);
			}
		});
		hb3.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point point = hb3.getLocation();
				if(x>=0&&x<=710&&y>=0&&y<=710) {
				hb3.setLocation(e.getPoint().x + point.x, e.getPoint().y + point.y);
				x = e.getPoint().x + point.x;
				y = e.getPoint().y + point.y;
				if(x%100==0||y%100 ==0)
				{
				x= x/100*100;
				y = y/100*100;
				black += "Pawn "+x+" "+y+"\n";
				}
			hb3.setLocation(x, y);}
		}});
		hb3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				if(e.getClickCount()>=2)
					hb3.setVisible(false);
			}
		});
		hb4.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point point = hb4.getLocation();
				if(x>=0&&x<=710&&y>=0&&y<=710) {
				hb4.setLocation(e.getPoint().x + point.x, e.getPoint().y + point.y);
				x = e.getPoint().x + point.x;
				y = e.getPoint().y + point.y;
				if(x%100==0||y%100 ==0)
				{
				x= x/100*100;
				y = y/100*100;
				black += "Pawn "+x+" "+y+"\n";
				}
			hb4.setLocation(x, y);}
		}});
		hb4.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				if(e.getClickCount()>=2)
					hb4.setVisible(false);
			}
		});
		hb5.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point point = hb5.getLocation();
				if(x>=0&&x<=710&&y>=0&&y<=710) {
				hb5.setLocation(e.getPoint().x + point.x, e.getPoint().y + point.y);
				x = e.getPoint().x + point.x;
				y = e.getPoint().y + point.y;
				if(x%100==0||y%100 ==0)
				{
				x= x/100*100;
				y = y/100*100;
				black += "Pawn "+x+" "+y+"\n";
				}
			hb5.setLocation(x, y);}
		}});
		hb5.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				if(e.getClickCount()>=2)
					hb5.setVisible(false);
			}
		});
		hb6.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point point = hb6.getLocation();
				if(x>=0&&x<=710&&y>=0&&y<=710) {
				hb6.setLocation(e.getPoint().x + point.x, e.getPoint().y + point.y);
				x = e.getPoint().x + point.x;
				y = e.getPoint().y + point.y;
				if(x%100==0||y%100 ==0)
				{
				x= x/100*100;
				y = y/100*100;
				black += "Pawn "+x+" "+y+"\n";
				}
			hb6.setLocation(x, y);}
		}});
		hb6.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				if(e.getClickCount()>=2)
					hb6.setVisible(false);
			}
		});
		hb7.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point point = hb7.getLocation();
				if(x>=0&&x<=710&&y>=0&&y<=710) {
				hb7.setLocation(e.getPoint().x + point.x, e.getPoint().y + point.y);
				x = e.getPoint().x + point.x;
				y = e.getPoint().y + point.y;
				if(x%100==0||y%100 ==0)
				{
				x= x/100*100;
				y = y/100*100;
				black += "Pawn "+x+" "+y+"\n";
				}
			hb7.setLocation(x, y);}
		}});
		hb7.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				if(e.getClickCount()>=2)
					hb7.setVisible(false);
			}
		});
		hb8.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point point = hb8.getLocation();
				if(x>=0&&x<=710&&y>=0&&y<=710) {
				hb8.setLocation(e.getPoint().x + point.x, e.getPoint().y + point.y);
				x = e.getPoint().x + point.x;
				y = e.getPoint().y + point.y;
				if(x%100==0||y%100 ==0)
				{
				x= x/100*100;
				y = y/100*100;
				black += "Pawn "+x+" "+y+"\n";
				}
			hb8.setLocation(x, y);}
		}});
		hb8.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				if(e.getClickCount()>=2)
					hb8.setVisible(false);
			}
		});
		bw.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point point = bw.getLocation();
				//if(x>=0&&x<=710&&y>=0&&y<=710) {
				bw.setLocation(e.getPoint().x + point.x, e.getPoint().y + point.y);
				x = e.getPoint().x + point.x;
				y = e.getPoint().y + point.y;
				if(x%100==0||y%100 ==0)
				{
				x= x/100*100;
				y = y/100*100;
				black += "King "+x+" "+y+"\n";
				}
			bw.setLocation(x, y);//}
		}});
		bw.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				if(e.getClickCount()>=2)
					bw.setVisible(false);
			}
		});
		bh.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point point = bh.getLocation();
				//if(x>=0&&x<=710&&y>=0&&y<=710) {
				bh.setLocation(e.getPoint().x + point.x, e.getPoint().y + point.y);
				x = e.getPoint().x + point.x;
				y = e.getPoint().y + point.y;
				if(x%100==0||y%100 ==0)
				{
				x= x/100*100;
				y = y/100*100;
				black += "Queen "+x+" "+y+"\n";
				}
			bh.setLocation(x, y);//}
		}});
		bh.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				if(e.getClickCount()>=2)
					bh.setVisible(false);
			}
		});
		bm1.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point point = bm1.getLocation();
				//if(x>=0&&x<=710&&y>=0&&y<=710) {
				bm1.setLocation(e.getPoint().x + point.x, e.getPoint().y + point.y);
				x = e.getPoint().x + point.x;
				y = e.getPoint().y + point.y;
				if(x%100==0||y%100 ==0)
				{
				x= x/100*100;
				y = y/100*100;
				black += "Knight "+x+" "+y+"\n";
				}
			bm1.setLocation(x, y);//}
		}});
		bm1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				if(e.getClickCount()>=2)
					bm1.setVisible(false);
			}
		});
		bm2.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point point = bm2.getLocation();
				//if(x>=0&&x<=710&&y>=0&&y<=710) {
				bm2.setLocation(e.getPoint().x + point.x, e.getPoint().y + point.y);
				x = e.getPoint().x + point.x;
				y = e.getPoint().y + point.y;
				if(x%100==0||y%100 ==0)
				{
				x= x/100*100;
				y = y/100*100;
				black += "Knight "+x+" "+y+"\n";
				}
			bm2.setLocation(x, y);//}
		}});
		bm2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				if(e.getClickCount()>=2)
					bm2.setVisible(false);
			}
		});
		bx1.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point point = bx1.getLocation();
				//if(x>=0&&x<=710&&y>=0&&y<=710) {
				bx1.setLocation(e.getPoint().x + point.x, e.getPoint().y + point.y);
				x = e.getPoint().x + point.x;
				y = e.getPoint().y + point.y;
				if(x%100==0||y%100 ==0)
				{
				x= x/100*100;
				y = y/100*100;
				black += "Bishop "+x+" "+y+"\n";
				}
			bx1.setLocation(x, y);//}
		}});
		bx1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				if(e.getClickCount()>=2)
					bx1.setVisible(false);
			}
		});
		bx2.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point point = bx2.getLocation();
				//if(x>=0&&x<=710&&y>=0&&y<=710) {
				bx2.setLocation(e.getPoint().x + point.x, e.getPoint().y + point.y);
				x = e.getPoint().x + point.x;
				y = e.getPoint().y + point.y;
				if(x%100==0||y%100 ==0)
				{
				x= x/100*100;
				y = y/100*100;
				black += "Bishop "+x+" "+y+"\n";
				}
			bx2.setLocation(x, y);//}
		}});
		bx2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				if(e.getClickCount()>=2)
					bx2.setVisible(false);
			}
		});
		bc1.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point point = bc1.getLocation();
				//if(x>=0&&x<=710&&y>=0&&y<=710) {
				bc1.setLocation(e.getPoint().x + point.x, e.getPoint().y + point.y);
				x = e.getPoint().x + point.x;
				y = e.getPoint().y + point.y;
				if(x%100==0||y%100 ==0)
				{
				x= x/100*100;
				y = y/100*100;
				black += "Rook "+x+" "+y+"\n";
				}
			bc1.setLocation(x, y);//}
		}});
		bc1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				if(e.getClickCount()>=2)
					bc1.setVisible(false);
			}
		});
		bc2.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point point = bc2.getLocation();
				//if(x>=0&&x<=710&&y>=0&&y<=710) {
				bc2.setLocation(e.getPoint().x + point.x, e.getPoint().y + point.y);
				x = e.getPoint().x + point.x;
				y = e.getPoint().y + point.y;
				if(x%100==0||y%100 ==0)
				{
				x= x/100*100;
				y = y/100*100;
				black += "Rook "+x+" "+y+"\n";
				}
			bc2.setLocation(x, y);//}
		}});
		bc2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				if(e.getClickCount()>=2)
					bc2.setVisible(false);
			}
		});
		bb1.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point point = bb1.getLocation();
				//if(x>=0&&x<=710&&y>=0&&y<=710) {
				bb1.setLocation(e.getPoint().x + point.x, e.getPoint().y + point.y);
				x = e.getPoint().x + point.x;
				y = e.getPoint().y + point.y;
				if(x%100==0||y%100 ==0)
				{
				x= x/100*100;
				y = y/100*100;
				black += "Pawn "+x+" "+y+"\n";
				}
			bb1.setLocation(x, y);//}
		}});
		bb1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				if(e.getClickCount()>=2)
					bb1.setVisible(false);
			}
		});
		bb2.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point point = bb2.getLocation();
				//if(x>=0&&x<=710&&y>=0&&y<=710) {
				bb2.setLocation(e.getPoint().x + point.x, e.getPoint().y + point.y);
				x = e.getPoint().x + point.x;
				y = e.getPoint().y + point.y;
				if(x%100==0||y%100 ==0)
				{
				x= x/100*100;
				y = y/100*100;
				black += "Pawn "+x+" "+y+"\n";
				}
			bb2.setLocation(x, y);//}
		}});
		bb2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				if(e.getClickCount()>=2)
					bb2.setVisible(false);
			}
		});
		bb3.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point point = bb3.getLocation();
				//if(x>=0&&x<=710&&y>=0&&y<=710) {
				bb3.setLocation(e.getPoint().x + point.x, e.getPoint().y + point.y);
				x = e.getPoint().x + point.x;
				y = e.getPoint().y + point.y;
				if(x%100==0||y%100 ==0)
				{
				x= x/100*100;
				y = y/100*100;
				black += "Pawn "+x+" "+y+"\n";
				}
			bb3.setLocation(x, y);//}
		}});
		bb3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				if(e.getClickCount()>=2)
					bb3.setVisible(false);
			}
		});
		bb4.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point point = bb4.getLocation();
				//if(x>=0&&x<=710&&y>=0&&y<=710) {
				bb4.setLocation(e.getPoint().x + point.x, e.getPoint().y + point.y);
				x = e.getPoint().x + point.x;
				y = e.getPoint().y + point.y;
				if(x%100==0||y%100 ==0)
				{
				x= x/100*100;
				y = y/100*100;
				black += "Pawn "+x+" "+y+"\n";
				}
			bb4.setLocation(x, y);//}
		}});
		bb4.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				if(e.getClickCount()>=2)
					bb4.setVisible(false);
			}
		});
		bb5.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point point = bb5.getLocation();
				//if(x>=0&&x<=710&&y>=0&&y<=710) {
				bb5.setLocation(e.getPoint().x + point.x, e.getPoint().y + point.y);
				x = e.getPoint().x + point.x;
				y = e.getPoint().y + point.y;
				if(x%100==0||y%100 ==0)
				{
				x= x/100*100;
				y = y/100*100;
				black += "Pawn "+x+" "+y+"\n";
				}
			bb5.setLocation(x, y);//}
		}});
		bb5.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				if(e.getClickCount()>=2)
					bb5.setVisible(false);
			}
		});
		bb6.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point point = bb6.getLocation();
				//if(x>=0&&x<=710&&y>=0&&y<=710) {
				bb6.setLocation(e.getPoint().x + point.x, e.getPoint().y + point.y);
				x = e.getPoint().x + point.x;
				y = e.getPoint().y + point.y;
				if(x%100==0||y%100 ==0)
				{
				x= x/100*100;
				y = y/100*100;
				black += "Pawn "+x+" "+y+"\n";
				}
			bb6.setLocation(x, y);//}
		}});
		bb6.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				if(e.getClickCount()>=2)
					bb6.setVisible(false);
			}
		});
		bb7.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point point = bb7.getLocation();
				//if(x>=0&&x<=710&&y>=0&&y<=710) {
				bb7.setLocation(e.getPoint().x + point.x, e.getPoint().y + point.y);
				x = e.getPoint().x + point.x;
				y = e.getPoint().y + point.y;
				if(x%100==0||y%100 ==0)
				{
				x= x/100*100;
				y = y/100*100;
				black += "Pawn "+x+" "+y+"\n";
				}
			bb7.setLocation(x, y);//}
		}});
		bb7.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				if(e.getClickCount()>=2)
					bb7.setVisible(false);
			}
		});
		bb8.addMouseMotionListener(new MouseAdapter() {
			public void mouseDragged(MouseEvent e) {
				Point point = bb8.getLocation();
				//if(x>=0&&x<=1&&y>=0&&y<=710) {
				bb8.setLocation(e.getPoint().x + point.x, e.getPoint().y + point.y);
				x = e.getPoint().x + point.x;
				y = e.getPoint().y + point.y;
				if(x%100==0||y%100 ==0)
				{
				x= x/100*100;
				y = y/100*100;
				black += "Pawn "+x+" "+y+"\n";
				}
			bb8.setLocation(x, y);//}
		}});
		bb8.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e)
			{
				if(e.getClickCount()>=2)
					bb8.setVisible(false);
			}
		});
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getClickCount()==2)
			black+=e.getX()+" "+e.getY()+"\n";
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		black+=e.getX()+" "+e.getY()+"\n";
		}
        

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	class OpenJFrame extends JFrame {
		public  OpenJFrame() {						
			JTextArea ta =    new JTextArea(20, 50);
			ta.append("黑棋\n");
			ta.append(black);
			ta.append("白棋\n");
			ta.append(white);
			add(ta);
			validate();
			this.setSize(380, 245);
			// 设置此窗口永远为最上方 是window的方法
			this.setAlwaysOnTop(true);			
			this.setResizable(true);			
			this.setLocationRelativeTo(null);
			this.setTitle("历史纪录");
			this.setVisible(true);
			new Go();
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		add(button);
		add(button0);
		button.setBounds(10, 5, 60, 26);
		button0.setBounds(200, 5, 60, 26);
		Button eventobj = (Button) e.getSource();
		String labelname = eventobj.getLabel();
		System.out.println(labelname);
		if ("历史纪录".equals(labelname)) {
			this.setVisible(false);
			new OpenJFrame();
		} else if ("重新开局".equals(labelname)) {
			this.setVisible(false);
			new Go();
			black = new String();
			white = new String();
		}

	}
}
