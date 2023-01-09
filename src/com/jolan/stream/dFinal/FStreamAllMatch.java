package com.jolan.stream.dFinal;

import com.jolan.stream.aExample.Author;
import com.jolan.stream.aExample.StreamDemo;

import java.util.List;

/**
 * allMatch:可以用来判断是否符合匹配条件，结果为boolean类型。如果符合结果为true，否则结果为false
 */
public class FStreamAllMatch {
    public static void main(String[] args) {
        //判断是否所有的作家都是成年人
        List<Author> authors = StreamDemo.getAuthors();
        boolean allMatch = authors.stream()
                .allMatch(author -> author.getAge() >= 18);
        System.out.println(allMatch);
    }
}
