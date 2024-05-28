package Basics;
import Printers.Printer;
public class ThreadA extends Thread{
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

