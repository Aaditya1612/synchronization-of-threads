package Basics;

import Printers.Printer;

class ThreadA extends Thread{
    Printer printer;
    char c;
    public ThreadA(char c, Printer printer){
        this.printer = printer;
        this.c = c;
    }
    @Override
    public void run() {
        printer.startPrint(this.c);
    }
}

class ThreadB extends Thread{
    Printer printer;
    char c;
    public ThreadB(char c, Printer printer){
        this.printer = printer;
        this.c = c;
    }
    @Override
    public void run() {
        printer.startPrint(this.c);
    }
}
public class Basic {
    public static void main(String[] args) {
        Printer printer = new Printer();
        ThreadA threadA = new ThreadA('A', printer);
        ThreadB threadB = new ThreadB('B', printer);

        threadA.start();
        threadB.start();
    }
}
