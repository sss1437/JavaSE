package pc;

/**
 * @Author: zhaodoudou
 * @Date: 2019/4/21
 * @Description: pc
 * @Version: 1.0
 */
public class Goods {
    private String name;
    private Double price;

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public Goods(String name, Double price) {

        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
