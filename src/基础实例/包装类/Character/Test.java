package 基础实例.包装类.Character;

public class Test {
    public static void main(String[] args) {
        System.out.println("是否是大写：" + Character.isUpperCase('s'));
        System.out.println("是否是小写：" + Character.isLowerCase('S'));

        System.out.println("是否是数字：" + Character.isDigit('1'));

        System.out.println("转大写：" + Character.toUpperCase('s'));
        System.out.println("转小写：" + Character.toLowerCase('S'));
    }
}
