package 基础实例.接口多态.实例;

public class Test {
    public static void main(String[] args){
            Computer computer=new Computer();
            USB mouse =new Mouse();
            USB keyboard=new Keyboard();
            computer.useUSBDevice(mouse);
            computer.useUSBDevice(keyboard);
            Mouse logic=new LogicMouse();
            USB logicmouse=logic;//向上转型
            computer.useUSBDevice(logicmouse);
    }
}
