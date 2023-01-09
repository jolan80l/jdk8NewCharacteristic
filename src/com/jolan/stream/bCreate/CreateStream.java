package com.jolan.stream.bCreate;

import java.util.*;
import java.util.stream.Stream;

/**
 * 在对stream流有了大致的了解后，现在比较系统的学习一下如何创建stream流
 * 其中包括集合、数组和Map的stream创建
 * @author jolan
 * @date 2023-01-08
 */
public class CreateStream {
    public static void main(String[] args) {
        //1.Collection集合创建Stream流
        List<String> lists = new ArrayList<>();
        Stream<String> listStream = lists.stream();

        //2.数组创建Stream流
        Integer[] arr = {1, 2, 3, 4, 5};
        //2.1.方式一，通过Arrays的stream方法创建
        Stream<Integer> arrStream = Arrays.stream(arr);
        //2.2.方式二，通过Stream的of方法创建
        Stream<Integer> arrStream2 = Stream.of(arr);

        //3.Map创建stream流
        Map<String, Integer> map = new HashMap<>();
        Set<Map.Entry<String, Integer>> entries = map.entrySet();
        Stream<Map.Entry<String, Integer>> setStream = entries.stream();

    }
}
