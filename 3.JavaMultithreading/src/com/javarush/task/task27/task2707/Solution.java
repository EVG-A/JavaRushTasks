package com.javarush.task.task27.task2707;

/* 
Определяем порядок захвата монитора
*/
public class Solution {
    public void someMethodWithSynchronizedBlocks(Object obj1, Object obj2)  {
        synchronized (obj1) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (obj2) {
                System.out.println(obj1 + " " + obj2);
            }
        }
    }


    public static boolean isLockOrderNormal(final Solution solution, final Object o1, final Object o2) throws Exception {
        class Sol1 extends Thread {
            public void run() {
                synchronized (o1) {

                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (o2) {
                        }

                }
            }
        }
        class Sol2 extends Thread {
            public void run() {
                solution.someMethodWithSynchronizedBlocks(o1, o2);
            }
        }

        Sol1 sol1 = new Sol1();
        Sol2 sol2 = new Sol2();

        sol1.start();
        sol2.start();
        //sol2.wait(2000);
        Thread.sleep(600);
        return sol2.getState() != Thread.State.BLOCKED;
    }

    public static void main(String[] args) throws Exception {
        final Solution solution = new Solution();
        final Object o1 = new Object();
        final Object o2 = new Object();

        System.out.println(isLockOrderNormal(solution, o1, o2));
    }
}
