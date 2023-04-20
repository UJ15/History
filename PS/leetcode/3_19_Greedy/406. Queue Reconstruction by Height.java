/**
 * 우선순위 큐를 이용해 키 내림차순으로 정렬한다음
 * 순서대로 뽑아 k 인덱스에 삽입해주면 된다.
 */

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        PriorityQueue<People> q = new PriorityQueue<>();
        List<People> list = new ArrayList<>();
        int[][] result = new int[people.length][2];

        for (int i = 0 ; i < people.length ; i++) {
            q.offer(new People(people[i][0], people[i][1]));
        }

        while (!q.isEmpty()) {
            People cur = q.poll();
            list.add(cur.k, cur);
        }

        for (int i = 0 ; i < result.length ; i++) {
            People p = list.get(i);
            result[i][0] = p.h;
            result[i][1] = p.k;
        }

        return result;
    }
}

class People implements Comparable<People> {
    int h;
    int k;

    public People(int h, int k) {
        this.h = h;
        this.k = k;
    }

    @Override
    public int compareTo(People o) {
        if (o.h == this.h) {
            return this.k - o.k;
        } else {
            return o.h - this.h;
        }
    }
}