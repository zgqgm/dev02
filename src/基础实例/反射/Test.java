package 基础实例.反射;

import java.lang.constant.Constable;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Test {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException, ClassNotFoundException {
        // 通过类名.class获取字节码对象
        Class<?> studentClass=Student.class;
        // 通过对象名.getClass()
        Class<?> studentClass2=new Student().getClass();
        // 通过Class.forName("")
        Class<?> studentClass3=Class.forName("基础实例.反射.Student");
        System.out.println(studentClass == studentClass2);
        System.out.println(studentClass == studentClass3);//三个对象是同一个
        System.out.println(studentClass3 == studentClass2);

        //获取构造方法
        Constructor<?> studentConstructor= studentClass.getConstructor(null);
        //创建对象
        Object student=studentConstructor.newInstance(null);
        System.out.println(student);
        //获取成员变量
        Field agefield=studentClass.getField("age");
        //获取私有变量
        Field namefield=studentClass.getDeclaredField("name");
        //设置对象中的变量
        agefield.set(student,18);
        // 可访问的【暴力反射】
        namefield.setAccessible(true);
        namefield.set(student,"小明");
        System.out.println(student);
        //获取方法
        Method eatMethod=studentClass.getMethod("eat",null);
        //执行获得的方法
        eatMethod.invoke(student,null);

        invoke("基础实例.反射.Student","run");
        //该代码不要在本类运行，因为student类对象已经创建（写在这里是为了说明反射的用处）
        /*Student student = new Student();
        student.setAge(34);
        student.setName("李老板");
        Class<?> studentClass = student.getClass();
        Field nameField = studentClass.getDeclaredField("name");//获取私有变量
        nameField.setAccessible(true);// 可访问的【暴力反射】
        nameField.set(student, "光头强");//不顾及私有化直接修改
        System.out.println(student);*/


    }
    public static void invoke(String name, String method) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> ObjectClass=Class.forName(name);
        Constructor<?> constructor = ObjectClass.getConstructor(null);
        Object object=constructor.newInstance(null);
        Method eatMethod=ObjectClass.getMethod(method,null);
        eatMethod.invoke(object,null);
    }
}
