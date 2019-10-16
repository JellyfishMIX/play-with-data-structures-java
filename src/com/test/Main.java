package com.test;
import com.algorithm.array.Array;
import com.algorithm.linked_list.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        Array<Integer> arr = new Array<>(1000); // 泛型，Integer是一个包装类，包装类可以在需要的时候自动转化为基本数据类型
        LinkedList<Integer> arr = new LinkedList<>();

//        Array<Integer> linkedList = new Array<>(1000); // 泛型，Integer是一个包装类，包装类可以在需要的时候自动转化为基本数据类型
        LinkedList<Integer> linkedList = new LinkedList<>();
        Scanner input = new Scanner(System.in);

//        开始输入A集合
        System.out.print("请输入A集合的元素个数，该集合将使用顺序表存储：");
        int quantityA = input.nextInt();
        for (int i=0; i< quantityA; i++) {
            System.out.print("请输入A集合第" + (i+1) + "个元素：");
            int tem = input.nextInt();
            arr.addLast(tem);
        }
        System.out.println("A集合如下所示：");
        System.out.println(arr);
        System.out.println();

//        开始输入B集合
        System.out.print("请输入B集合元素的个数，该集合将使用链式表储存：");
        int quantityB = input.nextInt();
        for (int i=0; i<quantityB; i++) {
            System.out.print("请输入B集合第" + (i+1) + "个元素：");
            int tem = input.nextInt();
            linkedList.addLast(tem);
        }
        System.out.println("B集合如下所示：");
        System.out.println(linkedList);

//        开始存放并集
        Array<Integer> union = new Array<>(2000);
        for (int i=0; i<quantityA; i++) {
            union.addLast(arr.get(i));
        }
        for (int i=0; i<quantityB; i++) {
            int flag = 0;
            for (int j=0; j<quantityA; j++) {
                if (linkedList.get(i).equals(arr.get(j))) {
                    flag = 1;
                }
            }
            if (flag == 1) {
                continue;
            }
            union.addLast(linkedList.get(i));
        }
        System.out.println("A与B的并集如下：");
        System.out.println(union);
        System.out.println();

//        开始存放交集
        Array<Integer> mix = new Array<>(1500);
        for (int i=0; i<quantityB; i++) {
            int flag = 0;
            for (int j=0; j<quantityA; j++) {
                if (linkedList.get(i).equals(arr.get(j))) {
                    flag = 1;
                }
            }
            if (flag == 1) {
                mix.addLast(linkedList.get(i));
            }
        }
        System.out.println("A与B的交集如下：");
        System.out.println(mix);
        System.out.println();
    }
}
