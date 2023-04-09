import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Test
 * @Description TODO
 * @Author 86189
 * @Date 2023/4/9 9:41
 **/
class Animal{
    public int age ;
    public double heigth;
    public Animal(int a,double height){
        this.age = a;
        this.heigth = height;
    }
    public void print(){
        System.out.println(this.heigth+" "+this.age);
    }

}

class Dog extends Animal{

    public Dog(int a, double height) {
        super(a, height);
    }
}

public class Test {
    public static void fun(int a,int b){
        System.out.println("Fuck");
    }
    public static int [] grad(int []arr,int a){
        for(int i = 0;i<arr.length;i++){
            arr[i] = a;
        }
        System.out.println(arr);
        return arr;
    }
    public static void main1(String[] args) {
        List<Integer> list = new ArrayList<>();

        list.add(1);
        System.out.println(list);

        fun(1,2);
        Animal animal = new Animal(25,66.66);
        animal.print();
        double []arr = new double[]{1,2,3,4,5};
        System.out.println(arr);
        for (double a:arr) {
            System.out.print(a+" ");
        }
        System.out.println();
        System.out.println(Arrays.toString(arr));
        System.out.println("========================");
        int []arr1 = new int[5];
        int []arr2 = grad(arr1,3);
        System.out.println(arr1+" "+arr2);

        int str = 32432;
        System.out.println(Integer.valueOf(str));
    }

    public static int BinarySearch(int []arr,int src){
        int left  =0,right = arr.length -1;
        while(left <= right){
            int mid = ((right - left)>>>1) + left;
            if(arr[mid]<src){
                left = mid+1;
            }else if(arr[mid] > src){
                right = mid-1;
            }else{
                return mid;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int []arr1 = new int[]{1,2,3,4};
        int []arr2=  Arrays.copyOf(arr1,4);
        int []arr3 = new int[3];
        System.arraycopy(arr1,0,arr3,0,3);
        int []arr4 = Arrays.copyOfRange(arr1,2,4);

        System.out.println(Arrays.toString(arr2));
        System.out.println(Arrays.toString(arr3));
        System.out.println(Arrays.toString(arr4));

        int []arr5 = arr1.clone();
        System.out.print(Arrays.toString(arr5));

        int []array = new int[]{1,2,3,4,5,6,7,8,9,10};
        System.out.println(BinarySearch(array,4));

    }
}
