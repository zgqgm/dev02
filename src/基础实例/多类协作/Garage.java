package 基础实例.多类协作;
import  java.util.Scanner;
//汽修厂类
public class Garage {
    private String name;//名称
    private String location;//地址
    private int tel;//电话号
    private float money;//钱
    private byte item;
    Scanner sc=new Scanner(System.in);
    /*
     *共外类使用的car方法
     */
    public Car car ( Car car){
        System.out.println("欢迎来到"+this.location+"的"+this.name+"，我们的联系方式是："+this.tel+"\n我们将先进行轮胎、车速检查，若正常则进行引擎检查。");
        item=test(car);//将Car类信息传入test方法，并返还给item变量。
        tyre(car);//将Car类信息传入tyre方法。
        engine(car);//将Car类信息传入engine方法。
        boos(item);//将item得到的值穿给boos方法。
        return car;
    }
        /*
         *test方法用来Car类信息中符合 不正常情况的组合。
         */
    private byte test(Car car){
        byte n=0;
        boolean n1=car.getTyreNum()!=4;
        boolean n2=(car.getAbrade()).equals("差");
        boolean n3=(car.getAbrade()).equals("报废");
        if(n1){
            if(n3){
                n=13;
            }else if (n2){
                n=12;
            }else {
                n=1;
            }
        }else if (n3){
            n=3;
        }else if (n2){
            n=2;
        }else {
            n=0;
        }
        return n;
    }
        /*
         *tyre方法用来将符合 不正常情况的TyreNum、Speed恢复正常。
         */
    private void tyre(Car car){
        if(car.getTyreNum()!=4){
            car.setTyreNum(4);//重新设置TyreNum数量。
            car.setSpeed(80);//重新设置speed值。
            System.out.println("轮胎、车速修复，将进行引擎检查。");
        }else {
            System.out.println("您的轮胎正常。将进行引擎检查。");
        }
    }
        /*
         *engine方法用来Car类里engine变量的情况来分别处理。
         */
    private void engine(Car car){
        Engine engine = car.getEngine();
        String type = engine.getType();//获得Car类中Tyre变量的值。
        float displacement=engine.getDisplacement();//获得Car类中displacement变量的值。
        if(car.getAbrade().equals("差")){
            car.setAbrade("良好");//重新设置Car类中的abrade变量。
            System.out.println("引擎修复。");
        }else if (car.getAbrade().equals("报废")){
            System.out.println("请选购新的引擎：\n1.红旗牌\t2.五凌牌\t3.原厂的");
            byte n= sc.nextByte();
            switch(n){
                case 1:
                    car.setEngine(new Engine("红旗牌",4.1F));//这里中匿名的方法对Car类中的engine变量重新赋值。
                    car.setAbrade("优秀");
                    break;
                case 2:
                    car.setEngine(new Engine("五凌牌",1.5F));//这里中匿名的方法对Car类中的engine变量重新赋值。
                    car.setAbrade("优秀");
                    break;
                case 3:
                    byte old = car.getCarClass();//再次获取Car类中的engine变量 初始赋值。
                    car.setCarClass(old);
                    break;
                default:
                    break;
            }
        }else {
            System.out.println("您的"+type+"、"+displacement+"T引擎状态良好。");
        }
    }
        /*
         *boos方法通过item的值来针对Car类信息中符合 不正常情况的组合， 进行不同的收费。
         */
    private void boos(byte item){
        short n=0;
        System.out.println("修理完毕");
        switch (item){
            case 13:
                System.out.println("请给2019块辛苦费。");
                n= 2019;
                break;
            case 12:
                System.out.println("请给219块辛苦费。");
                n=219;
                break;
            case 3:
                System.out.println("请给1999块辛苦费。");
                n=1999;
                break;
            case 2:
                System.out.println("请给199块辛苦费。");
                n=199;
                break;
            case 1:
                System.out.println("请给20块辛苦费。");
                n=20;
                break;
            case 0:
                System.out.println("您的车没有问题。");
                break;
        }
        System.out.print("你从钱包里拿出：");
        this.money= sc.nextFloat();
        if(this.money==n){
            System.out.println("很高兴为您服务。");
        }else if(this.money<n){
            System.out.println("请您等待110的到来。");
        }
    }

    public Garage() {
    }
        /*
         *共外类传值的方法。
         */
    public Garage(String name, String location, int tel) {
        this.name = name;
        this.location = location;
        this.tel = tel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getTel() {
        return tel;
    }

    public void setTel(int tel) {
        this.tel = tel;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }
}
