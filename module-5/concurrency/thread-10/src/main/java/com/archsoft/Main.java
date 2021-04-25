package com.archsoft;

import java.util.concurrent.ForkJoinPool;

public class Main {

    public static void main(String[] args) {
        ForkJoinPool pool = ForkJoinPool.commonPool();
        pool.invoke(new CustomRecursiveAction(
                "Este eh um exemplo de processamento multithread e recursivo usando o ForkJoin Framework",
                10));
    }
}
