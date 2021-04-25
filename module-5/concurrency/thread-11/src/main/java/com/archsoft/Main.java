package com.archsoft;

import java.util.concurrent.ForkJoinPool;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        ForkJoinPool pool = ForkJoinPool.commonPool();
        int[] workload = {10, 27, 13, 25, 24, 99, 12, 9, 5, 22, 21, 19, 17, 18, 20};

        Integer result = pool.invoke(new CustomRecursiveTask(
                workload, 5));
        out.printf("Resultado: %d", result);

//        int sum = 0;
//        for (int x: workload) {
//            if (x > 10 && x < 27) {
//                sum += x*10;
//            }
//        }
//        out.printf("Soma: %d", sum);

    }
}
