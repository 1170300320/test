package P3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JTextArea;

//创建棋盘的类
@SuppressWarnings("serial")
class ChessPad extends Board implements MouseListener, ActionListener {
	int x = -1, y = -1, 棋子颜色 = 1;
	Button button = new Button("重新开局");
	Button button0 = new Button("历史纪录");
	TextField text_1 = new TextField("请玩家1下棋");
	TextField text_2 = new TextField();
	String ahistory = new String();
	String bhistory = new String();

	ChessPad() {
		setSize(440, 440);
		setLayout(null);
		setBackground(Color.orange);
		addMouseListener(this);
		add(button);
		add(button0);
		button.setBounds(10, 5, 60, 26);
		button0.setBounds(200, 5, 60, 26);
		button.addActionListener(this);
		button0.addActionListener(this);
		add(text_1);
		text_1.setBounds(90, 5, 90, 24);
		add(text_2);
		text_2.setBounds(290, 5, 90, 24);
		text_1.setEditable(false);
		text_2.setEditable(false);

	}

//绘制围棋棋盘的外观
	public void paint(Graphics g) {
		for (int i = 40; i <= 400; i += 20) {
			g.drawLine(40, i, 400, i);
		}
		for (int j = 40; j <= 400; j += 20) {
			g.drawLine(j, 40, j, 400);
		}
//五个小点
		g.fillOval(97, 97, 6, 6);
		g.fillOval(97, 337, 6, 6);
		g.fillOval(337, 97, 6, 6);
		g.fillOval(337, 337, 6, 6);
		g.fillOval(217, 217, 6, 6);
	}

//按下鼠标左键下棋子事件
	@SuppressWarnings("deprecation")
	public void mousePressed(MouseEvent e) {
		if (e.getModifiers() == InputEvent.BUTTON1_MASK) {
//获取鼠标按下时的坐标
			x = (int) e.getX();
			y = (int) e.getY();
//定义两颗棋子，白色棋子和黑色棋子
			ChessPoint_black chesspoint_black = new ChessPoint_black(this);
			ChessPoint_white chesspoint_white = new ChessPoint_white(this);

			int a = (x + 10) / 20, b = (y + 10) / 20;
//鼠标的位置超出棋盘，则不下棋子
			if (x / 20 < 2 || y / 20 < 2 || x / 20 > 19 || y / 20 > 19) {
			} else {
				if (棋子颜色 == 1) {
					ahistory += x + " " + y + "\n";
					this.add(chesspoint_black);
					chesspoint_black.setBounds(a * 20 - 10, b * 20 - 10, 20, 20);
					棋子颜色 = 棋子颜色 * (-1);
					text_1.setText(null);
					text_2.setText("请白棋下子");
				} else if (棋子颜色 == -1) {
					bhistory += x + " " + y + "\n";
					this.add(chesspoint_white);
					chesspoint_white.setBounds(a * 20 - 10, b * 20 - 10, 20, 20);
					棋子颜色 = 棋子颜色 * (-1);
					text_1.setText("请黑棋下子");
					text_2.setText(null);
				}
			}
		}
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
	}

//响应button 事件
	public void actionPerformed(ActionEvent e) {
		this.removeAll();
		棋子颜色 = 1;
		add(button);
		add(button0);
		button.setBounds(10, 5, 60, 26);
		button0.setBounds(200, 5, 60, 26);
		add(text_1);
		text_1.setBounds(90, 5, 90, 24);
		add(text_2);
		text_2.setBounds(290, 5, 90, 24);
		text_1.setText("请下黑棋");
		text_2.setText(null);
		Button eventobj = (Button) e.getSource();
		String labelname = eventobj.getLabel();
		if ("历史纪录".equals(labelname)) {
			new OpenJFrame();
		} else if ("重新开局".equals(labelname)) {
			ahistory = new String();
			bhistory = new String();
		}
	}
//弹出历史纪录窗口事件
	class OpenJFrame extends JFrame {
		public OpenJFrame() {
			JTextArea ta = new JTextArea(20, 50);
			ta.append("黑棋\n");
			ta.append(ahistory);
			ta.append("白棋\n");
			ta.append(bhistory);
			add(ta);
			validate();
			this.setSize(380, 245);
//设置此窗口永远为最上方 是window的方法
			this.setAlwaysOnTop(true);
//不允许用户改变窗口的大小
			this.setResizable(true);
//让窗口在屏幕的正中间显示
			this.setLocationRelativeTo(null);
			this.setTitle("历史纪录");
			this.setVisible(true);
		}
	}

}
