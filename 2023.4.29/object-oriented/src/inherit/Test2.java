package inherit;

/**
 * @ClassName Test2
 * @Description 继承中代码块的执行顺序
 * @Author 86189
 * @Date 2023/4/29 15:07
 **/
class People {
    protected int age;
    protected String name;
    protected static String sex;

    {
        this.age = 17;
        this.name = "Leno";
        System.out.println("父类：执行实例代码块");

    }

    static {
        sex = "male";
        System.out.println("父类：执行静态代码块");
    }

    public People(int age, String name) {
        this.age = age;
        this.name = name;
        System.out.println("父类：执行构造放方法");
        System.out.println("==================");
    }

    public String toString() {
        return "age = " + this.age + "; " +
                "name = " + this.name + "; " +
                "sex = " + sex;
    }
}

class Student extends People {

    {
        System.out.println("子类：执行实例代码块");

    }

    static {
        System.out.println("子类：执行静态代码块");
        System.out.println("==================");

    }

    public Student(int age, String name) {
        super(age, name);
        System.out.println("子类：执行构造放方法");
    }
}

public class Test2 {
    public static void main(String[] args) {
        Student student = new Student(21, "Leno");
        /*
        执行结果：
            父类：执行静态代码块
            子类：执行静态代码块
            ==================
            父类：执行实例代码块
            父类：执行构造放方法
            ==================
            子类：执行实例代码块
            子类：执行构造放方法
       */
        /**
            需要注意的是，静态代码块是类加载的时候执行的，这意味着一个类最多只执行一次静态代码块
         **/
        Student student1 =new Student(22,"Aida");
    }
}
