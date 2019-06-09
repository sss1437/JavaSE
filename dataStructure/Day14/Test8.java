package day14;

import java.math.BigInteger;

/**
 * @Description:
 * @Author: zdd
 * @Date: 2019/6/8
 */
public class Test8 {
  public static void main(String[] args){
      long rich = 0;
      long poor = 0;
      for (int i = 1;i<=30; i++){
          rich += 10;
          poor =  poor +(long) Math.pow(2,i-1);
      }
      System.out.println(rich+" "+poor);
  }
}
