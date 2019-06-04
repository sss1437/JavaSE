package Test;

/**
 * @Author: zhaodoudou
 * @Date: 2019/6/3
 * @Description: Test
 * @Version: 1.0
 */
class GrayCode {
    public String[] getGray(int n) {
        String[] strings = null;
        if(n == 1){
            strings = new String[]{"0","1"};
        }else {
            String[] temp = getGray(n-1);
            strings = new String[2*temp.length];
            for (int i = 0;i < temp.length; i++){
                strings[i] = "0"+temp[i];
                strings[strings.length-1-i] = "1"+temp[i];
            }
        }
        return strings;
    }
}
public class Test11 {
    public static void main(String[] args){
       GrayCode grayCode = new GrayCode();
        System.out.println(grayCode.getGray(3));
    }
}
