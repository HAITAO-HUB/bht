package com.bit.operation;

import com.bit.book.Book;
import com.bit.book.BookList;
public class BorrowOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        //借书但不删除
        //1、找书是否存在
        //2、是否被借出
        System.out.println("借阅书籍");
        System.out.println("输入需要借阅书籍的名称");
        String name = scanner.next();
        int i=0;
        for (i = 0; i <bookList.getSize() ; i++) {
            if(bookList.getBook(i).name.equals(name)){
                break;
            }
        }
        if(i>=bookList.getSize()){
            System.out.println("没有此书");
            return;
        }
        Book book=bookList.getBook(i);
        if (book.isBorrowed){
            System.out.println("已经借出去了");
        }else{
            book.isBorrowed=true;
            System.out.println("书籍成功借阅");
        }
    }
}
