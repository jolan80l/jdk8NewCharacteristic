package com.jolan.optional;

import com.jolan.stream.aExample.Author;

import java.util.Optional;

/**
 * 消费Optional中的对象
 * @author jolan
 * @date 2023-01-09
 */
public class COptionalConsume {
    public static void main(String[] args) {
        //1.安全消费值
        Author author = AOptionalDemo.getAuthor();
        Optional<Author> optionalAuthor = Optional.ofNullable(author);
        optionalAuthor.ifPresent(currentAuthor -> System.out.println(currentAuthor.getName()));

        //2.使用get获取Optional中的值(不推荐)
        try {
            Author author2 = optionalAuthor.get();
        } catch (Exception e) {
            //NoSuchElementException: No value present
            e.printStackTrace();
        }

        //3.推荐使用orElseGet。如果Optional中的对象部位空，则返回这个对象，否则返回默认对象，如这个例子中的new Author()
        Author author3 = optionalAuthor.orElseGet(() -> new Author());
        System.out.println(author3.getName());

        //4.orElseThrow。当Optional中没有值时，抛出异常
        Author author4 = optionalAuthor.orElseThrow(() -> new RuntimeException("数据为null"));
        System.out.println(author4.getName());
    }
}
