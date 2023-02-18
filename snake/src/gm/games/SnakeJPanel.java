package gm.games;

import gm.skin.DefaultSkin;
import gm.skin.SkinFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.reflect.Type;
import java.util.LinkedList;

public class SnakeJPanel extends JPanel implements KeyListener, ActionListener {
    //字符串存储反射用到的类型
    private Class clazz;
    private Type type;

    //蛇身
    private SnakeBody snakeBody;
    //食物
    private SnakeFood snakeFood;
    //片段
    private int segment;
    //长度
    private int length;
    //分数
    private int score;
    //定时器
    private Timer timer;
    //是否存活
    private boolean isLive = true;
    private boolean isStart = false; //游戏是否开始

    public SnakeJPanel() {
        init();
        this.setFocusable(true); //获取焦点事件
        this.addKeyListener(this); //键盘监听事件
    }

    /**
     * 初始化
     */
    private void init() {
        /*try {
            clazz = (Class<? extends DefaultSkin>) Class.forName("gm.skin."+"DefaultSkin");
            type = clazz;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }*/
        //蛇身
        snakeBody = new SnakeBody();
        //食物
        snakeFood = new SnakeFood();
        //分数
        score = 0;
        length = 0;
        //长度
        segment = snakeBody.getSnake().size();

        //定时器
        timer = new Timer(200, this);

    }

    //画组件
    public void paintComponent(Graphics g){

        super.paintComponent(g);//清屏
        this.setBackground(Color.white); //设置面板的背景色

        Graphics2D graphics2D = (Graphics2D) g;
        //横线
        for (int i = 0; i <= 30; i++){

            if (i == 0){
                graphics2D.setStroke(new BasicStroke(3));
                graphics2D.drawLine(0,2,850,2);
                graphics2D.setStroke(new BasicStroke(1));
            }else if (i == 30){
                graphics2D.setStroke(new BasicStroke(3));
                graphics2D.drawLine(0,752,850,752);
                graphics2D.setStroke(new BasicStroke(1));
            }else {
                graphics2D.drawLine(0,i * 25+3,850,i * 25+3);
            }
        }
        //竖线
        for (int i = 0; i <= 34; i++) {
            if (i == 0) {
                graphics2D.setStroke(new BasicStroke(3));
                graphics2D.drawLine(2, 0, 2, 750);
                graphics2D.setStroke(new BasicStroke(1));
            } else if (i == 34) {
                graphics2D.setStroke(new BasicStroke(3));
                graphics2D.drawLine(852, 0, 852, 753);
                graphics2D.setStroke(new BasicStroke(1));
            } else {
                graphics2D.drawLine(i * 25 + 3, 0, i * 25 + 3, 750);
            }
        }

        //---------创建皮肤工厂 ------
        SkinFactory<DefaultSkin> defaultSkinSkinFactory = new SkinFactory<>();
        //g.fillRect(25,75,850,600); //绘制游戏区域

        //绘制蛇的身体并判断是否咬到自己
        int num = 0;
        Node snakeHeader = snakeBody.getSnake().getFirst().getFirst();
        for (LinkedList<Node> snakeSegment : snakeBody.getSnake()){
            for (Node node: snakeSegment) {
                if (num == 0){
                    defaultSkinSkinFactory
                            .SkinFactory("DefaultSkin")
                            .getHeader()
                            .paintIcon(this,g,node.getX(), node.getY());
                }else if(snakeHeader.getX()== node.getX() && snakeHeader.getY() == node.getY()){
                    //游戏结束
                    isLive = false;
                    timer.stop();
                }else {
                    defaultSkinSkinFactory
                            .SkinFactory("DefaultSkin")
                            .getBody()
                            .paintIcon(this,g,node.getX(), node.getY());
                }
                num++;
            }
        }

        //画食物
        defaultSkinSkinFactory
                .SkinFactory("DefaultSkin")
                .getFood()
                .paintIcon(this,g,snakeFood.getSnakeFood().getX(),snakeFood.getSnakeFood().getY());

        g.setColor(Color.RED);
        g.setFont(new Font("微软雅黑",Font.BOLD,18));
        g.drawString("长度 " + length,860,35);
        //g.drawString("分数 " + score,860,50);

        //游戏提示
        if (!isStart){
            g.setColor(Color.CYAN);
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            g.drawString("按下空格开始游戏!",300,300);
        }
        //失败判断
        if (!isLive){
            g.setColor(Color.RED);
            g.setFont(new Font("微软雅黑",Font.BOLD,40));
            g.drawString("失败, 按下空格重新开始",200,300);
        }
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        //如果游戏处于开始状态，并且没有结束，则小蛇可以移动isStart && isLive==false
        if (true){
            //吃到食物
            if ((snakeBody.getSnake().getFirst().getFirst().getX() == snakeFood.getSnakeFood().getX())
                    &&
                    (snakeBody.getSnake().getFirst().getFirst().getY() == snakeFood.getSnakeFood().getY())){
                //生长
                snakeBody.move(true);
                length++;
                if (length <=40 && length%5==0){
                    timer.setDelay(timer.getDelay()-20);
                }
                //生成食物
                snakeFood = new SnakeFood();

            }else {
                snakeBody.move(false);
            }
            repaint(); //需要不断的更新页面实现动画
        }
        ///让时间动起来!
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode(); //获取按下的键盘

        if (keyCode==KeyEvent.VK_SPACE){ //如果是空格
            //true false 初始 空格0
            //TRUE TRUE 开始游戏 空格1-------
            //TRUE false 暂停游戏 空格2
            //TRUE TRUE 开始游戏 空格3---------
            //false TRUE 死亡 空格4
            //true TRUE 初始化复活------------

            if (isStart == isLive){
                isStart = !isStart;
                timer.stop();
            }else{
                if (isStart){//初始化复活
                    isLive = isStart;
                    init();
                }else {//开始游戏
                    isStart = isLive;
                }
                timer.start();
            }
        }

        //键盘控制走向
        switch (keyCode){
            case KeyEvent.VK_UP -> {
                //蛇的运动方向与将要移动的方向不同时可改变方向
                if(snakeBody.getDirection() != Direction.DOWN )
                    snakeBody.setDirection(Direction.UP);
            }
            case KeyEvent.VK_DOWN -> {
                if(snakeBody.getDirection() != Direction.UP )
                    snakeBody.setDirection(Direction.DOWN);
            }
            case KeyEvent.VK_LEFT -> {
                if(snakeBody.getDirection() != Direction.RIGHT )
                    snakeBody.setDirection(Direction.LEFT);
            }
            case KeyEvent.VK_RIGHT -> {
                if(snakeBody.getDirection() != Direction.LEFT )
                    snakeBody.setDirection(Direction.RIGHT);
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
