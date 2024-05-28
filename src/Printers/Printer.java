package Printers;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Printer {
    ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    public void startPrint(char c){
        readWriteLock.writeLock().lock();;
        try {
            for(int i=0; i<10; i++){
                for(int j=0; j<10; j++){
                    System.out.print(c+" ");
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println();
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally{
            readWriteLock.writeLock().unlock();
        }
    }
}
