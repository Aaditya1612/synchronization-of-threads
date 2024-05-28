import java.util.*;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

import Basics.ListThread;

public class App {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        ListThread threadA = new ListThread("A", list, readWriteLock);
        ListThread threadB = new ListThread("B", list, readWriteLock);
        ListThread threadC = new ListThread("C", list, readWriteLock);
        ListThread threadD = new ListThread("D", list, readWriteLock);
        ListThread threadE = new ListThread("E", list, readWriteLock);
        ListThread threadF = new ListThread("F", list, readWriteLock);

        threadA.start();
        // try {
        //     threadA.join();  // this will pause the execution of current thread until the thread A finish it's execution.
        // } catch (InterruptedException e) {
        //     // TODO Auto-generated catch block
        //     e.printStackTrace();
        // }
        threadB.start();
        threadC.start();
        threadD.start();
        threadE.start();
        threadF.start();
    }
}
