package com.jolan.stream.cOperate;

import com.jolan.stream.aExample.Author;
import com.jolan.stream.aExample.StreamDemo;

import java.util.List;

/**
 * skip：跳过流中的前n个元素，返回剩下的元素
 * @author jolan
 * @date 2023-01-08
 */
public class FStreamSkip {
    public static void main(String[] args) {
        //打印除了年龄最大作家的其他作家，要求不能有重复元素，并且按作家年龄的降序排列
        List<Author> authors = StreamDemo.getAuthors();
        authors.stream()
                .distinct()
                .sorted((o1, o2) -> o2.getAge() - o1.getAge())
                .skip(1)
                .forEach(author -> System.out.println(author.getName()));
    }
}
