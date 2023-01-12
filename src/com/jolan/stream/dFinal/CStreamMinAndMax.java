package com.jolan.stream.dFinal;

import com.jolan.stream.aExample.Author;
import com.jolan.stream.aExample.Book;
import com.jolan.stream.aExample.StreamDemo;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Stream;

/**
 * min&max:获取流中的最大值或最小值
 * @author jolan
 * @date 2023-01-09
 */
public class CStreamMinAndMax {
    public static void main(String[] args) {
        //分别获取作家所出书籍的最高分和最低分并打印
        List<Author> authors = StreamDemo.getAuthors();
        Optional<Integer> maxScore = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .map(book -> book.getScore())
                .max((s1, s2) -> s1 - s2);
        System.out.println(maxScore.get());

        Optional<Integer> minScore = authors.stream()
                .flatMap(author -> author.getBooks().stream())
                .map(book -> book.getScore())
                .min((s1, s2) -> s1 - s2);
        System.out.println(minScore.get());


    }
}
