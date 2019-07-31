package com;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


/**
 * @Description:
 * @Author: zdd
 * @Date: 2019/7/31
 */
public class Main {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException, InvocationTargetException {

        CaseLoader loader = new CaseLoader();
        loader.load().run();
    }
}
