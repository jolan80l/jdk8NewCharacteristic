package com.jolan.stream.dFinal;

import com.jolan.stream.aExample.Author;
import com.jolan.stream.aExample.StreamDemo;

import java.util.List;
import java.util.Optional;

/**
 * findAny:获取流中任意一个元素，该方法没有办法保证获取的是流中的第一个元素
 * @author jolan
 * @date 2023-01-09
 */
public class HStreamFindAny {
    public static void main(String[] args) {
        //获取作家中任意一个18岁以上的作家，如果存在就输出他的名字
        List<Author> authors = StreamDemo.getAuthors();
        Optional<Author> optionalAuthor = authors.stream()
                .filter(author -> author.getAge() > 18)
                .findAny();
        System.out.println(optionalAuthor.get().getName());
        optionalAuthor.ifPresent(author -> System.out.println(author.getName()));
    }
}
