package com.bit.operation;

import com.bit.book.BookList;

public class Exit implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("程序退出");
        System.exit(0);//0 正常退出
    }
}
