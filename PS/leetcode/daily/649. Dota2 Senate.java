/**
 * 2개의 큐를 이용해서 권리가 있는 진영의 의원들을 인덱스 값을 늘리며 추가해준다.
 * 큐의 각 값을 비교해서 인덱스가 더 빠르면 해당 진영에 추가하는 방식으로 반복한다.
 */

class Solution {
    public String predictPartyVictory(String senate) {
        Queue<Integer> rQ = new LinkedList<>();
        Queue<Integer> dQ = new LinkedList<>();

        for (int i = 0 ; i < senate.length() ; i++) {
            if (senate.charAt(i) == 'R') {
                rQ.offer(i);
            } else {
                dQ.offer(i);
            }
        }

        int last = senate.length() + 1;

        while (!rQ.isEmpty() && !dQ.isEmpty()) {
            if (rQ.poll() < dQ.poll()) {
                rQ.offer(last++);
            } else {
                dQ.offer(last++);
            }
        }

        return rQ.isEmpty() ? "Dire" : "Radiant";
    }
}