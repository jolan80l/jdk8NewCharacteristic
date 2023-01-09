package com.jolan.optional;

import com.jolan.stream.aExample.Author;

import javax.swing.text.html.Option;
import java.util.Optional;

/**
 * Optional就像是包装类，把具体的数据封装到Optional对象内部。在使用Optional封装好的方法就能很优雅的避免空指针异常
 */
public class BOptionalCreate {
    public static void main(String[] args) {
        //输出作者的姓名
        //1.Optional.ofNullable
        Author author = AOptionalDemo.getAuthor();
        Optional<Author> optionalAuthor = Optional.ofNullable(author);
        optionalAuthor.ifPresent(currentAuthor -> System.out.println(currentAuthor.getName()));

        //2.在获取对象的时候，直接封装为Optional对象，也就是说把Optional.ofNullable放到调用方法的内部(推荐)
        Optional<Author> optionalAuthor2 = getOptionalAuthor();
        optionalAuthor2.ifPresent(currentAuthor -> System.out.println(currentAuthor.getName()));

        //3.Mybatis3.5以上版本可以支持Optional，可以直接把dao的返回值定义为Optional类型，Mybatis会把数据封装为Optional对象返回

        //4.如果确定一个对象肯定不是空，可以使用of方法进行封装。在这种情况下，如果传入的参数是null，会报空指针异常
        try {
            Optional<Author> optionalAuthor3 = Optional.of(author);
            optionalAuthor3.ifPresent(currentAuthor -> System.out.println(currentAuthor.getName()));
        } catch (Exception e) {
            e.printStackTrace();
        }

        //5.如果一定要使用of方法，并且又不想报空指针异常，可以使用Optional的empty()方法，这个返回一个value为空的Optional对象
        Optional<Author> optionalAuthor4 = getOptionalAuthorNullable();
        optionalAuthor4.ifPresent(currentAuthor -> System.out.println(currentAuthor.getName()));
    }

    public static Optional<Author> getOptionalAuthor(){
        Author author = new Author(1L, "蒙多", 33, "一个从菜刀中明悟哲理的祖安人", null);
        return Optional.ofNullable(author);
    }

    public static Optional<Author> getOptionalAuthorNullable(){
        Author author = new Author(1L, "蒙多", 33, "一个从菜刀中明悟哲理的祖安人", null);
        return author == null ? Optional.empty() : Optional.of(author);
    }
}
