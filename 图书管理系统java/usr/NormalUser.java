package com.bit.usr;

import com.bit.operation.*;

import java.util.Scanner;
public class NormalUser extends User{
    public NormalUser(String name) {
        this.name = name;
        this.operations = new IOperation[]{
                new Exit(),//0号下标
                new FindOperation(),//1
                new BorrowOperation(),//2
                new ReturnOperation(),//3
                new DisplayOperation()//4
        };
    }

    @Override
    public int menu() {
        System.out.println("=============================");
        System.out.println("Hello " + this.name + ", 欢迎使用图书管理系统!");
        System.out.println("1. 查找图书");
        System.out.println("2. 借阅图书");
        System.out.println("3. 归还图书");
        System.out.println("4. 打印图书");
        System.out.println("0. 退出系统");
        System.out.println("=============================");
        System.out.println("请输入您的选择: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        return choice;
    }
}
