package test;

import NodeUtil.nodeUtil;

public class Test {
    public static void main(String[] args) {
        nodeUtil util = new nodeUtil();
        util.AddLast(1);
        util.AddLast(2);
        util.AddLast(3);
        util.AddLast(4);
        util.AddLast(5);
        util.AddLast(6);
        //int num = util.replaceIndex(3,5);
        System.out.println(util.selectIndex(3));
        util.ForNode();

    }
}
