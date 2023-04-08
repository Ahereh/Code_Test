package Test1;

/**
 * @ClassName Test1
 * @Description 汉诺塔
 * @Author 86189
 * @Date 2022/6/18 23:54
 **/
public class Test1 {
    public static void move(char pos1,char pos2){
        System.out.print(pos1+"->"+pos2+" ");
    }
    public static void hanNot(int n,char pos1,char pos2,char pos3){
        if(n==1) move(pos1,pos3);
        else {
            hanNot(n-1,pos1,pos3,pos2);
            move(pos1,pos3);
            hanNot(n-1,pos2,pos1,pos3);
        }
    }
    public static void main(String[] args) {
        hanNot(1,'A','B','C');
        System.out.println();
        hanNot(2,'A','B','C');
        System.out.println();
        hanNot(3,'A','B','C');
    }
}
