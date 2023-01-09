package com.jolan.optional;

import com.jolan.stream.aExample.Author;
import com.jolan.stream.aExample.StreamDemo;

/**
 * JDK8中引入了Optional来优雅的解决空指针的问题
 */
public class AOptionalDemo {
    public static void main(String[] args) {
        Author author = getAuthor();
        //空指针异常
        System.out.println(author.getName());
        //解决方案
        if(author != null){
            System.out.println(author.getName());
        }
    }

    public static Author getAuthor(){
        Author author = new Author(1L, "蒙多", 33, "一个从菜刀中明悟哲理的祖安人", null);
        return null;
    }
}
