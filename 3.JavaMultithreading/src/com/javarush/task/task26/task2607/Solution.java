package com.javarush.task.task26.task2607;

/* 
Вежливость - это искусственно созданное хорошее настроение
*/
public class Solution {
    public static class IntegerHolder{
        private  int value;

        public synchronized int getValue() {
            return value;
        }

        public synchronized void setValue(int value) {
            this.value = value;
        }
    }
    public static void main(String[] args) {
    }
}
