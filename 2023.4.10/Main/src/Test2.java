import com.bit.www.Test;
import com.sun.deploy.perf.PerfRollup;

/**
 * @ClassName Test2
 * @Description TODO
 * @Author 86189
 * @Date 2023/4/12 15:45
 **/
class People{
    /**
        静态代码块 > 实例代码块 > 构造方法
     <注意>：字节码层面<clinit>是Java中的一个特殊方法，也称为类初始化方法。它是在类加载时由Java虚拟机调用的，
     用于执行静态初始化代码块和静态变量初始化。如果类没有静态初始化代码块或静态变量，则不会生成<clinit>方法。
     **/
    public static String emotion = "Nice";
    public int count;
    public static int score;

    class InClass{
        //InClass类相对于People类来说是内部类，而People类对于InClass来说是外部类
        public int a;
    }

    static {
        //静态代码块的优先级高于实例代码块【静态代码块无论定义了多少个对象，最终只执行一个】
        score = 100;
        System.out.println("shit!");
    }

    {
        //实例代码块优先于构造方法
        System.out.println("fuck you");
    }

    public People(int count) {
        this.count = count;
        System.out.println("good!");
    }

    @Override
    public String toString() {
        return "count = "+this.count;
    }
    void talking(){
        toString();
    }
    static void express(){
        People people = new People(5);
        people.toString();
    }
}
public class Test2 {
    public static void main(String[] args) {
        People people = new People(5);
        Test test = new Test();
        test.scan2();
    }
}
