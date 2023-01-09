package com.jolan.lambda;

/**
 * 这个例子针对Demo2中的例子进行优化，lambda可以更加简化
 * 可推到则可省略
 * 1.参数类型可以省略
 * 2.假如只有一个参数，括号也可以省略
 * 3.如果大括号的中的方法体只有一条语句，大括号也可以省略
 * 4.如果方法体中唯一的一条语句是return返回语句，那么可以省略大括号，同时return也必须省略
 * @author jolan
 * @date 2023-01-07
 */
public class Demo3 {
    public static void main(String[] args) {
        //无返回值无形参lambda写法
        Demo2.NoReturnNoArgs noReturnNoArgs = () -> System.out.println("无返回值无形参方法体");


        //无返回值单形参
        Demo2.NoReturnOneArg noReturnOneArg = (a) -> System.out.println("无返回值单形参,输入参数值:" + a);


        //无返回值双形参
        Demo2.NoReturnTwoArgs noReturnTwoArgs = (a, b) -> System.out.println("无返回值双形参,计算两数只和:" + (a + b));


        //有返回值无形参
        Demo2.HasReturnNoArgs hasReturnNoArgs = () -> 4;


        //有返回值单形参
        Demo2.HasReturnOneArg hasReturnOneArg = (a) -> a;




        //有返回值双形参
        Demo2.HasReturnTwoArgs hasReturnTwoArgs = (a, b) -> a + b;


        noReturnNoArgs.test();
        noReturnOneArg.test(2);
        noReturnTwoArgs.test(1, 2);
        System.out.println(hasReturnNoArgs.test());
        System.out.println(hasReturnOneArg.test(5));
        System.out.println(hasReturnTwoArgs.test(3, 3));
        /**
         * 输出结果：
         * 无返回值无形参方法体
         * 无返回值单形参,输入参数值:2
         * 无返回值双形参,计算两数只和:3
         * 4
         * 5
         * 6
         */
    }



    /**
     * 无返回值无形参接口
     */
    interface NoReturnNoArgs {
        void test();
    }

    /**
     * 无返回一个形参接口
     */
    interface NoReturnOneArg {
        void test(int a);
    }

    /**
     * 无返回两个形参接口
     */
    interface NoReturnTwoArgs {
        void test(int a, int b);
    }

    /**
     * 有返回值无形参接口
     */
    interface HasReturnNoArgs {
        int test();
    }

    /**
     * 有返回值单形参接口
     */
    interface HasReturnOneArg {
        int test(int a);
    }

    /**
     * 有返回值单形参接口
     */
    interface HasReturnTwoArgs {
        int test(int a, int b);
    }
}
