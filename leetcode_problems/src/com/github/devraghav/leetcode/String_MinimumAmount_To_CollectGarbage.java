package com.github.devraghav.leetcode;

import java.util.HashMap;
import java.util.Map;

public class String_MinimumAmount_To_CollectGarbage {

    public int garbageCollection(String[] garbage, int[] travel) {

        int[] totalTimeTillIndex = new int[travel.length];
        totalTimeTillIndex[0] = travel[0];
        for (int i = 1; i < travel.length; i++) {
            totalTimeTillIndex[i] = totalTimeTillIndex[i - 1] + travel[i];
        }


        Map<Character, Integer> garbageTypeTotalTime = new HashMap<>() {{
            put('G', 0);
            put('P', 0);
            put('M', 0);

        }};

        Map<Character, Integer> garbageTypeLastOccurance = new HashMap<>() {{
            put('G', 0);
            put('P', 0);
            put('M', 0);
        }};

        String garbageInFirstHouse = garbage[0];
        for (int i = 0; i < garbageInFirstHouse.length(); i++) {
            Character garbageType = garbageInFirstHouse.charAt(i);
            Integer tillTotalTimeOfGrabageType = garbageTypeTotalTime.get(garbageType);
            garbageTypeTotalTime.put(garbageType, ++tillTotalTimeOfGrabageType);
        }
        for (int i = 1; i < garbage.length; i++) {
            String garbageInHouse = garbage[i];
            boolean isGlassGarbageOccur = false;
            boolean isPlasticGarbageOccur = false;
            boolean isMetalGarbageOccur = false;
            for (int j = 0; j < garbageInHouse.length(); j++) {
                Character garbageType = garbageInHouse.charAt(j);
                isGlassGarbageOccur = isGlassGarbageOccur || garbageType.equals('G');
                isPlasticGarbageOccur = isPlasticGarbageOccur || garbageType.equals('P');
                isMetalGarbageOccur = isMetalGarbageOccur || garbageType.equals('M');
                Integer tillTotalTimeOfGrabageType = garbageTypeTotalTime.get(garbageType);
                garbageTypeTotalTime.put(garbageType, ++tillTotalTimeOfGrabageType);
            }
            if (isGlassGarbageOccur) {
                int currentTime = totalTimeTillIndex[i - 1] - (garbageTypeLastOccurance.get('G') == 0 ? 0 : totalTimeTillIndex[(garbageTypeLastOccurance.get('G') - 1)]);
                Integer tillTotalTimeOfGrabageType = garbageTypeTotalTime.get('G');
                garbageTypeTotalTime.put('G', (tillTotalTimeOfGrabageType + currentTime));
                garbageTypeLastOccurance.put('G', i);
            }
            if (isPlasticGarbageOccur) {
                int currentTime = totalTimeTillIndex[i - 1] - (garbageTypeLastOccurance.get('P') == 0 ? 0 : totalTimeTillIndex[(garbageTypeLastOccurance.get('P') - 1)]);
                Integer tillTotalTimeOfGrabageType = garbageTypeTotalTime.get('P');
                garbageTypeTotalTime.put('P', (tillTotalTimeOfGrabageType + currentTime));
                garbageTypeLastOccurance.put('P', i);
            }
            if (isMetalGarbageOccur) {
                int currentTime = totalTimeTillIndex[i - 1] - (garbageTypeLastOccurance.get('M') == 0 ? 0 : totalTimeTillIndex[(garbageTypeLastOccurance.get('M') - 1)]);
                Integer tillTotalTimeOfGrabageType = garbageTypeTotalTime.get('M');
                garbageTypeTotalTime.put('M', (tillTotalTimeOfGrabageType + currentTime));
                garbageTypeLastOccurance.put('M', i);
            }
        }
        return garbageTypeTotalTime.entrySet().stream().mapToInt(Map.Entry::getValue).sum();
    }

    public static void main(String[] args) {
        String_MinimumAmount_To_CollectGarbage string_minimumAmount_to_collectGarbage = new String_MinimumAmount_To_CollectGarbage();
        System.out.println(string_minimumAmount_to_collectGarbage.garbageCollection(new String[]{"G", "P", "GP", "GG"}, new int[]{2, 4, 3}));
        System.out.println(string_minimumAmount_to_collectGarbage.garbageCollection(new String[]{"MMM","PGM","GP"}, new int[]{3,10}));
    }
}
