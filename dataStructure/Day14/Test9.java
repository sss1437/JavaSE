package day14;

/**
 * @Description:
 * @Author: zdd
 * @Date: 2019/6/10
 */

class Substr {
    public boolean[] chkSubStr(String[] p, int n, String s) {
        boolean[] a = new boolean[n];
        for (int i = 0;i < n; i++){
            if (s.indexOf(p[i])!=-1){
                a[i] = true;
            }
        }
        return a;
    }
}
public class Test9 {
    public static void main(String[] args){
        Substr substr = new Substr();
        String[] a = new String[]{"a","b","c","d"};
        System.out.println(substr.chkSubStr(a,4,"abc"));
    }
}
