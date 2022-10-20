https://school.programmers.co.kr/learn/courses/30/lessons/17680

import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        List<String> cache = new ArrayList<>();
        int answer = 0;

        for (String city : cities) {
            city = city.toLowerCase();

            if (cache.contains(city)) {

                answer += 1;
                cache.remove(city);
                cache.add(city);

            } else {

                if (cache.size() == cacheSize && cacheSize != 0) {
                    cache.remove(0);
                }
                if (cacheSize != 0) {
                    cache.add(city);
                }

                answer += 5;
            }
        }

        return answer;
    }
}