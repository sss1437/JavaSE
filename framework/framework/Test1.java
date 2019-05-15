package framework;

import java.util.*;

/**
 * @Author: zhaodoudou
 * @Date: 2019/5/11
 * @Description: framework
 * @Version: 1.0
 */
/*
public class Test1 {
    public static void main(String[] args){
        List<Integer> list = new Vector<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        System.out.println(list);
        System.out.println(list.remove(1));
        System.out.println(list);
        System.out.println(list.contains(2));
        System.out.println(list.set(1,222));
        System.out.println(list.get(1));
        System.out.println(list.size());
    }
}
*/
/*
class Person implements Comparable<Person>{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    */
/**
     * 自定义类Person类如何比较大小
     * @param o
     * @return
     *//*

    @Override
    public int compareTo(Person o) {
        if(this.age>o.age){
            return 1;
        }else if (this.age<o.age){
            return -1;
        }else{
            return this.name.compareTo(o.name);
        }
    }
}
public class Test1{
    public static void main(String[] args){
        Set<Person> set = new TreeSet<>();
        set.add(new Person("张三",12));
        set.add(new Person("李四",13));
        set.add(new Person("王五",10));
        set.add(new Person("王五",10));
        System.out.println(set);

    }
}
*/
/*
class Person{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String name, int age) {

        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

*/
/**
 * Person类的比较器（所有类默认继承Object累equals方法在此类中实现）
 *//*

class AscAgeComparator implements Comparator<Person>{

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getAge()-o2.getAge();
    }
}
public class Test1{
    public static void main(String[] args){
        Set<Person> set = new TreeSet<>(new AscAgeComparator());
        set.add(new Person("张三",12));
        set.add(new Person("李四",13));
        set.add(new Person("王五",10));
        set.add(new Person("王五",10));
        System.out.println(set);
    }
}
*/
/*
class Person{
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(int age) {
        this.age = age;
    }

    public Person(String name, int age) {

        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public Person(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }
    */
/*@Override
    public boolean equals(Object obj) {
        if (obj==this){
            return true;
        } else if (obj == null) {
            return false;

        } else if (!(obj instanceof Person)) {
            return false;
        }
        Person per =(Person) obj;
        return per.age.equals(obj.age)&&per.name.equals(obj.name);

    }*//*

}
public class Test1{
    public static void main(String[] args){
        Set<Person> set = new HashSet<>();
        set.add(new Person("张三",12));
        set.add(new Person("李四",13));
        set.add(new Person("王五",10));
        set.add(new Person("王五",10));
        System.out.println(set);
    }
}
*/
/*
public class Test1{
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("!!!");
        //取得ArrayList的迭代器
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
*/
/*
public class Test1{
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        list.add("hello");
        list.add("world");
        list.add("!!!");
        //取得ArrayList的双向迭代器
        ListIterator<String> listIterator = list.listIterator();
        while(listIterator.hasNext()){
            System.out.println(listIterator.next());
        }
        System.out.println("---------------------------");
        while (listIterator.hasPrevious()){
            System.out.println(listIterator.previous());
        }
    }
}
*/
/*
public class Test1{
    public static void main(String[] args){
        Vector<String> vector = new Vector<>();
        vector.add("hello");
        vector.add("world");
        vector.add("!!!");
        Enumeration<String> enumeration=vector.elements();
        while (enumeration.hasMoreElements()){
            System.out.println(enumeration.nextElement());
        }
    }
}
*/
/*
public class Test1{
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"A","B","C","B");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String str = iterator.next();
            if (str.equals("B")){
                list.remove("B");
                continue;
            }
            System.out.println(str);
        }
    }
}
*/

/*
public class Test1{
    public static void main(String[] args){
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"hello");
        map.put(2,"world");
        map.put(3,"!!!");
        map.put(null,null);
        map.put(null,null);
        map.put(4,null);
        System.out.println(map.get(1));
        //取得当前Map中的所有key值
        Set<Integer> keySet = map.keySet();
        Iterator<Integer> iterator = keySet.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //取得所有value值
        for(Integer i:keySet){
            System.out.println(map.get(i));
        }
    }
}
*/

/**
 * Map集合使用迭代器输出
 */
/*
public class Test1{
    public static void main(String[] args){
        Map<Integer,String> map = new HashMap<>();
        map.put(1,"Hello");
        map.put(2,"World");
        map.put(3,"!!!");
        //输出Map集合
        //1.Map->Set
        Set<Map.Entry<Integer,String>> set = map.entrySet();
        //2.取得Set接口迭代器
        Iterator<Map.Entry<Integer,String>> iterator = set.iterator();
        //3.迭代输出
        while (iterator.hasNext()){
            Map.Entry<Integer,String> entry = iterator.next();
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
    }
}
*/

/**
 * 栈的使用
 */
/*
public class Test1{
    public static void main(String[] args){
        Stack<Integer> stack = new Stack<>();
        stack.push(123);
        stack.push(456);
        stack.push(789);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());

    }
}
*/
/*public class Test1{
    public static void main(String[] args){
        Queue<Integer> queue = new LinkedList<>();
        queue.add(123);
        queue.add(456);
        queue.add(789);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
        System.out.println(queue.poll());

    }
}*/


























