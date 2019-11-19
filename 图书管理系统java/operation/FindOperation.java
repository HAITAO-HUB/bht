package com.bit.operation;

import com.bit.book.BookList;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
public class FindOperation implements IOperation{
    @Override
    public void work(BookList bookList) {
        System.out.println("查找书籍");
        System.out.println("输入需要查找书籍的名称");
        String name = scanner.next();
        //不会从bookList-》进行删除-》isBorrowed true
        //1、找这本书 是否存在
        int i = 0;
        for (i=0; i < bookList.getSize(); i++) {
            if(bookList.getBook(i).name.equals(name)) {
                System.out.println(bookList.getBook(i));
                break;
            }
        }
        if(i >= bookList.getSize()) {
            System.out.println("没有此书");
            return;
        }
        System.out.println("书籍查找成功");
        //System.out.println();
    }
}
