package Test;

import java.util.List;

/**
 * @ClassName TestDemo1
 * @Description TODO
 * @Author 86189
 * @Date 2022/4/30 23:37
 **/
interface Animal{
    String name="小黄";
    void voice();
}
interface Move{
    void move();
}
interface Swim{
    void swim();
}
interface Do extends Move,Swim{
}
class Dog implements Do{

    @Override
    public void move() {
        System.out.println("狗在跑！");
    }

    @Override
    public void swim() {
        System.out.println("狗在狗刨游泳!");
    }
}

public class TestDemo1 {
    public static void run(Move run){
        run.move();
    }
    public static void swim(Swim move){
        move.swim();
    }
    public static void main(String[] args) {
        Dog dog=new Dog();
        run(dog);
        swim(dog);
    }
}
