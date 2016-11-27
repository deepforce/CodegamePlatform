package Spirit;

import java.awt.*;

/**
 * Created by Administrator on 2016/11/24 0024.
 */
public class Bullet {
    private double power;
    private int angle;
    private double speed;
    private Point pos;

    public Bullet(int x,int y,double p,int a)
    {
        pos.x=x;
        pos.y=y;
        power=p;
        angle=a;
        speed=2/p;
    }

    public void move()
    {
        pos.x+=speed*Math.cos(Math.toRadians(angle));
        pos.y+=speed*Math.sin(Math.toRadians(angle));
    }

    public Point getPos()
    {
        return pos;
    }
}
