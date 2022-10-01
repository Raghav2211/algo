package com.github.devraghav.sort;

import java.util.TreeMap;

// Implement a MyCalendar class to store your events.
// A new event can be added if adding the event will not cause a double booking.
public class MyCalendar {
    TreeMap<Integer, Integer> calendar;

    public MyCalendar() {
        calendar = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        Integer prev = calendar.floorKey(start);
        Integer next = calendar.ceilingKey(start);
        if ((prev == null || start >= calendar.get(prev)) && (next == null || end <= next)) {
            calendar.put(start, end);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(10, 20));
        System.out.println(myCalendar.book(15, 25));
        System.out.println(myCalendar.book(20, 30));
    }
}
