package LinkList;

/**
 * @ClassName Main
 * @Description TODO
 * @Author 86189
 * @Date 2022/4/30 11:07
 **/
public class Main {
    public static void main(String[] args) {
        MyLinkList myLinkList=new MyLinkList();
        myLinkList.crative();
        int ret=myLinkList.size();
        System.out.println(ret);
        myLinkList.display();
        System.out.println("=============");
        System.out.println();
        myLinkList.addFirst(9);
        myLinkList.addLast(10);
        myLinkList.display();
        System.out.println();
        System.out.println("==========");
        myLinkList.addIndex(2,555);
        myLinkList.display();
        System.out.println(myLinkList.contains(555));
        myLinkList.remove(555);
        myLinkList.display();

    }
}
