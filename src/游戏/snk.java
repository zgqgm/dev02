package 游戏;
import java.awt.Color;//颜色
import java.awt.font.*;//字体
import java.awt.Graphics;//绘制2D图
import java.awt.event.KeyEvent;//按键触发事件**类**
import java.awt.event.KeyListener;//接收按键触发事件**接口**
import java.awt.event.ActionEvent;//指示发生了组件定义的动作的语义事件。（根据按键事件做出相应指示动作）**类**
import java.awt.event.ActionListener;//接收操作事件的侦听器接口。**接口**

import java.util.Random;//产生随机数

import javax.swing.ImageIcon;//根据 Image 绘制 Icon。**类**
import javax.swing.Timer;//在指定时间间隔触发一个或多个 ActionEvent。**类**
import javax.swing.JPanel;//轻量级容器**类**
public class snk extends JPanel implements KeyListener,ActionListener {
    int[] snkx=new int[750];
    int[] snky=new int[750];

    //随机food
    int foodx=new Random().nextInt(34)*25+25;//随机生成0~33的正数 乘于25 加25
    int foody=new Random().nextInt(24)*25+75;//随机生成0~23的正数 乘于25 加75

    int len=3;
    int score=0;
    String dire="R";

    boolean isS=false;
    boolean isE=false;

    Timer times=new Timer(100,this);

    public snk(){
        this.setFocusable(true);//获取焦点
        this.addKeyListener(this);//监听按键
        setup();
        times.start();
    }

    private void setup() {
        len=3;
        score=0;
        isE=false;
        isS=false;
        snkx[0]=100;snkx[1]=75;snkx[2]=50;
        snky[0]=100;snky[1]=100;snky[2]=100;

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
