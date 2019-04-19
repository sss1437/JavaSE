package framework;

import java.util.*;

/**
 * @Author: zhaodoudou
 * @Date: 2019/4/13
 * @Description: framework
 * @Version: 1.0
 */
/*public class Test {
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        //重复数据
        list.add(2);
        list.add(4);
        //isEmpty():判断此集合包含元素返回false
        System.out.println(list.size()+" "+list.isEmpty());
        //remove（）：删除指定索引元素
        System.out.println(list.remove(0));
        //contains（）：判断元素是否存在
        System.out.println(list.contains(1));
        System.out.println(list.set(0,9999));
        //size（）：计算此集合中的元素数
        for(int i = 0;i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}*/


/*
public class Test{
    public static void main(String[] args){
        //开发中尽量不要使用Collection接口
        //此时集合里面只保存Integer类型
        Collection<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(3);
        Object[] result = list.toArray();
        System.out.println(Arrays.toString(result));
    }
}
*/
/*
class Person{
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(age, person.age);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }
}
public class Test{
    public static void main(String[] args){
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("张三",11));
        personList.add(new Person("王五",12));
        personList.add(new Person("张三",11));
        personList.add(new Person("李四",14));
        //集合操作简单java类是必须覆写equals（）和hashCode（）
        System.out.println(personList.remove(new Person("李四",14)));
        System.out.println(personList.contains(new Person("王五",12)));
        for(Person p:personList){
            System.out.println(p);
        }
    }
}*/
/*
public class Test{
    public static void main(String[] args){
        List<String> list = new Vector<>();
        list.add("hello");
        list.add("hello");
        list.add("world");
        System.out.println(list);
        list.remove("world");
        System.out.println(list);

    }
}
*/
/*
public class Test{
    public static void main(String[] args){
        List<String> list = new LinkedList<>();
        list.add("hello");
        list.add("hello");
        list.add("world");
        System.out.println(list);
        System.out.println(list.remove(0));
        System.out.println(list);
    }
}
*/
//HashSet:无序存储
/*
public class Test{
    public static void main(String[] args){
        Set<String> set = new HashSet<>();
        set.add("hello");
        set.add("world");
        set.add("Hello");
        set.add("hello");
        System.out.println(set);
    }
}
*/

//TreeSet：有序存储
/*
public class Test{
    public static void main(String[] args){
        Set<String> set = new TreeSet<>();
        set.add("hello");
        set.add("world");
        set.add("Hello");
        set.add("hello");
        System.out.println(set);
    }
}
*/
/*
class Person{
    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
//返回正数按从小到大排列
class AsAgeComparator implements Comparator<Person>{
    @Override
    public int compare(Person o1,Person o2) {
        return o1.getAge()-o2.getAge();
    }
}
//返回负数按从大到小排列
class DescAgeComparator implements Comparator<Person>{
    @Override
    public int compare(Person o1, Person o2) {
        return o2.getAge()-o1.getAge();
    }
}
public class Test{
    public static void main(String[] args){
        Set<Person> set = new TreeSet<>(new AsAgeComparator());
        set.add(new Person("张三",20));
        set.add(new Person("李四",10));
        System.out.println(set);
        Set<Person> set1 = new TreeSet<>(new DescAgeComparator());
        set1.add(new Person("张三",20));
        set1.add(new Person("李四",10));
        System.out.println(set1);
    }
}
*/
/*
class Person implements Comparable<Person>{

    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null|| getClass()!= o.getClass())
            return false;
        Person person = (Person) o;
        return Objects.equals(name,person.name) && Objects.equals(age,person.age);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name,age);
    }

    @Override
    public int compareTo(Person o) {
        if (this.age > o.age){
            return 1;
        }else if (this.age < o.age){
            return -1;
        }else{
            return this.name.compareTo(o.name);
        }
    }

}
public class Test{
    public static void main(String[] args){
        Set<Person> set = new HashSet<>();
        set.add(new Person("张三",20));
        set.add(new Person("李四",10));
        System.out.println(set);
    }
}
*/
/*
//迭代输出
public class Test{
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        list.add("Hello");
        list.add("hello");
        list.add("world");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String str = iterator.next();
            System.out.println(str);
        }
    }
}
*/






























































