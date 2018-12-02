//Java数组章节练习题
public class ArrayUtils{

    //1.计算数组中最大值
    public static int arrayMaxElement(int[] data){
          int max=data[0];
          for(int i=0;i<data.length;i++){
              if(data[i]>max){
                  max=data[i];
              }
          }
        return max;
    }
    //2.计算数组中最小值
    public static int arrayMinElement(int[] data){
        int min=data[0];
        for(int i=0;i<data.length;i++){
            if(data[i]<min){
                min=data[i];
            }
        }
      return min;
  }
    //3.计算数组值之和
    public static int arrayElementSum(int[] data){
        int sum=0;
        for(int i=0;i<data.length;i++){
            sum += data[i];
        }
        return sum;
    }
    //4.数组拼接
    // A {1,3,5,7,9} B {2,4,6,8,10} -> {1,3,5,7,9,2,4,6,8,10}
    public static int[] arrayJoin(int[] a, int[] b){
        int[] c=new int[a.length+b.length];
        for(int i=0;i<c.length;i++){
            if(i<a.length){
                c[i]=a[i];
            }
            else{
                c[i]=b[i-a.length];
            }

        }
        return c;
    }
    //5.数组截取
    //[start, end)
    // A {1,3,5,7,9} ->(A,1,3) > {3,5}
    public static int[] arraySub(int[] data, int start , int end){
        int[] sub=new int [end-start];
        for(int i=start;i<end;i++){
           sub[i-start]= data[i];
        }
        return sub;
    }
     //6.数组打印
     public static void printArray(int[] data){
        for(int i=0;i<data.length;i++){
            System.out.print(data[i]+" ");
        }
        System.out.println();
    }
     //7.数组反转
    // 比如：[1,2,3,4] => [4,3,2,1]
    public static void printReversal(int[] data){
        for(int i=0;i<data.length;i++){
            System.out.print(data[data.length-i-1]+" ");
        }
    }
    public static void main(String[] args){
          int[] A = new int[]{1,2,3,4,5};
          int[] B = new int[]{6,7,8,9,10};
          int max = arrayMaxElement(A);
          int min = arrayMinElement(A);
          int sum = arrayElementSum(A);
          int[] join = arrayJoin(A,B);
          int[] sub = arraySub(A,1,4);
          System.out.println("max="+max);
          System.out.println("min="+min);
          System.out.println("sum="+sum);
          printArray(join);
          printArray(sub);
          printReversal(A);
    }
}