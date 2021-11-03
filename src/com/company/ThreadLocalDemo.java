package com.company;

import java.util.TreeMap;

public class ThreadLocalDemo {

    private static ThreadLocal<String> sThreadLocal = new ThreadLocal<>();

    public static void main(String[] args) {
        //主线程
        sThreadLocal.set("这是在主线程中");
        System.out.println("线程名字"+Thread.currentThread().getName()+"-----"+sThreadLocal.get());

        //线程a
        new Thread(new Runnable() {
            @Override
            public void run() {
                sThreadLocal.set("这是在线程a中");
                System.out.println("线程名字"+Thread.currentThread().getName()+"-----"+sThreadLocal.get());
            }
        },"线程a").start();
        new Thread(()->{
            sThreadLocal.set("这是在线程b中");
            System.out.println("线程名字"+Thread.currentThread().getName()+"-----"+sThreadLocal.get());
        },"线程b").start();
    }
}
