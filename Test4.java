
class Person{
    private String name;
    private int age;
    public void setName(String n){
        name = n;
    }
    public String getName(){
        return name;
    }
    public void setAge(int i){
        if(i>0&&i<=200){
            age = i;
        }else{
            age = 0;
        }
    }
    public int getAge(){
        return age;
    }
    public void fun(){
        System.out.println("姓名："+name+"\n"+"年龄："+age);
    }
}
public class Test4{
    public static void main(String[] args){
        Person per = new Person();
        per.setName("张三");
        per.setAge(18);
        per.fun();
    }
}



class Person{
    private String name;
    private int age;
    public Person(String n,int i){
        setName(n);
        setAge(i);
    }
    public void setName(String n){
        name = n;
    }
    public String getName(){
        return name;
    }
    public void setAge(int i){
        if(i>0&&i<=200){
            age = i;
        }else{
            age = 0;
        }
    }
    public int getAge(){
        return age;
    }
    public void fun(){
        System.out.println("姓名："+name+"\n"+"年龄："+age);
    }
}
public class Test4{
    public static void main(String[] args){
        Person per = new Person("张三",18);
        per.fun();
    }
}




