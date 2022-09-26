package com.github.devraghav.dp;

import java.util.HashMap;
import java.util.Map;

public class Fibonacci {

    public long fibonacci(int n) {
        return fibonacci(n, new HashMap<>());
    }

    public long fibonacci(int n, Map<Integer, Long> memoization) {
        if (n <= 2) return 1;
        if (memoization.containsKey(n)) return memoization.get(n);
        memoization.put(n, (fibonacci(n - 1, memoization)
                + fibonacci(n - 2, memoization)));
        return memoization.get(n);
    }

    public static void main(String[] args) {
        Fibonacci fibonacci
                = new Fibonacci();
        System.out.println(fibonacci.fibonacci(5));
        System.out.println(fibonacci.fibonacci(6));
        System.out.println(fibonacci.fibonacci(7));
        System.out.println(fibonacci.fibonacci(8));
        System.out.println(fibonacci.fibonacci(50));
        System.out.println(fibonacci.fibonacci(120));
    }
}
