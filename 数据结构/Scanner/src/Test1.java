import javax.swing.*;
import java.io.*;
import java.util.Scanner;

/**
 * @ClassName test1
 * @Description 三种输入方法
 * @Author 86189
 * @Date 2023/4/9 16:12
 **/
public class Test1 {
    public static void scan() throws FileNotFoundException {
        BufferedReader buff = null;
        //将文本文件中的内容也读取放到缓冲区中,然后调用readLine()方法将缓冲区中的全部内容转为字符串
        buff = new BufferedReader(new FileReader("F:"+File.separator+"1"+ File.separator+"test.txt"));
        /* buff = new BufferedReader(new FileReader("E:\\资料\\nice.txt"));*/
        //File.separator 代表系统默认的分隔符，保证无论哪种情况下都是正确的
        //Windows下的目录分隔符是 '\'  而 Linux 下的目录分隔符是 '/'
        String str = null;
        do{
            try {
                str = buff.readLine();   //读取文本文件中的一行数据内容
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(str == null){
                    break;
                }
            }
            System.out.println(str);
        }while(str!=null);
    }
    public static void scan1() throws IOException {
        /**
         * BufferedReader接收键盘输入时实例化
         * 因为输入的数据有可能出现中文，所以此处使用字符流完成.
         * BufferedReader是从缓冲区之中读取内容，所有的输入的字节数据都将放在缓冲区之中。
         **/
        BufferedReader bufferedReader = new BufferedReader(
                new InputStreamReader(System.in)
        );
        //System.in本身表示的是InputStream（字节流），现在要求接收的是一个字符流，需要将字节流转为字符流才可以，InputStreamReader。
        String str = null;
        try {
            while((str=bufferedReader.readLine())!=null && !str.isEmpty()){
                System.out.println(str);
            }
              //从缓冲区读取所有输入的数据
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    public static void scan2(){
        int a = 0;
        System.out.println(a);
        int sum = Integer.parseInt(JOptionPane.showInputDialog("Please Enter"));
        //JOptionPane.showMessageDialog( , )方法的第一个参数是对话框的父组件，第二个参数是要显示的消息。
        JOptionPane.showMessageDialog(null,sum);
    }
    public static void scan3(){
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println(str);
    }

    public static void main(String[] args) throws IOException {
        scan();
    }
}
