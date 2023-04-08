package Test;

import java.util.Arrays;

/**
 * @ClassName TestHeap
 * @Description 优先级队列----堆
 * @Author 86189
 * @Date 2022/5/28 16:57
 **/
public class TestHeap  {
    public int []elem;
    public int useSize;

    public TestHeap(int[] elem) {
        this.elem = new int[10];
    }

    //创建一个大根堆
    public void creatHeap1(int[] array){
        for (int i = 0; i < array.length; i++) {
            this.elem[i]=array[i];
            this.useSize++;
        }
        //从完全二叉树的最后一个节点的双亲节点开始向下调整,调整完-1，继续对其他的子树进行向下调整
        for (int p = (this.useSize-1-1)/2; p >=0 ; p--) {
            shiftDown(p,this.useSize);//向下调整
        }
    }

    //创建一个小根堆
    public void creatHeap2(int []array){
        for (int i = 0; i < array.length; i++) {
            this.elem[i]=array[i];
            this.useSize++;
        }
        for (int i = (this.useSize-1-1)/2; i >=0 ; i--) {
            shiftDown1(i);
        }
    }
    //向下调整(小根堆)
    public void shiftDown1(int root){
        int child=root*2+1;
        while(child<this.useSize){
            if(child+1<this.useSize&&this.elem[child]>this.elem[child+1]){
                child+=1;
            }
            if(this.elem[child]<this.elem[root]){
                int temp=this.elem[child];
                this.elem[child]=this.elem[root];
                this.elem[root]=temp;
                root=child;
                child=root*2+1;
            } else{
                break;
            }
        }
    }
    //向下调整(大根堆)
    public void shiftDown(int root,int len){
        //root为每棵子树的根节点下标
        //len是每棵子树调整结束的结束条件
        int parent=root;
        int child=parent*2+1;
        while(child<len){
            if(child+1<len&&this.elem[child]<this.elem[child+1]){
                child+=1;
            }
            //此时比较完后，child下标对应的孩子节点是当前子树左右节点中最大的一个
            if(this.elem[child]>this.elem[parent]){
                int temp=this.elem[child];
                this.elem[child]=this.elem[parent];
                this.elem[parent]=temp;
                parent=child;       //更新节点下标，看下面的子树是不是大根堆
                child=2*parent+1;
            }else{
                break;
            }
        }
    }

    public boolean isFull(){
        if(this.elem.length==this.useSize){
            return true;
        }
        return false;
    }
    //插入一个元素，让堆人保持大根堆的状态(入队)
    public void push(int val){
        //在插入元素前，需判断当前数组是否需要扩容
        if(isFull()){
            this.elem= Arrays.copyOf(this.elem,this.elem.length*2);
        }
        this.elem[this.useSize]=val;
        //插入都是在当前堆的最后一个节点后，开始插入
        //插入后，依次向上调整子树
        shiftUp(this.useSize);
        this.useSize++; //插完，有效数量需+1
    }
    public void shiftUp(int root){
        int parent=(root-1)/2;
        //向上调整的结束条件是，双亲节点parent小于0的时候，说明已经调整完毕
        while(parent>=0){
            if(this.elem[root]>this.elem[parent]){
                int temp=this.elem[root];
                this.elem[root]=this.elem[parent];
                this.elem[parent]=temp;
                root=parent;
                parent=(root-1)/2;
            } else{
                break;
            }
        }
    }
    //删除最高优先级的元素(出队)
    public void pollHeap(){
        //首先得判断当前数组是否为空，才可以进行删除
        if(isEmpty()){
            System.out.println("优先级队列为空!");
            return;
        }
        //将堆顶元素和最后一个元素进行交换，再减少有效数量useSize，表示最后一个元素被删除
        int temp=this.elem[0];
        this.elem[0]=this.elem[this.useSize-1];
        this.elem[this.useSize-1]=temp;
        this.useSize--;
        //只需堆根子树进行向下调整即可
        shiftDown(0,this.useSize);
    }
    //获取堆顶元素
    public int peekHeap(){
        if(isEmpty()) return -1;
        return this.elem[0];
    }
    public boolean isEmpty(){
        return this.useSize==0;
    }
    public void display(){
        for (int i = 0; i < this.useSize; i++) {
            System.out.print(this.elem[i]+" ");
        }
    }



}
