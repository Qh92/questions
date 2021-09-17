package com.qinh.threadlocal;

/**
 * @author Qh
 * @version 1.0
 * @date 2021/9/17 15:35
 */
public class Person {

    private ThreadLocal<String> name = new ThreadLocal<>();

    public void setName(String name){
        this.name.set(name);
    }

    public String getName(){
        return this.name.get();
    }

    /**
     * 避免线程池中使用ThreadLocal导致内存溢出
     */
    public void remove(){
        this.name.remove();
    }
}
