package reflex;

import java.lang.reflect.Method;

/**
 * 操作简单类属性设置的工具类
 * @Author: zhaodoudou
 * @Date: 2019/4/5
 * @Description: java.vo
 * @Version: 1.0
 * emp.name:zdd|emp.job:Coder
 */
public class BeanUtil {
    private BeanUtil(){}
    public static void setBeanValue(Object actionObj,String beanValue)throws Exception{
        String[] temp = beanValue.split("\\|");
        for(int i = 0;i < temp.length; i++){
            String[] result = temp[i].split(":");
            //zdd属性值
            String realValue = result[1];
            //emp 类名
            String className = result[0].split("\\.")[0];
            //name 属性名
            String attrName = result[0].split("\\.")[1];
            //根据XXAction类取得真正操作的主题类Emp
            //通过反射调用getEmp类
            Object realObj = getRealObject(actionObj,className);
            //调用真正类的setter方法设置属性值
            setRealObject(realObj,attrName,realValue);
        }
    }
    private static Object getRealObject(Object actionObj,String className)throws Exception{
        //取得XXAction Class对象
        Class<?> cls = actionObj.getClass();
        //拼装getXX（）名称
        String methodName = "get"+initCap(className);
        //取得该方法名称的method对象
        Method method = cls.getMethod(methodName);
        //通过反射调用该方法
        return method.invoke(actionObj);
    }
    private static String initCap(String str){
        return str.substring(0,1).toUpperCase()+str.substring(1);
    }
    private static void setRealObject(Object realObj,String attrName,String realValue)throws Exception{
        Class <?> cls = realObj.getClass();
        String setName = "set"+initCap(attrName);
        Method setMethod = cls.getMethod(setName,String.class);
        setMethod.invoke(realObj,realValue);
    }
}