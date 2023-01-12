package com.jolan.optional;

import com.jolan.stream.aExample.Author;

import java.util.Optional;

/**
 * 使用Optional的filter方法进行过滤，如果原本有数据，但是不符合判断，也会变为一个无数据的Optional对象
 * @author jolan
 * @date 2023-01-09
 */
public class DOptionalFilter {
    public static void main(String[] args) {
        Optional<Author> optionalAuthor = getOptionalAuthor();
        optionalAuthor.filter(author -> author.getAge() > 88).ifPresent(author -> author.getName());

    }

    public static Optional<Author> getOptionalAuthor(){
        Author author = new Author(1L, "蒙多", 33, "一个从菜刀中明悟哲理的祖安人", null);
        return Optional.ofNullable(author);
    }
}
