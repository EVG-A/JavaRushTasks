package com.javarush.task.task25.task2512;

/* 
Живем своим умом
*/
public class Solution implements Thread.UncaughtExceptionHandler {

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        t.interrupt();
        printex(e);
        //System.out.println(e.getClass() + ": " + e.getMessage());
        /*for (StackTraceElement element: t.getStackTrace()){
            System.out.println(element.getClass() +":"+ e.getMessage());
        }*/
    }
    void printex(Throwable e){
        if (e.getCause() != null) printex(e.getCause());
        System.out.println(e.getClass().getName() + ": " + e.getMessage());
    }

    public static void main(String[] args) {
        //new Exception("ABC", new RuntimeException("DEF", new IllegalAccessException("GHI")));
    }
}
