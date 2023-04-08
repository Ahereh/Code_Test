package Counter;
/**
 * @ClassName Main
 * @Description 933.最近请求次数
 * @Author 86189
 * @Date 2022/5/13 13:57
 **/
import java.util.*;
class RecentCounter {
    List<Integer> list;     //定义一个List类引用，其内部类型为Integer
    public RecentCounter() {
        //RecentCounter类的构造方法
        //实例化list的实现类ArrayList(顺序表),当前列表内部为空
        list=new ArrayList<>();
    }
    
    public int ping(int t) {
        //在t时间内添加请求
        list.add(t);
        //如果列表头的添加时间不满足条件，则去除当前列表头，相对应的列表内有效数会-1
        //去除列表头后，之前的列表第二个位置会取代第一个位置的成为当前列表头
        //继续进行判断
        while(list.get(0)<(t-3000)){
            list.remove(0);
        }
        return list.size();
    }
}