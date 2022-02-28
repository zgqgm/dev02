package homework;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;

public class m12z {
    public static void main(String[] args) {
        String licensePlate = "1s335",s="cc";
        String[] words = { "steps","step", "stripe", "stepple"};
        //System.out.println(shortestCompletingWord(licensePlate,words));
        if(s.length()<2) System.out.println(s.length());
        int n=1,m=0;
        for(int i=0;i<s.length()-1;i++){
            if(s.charAt(i)==s.charAt(i+1)){
                n+=1;
            }else if(n>m){
                m=n;
                n=1;
            }else{
                n=1;
            }
        }

        System.out.println(Math.pow(937,200));


    }
    public static String shortestCompletingWord(String licensePlate, String[] words) {
        char[] st ;
        int len=100,n=-1;
        String ss = licensePlate.toLowerCase();
        st = ss.toCharArray();
        Arrays.sort(st);
        for (int i = 0;i<licensePlate.length();i++){
            n++;
            if (st[i]>65){
                for (int j = 0;j< words.length;j++){
                    char[] ch=words[j].toCharArray();
                    Arrays.sort(ch);

                    for (int l = 0;i<licensePlate.length()&&l<ch.length;l++) {
                        if (ch[l] == st[i]) {
                            i++;
                            if (i==licensePlate.length()&&ch.length<len){
                                ss=words[j];
                                len=ch.length;
                                break;
                            }
                        }
                    }i=n;

                }break;

            }
        }
        return ss;
    }
}
