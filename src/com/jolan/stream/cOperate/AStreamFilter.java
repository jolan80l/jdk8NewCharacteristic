package com.jolan.stream.cOperate;

import com.jolan.stream.aExample.Author;
import com.jolan.stream.aExample.StreamDemo;

import java.util.List;

/**
 * filter可以对流中的元素进行条件过滤，符合过滤条件的才能继续留在流中
 * 在stream流后面跟的filter也好，forEach也罢，他们的入参都是一个匿名内部类，只是使用lambda表达式简化了他们的写法
 * @author jolan
 * @date 2023-01-08
 */
public class AStreamFilter {
    public static void main(String[] args) {
        //打印所有姓名长度大于1的作家姓名
        List<Author> authors = StreamDemo.getAuthors();
        authors.stream()
                .filter(author -> author.getName().length() > 1)
                .forEach(author -> System.out.println(author.getName()));
    }
}
