package ArrayList;

import java.util.Arrays;

/**
 * @ClassName Array
 * @Description TODO
 * @Author 86189
 * @Date 2022/5/2 14:08
 **/
public class Array {
    public final static int Size=10;
    public int[] arr=new int[Size];
    public int useSize;
        // 打印顺序表
        public void display() {
            for (int i = 0; i < useSize; i++) {
                System.out.print(arr[i]+" ");
            }
        }
        public void IgnoreFull(int[] arr){
            if(arr.length==this.useSize){
                arr= Arrays.copyOf(arr,2*arr.length);
            }
        }
        // 新增元素,默认在数组最后新增
        public void add(int data) {
            IgnoreFull(this.arr);
            this.arr[this.useSize]=data;
            this.useSize++;
        }
        public boolean IgnorePos(int pos){
            if(pos<0||pos>this.useSize){
               throw new indexException("指定下标位置不合法!");
            }
            return true;
        }
        // 在 pos 位置新增元素
        public void add(int pos, int data) {
            IgnoreFull(this.arr);
            if(pos==this.useSize){
                add(data);
            }
            if(IgnorePos(pos)){
                for (int i = this.useSize-1; i >=pos ; i--) {
                    this.arr[i+1]=this.arr[i];
                }
                this.arr[pos]=data;
                this.useSize++;
            }
        }
        // 判定是否包含某个元素
        public boolean contains(int toFind) {
            for (int i = 0; i < this.useSize; i++) {
                if(this.arr[i]==toFind){
                    return true;
                }
            }
            return false;
        }
        // 查找某个元素对应的位置
        public int indexOf(int toFind) {
            for (int i = 0; i < this.useSize; i++) {
                if(this.arr[i]==toFind){
                    return i;
                }
            }
            return -1;
        }
        // 获取 pos 位置的元素
        public boolean IgnoreEmpty(){
            if(this.useSize==0){
                return false;
            }
            return true;
        }
        public int get(int pos) {
            if(!IgnoreEmpty()){
                throw new EmptyException("顺序表为空");
            }
            if(IgnorePos(pos)&&pos!=this.useSize){
                return this.arr[pos];
            }
            return -1;
        }
        // 给 pos 位置的元素设为 value
        public void set(int pos, int value) {
            if(IgnorePos(pos)){
                this.arr[pos]=value;
            }
        }

        //删除第一次出现的关键字key
        public void remove(int toRemove) {
            if(!IgnoreEmpty()){
                throw new EmptyException("顺序表为空");
            }
            int ret=indexOf(toRemove);
            if(ret==-1){
                System.out.println("没有找到要删除的元素!");
                return;
            }
            for (int i = ret; i <this.useSize-1 ; i++) {
                this.arr[i]=this.arr[i+1];
            }
            this.useSize--;
        }
        // 获取顺序表长度
        public int size() {
            return useSize;
        }
        // 清空顺序表
        public void clear() {
            this.useSize=0;
        }
}
