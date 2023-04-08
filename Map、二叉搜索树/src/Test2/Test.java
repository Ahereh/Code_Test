package Test2;

import java.util.*;

/**
 * @ClassName Test
 * @Description leetcode692：前k个高频单词【中等】   address:   https://leetcode.cn/problems/top-k-frequent-words/submissions/
 * @Author 86189
 * @Date 2022/7/2 22:12
 **/
class Solution {
    //思路:
    //第一步：遍历字符串，依次将字符串放入哈希表中并记录其次数
    //第二步：利用优先级队列的topK问题，找出前k个次数最多的单词
    //第三步：在构建小根堆的时候，判断其出单词频率相同时的字典顺序
    //第四步:最后要记得对前k个进行反转，因为求topk求完后的顺序是反着来的
    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer>map=new HashMap<>();
        //依次存入哈希表内
        for(int i=0;i<words.length;i++){
            String s=words[i];
            int count=map.getOrDefault(s,0)+1;
            map.put(s,count);
        }
        PriorityQueue<Map.Entry<String,Integer>> heap=new PriorityQueue<>(k,new Comparator<Map.Entry<String,Integer>>(){
            public int compare(Map.Entry<String,Integer> o1,Map.Entry<String,Integer> o2){
                if(o1.getValue().compareTo(o2.getValue())==0){
                    return o2.getKey().compareTo(o1.getKey());
                }
                //建立一个小根堆
                return o1.getValue().compareTo(o2.getValue());
            }
        });
        for(Map.Entry<String,Integer> s: map.entrySet()){
            if(heap.size()<k){
                heap.offer(s);
            } else{
                Map.Entry<String,Integer> temp=heap.peek();
                Integer val=temp.getValue();
                if(val.compareTo(s.getValue())<0){
                    heap.poll();
                    heap.offer(s);
                } else if(val.compareTo(s.getValue())==0){
                    String str=temp.getKey();
                    if(str.compareTo(s.getKey())>0){
                        heap.poll();
                        heap.offer(s);
                    }
                }
            }
        }
        List<String> list=new ArrayList<>();
        for(int i=0;i<k;i++){
            String s=heap.poll().getKey();
            list.add(s);
        }
        Collections.reverse(list);
        return list;
    }
}
public class Test {
    public static void main(String[] args) {
        Solution solution=new Solution();
        String[] s={"i", "love", "leetcode", "i", "love", "coding"};
        List<String>list=solution.topKFrequent(s,2);
        System.out.println(list);
    }
}
