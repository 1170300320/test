package P3;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.JTextArea;

//�������̵���
@SuppressWarnings("serial")
class ChessPad extends Board implements MouseListener, ActionListener {
	int x = -1, y = -1, ������ɫ = 1;
	Button button = new Button("���¿���");
	Button button0 = new Button("��ʷ��¼");
	TextField text_1 = new TextField("�����1����");
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

//����Χ�����̵����
	public void paint(Graphics g) {
		for (int i = 40; i <= 400; i += 20) {
			g.drawLine(40, i, 400, i);
		}
		for (int j = 40; j <= 400; j += 20) {
			g.drawLine(j, 40, j, 400);
		}
//���С��
		g.fillOval(97, 97, 6, 6);
		g.fillOval(97, 337, 6, 6);
		g.fillOval(337, 97, 6, 6);
		g.fillOval(337, 337, 6, 6);
		g.fillOval(217, 217, 6, 6);
	}

//�����������������¼�
	@SuppressWarnings("deprecation")
	public void mousePressed(MouseEvent e) {
		if (e.getModifiers() == InputEvent.BUTTON1_MASK) {
//��ȡ��갴��ʱ������
			x = (int) e.getX();
			y = (int) e.getY();
//�����������ӣ���ɫ���Ӻͺ�ɫ����
			ChessPoint_black chesspoint_black = new ChessPoint_black(this);
			ChessPoint_white chesspoint_white = new ChessPoint_white(this);

			int a = (x + 10) / 20, b = (y + 10) / 20;
//����λ�ó������̣���������
			if (x / 20 < 2 || y / 20 < 2 || x / 20 > 19 || y / 20 > 19) {
			} else {
				if (������ɫ == 1) {
					ahistory += x + " " + y + "\n";
					this.add(chesspoint_black);
					chesspoint_black.setBounds(a * 20 - 10, b * 20 - 10, 20, 20);
					������ɫ = ������ɫ * (-1);
					text_1.setText(null);
					text_2.setText("���������");
				} else if (������ɫ == -1) {
					bhistory += x + " " + y + "\n";
					this.add(chesspoint_white);
					chesspoint_white.setBounds(a * 20 - 10, b * 20 - 10, 20, 20);
					������ɫ = ������ɫ * (-1);
					text_1.setText("���������");
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

//��Ӧbutton �¼�
	public void actionPerformed(ActionEvent e) {
		this.removeAll();
		������ɫ = 1;
		add(button);
		add(button0);
		button.setBounds(10, 5, 60, 26);
		button0.setBounds(200, 5, 60, 26);
		add(text_1);
		text_1.setBounds(90, 5, 90, 24);
		add(text_2);
		text_2.setBounds(290, 5, 90, 24);
		text_1.setText("���º���");
		text_2.setText(null);
		Button eventobj = (Button) e.getSource();
		String labelname = eventobj.getLabel();
		if ("��ʷ��¼".equals(labelname)) {
			new OpenJFrame();
		} else if ("���¿���".equals(labelname)) {
			ahistory = new String();
			bhistory = new String();
		}
	}
//������ʷ��¼�����¼�
	class OpenJFrame extends JFrame {
		public OpenJFrame() {
			JTextArea ta = new JTextArea(20, 50);
			ta.append("����\n");
			ta.append(ahistory);
			ta.append("����\n");
			ta.append(bhistory);
			add(ta);
			validate();
			this.setSize(380, 245);
//���ô˴�����ԶΪ���Ϸ� ��window�ķ���
			this.setAlwaysOnTop(true);
//�������û��ı䴰�ڵĴ�С
			this.setResizable(true);
//�ô�������Ļ�����м���ʾ
			this.setLocationRelativeTo(null);
			this.setTitle("��ʷ��¼");
			this.setVisible(true);
		}
	}

}
