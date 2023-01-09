package com.jolan.stream.cOperate;

import com.jolan.stream.aExample.Author;
import com.jolan.stream.aExample.StreamDemo;

import java.util.List;

/**
 * limit：可以设置流的最大长度，超出部分将被抛弃。如果limit限制的数量大于stream的长度，相当于没有任何操作
 * @author jolan
 * @date 2023-01-08
 */
public class EStreamLimit {
    public static void main(String[] args) {
        //对作家按年龄降序排列，并且要求不能有重复元素，然后打印其中年龄最大的两个作家的姓名
        List<Author> authors = StreamDemo.getAuthors();
        authors.stream()
                .distinct()
                .sorted((o1, o2) -> o2.getAge() - o1.getAge())
                .limit(2)
                .forEach(author -> System.out.println(author.getName()));
    }
}
