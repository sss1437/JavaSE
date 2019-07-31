package com;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

/**
 * @Description:
 * @Author: zdd
 * @Date: 2019/7/31
 */

public class CaseLoader {
    public CaseRunner load() throws IOException, ClassNotFoundException
            , IllegalAccessException, InstantiationException {
        String pkgDoc = "com.cases";
        String pkg = "com/cases";
        List<String> classNameList = new ArrayList<>();
        /**
         * 1.根据一个固定类，找到类加载器
         * 2.根据加载器找到类文件所在的路径
         * 3.扫描路径的所有类文件
         */
        ClassLoader classLoader = this.getClass().getClassLoader();
        Enumeration<URL> urls = classLoader.getResources(pkg);
        while (urls.hasMoreElements()) {
            URL url = urls.nextElement();
            //只能处理*.class的情况，无法处理打成jar包的情况
            if (!url.getProtocol().equals("file")) {
                continue;
            }
            String dirname = URLDecoder.decode(url.getPath(), "UTF-8");
            File dir = new File(dirname);
            if (!dir.isDirectory()) {
                //不是目录
                continue;
            }
            //扫描该目录下所有*.class文件，作为所有的类文件
            File[] files = dir.listFiles();
            if (files == null) {
                continue;
            }

            for (File file : files) {
                //判断后缀是否是.class
                String fileName = file.getName();
                if (fileName.endsWith(".class")){
                    String className = fileName.substring(0, fileName.length() - 6);
                    classNameList.add(className);
                }
            }
        }
        List<Case> caseList = new ArrayList<>();
        for (String className:classNameList){
            Class<?> cls = Class.forName(pkgDoc+"."+className);
            if (hasInterface(cls,Case.class)){
                caseList.add((Case)cls.newInstance());
            }
        }
        return new CaseRunner(caseList);

    }
    private boolean hasInterface(Class<?> cls,Class<?> intf){
        Class<?>[] interfaces = cls.getInterfaces();
        for (Class<?> i:interfaces){
            if (i ==intf){
                return true;
            }
        }
        return false;
    }

}
