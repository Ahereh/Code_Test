import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @ClassName Fib
 * @Description Fibonacci
 * @Author 86189
 * @Date 2023/4/12 14:47
 **/
public class Fib {
    //此处是一个简单的求斐波那契数列，加了一个定时器，每隔一段时间执行一次输入项
    public static int fib(int n) {
        // 0 1 1 2 3 5 8
        if (n == 1) return 0;
        if (n == 2) return 1;
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Timer timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            int n = 0;
            @Override
            public void run() {
                try {
                    System.out.print("Enter:");
                    n = Integer.parseInt(reader.readLine());
                    System.out.print("Fib=" + fib(n) + '\n');
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        //timer.schedule方法安排TimerTask对象在2000毫秒(2秒)后开始执行，并且每隔5000毫秒(5秒)执行一次
        timer.schedule(timerTask,2000,5000);
    }
}
