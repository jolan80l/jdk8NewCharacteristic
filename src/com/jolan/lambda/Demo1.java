package com.jolan.lambda;

/**
 * 简单说明和演示
 * Lambda表达式是JDK 8开始后的一种新语法形式
 * 它的作用是简化匿名内部类的代码写法，是一种语法糖
 * 语法糖：语法糖（Syntactic sugar），也译为糖衣语法，是由英国计算机科学家彼得·约翰·兰达（Peter J. Landin）发明的一个术语，指计算机语言中添加的某种语法，这种语法对语言的功能并没有影响，但是更方便程序员使用。通常来说使用语法糖能够增加程序的可读性，从而减少程序代码出错的机会
 * 基本格式：(参数列表) -> {代码}
 * @author jolan
 * @date 2023-01-07
 */
public class Demo1 {

    public static void main(String[] args) {
        //匿名内部类写法
        PlusFormula plusFormula = new PlusFormula() {
            @Override
            public int add(int a, int b) {
                return a + b;
            }
        };
        //输出结果2
        System.out.println(plusFormula.add(1, 1));

        //lambda写法：等号右边，括号里面是接口中方法的参数类型和形参变量，右箭头是lambda的固定写法，大括号中是需要实现的方法体
        PlusFormula plusFormula2 = (int a, int b) -> {
            return a + b;
        };
        //输出结果也是2
        System.out.println(plusFormula2.add(1, 1));
    }

    /**
     * 计算两个整数只和的加法运算公式接口
     */
    interface PlusFormula {
        int add(int a, int b);
    }
}
