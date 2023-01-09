package com.jolan.stream.cOperate;

import com.jolan.stream.aExample.Author;
import com.jolan.stream.aExample.StreamDemo;

import java.util.List;
import java.util.function.Function;

/**
 * map可以把流中的元素进行计算或转换
 * @author jolan
 * @date 2023-01-08
 */
public class BStreamMap {
    public static void main(String[] args) {
        //打印所有作家的姓名
        //1.使用stream打印
        List<Author> authors = StreamDemo.getAuthors();
        authors.stream()
                .forEach(author -> System.out.println(author.getName()));

        System.out.println("---分割线---");

        //2.在这个例子中，我们需要的是作家的姓名，可以通过map将其Author对象转换为姓名的String对象
        authors.stream()
                .map(author -> author.getName())
                .forEach(name -> System.out.println(name));

        System.out.println("---分割线---");

        //3.map中使用匿名内部类实现，其中的实现就是Function的匿名内部类将Author对象转换为String对象，在实际处理中，要注意空指针的情况
        authors.stream()
                .map(new Function<Author, Object>() {
                    @Override
                    public Object apply(Author author) {
                        return author.getName();
                    }
                })
                .forEach(name -> System.out.println(name));

        System.out.println("---分割线---");

        //另一个例子，将所有作家的年龄加10之后输出。map中的第一个类型必须是流中的原始类型，比如这个示例中的Author类型，返回类型是根据返回值推到出来的。比如这个例子两个map的返回值类型是Integer。而上一个示例中的map返回类型是String
        authors.stream()
                .map(author -> author.getAge())
                .map(age -> age + 10)
                .forEach(age -> System.out.println(age));

    }
}
