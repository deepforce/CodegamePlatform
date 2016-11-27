package Serve;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * Created by Administrator on 2016/10/9 0009.
 */
public class Communication implements Runnable{
    private static int BYTESIZE=100;

    DatagramSocket dSocket;
    DatagramPacket inPacket,outPacket;
    InetAddress cAddr;
    List<String> tank_datas;
    int cPort;
    byte[] inBuffer;
    byte[] outBuffer;
    String s;

    public Communication()
    {
        Init();
    }

    public void Init()
    {

        inBuffer=new byte[BYTESIZE];
        tank_datas=new ArrayList<>();
    }

    public List<String> getTankData()
    {
        return tank_datas;
    }

    public void EmptyTankData(){
        if(!tank_datas.isEmpty())
            tank_datas.clear();
    }

    public void run()
    {
        myconnect();
    }

    public void myconnect()
    {
        try
        {
            dSocket=new DatagramSocket(8000);
            while(true)
            {
                inPacket=new DatagramPacket(inBuffer,inBuffer.length);
                dSocket.receive(inPacket);
                cAddr=inPacket.getAddress();
                cPort=inPacket.getPort();
                s=new String(inPacket.getData(),0,inPacket.getLength());
                tank_datas.add(s);

                Date date=new Date();
                outBuffer=date.toString().getBytes();
                outPacket=new DatagramPacket(outBuffer,outBuffer.length,cAddr,cPort);
                dSocket.send(outPacket);
            }
        }
        catch(Exception e)
        {
            System.out.println("UDP connect Error");
        }
    }

}
