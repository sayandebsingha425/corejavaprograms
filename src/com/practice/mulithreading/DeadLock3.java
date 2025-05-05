package com.practice.mulithreading;

public class DeadLock3 {
public static void main(String[] args) throws InterruptedException {
    System.out.println("Main Thread Started..");
    Thread.currentThread().join();
    System.out.println("Main Thread Ended..");
}
}
