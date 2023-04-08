package Car;
import java.util.Arrays;
import java.util.Comparator;
class Car{
    public int position;
    public double time;
    Car(int a,double b){
        position=a;
        time=b;
    }
}
class Position implements Comparator<Car>{

    @Override
    public int compare(Car o1, Car o2) {
        return o1.position-o2.position;
    }
}

class Solution {
    public void insertSort(Car[] arr){
        for(int i=1;i<arr.length;i++){
            int j=i-1;
            Car temp=arr[i];
            for(;j>=0;j--){
                if(temp.position<arr[j].position){
                    arr[j+1]=arr[j];
                }else{
                    break;
                }
            }
            arr[j+1]=temp;
        }
    }
    public int carFleet(int target, int[] position, int[] speed) {
        Car []car=new Car[position.length];
        for(int i=0;i<position.length;i++){
            car[i]=new Car(position[i],(double)(target-position[i])/speed[i]);
        }
        Position position1=new Position();
        Arrays.sort(car,position1);
        int ret=0,t=position.length;
        for(int i=position.length-1;i>0;i--){
            if(car[i].time<car[i-1].time){
                ret++;
            } else{
                car[i-1]=car[i];
            }
        }
        return ret+1;
    }
}
public class Test{
    public static void main(String[] args) {
        Solution solution=new Solution();
        int target[]={6,8};
        int speed[]={3,2};
        int ret=solution.carFleet(12, target, speed);
        System.out.println(ret);
    }
}
