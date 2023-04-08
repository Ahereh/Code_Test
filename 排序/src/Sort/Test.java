package Sort;

import java.nio.channels.SelectableChannel;
import java.util.Arrays;
import java.util.Random;
import java.util.Stack;

/**
 * @ClassName Test
 * @Description 排序
 * @Author 阿杭
 * @Date 2022/5/30 9:27
 **/

public class Test {

    public static void swap(int []arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
    /**
     * 直接插入排序
     * 时间复杂度：[对数据敏感]
     *   最坏情况下：O(n^2)  逆序的
     *   最好情况下：数据是有序的 O(n)
     *   【直接插入排序的使用场景是：当数据量小，并且已经趋于有序的时候，使用直接插入排序】
     * 空间复杂度：O(1)
     * 稳定性：稳定的排序
     * @param arr
     */
    public static void directSort(int[]arr) {
        for (int i = 1; i <arr.length ; i++) {
            int temp=arr[i];
            int j=i-1;
            for (; j >=0 ; j--) {
                if(temp<arr[j]){
                    //因为temp用的是小于arr[j],那么此处的排序是稳定的。
                    //如果改成temp<=arr[j]，此处排序会变为不稳定。
                    //【注意】： 稳定的排序可以改成不稳定的，不稳定的排序不可以改成稳定的。
                    arr[j+1]=arr[j];
                }else{
                    break;
                }
            }
            arr[j+1]=temp;
        }
    }


    public static void shell(int k,int[]arr){
        //每次分组内部的排序
        for (int i = k; i < arr.length; i++) {
            int temp=arr[i];
            int j = i-k;
            for (; j >=0 ; j-=k) {
                if(arr[j]>temp){
                    arr[j+k]=arr[j];
                } else{
                    break;
                }
            }
            arr[j+k]=temp;
        }
    }
    /**
     * @Description:  希尔排序(此处排从小到大)
     * 通过不断分组排序，减少顺序偏差，但最后还是得堆整体进行一次排序
     * 稳定性：不稳定的排序
     * 空间复杂度：O(1)
     * @Param:  arr
     * @return:  void
     */
    public static void shellSort(int[]arr){
        for (int i = arr.length; i >1;i/=2 ) {
            shell(i,arr);
        }
        shell(1,arr);
    }


    /**
     * 时间复杂度:不管有序无序-》O(n^2)
     * 空间复杂度：O(1)
     * 稳定性：不稳定
    * @Description:  选择排序
    * @Param:  arr
    * @return:  void
    */
    public static void selectSort(int[]arr){
        for (int i = 0; i < arr.length; i++) {
            int minindex=i;
            for (int j = i+1; j < arr.length ; j++) {
                if(arr[minindex]>arr[j]){
                    minindex=j;
                }
            }
            swap(arr,minindex,i);
        }
    }

    //因为此处是创建大根堆，那么向下调整是需要比较大的一方，进行交换的
    public static void shiftDowen(int[]arr,int ret,int len){
        int child=ret*2+1;
        while(child<len){
            if(child+1<len&&arr[child]<arr[child+1]){
                child+=1;
            }
            if(arr[child]>arr[ret]){
                swap(arr,child,ret);
                ret=child;
                child=ret*2+1;
            } else{
                break;
            }
        }
    }
    public static void create(int []arr){
        for (int i = (arr.length-1-1)/2; i >=0 ; i--) {
            shiftDowen(arr,i,arr.length);
        }
    }
    /**
     * * 时间复杂度：O(n*logn)【不管数据是否有序 都是这样的】
     * 空间复杂度：O(1)
     * 稳定性：不稳定排序
    * @Description: 堆排序
    * @Param:   arr
    * @return: void
    */
    public static void heapSort(int []arr){
        /*此处是要从小到大排序
        * 先创建一个大根堆，然后再将堆顶元素，一个个放到最后的位置，结果就是一个从小到大排序的数组
        * */
        create(arr);    //创建了一个大根堆.

        for (int end=arr.length-1; end >=0;end--) {
            swap(arr,0,end);
            shiftDowen(arr,0,end);
        }
    }

    /**
     * 时间复杂度：O(N^2)
     * 空间复杂度：O(1)
     *  稳定性：稳定
    * @Description: 冒泡排序(优化版)
    * @Param:
    * @return:
    */
    public static void bubbleSort(int[]arr){
        for (int i = 0; i < arr.length-1; i++) {
            boolean ret=false;
            for (int j =0; j <arr.length-1-i ; j++) {
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                    ret=true;
                }
            }
            if(!ret){
                return ;
            }
        }
    }
    /**
     * Hoare法
     * 在最好的情况下是满二叉树：一共n层每一层比较n次，那么该情况下的时间复杂度为O(n*logn)，
     * 最坏情况下（数据有序的情况下）的时间复杂度为：O(n^2);     只有单支树（例：1 2 3 4 5）这种情况下的排序即为O(n^2)  第一次走n-1，
     * 第二次n-2，第三次走n-3,第四次走n-4  ，一共走n次，每次走n次，那么时间复杂度为O(n^2)
     * 空间复杂度：（递归的时候）好的情况是满二叉树以左分支的树干为高度O(logn)    坏的情况O(n)---最坏的情况是单分支的情况，数的个数即是树的高度
     * 稳定性：不稳定
     * @param arr
     * @param low
     * @param high
     * @return int
     */
    //快速排序方法一：(Hoare版)
    public static int paration(int []arr,int low,int high){
        int key=low;
        while(low<high){
            while(low<high&&arr[high]>=arr[key]){
                high--;
            }
            while(low<high&&arr[low]<=arr[key]){
                low++;
            }
            swap(arr,low,high);
        }
        swap(arr,key,low);
        return low;
    }
    /**
     * 挖坑法
     * @param arr
     * @param low
     * @param high
     * @return
     */
    //方法二：(挖坑法)
    public static int paration1(int []arr,int low,int high){
        int key=arr[low];
        while(low<high){
            while(low<high&&arr[high]>=key){
                high--;
            }
            arr[low]=arr[high];
            while(low<high&&arr[low]<=key){
                low++;
            }
            arr[high]=arr[low];
        }
        arr[low]=key;
        return low;
    }
    //前后指针法（第一种方法）
    public static int paration2(int[]arr,int low,int high){
        int prev=low;
        int cur=low+1;
        while(cur<=high){
            if(arr[cur]<arr[low]&&arr[++prev]!=arr[cur]){
                swap(arr,prev,cur);
            }
            cur++;
        }
        swap(arr,prev,low);
        return prev;
    }
    //前后指针法（第二种方法）
    public static int paration3(int[]arr,int low,int high){
        int key=arr[low];
        int ret=low+1;
        for (int i = low+1; i <=high ; i++) {
            if(arr[i]<key){
                swap(arr,ret,i);
                ret++;
            }
        }
        swap(arr,ret-1,low);
        return ret-1;
    }
    //①Hoare法
    public static void quickSort(int []arr,int left,int right){
        if(left>=right) return;
        int ret=paration(arr,left,right);
        quickSort(arr,left,ret-1);
        quickSort(arr,ret+1,right);
    }

    //②挖坑法
    public static void quickSort1(int []arr,int left,int right){
        if(left>=right) return;
        int ret=paration1(arr,left,right);
        quickSort1(arr,left,ret-1);
        quickSort1(arr,ret+1,right);
    }
    //区间插入优化
    public static void insertSortRange(int[]arr,int low,int end){
        for (int i = low+1; i <=end ; i++) {
            int temp=arr[i];
            int j = i-1;
            for (; j >=low; j--) {
                if(arr[j]>temp){
                    arr[j+1]=arr[j];
                } else{
                    break;
                }
            }
            arr[j+1]=temp;
        }
    }
    //三数取中法（median-of-three）（优化）
    public static int SelectPivotMedianOfThree(int[]arr,int low,int high){
        int mid=low+((high-low)>>>1);
        if(arr[low]<arr[high]){
            if(arr[mid]<arr[low]) {
                return low;
            }else if(arr[mid]>arr[high]){
                return high;
            } else{
                return mid;
            }
        } else{
            if(arr[mid]<arr[high]) {
                return high;
            }else if(arr[mid]>arr[low]){
                return low;
            } else{
                return mid;
            }
        }
    }

    //③前后指针法
    public static void quickSort2(int[]arr,int left,int right){
        if(left>=right)return;
        //当数据量少的时候且趋于有序的时候，可以是使用直接插入排序来进行优化
        //但本身并没有根本上解决有序情况下，递归深度太深的情况。
        //要想根本上解决---》尽量让每次划分更均匀
//        if(right-left+1<=70000){
//            //当数据小于1000个时，进行直接插入排序(优化)
//            insertSortRange(arr,left,right);
//            return;
//        }
        //三数去中法（优化）
        int p= SelectPivotMedianOfThree(arr,left,right);
        swap(arr,left,p);
        int ret=paration3(arr,left,right);
        quickSort2(arr,left,ret-1);
        quickSort2(arr,ret+1,right);
    }
    //④非递归快速排序
    public static void quickSort3(int[] arr,int left,int right){
        //要非递归进行快速排序，可以利用栈来完成
        //首先找到当前数组的基准
        int pivot=paration1(arr,left,right);
        Stack<Integer> stack=new Stack<>();
        //判断基准左边和右边的数据是否是2个或2个以上，如果只有1，则说明该数已有序
        //若大于或等于2个数据，则将该区间最左和最右两个数入栈
        if(pivot>left+1){
            stack.push(left);
            stack.push(pivot-1);
        }
        if(pivot<right-1){
            stack.push(pivot+1);
            stack.push(right);
        }
        //判断有序的条件为，当前栈为空
        while(!stack.isEmpty()){
            //首先将出两个栈顶元素分别为right、left
            //再通过这两个数，寻找当前区间的基准。
            right=stack.pop();
            left=stack.pop();
            pivot=paration1(arr,left,right);
            //之后重复同样操作，直到只剩一个数
            if(pivot>left+1){
                stack.push(left);
                stack.push(pivot-1);
            }
            if(pivot<right-1){
                stack.push(pivot+1);
                stack.push(right);
            }
        }
    }

    /**
     * merge()合并
     * @param arr
     * @param low
     * @param mid
     * @param high
     */
    public static void merge(int[]arr,int low,int mid,int high){
        int s1=low;
        int e1=mid;
        int s2=mid+1;
        int e2=high;
        int[]temp=new int[high-low+1];
        int k=0;
        while(s1<=e1&&s2<=e2){
            if(arr[s1]<arr[s2]){
                temp[k++]=arr[s1++];
            } else{
                temp[k++]=arr[s2++];
            }
        }
        while(s1<=e1){
            temp[k++]=arr[s1++];
        }
        while(s2<=e2){
            temp[k++]=arr[s2++];
        }
        for (int i = 0; i < temp.length; i++) {
            arr[i+low]=temp[i];
        }
    }
    /**
     * 时间复杂度：N*logN 【与数据是否有序没有关系】
     * 空间复杂度：O(n)
     * 稳定性：稳定的排序
     * 插入  冒泡   归并都是稳定的
     * @param arr
     */
    //☆归并排序
    public static void mergeSortInternal(int[]arr,int left,int right){
        if(left>=right) return;
        int mid=left+((right-left)>>>1);    //注意此处加括号
        mergeSortInternal(arr,left,mid);
        mergeSortInternal(arr,mid+1,right);
        merge(arr,left,mid,right);
    }
    //☆非递归的归并排序
    public static void mergeSortNor(int[]arr,int left,int right){
        int gap=1;  //gap代表组内数据的个数(例：gap=2为一组内有两个数据)
        while(gap<arr.length){
            //当组数等于或大于数组长度时，说明已经是有序
            for (int i = 0; i<arr.length; i+=gap*2) {
                left=i;
                int mid=left+gap-1;
                if(mid>=arr.length){
                    mid=arr.length-1;
                }
                right=mid+gap;
                if(right>=arr.length){
                    right=arr.length-1;
                }
                merge(arr,left,mid,right);
            }
            gap*=2;
        }
    }
    /**
     * 计数排序：(不基于比较的排序)
     * 时间复杂度：O(范围+N)
     * 空间复杂度：O(范围)
     * 计数排序和当前数据给定的范围是有关系的。
     *         int range = maxVal-minVal+1;
     *         集中的就好点；  0-100-》10
     * 稳定性：
     * @param arr
     */
    public static void courtSort(int[]arr,int left,int right){
        int minVal=arr[0];
        int maxVal=arr[0];
        //首先找到当前数组的最小值和最大值，确定计数的区间范围.
        for (int i = 1; i < arr.length; i++) {
            if(minVal>arr[i]){
                minVal=arr[i];
            }
            if(maxVal<arr[i]){
                maxVal=arr[i];
            }
        }
        //控制区间范围用于减少开辟的数组大小，如果给定的排序数值比较大，总不能开辟对应数值下标的数组
        int range=maxVal-minVal+1;  //区间范围
        int[] temp=new int[range];  //定义计数的数组，用于标记出现数值的次数
        for (int i = 0; i < arr.length; i++) {
            //可以通过arr[i]-minVal，让计数数组从0下标开始计数,节省空间
            //比如[90,100]，可以将其转换为[0,10]
            //遇到负数也同理，数组依旧可以按从0下标开始，存放出现数值的计数
            temp[arr[i]-minVal]++;  //在对应的下标位置++
        }
        int index=0;
        //遍历计数数组，将排好的值一一放回arr数组
        for (int i = 0; i < temp.length; i++) {
            while(temp[i]>0){
                arr[index++]=i+minVal;
                temp[i]--;
            }
        }
    }

    public static void test1(){
        Random random=new Random();
        int []arr=new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=i;       //插入有序的数组
//            arr[i]=random.nextInt(100000);     //将100000内随机的100000个数放进数组内
        }
        long start=System.currentTimeMillis();
        directSort(arr);
        long end=System.currentTimeMillis();
        System.out.println("插入排序:"+(end-start));
    }
    public static void test2(){
        Random random=new Random();
        int []arr=new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=i;       //插入有序的数组
//            arr[i]=random.nextInt(100000);     //将100000内随机的100000个数放进数组内
        }
        long start=System.currentTimeMillis();
        selectSort(arr);
        long end=System.currentTimeMillis();
        System.out.println("选择排序:"+(end-start));
    }
    public static void test3(){
        Random random=new Random();
        int []arr=new int[10_0000];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=i;       //插入有序的数组
//            arr[i]=random.nextInt(100000);     //将100000内随机的100000个数放进数组内
        }
        long start=System.currentTimeMillis();
        heapSort(arr);
        long end=System.currentTimeMillis();
        System.out.println("堆排序:"+(end-start));
    }
    public static void test4(){
        Random random=new Random();
        int []arr=new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=i;       //插入有序的数组
//            arr[i]=random.nextInt(100000);     //将100000内随机的100000个数放进数组内
        }
        long start=System.currentTimeMillis();
        bubbleSort(arr);
        long end=System.currentTimeMillis();
        System.out.println("冒泡排序:"+(end-start));
    }
    public static void test5(){
        Random random=new Random();
        int []arr=new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=i;       //插入有序的数组
//            arr[i]=random.nextInt(100000);     //将100000内随机的100000个数放进数组内
        }
        long start=System.currentTimeMillis();
        shellSort(arr);
        long end=System.currentTimeMillis();
        System.out.println("希尔排序"+(end-start));
    }
    /**
    * @Description:  快排时间测试
     *如果不进行优化，会随着递归深度的加深，造成栈溢出问题
     * 递归是要在栈上开辟内存的
    */
    public static void test6(){
        //快排
        Random random=new Random();
        int []arr=new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=i;       //插入有序的数组
//            arr[i]=random.nextInt(100000);     //将100000内随机的100000个数放进数组内
        }
        long start=System.currentTimeMillis();
//        quickSort(arr,0,arr.length-1);//Hoare法快排
//        quickSort1(arr,0, arr.length-1);//挖坑法快排
//        quickSort2(arr,0,arr.length-1);//前后指针快排
        quickSort3(arr,0,arr.length-1);//非递归快排
        long end=System.currentTimeMillis();
        System.out.println("快速排序"+(end-start));
    }

//    public static void main(String[] args) {
//        int[]arr={10,20,8,25,35,6,18,30,5,15,28};
//        shellSort(arr);
//        System.out.println(Arrays.toString(arr));
//    }
    public static void main(String[] args) {
        int[]arr = {8,1,6,3,7,4};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    public static void main3(String[] args) {
        int []arr={6,1,2,7,9,3,4,5,10,8};
//        quickSort(arr,0,arr.length-1);      //Hoare法
//        quickSort1(arr,0, arr.length-1);    //挖坑法
        quickSort2(arr,0,arr.length-1); //前后指针快排
//        quickSort3(arr,0,arr.length-1);//非递归快排
//        mergeSortInternal(arr,0, arr.length-1);//归并排序
//        mergeSortNor(arr,0, arr.length-1);//非递归排序
//        courtSort(arr,0,arr.length-1);//计数排序
        System.out.println(Arrays.toString(arr));
    }
    public static void main4(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
    }
    public static void main2(String[] args){
        //比较以上排序之间的速度
        Random random=new Random(); //以一个随机数组为例
        int []arr=new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=i;       //插入有序的数组
//            arr[i]=random.nextInt(100000);     //将100000内随机的100000个数放进数组内
        }

        long start=System.currentTimeMillis();
        directSort(arr);
        long end=System.currentTimeMillis();
        System.out.println("插入排序:"+(end-start));

        start=System.currentTimeMillis();
        selectSort(arr);
        end=System.currentTimeMillis();
        System.out.println("选择排序:"+(end-start));

        start=System.currentTimeMillis();
        heapSort(arr);
        end=System.currentTimeMillis();
        System.out.println("堆排序:"+(end-start));

        start=System.currentTimeMillis();
        bubbleSort(arr);
        end=System.currentTimeMillis();
        System.out.println("冒泡排序:"+(end-start));

        start=System.currentTimeMillis();
        shellSort(arr);
        end=System.currentTimeMillis();
        System.out.println("希尔排序"+(end-start));
    }
    public static void main1(String[] args) {
        int []arr={1,2,6,3,7,4,5,11,3,5,6,6,6,2};
//        directSort(arr);    //插入排序
//        shellSort(arr);     //希尔排序
//        selectSort(arr);    //选择排序
//        heapSort(arr);      //堆排序
        bubbleSort(arr);        //冒泡排序
        System.out.println(Arrays.toString(arr));
    }
}
