package 基础实例.多态;

public class Test {
    public static void main(String[] args){
        Monkey monkey=new Monkey();
        zoo(monkey);//这里monkey是Monkey类型，也是Animal类型。因为Monkey继承了Animal。
        Monkey monlei=getMonkey();
        zoo(monlei);
        Animal anilei=getAnimal();
        zoo(anilei);//这里同上同理。
        //mon(anilei);这里向mon方法传入anilei变量报错是因为anilei是Animal类型而不是Monkey类型。
        //所以需要对anilei进行强制类型转换，在传入mon方法。
        Monkey monAni=(Monkey) anilei;//类型下降。
        mon(monAni);

        //类型上升
        //Animal panlei=new Panda();==>Panda panlei1=new Panda();
                                    //Animal anilei1=panlei1;;

        //这样就能隐藏方法内部，对外提供接口。同时提高了扩展性。
        Animal vislei11=visited(100);
        Animal vislei22=visited(50);
        Animal vislei33=visited(10);
        zoo(vislei11);
        zoo(vislei22);
        zoo(vislei33);
    }
    public static void zoo(Animal animal){
        System.out.println("动物   "+animal);
    }
    public static void mon(Monkey monkey){
        System.out.println("猴子   "+monkey);
    }

    /**
     * 下面的visited方法就能较真实的表现出多态的优点。
     * @return
     */
    public static Animal visited(int money){
        if(money>99){
            return new Panda();
        }else if(money>49){
            return new Tiger();
        }else{
            return new Monkey();
        }
    }


    public static Monkey getMonkey(){
        return new Monkey();//这里的Monkey/panda/Tiger分别对应各自的类型。
    }
    public static Panda getPanda(){
        return new Panda();
    }
    public static Tiger getTiger(){
        return new Tiger();
    }
    //下面的getAnimal方法就能实现上面getMonkey/getPanda/getTiger三个方法的效果（但要记住个返回值类型不同）
    public static Animal getAnimal(){
        return new Monkey();//这里的Monkey/panda/Tiger都是Animal类型。
        /*
        * 或者
        * return new Panda();
        * */
        /*
         * 或者
         * return new Tiger();
         * */
    }

}
