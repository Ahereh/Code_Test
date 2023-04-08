import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @ClassName TestDemo1
 * @Description 扑克牌---顺序表实现
 * @Author 86189
 * @Date 2022/4/30 0:41
 **/
class Card{
    private String pattern;
    private int count;

    public Card(String pattern, int count) {
        this.pattern = pattern;
        this.count = count;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "[ "+pattern+" "+count+" ]";
    }
}
public class TestDemo1 {
    public static final String []suit={"♥","♦","♠","♣"};
    public static List<Card> setBox(){
        List <Card> box=new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            for (int j = 1; j <=13 ; j++) {
                String suits=suit[i];
                Card card=new Card(suits,j);
                box.add(card);
            }
        }
        return box;
    }
    public static void swap(List<Card>box,int i,int j){
        Card temp=box.get(i);
        box.set(i,box.get(j));
        box.set(j,temp);
    }
    public static void washCard(List<Card>box){
        for (int i = box.size()-1; i >0 ; i--) {
            Random random=new Random();
            int index=random.nextInt(i);
            swap(box,index,i);
        }
    }
    public static void main(String[] args) {
        List <Card>box=setBox();
        System.out.println("洗牌前:"+box);
        washCard(box);
        System.out.println("洗牌后:"+box);

        //给三个人各自轮流发5张牌
        List<List<Card>> hands=new ArrayList<>();
        List<Card>hand1=new ArrayList<>();
        List<Card>hand2=new ArrayList<>();
        List<Card>hand3=new ArrayList<>();
        hands.add(hand1);
        hands.add(hand2);
        hands.add(hand3);

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 3; j++) {
                Card card=box.remove(0);
                hands.get(j).add(card);
            }
        }
        System.out.println("第一个人的牌:"+hand1);
        System.out.println("第二个人的牌:"+hand2);
        System.out.println("第三个人的牌:"+hand3);
    }
}
