package com.bit.usr;

import com.bit.operation.*;//导入operation下的所有类

import java.util.Scanner;
public class Admin extends User{
    public Admin(String name) {
        this.name = name;
        this.operations = new IOperation[]{
                new Exit(),//0
                new FindOperation(),//1
                new AddOperation(),//2号,添加图书
                new DelOperation(),
                new DisplayOperation()
        };
    }

    @Override
    public int menu() {
        System.out.println("=============================");
        System.out.println("Hello " + this.name + ", 欢迎使用图书管理系统!");
        System.out.println("1. 查找图书");
        System.out.println("2. 新增图书");
        System.out.println("3. 删除图书");
        System.out.println("4. 显示所有图书");
        System.out.println("0. 退出系统");
        System.out.println("=============================");
        System.out.println("请输入您的选择: ");
        Scanner scanner = new Scanner(System.in);
        int choice = scanner.nextInt();
        //scanner.close();//关闭scanner资源
        return choice;
    }
}
