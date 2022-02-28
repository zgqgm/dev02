package 基础实例.多类协作;
//引擎类
public class Engine {
    private String type;//型号
    private  float displacement;//排量

    public Engine() {
    }
    /*
     *Engine有参构造用来接收外类传入的值。
     */
    public Engine(String type, float displacement) {
        this.type=type;
        this.displacement=displacement;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getDisplacement() {
        return displacement;
    }

    public void setDisplacement(float displacement) {
        this.displacement = displacement;
    }
}
