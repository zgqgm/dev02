package 基础实例.接口多态.Instanceof;

import 基础实例.接口多态.Instanceof.Animals;

public class Pandas implements Animals {
    @Override
    public void show() {
        System.out.println("动物：熊猫");
    }
}
