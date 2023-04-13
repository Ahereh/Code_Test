/**
 * @ClassName Test1
 * @Description TODO
 * @Author 86189
 * @Date 2023/4/10 10:55
 **/
class Animal{
    public int age;
    public String name;

    public Animal(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "age="+this.age+" name="+this.name;
    }
}
class Dog extends Animal{

    public Dog(int age, String name) {
        super(age, name);
    }

}
public class Test1 {
    public static void main(String[] args) {
        Dog dog1 = new Dog(2,"KaDi");
        System.out.println(dog1.toString());;
    }
}
