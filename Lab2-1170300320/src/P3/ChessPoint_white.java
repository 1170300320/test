package P3;

//���𴴽���ɫ���ӵ���
import java.awt.*;
import java.awt.event.*;

@SuppressWarnings("serial")
class ChessPoint_white extends Piece implements MouseListener {
	ChessPad chesspad = null;

	ChessPoint_white(ChessPad p) {
		setSize(20, 20);
		chesspad = p;
		addMouseListener(this);
	}

//�������ӵĴ�С
	public void paint(Graphics g) {
		g.setColor(Color.white);
		g.fillOval(0, 0, 20, 20);
	}

	@SuppressWarnings("deprecation")
	public void mousePressed(MouseEvent e) {
		if (e.getModifiers() == InputEvent.BUTTON3_MASK) {
			chesspad.remove(this);
			chesspad.������ɫ = -1;
			chesspad.text_2.setText("���������");
			chesspad.text_1.setText(null);
		}
	}

	public void mouseReleased(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent e) {
		if (e.getClickCount() >= 2)
			chesspad.remove(this);
	}
}
