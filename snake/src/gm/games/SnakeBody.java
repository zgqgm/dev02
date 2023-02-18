package gm.games;

import java.util.LinkedList;

public class SnakeBody {
    private LinkedList<LinkedList<Node>> getSnakeBody;
    //行动
    private Direction snakeAction = Direction.DOWN;

    public SnakeBody (){
        initSnake();
    }

    public void initSnake(){
        getSnakeBody = new LinkedList<>();
        LinkedList<Node> body = new LinkedList<>();//'.'先进后出
        body.add(new Node(0+3,0+3));//.'.尾
        body.add(new Node(1*25+3,3));
        body.add(new Node(2*25+3,3));//又.'.头
        getSnakeBody.add(body);
    }

    public Direction getDirection() {
        return snakeAction;
    }

    public void setDirection(Direction direction) {
        this.snakeAction = direction;
    }

    //在蛇的运动方向加节点，尾部减节点
    public void move(boolean isGrewUp){
        Node head = getSnakeBody.getFirst().getFirst();
        switch (snakeAction){
            case UP -> {
                //超越边界，添加新身体作为头
                if (head.getY() < 1*25+3){
                    LinkedList<Node> newBody = new LinkedList<>();
                    newBody.add(new Node(head.getX(),29*25+3));
                    getSnakeBody.addFirst(newBody);
                }else {
                    getSnakeBody.getFirst().addFirst(new Node(head.getX(),head.getY()-1*25));
                }
            }
            case DOWN -> {
                if (head.getY() > 28*25+3){
                    LinkedList<Node> newBody = new LinkedList<>();
                    newBody.add(new Node(head.getX(),0*25+3));
                    getSnakeBody.addFirst(newBody);
                }else {
                    getSnakeBody.getFirst().addFirst(new Node(head.getX(),head.getY()+1*25));
                }
            }
            case LEFT -> {
                if (head.getX() < 1*25+3){
                    LinkedList<Node> newBody = new LinkedList<>();
                    newBody.add(new Node(33*25+3,head.getY()));
                    getSnakeBody.addFirst(newBody);
                }else {
                    getSnakeBody.getFirst().addFirst(new Node(head.getX()-1*25,head.getY()));
                }
            }
            case RIGHT -> {
                if (head.getX() > 32*25+3){
                    LinkedList<Node> newBody = new LinkedList<>();
                    newBody.add(new Node(0*25+3,head.getY()));
                    getSnakeBody.addFirst(newBody);
                }else {
                    getSnakeBody.getFirst().addFirst(new Node(head.getX()+1*25,head.getY()));
                }
            }

        }
        grewUp(isGrewUp);
    }

    /**
     * 成长
     * @param isGrewUp 是否成长
     */
    public void grewUp(boolean isGrewUp){
        if (!isGrewUp){
            if (getSnakeBody.getLast().size() <= 0) {
                getSnakeBody.removeLast();
            }
            getSnakeBody.getLast().removeLast();

        }
    }

    public LinkedList<LinkedList<Node>> getSnake() {
        return getSnakeBody;
    }

    public void setSnake(LinkedList<LinkedList<Node>> snake) {
        this.getSnakeBody = snake;
    }
}
