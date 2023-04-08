package Test2;

/**
 * @ClassName test
 * @Description TODO
 * @Author 86189
 * @Date 2022/6/20 15:00
 **/
public class test {
    public static void main(String[] args) {
        String str="name=zhangsan&age=18";
        String[]ret=str.split("&");
        for (int i = 0; i < ret.length; i++) {
            String[]temp=ret[i].split("=");
            System.out.println(temp[0]+"="+temp[1]);
        }
        System.out.println("===========");
        /**
        * @Description:  String类的一些方法
        */
        //toUpperCase（字符串转大写）、toLowerCase、split、substring、trim（去掉字符串中的左右空格,保留中间空格）、format、lastindexOf、
        // indexOf、charAt、equals、compareTo（返回值两个字符串长度差值）、compareToIgnoreCase（返回值两个字符串长度差值，但是忽略大小写比较）
        //toCharArray、replaceAll、replaceFirst、String.valueOf、Integer.parseInt
        System.out.println(str.substring(4));   //从指定位置截取至末尾
        System.out.println(str.substring(0, 4));    //截取特定区间位置，左闭右开
    }
}
