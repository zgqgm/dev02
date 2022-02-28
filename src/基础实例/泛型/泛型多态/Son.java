package 基础实例.泛型.泛型多态;

public class Son implements Father<Name> {
    @Override
    public Name father(Name name) {
        return name;
    }
}
