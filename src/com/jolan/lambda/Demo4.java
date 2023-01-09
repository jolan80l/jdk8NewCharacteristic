package com.jolan.lambda;

/**
 * 使用lambda简化线程写法
 * @author jolan
 * @date 2023-01-07
 */
public class Demo4 {
    public static void main(String[] args) {
        //匿名内部类写法
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("使用匿名内部类创建线程");
            }
        }).start();

        //lambda写法：lambda是简化匿名内部类的语法糖，在上面的Thread的参数中，就是一个匿名内部类，所以可以使用lambda表达式优化
        new Thread(() -> {
            System.out.println("使用lambda创建线程");
        }).start();

    }
}
