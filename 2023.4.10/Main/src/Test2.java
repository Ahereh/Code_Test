import com.sun.deploy.perf.PerfRollup;

/**
 * @ClassName Test2
 * @Description TODO
 * @Author 86189
 * @Date 2023/4/12 15:45
 **/
class People{
    public static String emotion = "Nice";
    public int count;

    public People(int count) {
        this.count = count;
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
        People people1 =new People(6);
        System.out.println(People.emotion);
        System.out.println(people.emotion);

    }
}
