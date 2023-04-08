/**
 * @ClassName TestDemo5
 * @Description TODO
 * @Author 86189
 * @Date 2022/5/8 15:27
 **/
class Soulution{
    public String stringReturn(String s1,String s2){
        int length=Math.min(s1.length(),s2.length());
        int i=0;
        while(i<length&&s1.charAt(i)==s2.charAt(i)){
            i++;
        }
        return s1.substring(0,i);
    }
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0||strs==null){
            return "";
        }
        String ret=strs[0];
        for(int i=1;i<strs.length;i++){
            if(ret.length()==0){
                return "";
            }
           ret=stringReturn(ret,strs[i]);
        }
        return ret;
    }
}
public class TestDemo5 {
    public static void main(String[] args) {
        String []arr={"flower","flow","flight"};
        Soulution soulution=new Soulution();
        System.out.println(soulution.longestCommonPrefix(arr));
    }
}
