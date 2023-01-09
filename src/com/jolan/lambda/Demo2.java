package com.jolan.lambda;

/**
 * lamdba的进阶示例
 * 在本示例中，定义六种接口来进一步的掌握lambda的语法
 * @author jolan
 * @date 2023-01-07
 */
public class Demo2 {

    public static void main(String[] args) {
        //无返回值无形参lambda写法
        NoReturnNoArgs noReturnNoArgs = () -> {
            System.out.println("无返回值无形参方法体");
        };

        //无返回值单形参
        NoReturnOneArg noReturnOneArg = (int a) -> {
            System.out.println("无返回值单形参,输入参数值:" + a);
        };

        //无返回值双形参
        NoReturnTwoArgs noReturnTwoArgs = (int a, int b) -> {
            System.out.println("无返回值双形参,计算两数只和:" + (a + b));
        };

        //有返回值无形参
        HasReturnNoArgs hasReturnNoArgs = () -> {
            return 4;
        };

        //有返回值单形参
        HasReturnOneArg hasReturnOneArg = (int a) -> {
            return a;
        };

        //有返回值双形参
        HasReturnTwoArgs hasReturnTwoArgs = (int a, int b) -> {
            return a + b;
        };



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
