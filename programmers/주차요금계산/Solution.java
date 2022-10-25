https://school.programmers.co.kr/learn/courses/30/lessons/92341

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

class Solution {
    ConcurrentHashMap<String, Integer> infoMap = new ConcurrentHashMap<>();
    ConcurrentHashMap<String, Integer> useMap = new ConcurrentHashMap<>();

    public int[] solution(int[] fees, String[] records) {
        for (String record : records) {
            String[] info = record.split(" ");

            if (info[2].equals("IN")) {
                saveInfo(info[0], info[1]);
            } else {
                saveUseTime(info[0], info[1]);
            }
        }

        for (String carNumber : infoMap.keySet()) {
            saveUseTime("23:59", carNumber);
        }

        for (String carNumber : useMap.keySet()) {
            calculateFee(carNumber, fees);
        }

        List<String> list = new ArrayList<>(useMap.keySet());
        list.sort(String::compareTo);

        return list.stream().map(useMap::get).mapToInt(i -> i).toArray();
    }

    private void calculateFee(String carNumber, int[] fees) {
        int baseTime = fees[0];
        int baseFee = fees[1];
        double timeUnit = fees[2];
        int overFee = fees[3];
        double overTime = (double) useMap.get(carNumber) - baseTime;

        if (overTime < 0) {
            useMap.put(carNumber, baseFee);
            return;
        }

        int fee = baseFee + (int) Math.ceil(overTime / timeUnit) * overFee;

        useMap.put(carNumber, fee);
    }

    private void saveInfo(String time, String carNumber) {
        String[] times = time.split(":");
        int minute = Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
        infoMap.put(carNumber, minute);
    }

    private void saveUseTime(String time, String carNumber) {
        String[] times = time.split(":");
        int minute = Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
        int info = infoMap.remove(carNumber);
        useMap.put(carNumber, useMap.getOrDefault(carNumber, 0) + minute - info);
    }
}