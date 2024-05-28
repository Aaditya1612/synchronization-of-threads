package Basics;

import java.util.*;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;

class Helper{
    List<String> list = new ArrayList<>();

    void setElement(String el){
        list.add(el);
    }
    List<String> getList(){
        return list;
    }
}

public class ListThread extends Thread {
    List<String> list;  // this list is shared among multiple threads because it is being taken from the caller class (from where the thread is being initiated, so that each thread recieve same instance of the list and we can see the synchronization working)
    Lock writeLock;
    Lock readLock;
    public ListThread(String name, List<String> list, ReadWriteLock readWriteLock){ // taking read write lock in the parameter so that each thead share same instance of read write lock. If this will not be done then each thread will have their own read write lock and synchronization won'r work.
        super(name);
        this.list = list;
        this.writeLock = readWriteLock.writeLock();
        this.readLock = readWriteLock.readLock();
    }
    @Override
    public void run() {

        // Write section
        writeLock.lock();
        try {
            for(int i=0; i<10; i++){
                this.list.add(i+" "+Thread.currentThread().getName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }

        // Read section
        readLock.lock();
        try{
            System.out.println(list);
        } finally{
            readLock.unlock();
        }



        // synchronized (list){  // create a monitor for the shared list and a thread who wish to add element to the list will first need to acquire lock on this object
        //     for(int i=0; i<10; i++){
        //         this.list.add(i+" "+Thread.currentThread().getName());
        //     }
        // }
        // System.out.println(list);
    }
}
