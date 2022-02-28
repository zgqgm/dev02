package 基础实例.多类协作;

//车类
public class Car {
    private String user;//车主
    private String color;//颜色
    private String brand;//品牌
    private int tyreNum;//轮胎数
    private int speed;//速度
    private String abrade;//磨损度
    private Engine engine;//引擎
    public byte carClass;//车类
    /*
     *在无参构造内对私有变量赋值。
     */
    private Car() {
        this.tyreNum=4;
    }
    /*
     *在carClass方法内依据carClass变量值对所需变量集体赋值。
     */
    private void carClass(){
        switch (carClass){
            case 1:
                this.color="白色";
                this.brand="法拉利";
                //this.tyreNum=4;
                this.abrade="优秀";
               engine=new Engine("法拉利牌",3.0F);
                break;
            default:
                break;
        }
    }
    /*
     *printf方法对外类输出车子情况。
     */
    public void printf(){
        carClass();
        if (100<=this.speed && this.tyreNum==4) {
            System.out.println(
                    this.user+"开着"+this.color+"的"+this.brand
                            +"在路上飙车。速度为"+this.speed+"迈。"
            );
        }else if(this.tyreNum!=4){
            System.out.println("到汽修厂去维修");
        }
    }
    /*
     *Car有参构造用来接收外类传入的值。
     */
    public Car(String user,int speed){
        this();
        this.user=user;
        this.speed=speed;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getTyreNum() {
        return tyreNum;
    }

    public void setTyreNum(int tyreNum) {
        this.tyreNum = tyreNum;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public Engine getEngine() {
        return engine;
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public byte getCarClass() {
        return carClass;
    }

    public void setCarClass(byte carClass) {
        this.carClass = carClass;
    }

    public String getAbrade() {
        return abrade;
    }

    public void setAbrade(String abrade) {
        this.abrade = abrade;
    }
}
