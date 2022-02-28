package 基础实例.拷贝.克隆;

public class Car implements Cloneable{
    private String brand;
    private String Color;

    public Car(String brand, String color) {
        this.brand = brand;
        Color = color;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }
}
