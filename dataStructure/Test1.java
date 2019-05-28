package Test;

/**
 * @Author: zhaodoudou
 * @Date: 2019/5/28
 * @Description: Test
 * @Version: 1.0
 */
public class Test1 {
    public static void main(String[] args){
        System.out.println(new B().getValue());
    }
    static class A{
        protected int value;
        public A(int V){
            setValue(V);
        }
        public void setValue(int value){
            this.value = value;
        }
        public int getValue(){
            try{
                value++;
                return value;
            }catch (Exception e){
                System.out.println(e.toString());
            }
            finally {
                this.setValue(value);
                System.out.println(value);
            }
            return value;
        }
    }
    static class B extends A{

        public B() {
            super(5);
            setValue(getValue()-3);
        }

        @Override
        public void setValue(int value) {
            super.setValue(2*value);
        }
    }
    //22 34 17
}
