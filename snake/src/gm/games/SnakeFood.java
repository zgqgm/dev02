package gm.games;

import java.util.Random;

public class SnakeFood {
    private final Node snakeFood;

    public SnakeFood() {
        Random random = new Random();
        snakeFood = new Node();

        int foodX = 25 * random.nextInt(33)+3;
        int foodY = 25 * random.nextInt(29)+3;

        System.out.println("foodX:"+foodX+"\nfoodY:"+foodY);
        snakeFood.setX(foodX);
        snakeFood.setY(foodY);
    }

    public Node getSnakeFood(){
        return snakeFood;
    }


}
