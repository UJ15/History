https://school.programmers.co.kr/learn/courses/30/lessons/12927

import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());

        for (int work : works) {
            q.offer(work);
        }

        while (n-- > 0) {
            q.offer(q.poll() - 1);
        }

        return getOverWorkPoint(q);
    }

    private long getOverWorkPoint(PriorityQueue<Integer> q) {
        long sum = 0;
        while (!q.isEmpty()) {
            long work = (long) q.poll();

            if (work < 0) {
                return 0;
            }

            sum += work * work;
        }

        return sum;
    }


}