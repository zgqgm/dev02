package gm.games;

import java.util.stream.Stream;

public enum Direction {
    UP(0,"上"),DOWN(1,"下"),LEFT(2,"左"),RIGHT(3,"右");

    Integer numType;
    String cnType;

    Direction(int numType, String cnType) {
        this.numType = numType;
        this.cnType = cnType;
    }

    /**
     * 通过类型获取枚举类
     *
     * @param numType
     */
    public static Direction getType(Integer numType) {
        return Stream.of(Direction.values()).filter(s -> s.numType.equals(numType)).findAny().orElse(null);
    }
    /**
     * 通过类型获取描述值
     *
     * @param numType
     * @return
     */
    public static String getDescription(Integer numType) {
        Direction[] values = Direction.values();
        return Stream.of(values).filter(s -> s.numType == numType).map(s -> s.cnType).findAny().orElse(null);
    }
}
