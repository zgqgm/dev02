package 基础实例.多类协作;
import  java.util.Scanner;
//赛场类
public class Arena {
    static Scanner sc=new Scanner(System.in);
    public static void main(String[] args){
        Car car = new Car("小明",100);//创建Car对象，传入信息。
        Garage garage= new Garage("摇滚汽修厂","招财路",88888888);//创建Garage对象，传入信息。
        carClass(car);//调用本类方法carClass并传入Car类信息。
        /*
         *for循环为车提速。当速度不小于160时，轮胎数减为3，并进入其他方法。
         */
        for (int i=0;i<=10;i++){
            int speed=car.getSpeed()+i*2;
            car.setSpeed(speed);
            car.printf();//调用Car中printf方法输出车子情况。
            if(speed>160){
                car.setTyreNum(3);
                System.out.println("爆胎。");
                car.printf();//再次调用Car中printf方法输出车子情况。
                Car newcar=garage.car(car);//接收 将Car类中的信息 传入Garage类中的car方法。
            }
        }
    }
        /*
         *创建一个选择车类的carClass方法。
         */
    public static void carClass(Car car){
        System.out.println("请选择配车：\n1.法拉利");
        byte n= sc.nextByte();
        car.setCarClass(n);//调用Car类中的setcarClass方法，并传入值。

    }
}
