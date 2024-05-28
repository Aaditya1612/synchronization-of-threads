package Basics;
import Printers.Printer;
public class ThreadB extends Thread{
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
