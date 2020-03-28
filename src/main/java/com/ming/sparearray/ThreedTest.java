package com.ming.sparearray;

import java.util.concurrent.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName com.ming.sparearray
 * @Author 24206
 * @Date 2020/3/25 16:22
 **/
public class ThreedTest {
    public static void main(String[] args) {

        DoMath doMath = new DoMath();
        Executor executor = Executors.newCachedThreadPool();
        ThreadPoolExecutor executor1 = new ThreadPoolExecutor(1,5,2L,TimeUnit.SECONDS,new SynchronousQueue<>());


        new Thread(()->{

                try {
                    doMath.doSomeing(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

        },"a").start();

        new Thread(()->{

                try {
                    doMath.doSomeing(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

        },"b").start();
        new Thread(()->{

                try {
                    doMath.doSomeing(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

        },"c").start();


    }
}


class DoMath{
    private int number = 1;
    private Lock lock = new ReentrantLock();
    private Condition condition1 = lock.newCondition();
    private Condition condition2 = lock.newCondition();
    private Condition condition3 = lock.newCondition();

    public void doSomeing(int num) throws InterruptedException {
        lock.lock();
        try {
            if (num == 1){
                while (number != 1){
                    condition1.await();
                }
                if (number == 1){
                    for (int i = 1; i <= 5; i++) {
                        System.out.println(Thread.currentThread().getName()+i);
                    }
                    number =2;
                    condition2.signal();
                }
            }

            if (num == 2){
                while (number!=2){
                    condition2.await();
                }

                if (number == 2){
                    for (int i = 1; i <= 10; i++) {
                        System.out.println(Thread.currentThread().getName()+i);
                    }
                    number = 3;
                    condition3.await();
                }
            }


            if (num == 3){
                while (number!=3){
                    condition2.await();
                }
                if (number == 3){
                    for (int i = 1; i <= 15; i++) {
                        System.out.println(Thread.currentThread().getName()+i);
                    }
                    number = 1;
                    condition1.await();
                }
            }

        }finally {
            lock.unlock();
        }
    }



}