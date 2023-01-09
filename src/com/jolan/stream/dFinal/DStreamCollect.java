package com.jolan.stream.dFinal;

import com.jolan.stream.aExample.Author;
import com.jolan.stream.aExample.Book;
import com.jolan.stream.aExample.StreamDemo;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * collect：把流转换为集合
 */
public class DStreamCollect {
    public static void main(String[] args) {
        //获取一个存放所有作者名字的List集合
        List<Author> authors = StreamDemo.getAuthors();
        List<String> authorNames = authors.stream()
                .map(author -> author.getName())
                .collect(Collectors.toList());
        System.out.println(authorNames);

        //获取所有书名的Set集合
        Set<String> bookNames = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .map(book -> book.getName())
                .collect(Collectors.toSet());

        //获取一个map集合，map的key为作者姓名，value为List<Book>
        Map<String, List<Book>> map = authors.stream()
                .distinct()
                .collect(Collectors.toMap(author -> author.getName(), author -> author.getBooks()));
        System.out.println(map);
    }
}
