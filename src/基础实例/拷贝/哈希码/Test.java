package 基础实例.拷贝.哈希码;

/**
 * equals相等，哈希码一定相等。
 * 哈希码相等，equals不一定相等。
 */
public class Test {
    public static void main(String[] args) {
        Students student1=new Students(18,"小明",'男',01);
        Students student2=new Students(18,"小明",'男',01);
        int hashcode1=student1.hashCode();// 获取哈希码--十进制地址--
        int hashcode2=student2.hashCode();// 获取哈希码
        if (hashcode1==hashcode2){//先比较哈希码值，如果相等就比较equals。（因为equals比较 较麻烦）
            boolean stt=student1.equals(student2);
            if (stt){
                System.out.println("true");
            }else{System.out.println("false");}
        }else {
            System.out.println("false");
        }
        //获得完整的类名
        String z=student1.getClass().getName();
        System.out.println(z);
    }
}
