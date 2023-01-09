package com.jolan.stream.cOperate;

import com.jolan.stream.aExample.Author;
import com.jolan.stream.aExample.StreamDemo;

import java.util.List;

/**
 * distinct：可以去除流中的重复元素
 * 注意：distinct依赖的是Object方法中的equals方法来判断是否是相同的对象。所以需要注意重写equals方法
 * @author jolan
 * @date 2023-01-08
 */
public class CStreamDistinct {
    public static void main(String[] args) {
        //打印所有作家姓名，并且要求不能有重复元素
        List<Author> authors = StreamDemo.getAuthors();
        authors.stream()
                .distinct()
                .forEach(author -> System.out.println(author.getName()));
    }
}
