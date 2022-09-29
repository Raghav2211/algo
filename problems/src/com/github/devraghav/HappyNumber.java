package com.github.devraghav;

import com.sun.security.jgss.GSSUtil;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    private Set<Integer> numbers = new HashSet<>();

    public boolean isHappy(int n) {
        if (n == 0) return false;
        if (n == 1) return true;
        var nextNumber = 0;
        while (n != 0) {
            int remainder = n % 10;
            nextNumber += (remainder * remainder);
            n = n / 10;
        }

        if (nextNumber == 1) return true;
        if (numbers.contains(nextNumber)) return false;
        numbers.add(nextNumber);
        return isHappy(nextNumber);
    }

    public static void main(String[] args) {
        HappyNumber happyNumber = new HappyNumber();
        System.out.println(happyNumber.isHappy(19));
        System.out.println(happyNumber.isHappy(2));
    }
}
