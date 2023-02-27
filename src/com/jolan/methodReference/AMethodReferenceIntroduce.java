package com.jolan.methodReference;

import com.jolan.stream.aExample.Author;

import java.util.List;
import java.util.stream.Stream;

import static com.jolan.stream.aExample.StreamDemo.getAuthors;

/**
 * 方法引用：在使用lambda时，如果方法体中只有一个方法的调用，我们可以用方法引用进一步简化代码
 * 基本格式：类名或对象名称::方法名

 * @author jolan
 * @date 2023-02-25
 */
public class AMethodReferenceIntroduce {
    public static void main(String[] args) {
        List<Author> authors = getAuthors();
        Stream<Author> authorStream = authors.stream();
        authorStream.map(author -> author.getAge())
                .map(age -> String.valueOf(age));


        //使用方法引用转换：引用类的静态方法
        authorStream.map(author -> author.getAge())
                //引用静态方法：引用类的静态用法，使用类名::方法名
                //如果在重写方法的时候，方法体中只有一行代码，并且这行代码是调用了某个静态方法，并且我们把要重写的抽象方法中的所有参数按照顺序传入了这个静态方法中，这个时候我们可以引用静态方法
                .map(String::valueOf);


        //使用方法引用转换：引用对象的实力方法
        StringBuilder sb = new StringBuilder();
        authorStream.map(author -> author.getName())
                .forEach(name -> sb.append(name));
        //如果在重写方法的时候，方法体中只有一行代码，并且这行代码是调用对象的成员方法，并且我们把要重写的抽象方法中的所有参数都按顺序传入了这个成员方法中，这个时候我们就可以引用对象的实力方法
        authorStream.map(author -> author.getName())
                .forEach(sb::append);


        //使用方法引用转换：引用类的实力方法
        subAuthorName("jolan", new UseString() {
            @Override
            public String use(String str, int start, int length) {
                return str.substring(start, length);
            }
        });
        //如果在重写方法的时候，方法体中只有一行代码，并且这行代码是调用了第一个参数的成员方法，并且我们把要重写的抽象方法中剩余的所有参数都按照顺序传入了这个成员方法中，这个我们就可以引用类的实力方法
        subAuthorName("jolan", String::substring);


        //使用方法引用转换：构造器引用
        authors.stream()
                .map(author -> author.getName())
                .map(name -> new StringBuilder(name));
        //如果在重写方法的时候，方法体中只有一行代码，并且这行代码是调用某个类的构造方法，并且我们把要重写的抽象方法中的所有的参数都按顺序传入了这个构造方法中，这个时候我们可以使用引用构造器
        authors.stream()
                .map(author -> author.getName())
                .map(StringBuilder::new);
    }

    interface UseString {
        String use (String str, int start, int length);
    }
    public static String subAuthorName(String str, UseString useString){
        int start = 0;
        int length = 1;
        return useString.use(str, start, length);
    }
}
