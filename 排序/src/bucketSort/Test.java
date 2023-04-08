package bucketSort;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName Test
 * @Description 桶排序
 * @Author 86189
 * @Date 2022/6/16 22:41
 **/
public class Test {
    private static int indexFor(int a,int min,int step){
        return  (a-min)/step;
    }
    private static void insertSort(List<Integer> bucket){
        for (int i = 1; i <bucket.size(); i++) {
            int j=i-1;
            int temp=bucket.get(i);
            for (; j >=0&&bucket.get(j)>temp ; j--) {
                bucket.set(j+1,bucket.get(j));
            }
            bucket.set(j+1,temp);
        }
    }
    private static void bucketSort(int[] arr){
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for (int a:arr) {
            if(min>a) min=a;
            if(max<a) max=a;
        }
        List bucketArr=new ArrayList<List<Integer>>();
        int bucketNum=max/10-min/10+1;
        for (int i = 0; i < bucketNum; i++) {
            bucketArr.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < arr.length; i++) {
            int num=indexFor(arr[i],min,10);
            ((ArrayList<Integer>)bucketArr.get(num)).add(arr[i]);
        }
        int index=0;
        ArrayList<Integer> ret=null;
        for (int i = 0; i <bucketNum ; i++) {
            ret=(ArrayList<Integer>)bucketArr.get(i);
            insertSort(ret);
            for (int k:ret) {
                arr[index++]=k;
            }
        }
    }

    public static void main(String[] args) {
        int[]arr=new int[]{6,1,2,7,9,3,4,5,10,8};
        bucketSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
