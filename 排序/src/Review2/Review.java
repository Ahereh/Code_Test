package Review2;

import java.util.*;

/**
 * @ClassName Review
 * @Description TODO
 * @Author 86189
 * @Date 2022/6/14 21:57
 **/
public class Review {
    public static void swap(int []arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
    /**
    * @Description:插入排序
    * @Param:arr，left，right
    * @return:void
    */
    public static void directSort(int[]arr,int left,int right){
        for(int i=left+1;i<arr.length;i++){
            int temp=arr[i];
            int j=i-1;
            for(;j>=0;j--){
                if(arr[j]>temp){
                    arr[j+1]=arr[j];
                } else{
                    break;
                }
            }
            arr[j+1]=temp;
        }
    }
    /**
    * @Description:希尔排序
    * @Param:arr,gap
    * @return:void
    */
    public static void shell(int []arr,int gap){
        for (int i = gap; i <arr.length ; i++) {
            int j=i-gap;
            int temp=arr[i];
            for (; j >=0 ; j-=gap) {
                if(arr[j]>temp){
                    arr[j+gap]=arr[j];
                } else{
                    break;
                }
            }
            arr[j+gap]=temp;
        }
    }
    public static void shellSort(int[]arr){
        for (int i = arr.length-1; i >0; i/=2) {
            shell(arr,i);
        }
        shell(arr,0);
    }
    /**
    * @Description:选择排序
    * @Param:arr
    * @return:void
    */
    public static void selectSort(int []arr){
        for (int i = 0; i <arr.length; i++) {
           int minindex=i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[minindex]>arr[j]){
                    minindex=j;
                }
            }
            swap(arr,minindex,i);
        }
    }
    /**
    * @Description:堆排序
    * @Param:arr
    * @return:void
    */
    //创建一个大根堆
    public static void create(int []arr){
        for (int i = (arr.length-1-1)/2; i >=0 ; i--) {
            shiftDown(arr,i,arr.length);
        }
    }
    public static void shiftDown(int[]arr,int root,int len){
        int child=root*2+1;
        while(child<len){
            if(child+1<len&&arr[child+1]>arr[child]){
                child+=1;
            }
            if(arr[root]<arr[child]) {
                swap(arr,root,child);
                root=child;
                child=root*2+1;
            } else{
                break;
            }

        }

    }
    public static void heapSort(int[]arr){
        create(arr);
        for (int i = arr.length-1; i >=0 ; i--) {
            swap(arr,0,i);
            shiftDown(arr,0,i);
        }
    }
    /**
    * @Description:冒泡排序
    * @Param:arr
    * @return:void
    */
    public static void bubbleSort(int[]arr){
        for (int i = 0; i < arr.length-1 ; i++) {
            boolean ret=true;
            for (int j =0 ; j <arr.length-1-i; j++) {
                if(arr[j]>arr[j+1]){
                    swap(arr,j,j+1);
                    ret=false;
                }
            }
            if(ret) return;
        }
    }
    /**
    * @Description:快速排序
    * @Param:arr
    * @return:void
    */
    //Hoare法
    public static int paration1(int[]arr,int low,int high){
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
    public static void quickSort1(int[]arr,int left,int right){
        if(left>=right) return;
        int ret=paration1(arr,left,right);
        quickSort1(arr,left,ret-1);
        quickSort1(arr,ret+1,right);
    }
    //挖坑法
    public static int paration2(int[]arr,int low,int high){
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
    public static void quickSort2(int[]arr,int left,int right){
        if(left>=right) return;
        int ret=paration2(arr,left,right);
        quickSort2(arr,left,ret-1);
        quickSort2(arr,ret+1,right);
    }
    //前后指针法（第一种）
    public static int paration3(int[]arr,int low,int high){
        int key=arr[low];
        int cur=low+1;
        for (int i = low+1; i <=high; i++) {
            if(arr[i]<key){
                swap(arr,cur,i);
                cur++;
            }
        }
        swap(arr,low,cur-1);
        return cur-1;
    }
    //前后指针法（第二种）
    public static int paration4(int[]arr,int low,int high){
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
    public static void quickSort3(int[]arr,int left,int right){
        if(left>=right) return;
//        if(right-left+1<=5000){
//            insertSortRange(arr,left,right);  //区间插入优化
//            return;
//        }
        int p=SelectPivotMedianOfThree(arr,left,right);
        swap(arr,left,p);
        int ret=paration4(arr,left,right);
        quickSort3(arr,left,ret-1);
        quickSort3(arr,ret+1,right);
    }
    //快排中的优化（区间插入）
    public static void insertSortRange(int[]arr,int low,int high){
        for (int i = low+1; i <=high ; i++) {
            int j=i-1;
            int temp=arr[i];
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
    //快排中的优化（三数取中法）
    public static int SelectPivotMedianOfThree(int[]arr,int low,int high){
        int mid=low+(high-low)>>>1;
        if(arr[low]<arr[high]){
            if(arr[mid]<arr[low]){
                return low;
            } else if(arr[mid]>arr[high]){
                return high;
            } else{
                return mid;
            }
        } else{
            if(arr[mid]<arr[high]){
                return high;
            } else if(arr[mid]>arr[low]){
                return low;
            } else{
                return mid;
            }
        }
    }
    //非递归快速排序
    public static void quickSort4(int []arr,int left,int right){
        int pivot=paration1(arr,left,right);
        Stack<Integer> stack=new Stack<>();
        if(pivot>left+1){
            stack.push(left);
            stack.push(pivot-1);
        }
        if(pivot<right-1){
            stack.push(pivot+1);
            stack.push(right);
        }
        while(!stack.isEmpty()){
            right=stack.pop();
            left=stack.pop();
            pivot=paration1(arr,left,right);
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
    //归并排序
    public static void mergeSort(int[]arr,int left,int right){
        if(left>=right) return;
        int ret=left+((right-left)>>>1);
        mergeSort(arr,left,ret);
        mergeSort(arr,ret+1,right);
        merge(arr,left,ret,right);
    }
    public static void merge(int[]arr,int low,int mid,int high){
        int s1=low;
        int e1=mid;
        int s2=mid+1;
        int e2=high;
        int i=0;
        int[]temp=new int[high  -low+1];
        while(s1<=e1&&s2<=e2){
            if(arr[s1]>arr[s2]){
                temp[i++]=arr[s2++];
            } else{
                temp[i++]=arr[s1++];
            }
        }
        while(s1<=e1){
            temp[i++]=arr[s1++];
        }
        while(s2<=e2){
            temp[i++]=arr[s2++];
        }
        for (int j = 0; j < temp.length; j++) {
            arr[j+low]=temp[j];
        }
    }
    //非递归归并排序
    public static void mergeSort1(int[]arr,int left,int right){
        int gap=1;
        while(gap<arr.length){
            for (int i = 0; i < arr.length; i+=gap*2) {
                left=i;
                int mid=(left+gap)-1;
                if(mid>=arr.length){
                    mid=arr.length-1;
                }
                right=(mid+gap);
                if(right>=arr.length){
                    right=arr.length-1;
                }
                merge(arr,left,mid,right);
            }
            gap*=2;
        }
    }
    //计数排序
    public static void courtSort(int[]arr,int left,int right){
        int minvalue=arr[left];
        int maxvalue=arr[right];
        for (int i = 0; i < arr.length; i++) {
            if(minvalue>arr[i]){
                minvalue=arr[i];
            }
            if(maxvalue<arr[i]){
                maxvalue=arr[i];
            }
        }
        int range=maxvalue-minvalue+1;
        int[]temp=new int[range];
        for (int i = 0; i < temp.length; i++) {
            temp[arr[i]-minvalue]++;
        }
        int index=0;
        for (int i = 0; i <temp.length ; i++) {
            while(temp[i]>0){
                arr[index++]=i+minvalue;
                temp[i]--;
            }
        }
    }
    //桶排序（第一种方法）
    public static void bucketArr1(int[]arr){
        int min=Integer.MAX_VALUE;
        int max=Integer.MIN_VALUE;
        for (int a:arr) {
            //找到当前数组中的最小值和最大值，借此来确定桶的区间
            if(max<a){
                max=a;
            }
            if(min>a){
                min=a;
            }
        }
        //计算桶的数量
        int bucketCount=(max-min)/arr.length+1;     //视情况进行修改，此处可能有些时候不太好用
        ArrayList<ArrayList<Integer>> bucket=new ArrayList<>(bucketCount);
        //创建桶
        for (int i = 0; i < bucketCount; i++) {
            bucket.add(new ArrayList<>());
        }
        //在桶内放置元素
        for (int i = 0; i < arr.length; i++) {
            int num=(arr[i]-min)/arr.length;
            bucket.get(num).add(arr[i]);
        }
        //对桶内元素进行排序
        for (int i = 0; i < bucket.size(); i++) {
            Collections.sort(bucket.get(i));
        }
        //排完序后再重新放回原来的数组
        int index=0;
        for (int i = 0; i < bucket.size(); i++) {
            for (int j = 0; j < bucket.get(i).size(); j++) {
                arr[index++]=bucket.get(i).get(j);
            }
        }
    }
    //桶排序（第二种方法）
    private static int indexFor(int a,int min,int step){
        return (a-min)/step;
    }
    public static void bucketArr2(int[]arr){
        int min=arr[0],max=arr[0];
        for (int a:arr) {
            if(max<a) max=a;
            if(min>a) min=a;
        }
        int bucketNum=max/10-min/10+1;  //视情况进行修改，此处可能有些时候不太好用
        List bucket=new ArrayList<List<Integer>>();
        //创建桶
        for (int i = 0; i < bucketNum; i++) {
            bucket.add(new ArrayList<Integer>());
        }
        //在桶内放置元素
        for (int i = 0; i < arr.length; i++) {
            int num=indexFor(arr[i],min,10);
            ((ArrayList<Integer>)bucket.get(num)).add(arr[i]);
        }
        ArrayList<Integer> bucketArr=null;
        int index=0;
        //对每个桶内的元素进行排序并还给原来的数组
        for (int i = 0; i < bucket.size(); i++) {
            bucketArr=(ArrayList<Integer>)bucket.get(i);
            insertSort(bucketArr);
            //此处相较于下面的较好一点
            for (int b:bucketArr) {
                arr[index++]=b;
            }
        }
        //将排序好后的桶内元素，赋回原来的数组里
//        for (int i = 0; i < bucketNum; i++) {
//            for (int j = 0; j < ((ArrayList<Integer>)bucket.get(i)).size(); j++) {
//                arr[index++]=((ArrayList<Integer>)bucket.get(i)).get(j);
//            }
//        }
    }
    //桶内的插入排序
    public static void insertSort(List<Integer> bucket){
        for (int i = 1; i <bucket.size() ; i++) {
            int j=i-1;
            int temp=bucket.get(i);
            for (; j >=0 ; j--) {
                if(bucket.get(j)>temp){
                    bucket.set(j+1,bucket.get(j));
                } else{
                    break;
                }
            }
            bucket.set(j+1,temp);
        }
    }
    //基数排序
    public static void RadixSort(int[]arr){

    }
    public static void main(String[] args) {
        int[]arr={6,1,2,7,9,3,4,5,10,8};
//        quickSort4(arr,0,arr.length-1);
//        mergeSort1(arr,0,arr.length-1);
//        courtSort(arr,0,arr.length-1);
        bucketArr2(arr);
        System.out.println(Arrays.toString(arr));


    }
}
