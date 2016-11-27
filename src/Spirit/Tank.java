package Spirit;

import values.StaticTankData;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.List;

/**
 * Created by Administrator on 2016/11/24 0024.
 */
public class Tank {
    private BufferedImage bufferedImage;
    private int speed,gun_power,angle,padding,life,id;
    private Point pos;
    private boolean hitwall;
    public Tank(int i,BufferedImage bImag,int posx,int posy)
    {
        id=i;
        bufferedImage= bImag;
        pos=new Point(posx,posy);
        speed=0;
        angle=0;
        gun_power=0;
        life=100;
        hitwall=false;
        int mymax=Math.max(bufferedImage.getHeight(),bufferedImage.getWidth());
        padding=mymax/4;
    }

    public void move(int s)
    {
        if(s> StaticTankData.MAX_SPEED) speed=StaticTankData.MAX_SPEED;
        else if(s<-StaticTankData.MAX_SPEED) speed=-StaticTankData.MAX_SPEED;
        else speed=s;
    }

    public void turn(int a)
    {
        if(a>StaticTankData.MAX_ANGLE) angle+=StaticTankData.MAX_ANGLE;
        else if(a<-StaticTankData.MAX_ANGLE) angle-=StaticTankData.MAX_ANGLE;
        else angle+=a;
    }

    public void fire(int power)
    {
        if(power<0) gun_power=0;
        else if(power>StaticTankData.MAX_POWER) gun_power=StaticTankData.MAX_POWER;
        else gun_power=power;
    }

    public void UpdateTank(String s, Tank[] t)
    {
        String[] ts=s.split(" ");
        move(Integer.parseInt(ts[1]));
        turn(Integer.parseInt(ts[2]));
        fire(Integer.parseInt(ts[3]));
        domove(t);
    }

    public Point getPos()
    {
        return pos;
    }

    public int getLife()
    {
        return life;
    }

    public int getAngle(){
        return angle;
    }

    public int getId(){return id;}

    public BufferedImage getImage()
    {
        return bufferedImage;
    }

    public boolean Hit_Wall()
    {
        return hitwall;
    }

    public void domove(Tank[] tank)
    {
        double x=pos.x+speed*Math.cos(Math.toRadians(angle));
        double y=pos.y+speed*Math.sin(Math.toRadians(angle));
        double tw=StaticTankData.GAME_WIDTH-StaticTankData.TANK_WIDTH-StaticTankData.GAME_PAD;
        double th=StaticTankData.GAME_HIGHT-StaticTankData.TANK_HIGHT-StaticTankData.GAME_PAD;
        for(int i=0;i<tank.length;i++)
        {
            if(id==tank[i].getId()) continue;
            if(Math.abs(x-tank[i].getPos().x)<StaticTankData.TANK_WIDTH
                    &&Math.abs(y-tank[i].getPos().y)<StaticTankData.TANK_HIGHT)
            {
                return;
            }

        }
        if(x>=StaticTankData.GAME_PAD&&x<=tw&&y>=StaticTankData.GAME_PAD&&y<=th)
        {
            pos.x=(int)(x+0.5);
            pos.y=(int)(y+0.5);
            hitwall=false;
        }
        else {
            hitwall=true;
            if (x < StaticTankData.GAME_PAD) {
                pos.x = StaticTankData.GAME_PAD;
            } else if(x>tw){
                pos.x = (int)(tw+0.5);
            }
            if (y<StaticTankData.GAME_PAD)
            {
                pos.y=StaticTankData.GAME_PAD;
            }else if(y>th){
                pos.y=(int)(th+0.5);
            }
        }
        speed=0;
    }
}
