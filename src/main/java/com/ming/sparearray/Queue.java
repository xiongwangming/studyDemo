package com.ming.sparearray;

/**
 * @ClassName com.ming.sparearray
 * @Author 24206
 * @Date 2020/3/21 17:00
 **/
public class Queue {

    public static void main(String[] args) {

        MyQueue myQueue = new MyQueue(2);
        myQueue.add(10);
        myQueue.add(11);
//        myQueue.add(10);
        boolean enpty = myQueue.isEnpty();
        System.out.println(enpty);
        boolean full = myQueue.isFull();
        System.out.println(full);
        System.out.println(myQueue.get());
        myQueue.show();




    }




static class MyQueue{
        //数组最大长度
        private int maxSize;
        //队列头下标
        private int foot;
        //队列尾下标初始化时和头下标相等
        private int hand;
        //存放数据的数组
        private int[] arr;

        //构造方法
         MyQueue(int maxSize){
             this.maxSize = maxSize;
             foot = -1;
             hand = -1;
             arr = new int[maxSize];
    }

    //判断队列是否为空
    public boolean isEnpty(){
             if (hand == -1){
                 return true;
             }else {
                 return false;
             }
    }

    //判断数组是否已满
    public boolean isFull(){
             return maxSize == hand+1;
    }

    //给队列添加元素
    public void add(int n){
          if (isFull()) {
              throw new RuntimeException("数组已满");
          }
          hand++;
          arr[hand] = n;
    }

    //获取元素
    public int get(){
        if (isEnpty()) {
            throw new RuntimeException("数组为空");
        }
        foot++;
        return arr[foot];
    }

    //展示数组
    public void show(){
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
    }


}
}
