package 基础实例.接口多态.Instanceof;

public class Test {
    public static void main(String[] args){
        Animals panda1 = new Pandas();//对Pandas向上转型。

        Animals panda3=printf();
        if (panda3 instanceof Pandas){//格式： 对象 instanceof 类/接口 作用：用来判断什么是什么
            Pandas ani=(Pandas) printf();
            System.out.println("熊猫"+ani);
        }else if (panda3 instanceof Tigers){
            Tigers ani=(Tigers) printf();
            System.out.println("老虎"+ani);
        }else if(panda3 instanceof Monkeys){
            Monkeys ani=(Monkeys) printf();
            System.out.println("猴子"+ani);
        }else{System.out.println("动物"+panda3);}
    }
    public static Animals printf(){
        return new Pandas();
        //return new Monkeys();
        //return new Tigers();
    }
    //public static
}
