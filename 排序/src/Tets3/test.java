package Tets3;

/**
 * @ClassName test
 * @Description TODO
 * @Author 86189
 * @Date 2023/3/23 21:38
 **/

public class test {
    public static void swap(int []arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
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
    //①Hoare法
    public static void quickSort(int []arr,int left,int right){
        if(left>=right) return;
        int ret=paration(arr,left,right);
        quickSort(arr,left,ret-1);
        quickSort(arr,ret+1,right);
    }

    public static void main(String[] args) {
        int []arr = {9,7,8,-1,7,4,15,20};
        quickSort(arr,0,10);
        System.out.println(arr);
    }
}
