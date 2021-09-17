package com.qinh.threadlocal;

import java.util.concurrent.TimeUnit;

/**
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
