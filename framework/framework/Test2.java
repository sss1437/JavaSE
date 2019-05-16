package framework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Author: zhaodoudou
 * @Date: 2019/5/16
 * @Description: framework
 * @Version: 1.0
 */
/*
public class Test2 {
    public static void main(String[] args){
        List<String> list = new ArrayList<>();
        //向集合中一次增加多个元素
        Collections.addAll(list,"A","a","B","b");
        //将集合转为线程安全集合
        List<String> listSafe = Collections.synchronizedList(list);
        //集合排序
        Collections.sort(list);
        for (String string:list){
            System.out.println(string);
        }
        System.out.println("________________________");
        //倒序
        Collections.reverse(list);
        for (String string:list){
            System.out.println(string);
        }
    }
}
*/

/*
public class Test2{
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,2,3,4,5,6,7,4);
        //将集合中的每个元素取出来调用println方法
        list.forEach(System.out::println);
    }
}
*/

/*
public class Test2{
    public static void main(String[] args){
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list,1,2,3,4,5,6,7,4);
        Stream<Integer> stream = list.stream();
        //计算出集合中偶数的个数
        System.out.println(stream.filter(e -> e % 2 == 0).count());
        //计算出集合中最大值
        System.out.println(stream.max(Integer::compareTo).get());
    }
}
*/

class Goods{
    private String name;
    private int count;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Goods(String name, int count, double price) {

        this.name = name;
        this.count = count;
        this.price = price;
    }
}
public class Test2{
    public static void main(String[] args) {
        List<Goods> list = new ArrayList<>();
        list.add(new Goods("车子", 1, 20000.2));
        list.add(new Goods("ipadpro", 2, 10000.1));
        Double allprice = list.stream()
                .map(obj -> obj.getCount() * obj.getPrice())
                .reduce((sum, x) -> sum + x).get();
        System.out.println(allprice);
    }
}





















