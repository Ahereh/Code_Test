import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.jar.JarEntry;

/**
 * @ClassName Practice
 * @Description TODO
 * @Author 86189
 * @Date 2023/4/9 23:11
 **/
public class Practice {
    public static void main(String[] args) {
        JFrame jframe = new JFrame();
        //showInputDialog该方法中的第二个参数，是用于弹出对话框中的初始默认值
        int a = Integer.parseInt(JOptionPane.showInputDialog("请输入一个整数 ","0"));
        String s = JOptionPane.showInputDialog("请输入一个运算符","+");
        int b = Integer.valueOf(JOptionPane.showInputDialog("请输入一个整数:","0"));
        int sum = 0;
        switch (s){
            case "+": {
                sum = a + b;
                break;
            }
            case "-":{
                sum = a-b;
                break;
            }
            case "*":{
                sum = a*b;
                break;
            }
            case "/":{
                sum = a/b;
                break;
            }
            default:break;
        }
        JOptionPane.showMessageDialog(jframe,sum);
        System.exit(0);
    }
    public static void main1(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String temp = null;
        try{
            while((temp=reader.readLine())!=null && !temp.isEmpty()){
                System.out.println(temp);
            }
        }catch(IOException e){
            System.out.println("Errro reading input:" + e.getMessage());
        }
    }
}
