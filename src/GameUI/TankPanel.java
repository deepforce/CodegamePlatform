package GameUI;

import MyImageProcess.MyImageProcess;
import Serve.Communication;
import Spirit.Tank;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

/**
 * Created by Administrator on 2016/11/24 0024.
 */
public class TankPanel extends JPanel {

    BufferedImage tankImage,tImg;
    MyImageProcess myImgPro;
    long t_start,t_end;
    Tank[] tank;
    boolean[] change=new boolean[2];

    public TankPanel()
    {
        setBackground(new Color(255,255,255));
        setPreferredSize(new Dimension(900,600));
        LoadImage();
        tank=new Tank[2];
        tank[0]=new Tank(0,tankImage,0,0);
        tank[1]=new Tank(1,tankImage,450,300);
        TimeThread thread=new TimeThread(50);
        thread.start();
    }

    public void LoadImage()
    {
        myImgPro=new MyImageProcess();
        tankImage=myImgPro.zoomImage("src/image/tank.png",80,80);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        DrawTank(g);
    }

    public void DrawTank(Graphics g)
    {
        for(int i=0;i<tank.length;i++)
        {
            tImg=myImgPro.rotateImage(tank[i].getImage(),tank[i].getAngle());
            g.drawImage(tImg,tank[i].getPos().x,tank[i].getPos().y,this);
        }
    }

    public void UpdataTank(List<String> tanks)
    {
        String ts;
        String[] strings;
        for(int i=0;i<tanks.size();i++)
        {
            ts=tanks.get(i);
            strings=ts.split(" ");
            if(!change[Integer.parseInt(strings[0])])
            {
                tank[Integer.parseInt(strings[0])].UpdateTank(ts,tank);
                change[Integer.parseInt(strings[0])]=true;
            }
        }
    }

    /*
    计时器线程
    @param time 刷新时间间隔
     */
    public class TimeThread extends Thread
    {
        Communication serve;
        int time;
        public TimeThread(int t)
        {
            super();
            time=t;
            serve=new Communication();
            Thread thread=new Thread(serve);
            thread.start();
        }

        public void run()
        {
            while(true)
            {
                t_start=System.currentTimeMillis();
                UpdataTank(serve.getTankData());
                serve.EmptyTankData();
                repaint();
                for(int i=0;i<change.length;i++)
                    change[i]=false;
                t_end=System.currentTimeMillis();
                try
                {
                    if(t_end-t_start<time) sleep(time-(t_end-t_start));
                }catch(Exception e)
                {
                    System.out.println(e);
                }
            }
        }
    }

}
