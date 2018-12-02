public class Test2{
    public static void main(String[] args){
        int[] data=init();
       
        printArray(data);
    }
    public static int[] init(){
        return new int[] {1,1,2,2,4};
    }
    public static void printArray(int[] temp){
        for(int i=0;i<temp.length;i++){
            System.out.print(temp[i]);
        }
    }

}