package Test2;

import java.util.Arrays;

/**
 * @ClassName test1
 * @Description 合并有序数组
 * @Author 86189
 * @Date 2022/6/21 19:24
 **/
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //定义两个头指针
        int p=0;
        int q=0;
        int cur=0;
        int[]temp=new int[m+n];
        while(p<m||q<n){
            if(q==n){
                //走到后面如果nums2走完了，nums1没走完，nums2下标q会停留在n的位置
                //之后要把nums1剩余的整数依次放进temp数组内，直到nums1下标不小于m跳出循环
                cur=nums1[p++];
            } else if(p==m){
                //同理，nums2没走完，nums1走完了
                cur=nums2[q++];
            } else if(nums2[q]>nums1[p]){
                cur=nums1[p++];
            } else {
                cur=nums2[q++];
            }
            temp[p+q-1]=cur;
        }
        for(int i=0;i<temp.length;i++){
            nums1[i]=temp[i];
        }
    }
}
public class test1 {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int[]nums1= {1, 2, 3, 0, 0, 0};
        int[]nums2={2,5,6};
        solution.merge(nums1,3,nums2,3);
        System.out.println(Arrays.toString(nums1));
    }

}
