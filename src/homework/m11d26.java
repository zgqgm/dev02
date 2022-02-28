package homework;

public class m11d26 {
    public static void main(String[] args) {
        String a = "111", b = "1";
        //System.out.println(a.charAt(5));
        System.out.println(addBinary(a, b));
    }

    public static String addBinary(String a, String b) {
        /*int n = 0, l = b.length(), j = a.length();
        StringBuffer st = new StringBuffer("0");
        if (a.length() > b.length()) {//对于两个字符串长度不同时，将短的字符串向前补零对齐
            n = a.length();
            for (int i = 0; i < n - l; i++) {
                b = "0" + b;
            }
        } else {
            n = b.length();
            for (int i = 0; i < n - j; i++) {
                a = "0" + a;
            }
        }
        for (int i = n - 1; i >= 0; i--) {//遍历字符串
            if (st.charAt(0) != '1') {//存储字符串第一个字符不为一
                if (a.charAt(i) == '1' || b.charAt(i) == '1') {
                    if (a.charAt(i) == '0' || b.charAt(i) == '0') {
                        st.insert(1, '1');//1,0相加插入一
                    } else {
                        st.replace(0, 1, "0");//1,1相加将首字符换为0，再向前插一
                        st.insert(0, '1');
                    }
                } else {
                    if (a.charAt(i) == '0' || b.charAt(i) == '0') {
                        st.insert(0, '0');//0,0相加插入零
                    } else {
                        st.insert(1, '1');//1,0相加插入一
                    }
                }
            } else {//存储字符串第一个字符为一
                if (a.charAt(i) == '1' || b.charAt(i) == '1') {
                    if (a.charAt(i) == '0' || b.charAt(i) == '0') {
                        st.replace(0, 1, "0");//1,0相加将首字符换为0，再向前插一
                        st.insert(0, '1');

                    } else {
                        st.replace(0, 1, "1");//1,1相加将首字符换为1，再向前插一
                        st.insert(0, '1');
                    }
                } else {
                    if (a.charAt(i) == '1' || b.charAt(i) == '1') {
                        st.replace(0, 1, "0");//1,0相加将首字符换为0，再向前插一
                        st.insert(0, '1');
                    } else {
                        st.insert(0, '0');//0,0相加向前插零
                    }
                }
            }
        }
        String sty;
        int i = st.length();
        if (st.charAt(0) == '0' && i > 1) {//首字符为零则移除
            sty = st.substring(1, i);
        } else {
            sty = st.toString();
        }
        return sty;*/

        if(a == null || a.length() == 0) return b;
        if(b == null || b.length() == 0) return a;

        StringBuilder stb = new StringBuilder();
        int i = a.length() - 1;
        int j = b.length() - 1;

        int c = 0;  // 进位
        while(i >= 0 || j >= 0) {
            if(i >= 0) c += a.charAt(i --) - '0';
            if(j >= 0) c += b.charAt(j --) - '0';
            stb.append(c % 2);
            c >>= 1;
        }

        String res = stb.reverse().toString();
        return c > 0 ? '1' + res : res;
    }
}
