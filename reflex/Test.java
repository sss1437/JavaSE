package reflex;

/**
 * @Author: zhaodoudou
 * @Date: 2019/4/5
 * @Description: reflex
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) throws Exception {
        String str = "emp.name:zdd|emp.job:Coder";
        EmpAction empAction = new EmpAction();
        empAction.setEmpValue(str);
        System.out.println(empAction.getEmp());
    }
}
