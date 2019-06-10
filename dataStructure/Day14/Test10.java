package day14;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

/**
 * @Description:
 * @Author: zdd
 * @Date: 2019/6/10
 */
/*
import java.lang.reflect.*;
public class Test10 {
    public static void main(String[] args){
        try {
            Class c=Class.forName(args[0]);
            Method m[]=c.getDeclaredMethods();
            for (int i = 0; i < m.length; i++) {
                System.out.println(m[i].toString());
            }
        } catch (Throwable e) {
            System.err.println(e);
        }
    }
}
*/
public class Test10{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        System.out.println(fun(str));
    }
    public static int fun(String str){
        for (int i = 1;i <=str.length();i++){
            {
                Set<String> rq = new TreeSet<>();
                for (int j = 0;j < str.length()-i;j++){
                    rq.add(str.substring(j,j+1));
                }
                if (rq.size() < Math.pow(4,i)){
                    return i;
                }
            }
        }
        return 1;
    }
}

