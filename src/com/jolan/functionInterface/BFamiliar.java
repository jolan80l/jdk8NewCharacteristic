package com.jolan.functionInterface;

import com.jolan.stream.aExample.Author;
import com.jolan.stream.aExample.StreamDemo;

import java.util.List;
import java.util.function.Predicate;

/**
 * 常见的函数式接口：
 * 1.消费类接口Consumer。它的特点是有入参没有返回值
 * 2.计算转换接口Function。它的特点是有入参有返回值
 * 3.判断接口Predicate。它的特点是有入参并且返回布尔值
 * 4.生产接口Supplier。它的特点是没有入参但是有返回值
 *
 * 常见的默认方法：
 * 1.Predicate的and方法。这种方式无法使用lambda表达式，常用语自己定义函数式接口时使用
 *  例子：打印年龄大于17并且名字长度大于1的作家
 * @author jolan
 * @date 2023-01-12
 */
public class BFamiliar {
    public static void main(String[] args) {
        List<Author> authors = StreamDemo.getAuthors();
        authors.stream()
                .filter(new Predicate<Author>() {
                    @Override
                    public boolean test(Author author) {
                        return author.getAge() > 17;
                    }
                }.and(new Predicate<Author>() {
                    @Override
                    public boolean test(Author author) {
                        return author.getName().length() > 1;
                    }
                }))
                .forEach(author -> System.out.println(author.getName()));
    }
}
