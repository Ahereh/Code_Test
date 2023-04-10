public class Test2 {
    /**
     StringBuilder 和 StringBuffer 都是 Java 中用于处理字符串的类。它们的主要区别在于线程安全性和性能。

     StringBuffer 是一个线程安全的类，适用于多线程环境下的字符串操作。它的方法都是同步的，因此可以保证线程安全，但是在单线程环境下的性能相对较差。

     StringBuilder 是一个非线程安全的类，适用于单线程环境下的字符串操作。它的方法都是非同步的，因此在单线程环境下的性能相对较好，但是在多线程环境下不保证线程安全。

     StringBuffer：线程安全的可变字符序列，能够被多次的修改并且不产生新的未使用对象，执行效率低（字符串缓冲区）；【适用多线程下在字符缓冲区进行大量操作的情况】
     StringBuilder：线程不安全的类，能够被多次的修改并且不产生新的未使用对象，单线程程序中使用，不同步，执行效率高；【适用于单线程下在字符缓冲区进行大量操作的情况】

     **/
    public static void append(StringBuilder str){
        //字符串追加
        str.append("Fuck you!");
        System.out.println(str.toString());
        /**
         * str.toString() --- 将str中的数据以字符串的形式返回
         **/
    }
    public static void deleteChar(StringBuilder str){
        //删除指定下标位置的字符
        str.deleteCharAt(str.length()-1);
        System.out.println(str.toString());
    }

    public static void delete(StringBuilder str, int first,int end){
        //删除指定范围内的所有字符
        str.delete(first,end);
        System.out.println(str.toString());
    }
    public static void insert(StringBuilder str,String str1){
        //在指定位置下标插入另外一个字符串str1
        str.insert(str.length(),str1);
        System.out.println(str.toString());
    }

    public static void reverse(StringBuilder str){
        //将对象中的数据进行反转
        System.out.println(str.reverse().toString());
    }

    public static void main(String[] args) {
        StringBuilder str = new StringBuilder("Let's try!");

        append(str);
        deleteChar(str);

        String str1 = "Shit!";
        insert(str,str1);

        delete(str,0,10);

        reverse(str);
    }
}
