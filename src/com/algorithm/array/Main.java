package com.algorithm.array;

public class Main {
    public static void main(String[] args) {
        Array<Integer> arr = new Array<>(20); // 泛型，Integer是一个包装类，包装类可以在需要的时候自动转化为基本数据类型
        for(int i=0; i<10; i++) {
            arr.addLast(i);
        }
        System.out.println("原数组为：");
        System.out.println(arr);

        arr.delete(2);
        System.out.println("删除后的数组为：\n" + arr);
    }
}
