package gm.games;

import gm.util.UrlUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.image.ImageProducer;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;


public class SnakeJFrame {
    public JFrame snakeJFrame() {
        JFrame jFrame = new JFrame("贪吃蛇");
        //框架大小
        jFrame.setSize(950,792);
        //屏幕位置
        jFrame.setLocationRelativeTo(null);
        jFrame.add(new SnakeJPanel());
        //是否可见
        jFrame.setVisible(true);
        //是否可拉伸
        jFrame.setResizable(false);

        /*
         * Toolkit.getDefaultToolkit().createImage()   获取像素数据图像对象
         * 类名.class.getResource()   通过相对路径的方式获取文件URL
         */

        //SnakeJFrame.class.getResource(imagePath)
        URL url = new UrlUtil().getUrl("蛇.png");
        Image frame_icon=Toolkit.getDefaultToolkit().createImage(url);
        //设置jFrame的icon图标
        jFrame.setIconImage(frame_icon);
        //退出
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        return jFrame;
    }
}
