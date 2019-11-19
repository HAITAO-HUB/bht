package com.bit;

import com.bit.book.BookList;
import com.bit.usr.Admin;
import com.bit.usr.NormalUser;
import com.bit.usr.User;

import java.util.Scanner;
public class Main {
    public static User login() {//登陆
        System.out.println("请输入你的名字：");
        Scanner scanner=new Scanner(System.in);
        String name=scanner.nextLine();//输入一行
        System.out.println("请输入你的身份(1 表示管理员，0 表示用户)");
        int who=scanner.nextInt();
        if(who==1){
            return new Admin(name);
        }else{
            return new NormalUser(name);
        }
    }
    public static void main(String[] args) {
        //三本书
    BookList bookList=new BookList();
    User user=login();
    while(true) {
        int choice = user.menu();
        user.doOperation(choice, bookList);
    }
    }
}
