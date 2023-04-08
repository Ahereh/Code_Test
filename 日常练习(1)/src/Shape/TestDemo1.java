package Shape;

/**
 * @ClassName TestDemo1
 * @Description TODO
 * @Author 86189
 * @Date 2022/4/30 15:23
 **/
abstract class Shape{
     abstract public void draw();
     public static void create(){
         System.out.println("图形创造!");
     }

}
class Circle extends Shape{
    @Override
    public void draw() {
        System.out.println("⚪");
    }
}
class triangle extends Shape{

    @Override
    public void draw() {
        System.out.println("▲");
    }
}
class square extends Shape{

    @Override
    public void draw() {
        System.out.println("□");
    }
}
public class TestDemo1 {
    public static void main(String[] args) {
        Shape.create();
    }
}
