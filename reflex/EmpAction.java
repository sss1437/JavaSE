package reflex;

/**
 * 操作emp的类最终提供给用户使用
 * @Author: zhaodoudou
 * @Date: 2019/4/5
 * @Description: java.vo
 * @Version: 1.0
 */
public class EmpAction {
    private Emp emp = new Emp();
    public void setEmpValue(String str) throws Exception {
        BeanUtil.setBeanValue(this,str);
    }
    public Emp getEmp(){
        return this.emp;
    }
}
