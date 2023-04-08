package Counter;

/**
 * @ClassName Main
 * @Description TODO
 * @Author 86189
 * @Date 2022/5/13 13:57
 **/
public class Main {
    public static void main(String[] args) {
        RecentCounter recentCounter=new RecentCounter();
        System.out.println(recentCounter.ping(1));
        System.out.println(recentCounter.ping(100));
        System.out.println(recentCounter.ping(3001));
        System.out.println(recentCounter.ping(3002));
    }
}
