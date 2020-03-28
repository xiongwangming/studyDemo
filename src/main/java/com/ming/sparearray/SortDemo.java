package com.ming.sparearray;


import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @ClassName com.ming.sparearray
 * @Author 24206
 * @Date 2020/3/23 15:14
 **/
public class SortDemo {


    public static void main(String[] args) {

        int[] arr = new int[]{90,20,45,36,23,87,54};
//        selectSort(arr);
//        int[] ints = byMaoPao(arr);
//        System.out.println(Arrays.toString(ints));
        insertSort(arr);
    }


    //冒泡排序
    public static int[] byMaoPao(int[] arr){
        int temp = 0;
        //标记符，优化冒泡排序
        boolean flag = false;
        for (int i = 0; i <arr.length-1 ; i++) {
            for (int j = 0; j < arr.length-1; j++) {
                if (arr[j]<arr[j+1]){
                    //如果进行了位置交换则将标记符设置
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
            //判断是否交换位置
            if (!flag){
                System.out.println("当前数组未交换位置提前结束");
                break;
            }else {
                flag = false;//将标记符归位
            }
        }
        return arr;
    }


    //选择排序
    public static void selectSort(int[] arr){

        for (int i = 0; i < arr.length - 1; i++) {
            int index = i;
            int min = arr[i];
            for (int j = i; j < arr.length ; j++) {
                if (arr[j]<min){
                    min = arr[j];
                    index = j;
                }
            }
            if (index != i){
                arr[index] = arr[i];
                arr[i] = min;
            }

        }
        System.out.println(Arrays.toString(arr));
    }

    static void insertSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int index = i-1;
            while (index>=0 && temp<arr[index]){
                arr[index+1] = arr[index];
                index--;
            }
            arr[index+1] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
