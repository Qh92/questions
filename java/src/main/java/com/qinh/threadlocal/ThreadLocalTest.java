package com.qinh.threadlocal;

import java.util.concurrent.TimeUnit;

/**
 * 1.ThreadLocal是java中所提供的线程本地存储机制，可以利用该机制将数据缓存在某个线程内部，
 *      该线程可以在任意时刻、任意方法中获取缓存的数据
 * </p>
 * 2.ThreadLocal底层是通过ThreadLocalMap来实现的，每个Thread对象（注意不是ThreadLocal对象）中都存在一个ThreadLocalMap，
 *      Map的key为ThreadLocal对象，Map的value为需要缓存的值
 * </p>
 * 3.如果在线程池中使用ThreadLocal会造成内存泄漏，因为当ThreadLocal对象使用完之后，应该要把设置的key,value，也就是Entry对象进行回收，
 *      但线程池中的线程不会回收，而线程对象是通过强引用指向ThreadLocalMap，ThreadLocalMap也是通过强引用指向Entry对象，
 *      线程不被回收，Entry对象也就不会被回收，从而出现内存泄漏，解决办法是，在使用了ThreadLocal对象之后，手动调用ThreadLocal的remove方法，手动清除Entry对象
 * </p>
 * 4.ThreadLocal经典的应用场景就是连接管理（一个线程持有一个连接，该连接对象可以在不同的方法之间进行传递，线程之间不共享同一个连接）
 *
 * @author Qh
 * @version 1.0
 * @date 2021/9/17 15:34
 */
public class ThreadLocalTest {
    public static void main(String[] args){
        Person person = new Person();

        new Thread(() -> {
            person.setName("威少");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " : " + person.getName());
            person.remove();
        },"ThreadA").start();

        new Thread(() -> {
            person.setName("Ai");
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " : " + person.getName());
            person.remove();
        },"ThreadB").start();
    }
}
