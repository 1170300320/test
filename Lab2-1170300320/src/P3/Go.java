package P3;

import java.awt.*;

//棋盘的载体窗口类
@SuppressWarnings("serial")
public class Go extends Frame {
	GoPad gopad = new GoPad();
    public static void main(String[] args)
{
	new Go();
}
}
