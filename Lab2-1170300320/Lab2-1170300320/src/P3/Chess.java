package P3;

import java.awt.*;
import java.awt.event.*;

//棋盘的载体窗口类
@SuppressWarnings("serial")
public class Chess extends Frame {
	ChessPad chesspad = new ChessPad();
	Chess() {
		setVisible(true);
		setLayout(null);
		Label label = new Label("单机左键下棋子，吃棋子双击，用右键击棋子悔棋", Label.CENTER);
		add(label);
		label.setBounds(70, 55, 440, 26);
		label.setBackground(Color.orange);
		add(chesspad);
		chesspad.setBounds(70, 90, 440, 440);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		pack();
		setSize(600, 550);
	}
}