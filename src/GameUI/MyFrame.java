package GameUI;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Administrator on 2016/10/7 0007.
 */
public class MyFrame extends JFrame {
    public TankPanel mypanel;

    public static void main(String[] args) {

        MyFrame myframe=new MyFrame();
        myframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myframe.setVisible(true);
    }

    public MyFrame()
    {
        setTitle("RPG Game");
        mypanel=new TankPanel();
        Container contentPanel=getContentPane();
        contentPanel.add(mypanel);
        pack(); //依据你放置的组件设定窗口的大小 使之正好能容纳你放置的所有组件
    }
}
