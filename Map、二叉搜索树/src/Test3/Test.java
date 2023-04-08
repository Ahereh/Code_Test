package Test3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName Test
 * @Description TODO
 * @Author 86189
 * @Date 2022/7/12 23:17
 **/
class Solution {
    //利用双指针，分别指向数组的头和尾
    //从头部开始判断下标是否等于val元素，如若满足，让尾指针覆盖头指针，再将尾指针左移一位继续判断
    //如果不等于val，则右移头指针继续查找
    //关键：利用指针移动覆盖等于val的下标元素
    public int removeElement(int[] nums, int val) {
        int first =0,last=nums.length;
        while(first<last){
            //循环结束条件：头指针和尾指针相遇时遍历结束
            if(nums[first]==val){
                //还需注意头指针和尾指针同时等于val的情况，该情况会导致头指针被覆盖后还是等于val
                //因此循环判断完val后，还需继续通过移动尾指针，来将头指针覆盖为不等于val的值
                nums[first]=nums[last-1];
                last--;
            } else {
                first++;
            }
        }
        return first;
    }
}

public class Test {
    static void fermin(int i){
        i++;
    }
    public static void main(String[] args){
        Test test = new Test();
        int i=0;
        fermin(i);
        i=++i;
        System.out.println(i);
    }
    public static void main1(String[] args) {
        Solution solution =new Solution ();
        int[]arr={3,2,2,3};
        int count =solution.removeElement(arr,3);
        for(int i=0;i<count;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
