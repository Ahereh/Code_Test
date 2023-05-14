package polymorphism;

/**
 * @ClassName Test1
 * @Description 多态中方法的重写(重写是多态的一种表现)
 * 访问权限大小关系：
 * public > protected > default > private
 *
 * 多态的优点：（1）降低代码圈复杂度 （2）可扩展能力强
 *      缺点： 代码的运行效率低
 * 【注意】private不能修饰重写方法
 * @Date 2023/4/29 17:38
 **/
class Base {
    protected int count;
    protected String type;

    public Base() {

    }

    public Base(int count, String type) {
        this.count = count;
        this.type = type;
    }

    Base method(int a) {
        System.out.println("调用父类的method方法");
        return new Base(3, "Integer");
    }

    protected void method1() {

    }

    @Override
    public String toString() {
        return "Base{" +
                "count=" + count +
                ", type='" + type + '\'' +
                '}';
    }
}

class Derived extends Base {
    public Derived() {

    }

    public Derived(int count, String type) {
        super(count, type);
    }

    @Override
    public void method1() {
        //子类重写父类的方法，其访问修饰符的大小不能小于父类
        //此处可以是public，也可以是protected
    }

    @Override
    public Derived method(int a) {
        //子类方法重写的返回值类型可以和父类的方法不一样，但返回值类型得和父类构成继承关系
        System.out.println("调用子类的method方法");
        Derived derived = new Derived(5, "BigDecimal");
        return derived;
    }

    @Override
    public String toString() {
        return "Derived{" +
                "count=" + count +
                ", type='" + type + '\'' +
                '}';
    }

    //此处的两个add方法构成重载（访问修饰符，返回类型可以不一样/一样，但参数列表一定要不一样）
    public int add(int a ,int b){
        return a+b;
    }
    protected double add(double a,double b){
        return a+b;
    }
}
class Derived2 extends Base{
    @Override
    protected void method1() {
        System.out.println("子类2");
    }
}
public class Test1 {
    public static void main(String[] args) {
        Base base = new Base();
        Base base1 = new Derived();     //向上转型
        Base base2 = new Derived2();     //向上转型

        System.out.println(base.method(2));
        System.out.println(base1.method(2));


        if(base1 instanceof Derived){
            Derived derived = (Derived) base1;  //向下转型
            //instanceof关键字 可以检查该derived引用对象是否引用正确的 类(可以提高向下转型的安全性)
            System.out.println("Security!");
        }
        if(base1 instanceof Derived2){
            //因为base1引用的是Derived类，不是Derived2，所以instanceof检查后返回false
            Derived2 derived2 = (Derived2) base1 ;
            System.out.println("Security!");
        }
    }
}
