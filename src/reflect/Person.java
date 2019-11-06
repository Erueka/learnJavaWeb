package reflect;

/**
 * @author Ling
 * Created on 2019/11/6
 */
// 演示用类
public class Person {
    private String name;
    private int age;
    public String publicA;
    public String publicB;
    public String publicC;
    public String publicD;

    public Person(){

    }

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

    public void eat() {
        System.out.println("I'm eating.");
    }

    public void sleep() {
        System.out.println("I'm sleeping.");
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", publicA='" + publicA + '\'' +
                ", publicB='" + publicB + '\'' +
                ", publicC='" + publicC + '\'' +
                ", publicD='" + publicD + '\'' +
                '}';
    }
}
