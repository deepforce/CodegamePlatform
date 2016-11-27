package MyImageProcess;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;

/**
 * Created by Administrator on 2016/11/24 0024.
 */
public class MyImageProcess{
    public MyImageProcess() {}

    public BufferedImage rotateImage(BufferedImage bufferedimage,int angle) {
        int w = bufferedimage.getWidth();
        int h = bufferedimage.getHeight();
        int type = bufferedimage.getColorModel().getTransparency();
        int a=Math.abs(angle%90);
        int mymax=Math.max(w,h);
        int padding = mymax/4;
        int nw=(int)(mymax*Math.cos(Math.toRadians(a))+mymax*Math.cos(Math.toRadians(90-a)))+padding;
        BufferedImage img;
        Graphics2D graphics2d;
        (graphics2d = (img = new BufferedImage(nw, nw, type))
                .createGraphics()).setRenderingHint(
                RenderingHints.KEY_INTERPOLATION,
                RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        graphics2d.rotate(Math.toRadians(angle), w/2+padding, h/2+padding);
        graphics2d.drawImage(bufferedimage, padding, padding, null);
        graphics2d.dispose();

        return img;
    }

    public BufferedImage zoomImage(String s,int w,int h) {
        BufferedImage tempImage;
        BufferedImage result;
        try {
            tempImage = ImageIO.read(new FileInputStream(s));
            int imgHeight = tempImage.getHeight();//取得图片的长和宽
            int imgWidth = tempImage.getWidth();
            int c = tempImage.getRGB(3, 3);
            result = new BufferedImage(w,
                    h, BufferedImage.TYPE_4BYTE_ABGR);
            for(int i = 0; i < imgWidth; ++i)//把原图片的内容复制到新的图片，同时把背景设为透明
            {
                for(int j = 0; j < imgHeight; ++j)
                {
                    if(tempImage.getRGB(i, j) == c)
                        result.setRGB(i, j, c & 0x00ffffff);//这里把背景设为透明
                    else
                        result.setRGB(i, j, tempImage.getRGB(i, j));
                }
            }
            result.getGraphics().drawImage(tempImage.getScaledInstance(w,
                    h, Image.SCALE_SMOOTH), 0, 0, null);
            return result;
        } catch(Exception e)
        {
            System.out.println("Load Image Error");
        }
        return null;
    }
}
