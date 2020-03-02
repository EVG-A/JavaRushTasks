package com.javarush.task.task27.task2709;

public class TransferObject {
    private int value;
    protected volatile boolean isValuePresent = false; //use this variable

    public synchronized int get() {
        while (!isValuePresent) {
            try {
                wait(400);
            } catch (InterruptedException e) {

            }
        }
        isValuePresent = false;
        notifyAll();
        System.out.println("Got: " + value);
        return value;
    }

    public synchronized void put(int value) {
        while (isValuePresent) {
            try {
                wait(400);
            } catch (InterruptedException e) {

            }
        }
        isValuePresent = true;
        notifyAll();
        this.value = value;
        System.out.println("Put: " + value);
    }
}
