package com.jolan.stream.aExample;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 通过一个示例先对流有一个大概的了解
 * authors是一个作家列表，每个作家有年龄、介绍、作品等属性。其中作品可能有多个，是Book的集合。getAuthors静态方法是准备的基础数据
 * 该示例需要使用到lombok插件
 * 打印所有年龄小于18的作家的名字，并且要注意去重
 * 如果不使用stream流，需要对作家列表进行遍历，在遍历过程中使用Set进行去重，并且要判断年龄小于18的作家
 * 现在使用stream流+lambda表达式来实现，代码更加清爽
 */
public class StreamDemo {

    public static void main(String[] args) {
        List<Author> authors = getAuthors();
        System.out.println(authors);

        //1.首先需要创建流，使用数组对象的stream方法就可以创建一个流对象
        //2.中间操作：比如去重，过滤等都是中间操作
        //3.终结操作：这个例子中的forEach就是终结操作，如果没有终结操作，中间操作都不会被调用
        authors.stream()
                .distinct()
                .filter(author -> author.getAge() < 18)
                .forEach(author -> System.out.println(author.getName()));
    }

    public static List<Author> getAuthors() {
        Author author = new Author(1L, "蒙多", 33, "一个从菜刀中明悟哲理的祖安人", null);
        Author author2 = new Author(2L, "亚索", 15, "狂风也追赶不上他的思考速度", null);
        Author author3 = new Author(3L, "易大师", 14, "是这个世界在限制他的思维", null);
        Author author4 = new Author(3L, "易大师", 14, "是这个世界在限制他的思维", null);

        List<Book> books1 = new ArrayList<>();
        List<Book> books2 = new ArrayList<>();
        List<Book> books3 = new ArrayList<>();

        books1.add(new Book(1L, "防御塔要用头顶", "哲学,爱情", 88, "怎么拆塔"));
        books1.add(new Book(2L, "想去哪儿就去哪儿", "个人成长,爱情", 89, "关于去哪儿旅游"));

        books2.add(new Book(3L, "那风吹不到的地方", "哲学", 85, "我当时大意了"));
        books2.add(new Book(3L, "那风吹不到的地方", "哲学", 85, "我当时大意了"));
        books2.add(new Book(4L, "接不接大", "爱情,个人传记", 56, "没有闪"));

        books3.add(new Book(5L, "你的剑就是我的剑", "爱情", 56, "不讲武德"));
        books3.add(new Book(6L, "风与剑", "个人传记", 100, "接化发"));
        books3.add(new Book(6L, "风与剑", "个人传记", 100, "接化发"));

        author.setBooks(books1);
        author2.setBooks(books2);
        author3.setBooks(books3);
        author4.setBooks(books3);

        List<Author> authorList = new ArrayList<>(Arrays.asList(author, author2, author3, author4));

        return authorList;

    }
}
