package Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName Test
 * @Description 优先级队列---堆
 * @Author 86189
 * @Date 2022/5/28 17:17
 **/
class inCmp2 implements Comparator<Integer>{
    // 此时创建的是大根堆
    @Override
    public int compare(Integer o1, Integer o2) {
        return o2-o1;
    }
}
class inCmp implements Comparator<Integer> {

    @Override
    // 此时创建的是小根堆
    public int compare(Integer o1, Integer o2) {
        return o1-o2;
    }
}
public class Test {
    //时间复杂度为O(n*logn)
    //找前k个最大的元素
    //方法一:把当前堆建成一个大根堆，每次提取堆顶元素，取k次，即为前k个最大的元素
    public static int[] topK(int []arr,int k){
        inCmp2 inCmp2=new inCmp2();
        PriorityQueue<Integer>maxHeap=new PriorityQueue<>(k,inCmp2);
        int []ret=new int[k];
        for (int i = 0; i < arr.length; i++) {
            maxHeap.offer(arr[i]);
        }
        for (int i = 0; i <k; i++) {
            int t=maxHeap.poll();
            ret[i]=t;
        }
        return ret;
    }


    /*
     *  方法二
     *  arr:队列--堆数组
     * k:前k个优先级最高的元素
     * 此方法相较于第一种方法，速度更快
     * */
    //top-K问题(前k个最大的元素)
    public static int[]topK1(int[]arr,int k){
        inCmp inCmp=new inCmp();
        PriorityQueue<Integer> minHeap=new PriorityQueue<>(k,inCmp);

        for (int i = 0; i < k; i++) {
            minHeap.offer(arr[i]);
        }
        for (int i = k; i <arr.length ; i++) {
            int top=minHeap.peek();
            if(top<arr[i]){
                minHeap.poll();
                minHeap.offer(arr[i]);
            }
        }
        int []ret=new int[k];
        for(int i=0;i<k;i++){
            int r=minHeap.poll();
            ret[i]=r;
        }
        return ret;
    }

    public static void main(String[] args) {
        int []arr={5,10,3,6,8,15,2,1,56,33};
        int []ret=topK1(arr,3);
        System.out.println(Arrays.toString(ret));
    }
    public static void main2(String[] args) {
        int []arr={5,10,3,6,8,15,2,1,56,33};
        int []ret=topK1(arr,3);
        System.out.println(Arrays.toString(ret));
    }
    public static void main1(String[] args) {
        int[]arr={27,15,19,18,28,34,65,49,25,37};
        TestHeap testHeap=new TestHeap(arr);
        testHeap.creatHeap1(arr);//创建大根堆
        testHeap.push(95);//入队
        testHeap.pollHeap();//出队（删除）
        testHeap.display();
//        System.out.println();
//        TestHeap testHeap1=new TestHeap(arr);
//        testHeap1.creatHeap2(arr);//创建小根堆
//        testHeap1.display();
    }
}
