https://school.programmers.co.kr/learn/courses/30/lessons/42627

import java.util.*;

class Job implements Comparable<Job> {
    int requestTime;
    int workload;

    public Job(int requestTime, int workload) {
        this.requestTime = requestTime;
        this.workload = workload;
    }

    @Override
    public int compareTo(Job o) {
        return this.workload - o.workload;
    }
}

class Solution {
    private int idx = 0;
    private int time = 0;
    private int completion = 0;
    private int answer = 0;

    public int solution(int[][] jobs) {
        PriorityQueue<Job> heap = new PriorityQueue<>();
        Arrays.sort(jobs, (o1, o2) -> o1[0] - o2[0]);

        while (completion != jobs.length) {

            while (idx != jobs.length && jobs[idx][0] <= time) {
                heap.offer(new Job(jobs[idx][0], jobs[idx][1]));
                idx++;
            }

            if (!heap.isEmpty()) {
                Job job = heap.poll();

                answer += job.workload + time - job.requestTime;
                time += job.workload;
                completion++;
            } else {
                time = jobs[idx][0];
            }
        }

        return answer / jobs.length;
    }
}