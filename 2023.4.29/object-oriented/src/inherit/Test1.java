package inherit;
/**
 * @ClassName Test2
 * @Description 继承super和this的引用
 * @Date 2023/4/29 15:07
 **/
class Base{
    int count;
    String type;

    public Base(){
        System.out.println("无参！");
    }
    public Base(int count, String type) {
        this.count = count;
        this.type = type;
    }

}

class Derived extends Base{
    /**
     // Derived类继承父类，编译器会默认提供一个无参数的隐式构造方法给父类
     【但如果父类的构造方法是有参数或不是编译器默认提供的，则子类构造方法需要调用父类的构造方法】
        ！先有父后有子，在实例化子类对象时，在子类的构造方法中会先调用父类的构造方法【而调用父类的构造方法会用到super引用】
     **/
    public Derived (int count,String type){
        //注意：super是对父类的引用，this是对当前对象的引用，一个构造方法中两者只能出现其一
        // （在子类构造方法中，super(...)调用父类构造时，必须是子类构造函数中第一条语句）
        //  (this()在子类构造方法内是调用子类其他被重载的构造方法，也必须在构造方法内的第一行，和super()调用父类构造方法冲突)
        super(count,type);

    }
    public void print(){
        System.out.println("count = "+super.count+" type = "+super.type);
    }
}

public class Test1 {
    public static void main(String[] args) {
        Derived derived =new Derived(5,"BigDecimal");
        derived.print();
    }
}
