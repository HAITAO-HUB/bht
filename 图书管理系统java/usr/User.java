package com.bit.usr;

import com.bit.book.BookList;
import com.bit.operation.IOperation;
public abstract class User {//抽象类
    protected String name;
    protected IOperation[] operations;

    public abstract int menu();//抽象方法
    // 根据用户选项执行操作
    public void doOperation(int choice, BookList bookList) {
        operations[choice].work(bookList);
    }
}
