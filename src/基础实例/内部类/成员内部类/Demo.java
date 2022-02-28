package 基础实例.内部类.成员内部类;

public class Demo {
    private int num=1;
    private void link(){
        System.out.println("外类私有方法");
    }
    public Demo() {
        System.out.println("外类构造方法");
    }
    public void ouT(){
        System.out.println("外类方法");
        inner printInner=new inner();
        System.out.println(printInner.nums);
        printInner.links();
    }
    class inner {
        private int nums=2;
        public String name="内部公开变量";
        private void links(){
            System.out.println("内类私有方法");
        }
        public inner() {
            System.out.println("内类构造方法");
        }
        public void inneR(){
            System.out.println("内部方法");
            System.out.println(num);
            link();
            ouT();
        }
    }
}
