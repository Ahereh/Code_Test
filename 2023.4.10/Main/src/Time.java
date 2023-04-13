import java.util.Timer;
import java.util.TimerTask;

/**
 * @ClassName Time
 * @Description TODO
 * @Author 86189
 * @Date 2023/4/12 15:11
 **/
public class Time {
    public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTask task = new TimerTask() {
            int k = 0;
            @Override
            public void run() {
                k++;
                System.out.println("定时器计时了"+k+"次");
            }
        };
        timer.schedule(task,0,1000);
    }
}
