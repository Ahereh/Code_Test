package inherit;

import com.sun.org.apache.xpath.internal.operations.Or;

/**
 * @ClassName Test3
 * @Description final
 * @Date 2023/4/29 15:50
 **/
final class Origin{
    //被final修饰的类无法被继承
    /**
     final 关键字在 Java 中有以下作用：
     1. 修饰变量为常量，即一旦赋值后就不能再修改。
     2. 修饰方法，防止子类重写该方法。
     3. 修饰类，防止该类被继承。
     4. 修饰参数，表示该参数不可被修改。
     5. 修饰局部变量，表示该变量只能被赋值一次。
     **/
}

/* class Breanch extends Origin{
    此处会编译报错
}*/
class Origin1{
    protected int count=1;
    protected String type="BigDeciaml";
    final protected void method(){
        //此处的方法被final修饰后，能防止其子类重写该方法
        System.out.println("count="+this.count+" type="+this.type);
    }
}
class Branch extends Origin1{
    protected int count = 3 ;
    protected String type ="Integer";
   /* protected void method(){
        //此处子类Branch的method方法和父类Origin1重写了[但因为子类的method（）被final修饰，导致此处无法重写]
        System.out.println("count="+this.count+" type="+this.type);
    }*/
    public void method2(final int count,final String type){
        //final 修饰参数时，表示该参数无法被修改
        //例如：count = 2;
        this.count =count;
        this.type = type;
    }
}
public class Test3 {
    public static void main(String[] args) {
        Origin1 origin2 = new Origin1();
        Origin1 origin1 = new Branch();     //此处发生向上转型，编译器在编译的时候无法知道此处调用的方法是父类的还是父类
        //在程序运行起来后，会先判断父类的引用类型，在根据实例的类型去调用对应实例的方法，运行过程中即会发生“动态绑定”
        origin1.method();
        origin2.method();
        /**
            因为此处的子类Branch里的method无法重写父类Origin1，因此当实例对象时（即使此处发生了向上转型），因为继承的缘故，
         调用method方法，调用的其实时父类Origin1类对象里的method（）方法
            执行结果为：count=1 type=BigDeciaml
                      count=1 type=BigDeciaml
            如果父类method方法没有被final修饰，则执行结果为：
                      count=3 type=Integer
                      count=1 type=BigDeciaml
         **/
    }
}
