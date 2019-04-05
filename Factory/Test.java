package Factory;

/**
 * @Author: zhaodoudou
 * @Date: 2019/4/2
 * @Description: Factory
 * @Version: 1.0
 */
public class Test {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        Fruit fruit = FruitFactory.getInstance("Factory.Orange");
        fruit.eat();
    }
}
