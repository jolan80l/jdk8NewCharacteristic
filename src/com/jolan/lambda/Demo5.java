package com.jolan.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 使用lambda实现list的排序功能
 * @author jolan
 * @date 2023-01-07
 */
public class Demo5 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(null);
        list.add(10);
        list.add(6);
        list.add(8);
        list.add(12);
        list.add(9);
        list.add(null);
        for (Integer integer : list) {
            System.out.println(integer);
        }
        System.out.println("--------------");
        //匿名内部类的实现方式
//        Collections.sort(list, new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                if(o1 == null && o2 != null){
//                    return 1;
//                }
//                if(o1 != null && o2 == null){
//                    return -1;
//                }
//                if(o1 == null && o2 == null){
//                    return 0;
//                }
//                if(o1 >= o2){
//                    return 1;
//                }
//                return -1;
//            }
//        });
//        for (Integer integer : list) {
//            System.out.println(integer);
//        }
//        System.out.println("--------------");
        //lambda的实现方式，实现list中元素的升序排列（null当作最大值）
        Collections.sort(list, (o1, o2) -> {
            if(o1 == null && o2 != null){
                return 1;
            }
            if(o1 != null && o2 == null){
                return -1;
            }
            if(o1 == null && o2 == null){
                return 0;
            }
            if(o1 >= o2){
                return 1;
            }
            return -1;
        });
        for (Integer integer : list) {
            System.out.println(integer);
        }
    }
}
