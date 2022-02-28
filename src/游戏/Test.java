package 游戏;


import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class  Test extends Frame {
    public static void main(String[] args){
        Test first=new Test("FristFrame");//设置窗口名//first.setTitle("这是一个测试");和直接传参一样。
        first.setSize(300,300);//设置窗口大小
        first.setBackground(Color.blue);//设置窗口背景颜色
        first.setLocation(700,300);//设置窗口的位置   **first.setBounds();是.setSize(和setLocation(的结合

        first.setResizable(true);//设置窗口为可任意拉伸
        first.setVisible(true);//设置窗口为可见
        first.setLayout(null);//取消布局管理器
        Panel pan=new Panel();

        pan.setBackground(Color.BLACK);//面板颜色
        pan.setSize(200,100);//面板大小
        pan.setLocation(500,300);//设置面板位置
        first.add(pan);//在窗口内实现面板
        Insets ne=new Insets(10,20,10,20);

        Button button=new Button("测试");

        button.setPreferredSize(new Dimension(100,200));
        pan.add(button);
        first.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {//Lamdbe方法重写：获取鼠标点击关闭事件执行结束
                System.exit(0);
            }
        });//System.exit(0);结束虚拟机。
        snk ss=new snk();


    }
    public Test(String fl){
        super(fl);//调用父类构造方法
    }
}

