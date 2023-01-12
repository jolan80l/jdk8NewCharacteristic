package com.jolan.stream.dFinal;

import com.jolan.stream.aExample.Author;
import com.jolan.stream.aExample.StreamDemo;

import java.util.List;

/**
 * anyMatch:可以用判断是否任务符合匹配条件的元素，结果为boolean你类型
 * @author jolan
 * @date 2023-01-09
 */
public class EStreamAnyMatch {
    public static void main(String[] args) {
        //判断是否有年龄在29以上的作家
        List<Author> authors = StreamDemo.getAuthors();
        boolean anyMatch = authors.stream()
                .anyMatch(author -> author.getAge() > 29);
        System.out.println(anyMatch);
    }
}
