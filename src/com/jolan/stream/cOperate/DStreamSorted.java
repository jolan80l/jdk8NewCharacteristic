package com.jolan.stream.cOperate;

import com.jolan.stream.aExample.Author;
import com.jolan.stream.aExample.StreamDemo;

import java.util.List;

/**
 * sorted：可以对流中的元素进行排序
 * @author jolan
 * @date 2023-01-08
 */
public class DStreamSorted {
    public static void main(String[] args) {
        //对作家根据年龄降序排列，并且没有重复元素
        //1.sorted的默认排序，报错：com.jolan.stream.aExample.Author cannot be cast to java.lang.Comparable。原因sorted需要一个Comparable类型的接口
        List<Author> authors = StreamDemo.getAuthors();
        try {
            authors.stream()
                    .distinct()
                    .sorted()
                    .forEach(author -> System.out.println(author.getAge()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        //2.第二种方式，在使用无参的sorted的同时，可以让Author类实现Comparable接口，实现Comparable接口后需要实现compareTo方法，在这个方法中判断当前对象和传入对象的大小，略

        //3.使用有参sorted方法，传入Comparable实现
        authors.stream()
                .distinct()
                .sorted((a1, a2) -> a2.getAge() - a1.getAge())
                .forEach(author -> System.out.println(author.getAge()));
    }
}
