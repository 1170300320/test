package P3;
import java.awt.*;
import java.awt.event.*;
//���𴴽���ɫ���ӵ���
@SuppressWarnings("serial")
class ChessPoint_black extends Piece implements MouseListener
{
ChessPad chesspad=null;
ChessPoint_black(ChessPad p)
{
setSize(20,20);
chesspad=p;
addMouseListener(this);
}
//�������ӵĴ�С
public void paint(Graphics g)
{
g.setColor(Color.black);
g.fillOval(0,0,20,20);
}
@SuppressWarnings("deprecation")
public void mousePressed(MouseEvent e)
{
if(e.getModifiers()==InputEvent.BUTTON3_MASK)
{
chesspad.remove(this);
chesspad.������ɫ=1;
chesspad.text_2.setText(null);
chesspad.text_1.setText("���������");
}
}
public void mouseReleased(MouseEvent e){}
public void mouseEntered(MouseEvent e){}
public void mouseExited(MouseEvent e){}
public void mouseClicked(MouseEvent e)
{
if(e.getClickCount()>=2)
chesspad.remove(this);
}
}

