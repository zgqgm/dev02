package 基础实例.反射.自定义注解;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Test {
    public static void main(String[] args) throws NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Class<?> studentClass = Student.class;
        Constructor<?> constructor = studentClass.getConstructor(null);
        Object student = constructor.newInstance(null);
        Field nameField = studentClass.getDeclaredField("name");
        nameField.setAccessible(true);
        Nickname nickname = nameField.getAnnotation(Nickname.class);
        String name = nickname.name();
        nameField.set(student, name);
        System.out.println(student);
    }
}
