package Review;

import java.util.Arrays;

/**
 * @ClassName SortReview
 * @Description 排序(从小到大)
 * @Author 86189
 * @Date 2022/6/3 9:44
 **/
public class SortReview {
    public static void swap(int[]arr,int a,int b){
        //交换
        int t=arr[a];
        arr[a]=arr[b];
        arr[b]=t;
    }
    public static void insertSort(int []arr){
        //插入排序
        for (int i = 1; i < arr.length; i++) {
            int temp=arr[i];
            int j=i-1;
            for (; j >=0; j--) {
                if(arr[j]>temp) {
                    arr[j+1]=arr[j];
                } else{
                    break;
                }
            }
            arr[j+1]=temp;
        }
    }
    public static void shell(int []arr,int k){
        for (int i = k; i < arr.length; i++) {
            int temp=arr[i];
            int j=i-k;
            for (; j >=0; j-=k) {
                if(arr[j]>temp) {
                    arr[j+k]=arr[j];
                } else{
                    break;
                }
            }
            arr[j+k]=temp;
        }

    }

    public static void shellSort(int []arr){
        for (int i = arr.length; i >1 ; i/=2) {
            shell(arr,i);
        }
        shell(arr,1);
    }
    public static void selectSort(int []arr){
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
    public static void shiftDown(int []arr,int i,int len) {
        int child = i * 2 + 1;
        while (child < len) {
            if (child + 1 < len && arr[child] < arr[child + 1]) {
                child++;
            }
            if(arr[child]>arr[i]){
                swap(arr,child,i);
                i=child;
                child=i*2+1;
            } else{
                break;
            }
        }
    }

    public static void create(int[]arr){
        //创建一个大根堆
        for (int i = (arr.length-1-1)/2; i >=0 ; i--) {
            shiftDown(arr,i, arr.length);
        }
    }
    public static void heapSort(int []arr){
        create(arr);
        for (int i = arr.length-1;i >=0 ; i--) {
            swap(arr,0,i);
            shiftDown(arr,0,i);
        }
    }
    public static void bubbleSort(int []arr){
        for (int i = 0; i < arr.length-1; i++) {
            boolean ret=false;
            for (int j = 0; j < arr.length-i-1; j++) {
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                    ret=true;
                }
            }
            if(!ret) break;
        }
    }
    //前后指针法
    public static int paration(int []arr,int low,int high){
        int key=arr[low];
        int prev=low+1;
        for(int i=low+1;i<=high;i++){
            if(arr[i]<key){
                swap(arr,prev,i);
                prev++;
            }
        }
        swap(arr,prev-1,low);
        return prev-1;
    }
    //三数取中法优化
    public static int majorization(int[]arr,int left,int right){
        int mid=left+((right-left)>>>1);
        if(arr[left]<arr[right]){
            if(arr[mid]<arr[left]){
                return mid;
            } else if(arr[mid]>arr[right]){
                return left;
            } else{
                return right;
            }
        } else{
            if(arr[mid]<arr[left]){
                return mid;
            } else if(arr[mid]<arr[right]){
                return right;
            } else{
                return left;
            }
        }
    }
    public static void quickSort(int []arr,int left,int right){
        if(left>=right) return;

        //三数取中法优化
        int temp=majorization(arr,left,right);
        swap(arr,left,temp);

        int prv=paration(arr,left,right);
        quickSort(arr,left,prv-1);
        quickSort(arr,prv+1,right);
    }
    public static void main(String[] args) {
        int []arr={9,1,2,5,7,4,8,6,3,5};
/*        insertSort(arr);    //插入排序
        System.out.println(Arrays.toString(arr));*/
/*        shellSort(arr);     //希尔排序
        System.out.println(Arrays.toString(arr));*/
/*        selectSort(arr);    //选择排序
        System.out.println(Arrays.toString(arr));*/
/*        heapSort(arr);
        System.out.println(Arrays.toString(arr));*/
        /*bubbleSort(arr);
        System.out.println(Arrays.toString(arr));*/
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
