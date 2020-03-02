package com.javarush.task.task28.task2805;

public class MyThread  extends  Thread{
    private static int priority = 0;
    public MyThread() {
        super();
        setPriority();
    }

    public MyThread(Runnable target) {
        super(target);
        setPriority();
    }
    private void setPriority(){
        priority++;
        if (priority > 10) priority = 1;
        setPriority(priority);
    }
    public MyThread(ThreadGroup group, Runnable target) {
        super(group, target);
        priority++;
        if (priority > 10) {
            priority = 1;
            setPriority(priority);
        }else if (priority > group.getMaxPriority()) setPriority(group.getMaxPriority());
        else setPriority(priority);
    }

    public MyThread(String name) {
        super(name);
        setPriority();
    }

    public MyThread(ThreadGroup group, String name) {
        super(group, name);
        priority++;
        if (priority > 10) {
            priority = 1;
            setPriority(priority);
        }else if (priority > group.getMaxPriority()) setPriority(group.getMaxPriority());
        else setPriority(priority);
    }

    public MyThread(Runnable target, String name) {
        super(target, name);
        setPriority();
    }

    public MyThread(ThreadGroup group, Runnable target, String name) {
        super(group, target, name);
        priority++;
        if (priority > 10) {
            priority = 1;
            setPriority(priority);
        }else if (priority > group.getMaxPriority()) setPriority(group.getMaxPriority());
        else setPriority(priority);
    }

    public MyThread(ThreadGroup group, Runnable target, String name, long stackSize) {
        super(group, target, name, stackSize);
        priority++;
        if (priority > 10) {
            priority = 1;
            setPriority(priority);
        }else if (priority > group.getMaxPriority()) setPriority(group.getMaxPriority());
        else setPriority(priority);
    }
}
