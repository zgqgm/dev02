package 基础实例.接口多态.实例;

public class Computer {
    public void useUSBDevice(USB usb) {
        System.out.println("电脑能够使用USB设备");
        usb.connect();
    }
}
