package com.bit.www;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Time;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

import static java.lang.System.exit;

/**
 * @ClassName Test
 * @Description TODO
 * @Author 86189
 * @Date 2023/4/23 16:35
 **/
public class Test {
    public void fun() {
        Timer time = new Timer();
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                int count = 0;
                count++;
            }
        };
        TimerTask task2 = new TimerTask() {
            @Override
            public void run() {
                System.out.println("fuck you!");
            }
        };
        time.schedule(task,0,1000);
        time.schedule(task2,0,1000);
    }

    public void scan1() {
        Scanner scanner = new Scanner(System.in);
        int a = 0;
        a = scanner.nextInt();
        System.out.println(a);
    }


    public void scan2() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String str = null;
        try {
            while ((str = reader.readLine()) != null && !str.isEmpty()) {
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void scan3() {
        JFrame frame = new JFrame();
        int a = Integer.valueOf(JOptionPane.showInputDialog("Enter:", 0));
        String str = JOptionPane.showInputDialog("请输入运算符:", "+");
        int b = Integer.valueOf(JOptionPane.showInputDialog("Enter:", 0));
        int sum = 0;
        switch (str) {
            case "+": {
                sum = a + b;
                break;
            }
            case "-": {
                sum = a - b;
                break;
            }
            case "*": {
                sum = a * b;
                break;
            }
            case "/": {
                sum = a / b;
                break;
            }
            default:
                break;
        }
        JOptionPane.showMessageDialog(frame, sum);
        exit(0);
    }

    public static void binarySearch(int[] arr, int des) {
        //二分查找
        int left = 0, right = arr.length - 1;
        int mid = 0;
        while (left <= right) {
            mid = ((right - left) >> 1) + left;
            if (arr[mid] > des) {
                right = mid - 1;
            } else if (arr[mid] < des) {
                left = mid + 1;
            } else {
                System.out.println("Success!");
                return;
            }
        }
        System.out.println("Fail!");
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        binarySearch(arr, 5);
    }
}
