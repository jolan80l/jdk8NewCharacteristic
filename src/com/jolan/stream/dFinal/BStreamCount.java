package com.jolan.stream.dFinal;

import com.jolan.stream.aExample.Author;
import com.jolan.stream.aExample.StreamDemo;

import java.util.List;

/**
 * count：获取当前流中元素的个数
 * @author jolan
 * @date 2023-01-09
 */
public class BStreamCount {
    public static void main(String[] args) {
        //打印作家的所有书籍的数目，注意删除重复元素
        List<Author> authors = StreamDemo.getAuthors();
        long counts = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .count();
        System.out.println(counts);
    }
}
