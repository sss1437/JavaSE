package reflex;

/**
 * @Author: zhaodoudou
 * @Date: 2019/4/5
 * @Description: java.vo
 * @Version: 1.0
 */
public class Emp {
    private String name;
    private String job;
    public Emp(){}

    public Emp(String job) {

        this.job = job;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {

        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }

}

