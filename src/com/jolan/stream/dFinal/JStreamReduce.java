package com.jolan.stream.dFinal;

import com.jolan.stream.aExample.Author;
import com.jolan.stream.aExample.StreamDemo;

import java.util.List;
import java.util.Optional;

/**
 * reduce:对流中的数据按照你指定的计算方式计算出一个结果（缩减操作）
 * reduce的作用是把stream中的元素组合起来，我们可以传入一个初始值，它会按照我们的计算方式依次拿流中的元素和初始值的基础上进行计算，计算的结果再和后面的元素计算
 */
public class JStreamReduce {
    public static void main(String[] args) {
        //使用reduce计算所有作者年龄只和
        List<Author> authors = StreamDemo.getAuthors();
        Integer reduce = authors.stream()
                .distinct()
                .map(author -> author.getAge())
                .reduce(0, (i1, i2) -> i1 + i2);
        System.out.println(reduce);

        //使用reduce求所有作者中年龄的最大值
        Integer maxAge = authors.stream()
                .distinct()
                .map(author -> author.getAge())
                .reduce(Integer.MIN_VALUE, (result, element) -> result < element ? element : result);
        System.out.println(maxAge);

        //使用reduce求所有作者中年龄的最小值
        Integer minAge = authors.stream()
                .distinct()
                .map(author -> author.getAge())
                .reduce(Integer.MAX_VALUE, (result, element) -> result > element ? element : result);
        System.out.println(minAge);

        //使用reduce求所有作者中年龄的最小值2
        Optional<Integer> optionalReduce = authors.stream()
                .distinct()
                .map(author -> author.getAge())
                .reduce((result, element) -> result > element ? element : result);
        optionalReduce.ifPresent(age -> System.out.println(age));
    }
}
