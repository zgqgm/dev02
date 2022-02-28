package 基础实例.集合.增强for;

import java.util.Iterator;

public class Home implements Iterable<Person>{
    //创建一个Person类型数组。
    private Person[] persons = {
            new Person("小明", 28),//匿名对象
            new Person("小红", 21),
            new Person("小黑", 3)};

    @Override
    public Iterator<Person> iterator() {
        return new Itr();// 创建了一个对象，并且这个对象一定实现了Iterator接口
    }
    // Itr是ArrayList的一个内部类。返回一个实现了Iterator接口的实现类对象
    private class Itr implements Iterator<Person> {

        // 下一个元素
        int cur;

        Itr() {}

        @Override
        public boolean hasNext() {
            return cur != persons.length;
        }

        @Override
        public Person next() {
            return persons[cur++];
        }
    }
}
