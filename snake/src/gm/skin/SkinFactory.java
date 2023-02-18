package gm.skin;

public class SkinFactory<T>{
    //<? extends T> 泛型上限，可以使用T以及T的子类      dir C:/.././practise/src/基础实例/泛型/上下限
    public T SkinFactory(String className) {
        if (className == null || className.equals("")){
            return null;
        }
        try {
            Class<T> clazz = (Class<T>) Class.forName("gm.skin."+className);
            return clazz.newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }

        return null;
    }
}
