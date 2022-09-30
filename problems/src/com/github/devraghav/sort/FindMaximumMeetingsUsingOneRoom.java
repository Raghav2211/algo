package com.github.devraghav.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FindMaximumMeetingsUsingOneRoom {

    class Meeting {
        int id;
        int start;
        int end;


        public Meeting(int id, int start, int end) {
            this.id = id;
            this.start = start;
            this.end = end;
        }

        public int getId() {
            return id;
        }

        public int getStart() {
            return start;
        }

        public int getEnd() {
            return end;
        }

        @Override
        public String toString() {
            return "Meeting{" +
                    "id=" + id +
                    ", start=" + start +
                    ", end=" + end +
                    '}';
        }
    }

    public List<Meeting> maxMeetings(int start[], int end[], int n) {
        if (n == 0 || n == 1) return new ArrayList<>();
        List<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            meetings.add(new Meeting(i, start[i], end[i]));
        }
        Collections.sort(meetings, Comparator.comparingInt(Meeting::getEnd)
        );
        var iterator = meetings.iterator();
        var prevValidMeeting = iterator.next();
        while (iterator.hasNext()) {
            Meeting currMeeting = iterator.next();
            if (currMeeting.getStart() <= prevValidMeeting.getEnd()) {
                iterator.remove();
                continue;
            }
            prevValidMeeting = currMeeting;

        }
        return meetings;
    }

    public static void main(String[] args) {
        FindMaximumMeetingsUsingOneRoom findMaximumMeetingsInOneRoom = new FindMaximumMeetingsUsingOneRoom();
        System.out.println(findMaximumMeetingsInOneRoom.maxMeetings(new int[]{1, 3, 0, 5, 8, 5}, new int[]{2, 4, 6, 7, 9, 9}, 6));
    }
}
