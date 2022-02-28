package 基础实例.拷贝.克隆;

public class person implements Cloneable {
    private String name;
    private Car car;

    public person() {
    }

    public person(String name, Car car) {
        this.name = name;
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Object cloneperson=super.clone();
        person per=(person)cloneperson;
        /*Object clonecar=car.clone();//对引用对象再次克隆就是“深克隆”，否则便是“浅克隆”。
        Car car1=(Car)clonecar;
        car1.setColor("蓝色");
        System.out.println("克隆车："+car1.getColor());
        System.out.println("本体车："+car.getColor());
        */
        /**
         * 上面注释内的代码就是深克隆
         * 深克隆对引用对象重写，不会影响本体；
         * 浅克隆对引用对象重写，会影响本体。
         */
        per.car.setColor("蓝色");
        System.out.println("克隆车："+per.car.getColor());
        System.out.println("本体车："+car.getColor());
        ((person) cloneperson).setName("小红");
        return per;
    }
}

