package com.jolan.optional;

import com.jolan.stream.aExample.Author;

import java.util.Optional;

/**
 * map:Optional提供了map方法可以让我们对数据进行转换，并且转换的结果也是被Optional封装好的对象，保证使用安全
 */
public class FOptionMap {
    public static void main(String[] args) {
        //获取作家的书籍集合
        Optional<Author> optionalAuthor = BOptionalCreate.getOptionalAuthor();
        optionalAuthor.map(author -> author.getBooks())
                .ifPresent(books -> System.out.println(books));
    }
}
