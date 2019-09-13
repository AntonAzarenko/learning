package com.azarenka.test1;

import java.time.LocalDateTime;

public class MemoryError {

    static int count = 0;
    static int Ctime = 0;
    static LocalDateTime time = LocalDateTime.now();
    public static void main(String[] args) {
        try {

            run();
        } catch (StackOverflowError e) {
        }
        LocalDateTime newTime = LocalDateTime.now();
        System.out.println("Count = " + count);
        System.out.println("Time - " + Ctime +"ms");
    }

    static void run() {
        count++;
        run();
        LocalDateTime newTime = LocalDateTime.now();
    }
}
