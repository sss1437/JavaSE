public class Test3{
    public static void main(String[] args){
        for(int i=1;i<10;i++){
            for(int j=1;j<=i;j++){
                System.out.print(i+"*"+j+"="+i*j);
                System.out.print("\t");
            }
            System.out.println();
        }
    }
}
public class Test3{
    public static double Factorial(double n){
        if(n==1){
            return 1;
        }
        else{
            return  n*Factorial(n-1);
        }
    }
    public static void main(String[] args){
        System.out.print(Factorial(20));
    }
}
