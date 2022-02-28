package homework;



public class m11d9 {
    public static void main(String[] args) {
        int x=9;
        int y=8;
        int o=0,p=0,q=0;
        for (int i=7;i>0;i--){
            for (int j=7;j>0;j--){
                for (int l=7;l>0;l--){
                    for (int a=7;a>0;a--){
                        for (int b=7;b>0;b--){
                            for (int c=7;c>0;c--){
                                for (int d=7;d>0;d--) {//for循环获得九个人的所有排列组合
                                    //通过if排除相同名次的可能
                                    if (i != j && i != l && i != a && i != b && i != c && i != d && j != l && j != a && j != b && j != c && j != d && l != a && l != b && l != c && l != d && a != b && a != c && a != d && b != c && b != d && c != d) {
                                        //if排除每家成绩不同的可能
                                        if ((i + j + l) == (9 + a + b) && (9 + a + b) == (8 + c + d)) {
                                            //if排除排名连续的可能
                                            if ((i - j) != 1 && (j - l) != 1 && (i - l) != 1 && (9 - a) != 1 && (9 - b) != 1 && (a - b) != 1 && (8 - c) != 1 && (8 - d) != 1 && (c - d) != 1) {
                                                //if排除重复排列组合的可能
                                                if (o != (i + j + l) && p != (9 + a + b) && q != (8 + c + d)) {
                                                    //if-else判断最后一名
                                                    if (i == 1 || j == 1 || l == 1) {
                                                        System.out.println("最后一名是张家孩子");
                                                    } else if (a == 1 || b == 1) {
                                                        System.out.println("最后一名是李家孩子");
                                                    } else {
                                                        System.out.println("最后一名是王家孩子");
                                                    }
                                                }
                                                o = i + j + l;
                                                p = 9 + a + b;
                                                q = 8 + c + d;
                                            }
                                        }
                                    }
                            }    }
                        }
                    }

                }
            }
        }

    }
}
