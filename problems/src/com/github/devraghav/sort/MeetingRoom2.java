package com.github.devraghav.sort;

import java.lang.reflect.Array;
import java.util.Arrays;

// how many minimum number of meeting rooms are required to schedule all meetings?
public class MeetingRoom2 {

    public int meetingRooms(int intervals[][]) {
        int len = intervals.length;
        if (len == 0 || len == 1) return len;
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];

        for (int i = 0; i < intervals.length; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);
        int minimumRoomRequired = 0;
        for (int i = 0, j = 0; i < start.length; i++) {
            if (start[i] < end[j]) {
                minimumRoomRequired++;
                continue;
            }
            j++;
        }
        return minimumRoomRequired;
    }

    public static void main(String[] args) {
        MeetingRoom2 meetingRoom2 = new MeetingRoom2();
        System.out.println(meetingRoom2.meetingRooms(new int[][]{{0, 30}, {5, 10}, {15, 20}}));
        System.out.println(meetingRoom2.meetingRooms(new int[][]{{7, 10}, {2, 4}}));
        System.out.println(meetingRoom2.meetingRooms(new int[][]{{1, 3}, {8, 10}, {7, 8}, {9, 15}, {2, 6}}));
        System.out.println(meetingRoom2.meetingRooms(new int[][]{{1, 3}, {3, 10}, {12, 20}}));
        System.out.println(meetingRoom2.meetingRooms(new int[][]{{1, 3}, {2, 4}, {6, 8}, {10, 14}, {7, 9}}));

    }
}
