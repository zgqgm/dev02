package 基础实例.泛型.泛型多态;

public class Test {
    public static void main(String[] args) {
        Son son=new Son();
        Name name= son.father(new Name("小明",48));
        System.out.println(name);
        Type<Name> ty=new Type<>();//泛型推断
        Name name1= ty.father(new Name("小王",45));
        System.out.println(name1);
    }
}
