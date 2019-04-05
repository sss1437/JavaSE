package Factory;

/**
 * @Author: zhaodoudou
 * @Date: 2019/4/2
 * @Description: Factory
 * @Version: 1.0
 */
/*interface Fruit {
    public void eat();
}
class Apple implements Fruit{
    @Override
    public void eat() {
        System.out.println("I like apple");
    }
}
class Orange implements Fruit{
    @Override
    public void eat() {
        System.out.println("I like orange");
    }
}
class FruitFactory{
    private FruitFactory(){}
    public static Fruit getInstance(String className){
        if("apple".equals(className)){
            return new Apple();
        }else if("orange".equals(className)){
            return new Orange();
        }
        return null;
    }
}*/
interface Fruit {
    public void eat();
}
class Apple implements Fruit{
    @Override
    public void eat() {
        System.out.println("I like apple");
    }
}
class Orange implements Fruit{
    @Override
    public void eat() {
        System.out.println("I like orange");
    }
}
class FruitFactory {
    private FruitFactory(){}
    public static Fruit getInstance(String className) throws ClassNotFoundException,
            IllegalAccessException, InstantiationException {
       Fruit fruit = null;
       //取得水果类的class对象，然后通过newinstance产生该类的对象
        fruit = (Fruit) Class.forName(className).newInstance();
        return fruit;
    }
}


