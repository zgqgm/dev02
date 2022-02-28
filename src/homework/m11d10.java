package homework;

public class m11d10 {
    public static void main(String[] args) {
        System.out.println("输出：");
        for (int i=3;i<100;i++){
            for (int j=4;j<100;j++){
                if (j>i){//排除重复部分
                    for (int l=5;l<100;l++){
                        if ((i*i+j*j)==(l*l)&&l>j&&(i+j>l)&&(j+l>i)&&(l+i>j)){//找出符合条件组合
                            System.out.println(i+"\s"+j+"\s"+l);
                        }
                    }
                }
            }
        }
    }
}
