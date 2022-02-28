package 基础实例.接口.接口优化;

public interface cat {
    public abstract void leg();
    public abstract void breed();

    /**
     * 以下两种方法建议不要用，因为具体方法交给类和抽象类就好了！！！！！！！！！！
     */
    public default void test11(){//最早出现在switch选择结构中，这里可以让接口使用非抽象方法。重不重写都可以。
        System.out.println("JDK1.8及之后版本可用default修饰方法，称为：默认方法");
    }
    public static void test22(){//通过接口名可以直接调用，不能被重写。
        System.out.println("JDK1.8及之后版本可用static修饰方法，称为：静态方法");
    }
}
