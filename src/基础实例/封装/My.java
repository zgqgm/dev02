package 基础实例.封装;
//封装的定义较广泛，可以对照生活中的“封装、打包、带走”理解一下（类就是个典型例子）
public class My {
    //访问修饰符有四种（下面第二种容易被忽视）。
    private String diary;//private 只能在本类中访问（（对属性和方法使用（构造方法除外，因为创建对象时报错））不能对类使用！！！）
    String car;
    public String name;
    protected int age;//这个先不管。
    private boolean married;
    /*
     *创建一个private的方法。
     */
    private void information(){
        System.out.println("这是我的信息");
    }
    /*
     *创建一个构造方法（构造方法执行优先级较高！）
     */
    public My(){
        this.diary="我的日记内容";
        System.out.println("private diary:"+this.diary);
        this.information();
    }
    /*
     *创建为其他类在本类赋值的“中介”方法（通过set***和get***（/Boolean用is***）的方法！！！这只是规范不是强制）
     */
    public void setDiary(String diary){
        this.diary=diary;
    }
    public void setMarried(boolean married) { this.married=married;}
    /*
     *创建为其他类获得本类方法或属性的“中介”方法。
     */
    public String getDiary(){
        return this.diary;
    }
    public boolean isMarried() { return this.married;}//boolean类型
    /*
     *创建private的方法
     */
    private void marriedInformation(){
        if(married){
            System.out.println("已婚");
        }else{
            System.out.println("未婚");
        }
    }
    /*
     *用普通方法作为“中介”，以便调用marriedInformation（）。
     */
    public void printf(){
        marriedInformation();
    }
}
