package Test1;
import java.util.*;
/**
 * @ClassName Test
 * @Description leetcode 【1089.复写零】  https://leetcode.cn/problems/duplicate-zeros/
 * @Author 86189
 * @Date 2022/6/18 14:58
 **/
class Solution {
    //用栈解决
    public void duplicateZeros(int[] arr) {
        Stack<Integer> stack=new Stack<>();
        for(int i=0;i<arr.length;i++){
            int temp=arr[i];
            stack.push(arr[i]);
            //此处注意有可能arr数组下标最后一个数为0，导致stack又入了两个0进栈导致栈内元素大于数组元素数量
            //判断是否栈内元素数量是否已经等于数组长度，再进行入栈
            if(arr[i]==0&&stack.size()!=arr.length){
                stack.push(arr[i]);
            }
            if(stack.size()==arr.length) break;
        }
        int index=arr.length-1;
        while(!stack.isEmpty()){
            if(index==-1) break;
            arr[index--]=stack.pop();
        }
    }
}
public class Test {
    public static void main(String[] args) {
        Solution solution=new Solution();
        int []arr={8,4,5,0,0,0,0,7};
        solution.duplicateZeros(arr);
        System.out.println(Arrays.toString(arr));
    }
}
