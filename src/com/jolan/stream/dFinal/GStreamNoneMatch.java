package com.jolan.stream.dFinal;

import com.jolan.stream.aExample.Author;
import com.jolan.stream.aExample.StreamDemo;

import java.util.List;

/**
 * noneMatch:判断是否都不符合条件。如果不符合结果为true，否则为false
 * @author jolan
 * @date 2023-01-09
 */
public class GStreamNoneMatch {
    public static void main(String[] args) {
        //判断所有的作家是否都没有超过100岁
        List<Author> authors = StreamDemo.getAuthors();
        boolean noneMatch = authors.stream()
                .noneMatch(author -> author.getAge() > 100);
        System.out.println(noneMatch);
    }
}
