package 基础实例.泛型.泛型多态;

public class Type<T> implements Father<T>{
    @Override
    public T father(T t) {
        return t;
    }
}
