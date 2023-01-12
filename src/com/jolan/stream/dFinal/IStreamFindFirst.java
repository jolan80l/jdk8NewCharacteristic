package com.jolan.stream.dFinal;

import com.jolan.stream.aExample.Author;
import com.jolan.stream.aExample.StreamDemo;

import java.util.List;
import java.util.Optional;

/**
 * findFirst:找到流中的第一个元素
 * @author jolan
 * @date 2023-01-09
 */
public class IStreamFindFirst {
    public static void main(String[] args) {
        //获取一个年龄最小的作家，并输出他的年龄
        List<Author> authors = StreamDemo.getAuthors();
        Optional<Author> minAgeAuthor = authors.stream()
                .sorted((a1, a2) -> a1.getAge() - a2.getAge())
                .findFirst();
        minAgeAuthor.ifPresent(author -> System.out.println(author.getName()));

    }
}
