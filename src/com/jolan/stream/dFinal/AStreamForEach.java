package com.jolan.stream.dFinal;

import com.jolan.stream.aExample.Author;
import com.jolan.stream.aExample.StreamDemo;

import java.util.List;

/**
 * forEach：对流中的元素进行遍历操作，我们可以通过传入的参数去指定对遍历的元素进行具体操作
 * @author jolan
 * @date 2023-01-08
 */
public class AStreamForEach {
    public static void main(String[] args) {
        //输出所有作家的名字
        List<Author> authors = StreamDemo.getAuthors();
        authors.stream()
                .map(author -> author.getName())
                .distinct()
                .forEach(name -> System.out.println(name));
    }
}
