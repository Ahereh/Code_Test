package LinkList;

import java.util.LinkedList;
import java.util.List;

/**
 * @ClassName LIst
 * @Description TODO
 * @Author 86189
 * @Date 2022/4/30 10:57
 **/
public class MyLinkList {
    static class ListNote{
        public int value;
        public ListNote next;

        public ListNote(int value) {
            this.value = value;
        }
    }
    public ListNote head;
    public void crative(){
        ListNote listNote1=new ListNote(1);
        ListNote listNote2=new ListNote(2);
        ListNote listNote3=new ListNote(3);
        ListNote listNote4=new ListNote(4);
        ListNote listNote5=new ListNote(5);
        this.head=listNote1;
        listNote1.next=listNote2;
        listNote2.next=listNote3;
        listNote3.next=listNote4;
        listNote4.next=listNote5;
    }
    //头插法
    public void addFirst(int data){
        ListNote cur=new ListNote(data);
        if(head==null){
            System.out.println("链表为空!");
        }
        cur.next=this.head;
        this.head=cur;
    };
    //尾插法
    public void addLast(int data){
        ListNote last=new ListNote(data);
        if(head==null){
            System.out.println("链表为空!");
        }
        ListNote cur=this.head;
        while(cur!=null){
            if(cur.next==null){
                cur.next=last;
                return;
            }
            cur=cur.next;
        }
    };
    public void Ingoreindex(int index){
        if(index<0||index>size()){
            throw new LinkListIndexException("插入任意位置节点时，index不合法");
        }
    }
    public ListNote findIndexSubOne(int index){
        ListNote cur=this.head;
        while(index-1!=0){
            cur=cur.next;
            index--;
        }
        return cur;
    }
    //任意位置插入,第一个数据节点为0号下标
    public void addIndex(int index,int data){
        Ingoreindex(index);
        if(index==0){
            addFirst(data);
        }
        if(index==size()-1){
            addLast(data);
        }
        ListNote des=new ListNote(data);
        des.next=findIndexSubOne(index).next;
        findIndexSubOne(index).next=des;
    };
    //查找是否包含关键字key是否在单链表当中
    public boolean contains(int key){
        ListNote cur=this.head;
        while(cur!=null){
            if(cur.value==key){
                return true;
            }
            cur=cur.next;
        }
        return false;
    };
    //删除第一次出现关键字为key的节点
    public void remove(int key){
        if(this.head==null){
            System.out.println("当前链表为空");
            return;
        }
        if(this.head.value==key){
            this.head=this.head.next;
        }
        ListNote cur=this.head;
        while(cur!=null){
            if(cur.next.value==key){
                cur.next=cur.next.next;
                return;
            }
            cur=cur.next;
        }
    };

    //得到单链表的长度
    public int size(){
        int num=0;
        ListNote cur=this.head;
        while(cur!=null){
            num++;
            cur=cur.next;
        }
        return num;
    };
    public void display(){
        ListNote cur=this.head;
        while(cur!=null){
            System.out.print(cur.value+" ");
            cur=cur.next;
        }
        System.out.println(" ");
    };

}
