package com.jolan.stream.cOperate;

import com.jolan.stream.aExample.Author;
import com.jolan.stream.aExample.StreamDemo;

import java.util.Arrays;
import java.util.List;

/**
 * flatMap：map只能把一个对象转换为另一个对象来作为流中的元素，而flatMap可以把一个对象转换成多个对象作为流中的元素
 * @author jolan
 * @date 2023-01-08
 */
public class GStreamFlatMap {
    public static void main(String[] args) {
        //打印所有书籍的名字，要求对重复的书籍名字进行去重
        List<Author> authors = StreamDemo.getAuthors();
        authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .forEach(book -> System.out.println(book.getName()));

        System.out.println("---分割线---");

        //打印所有书籍的所有分类，要求对分类进行去重，不能出现这种格式，如：哲学,爱情。在实际应用中，注意空的情况
        authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .distinct()
                .flatMap(book -> Arrays.stream(book.getCategory().split(",")))
                .distinct()
                .forEach(category -> System.out.println(category));
    }
}
