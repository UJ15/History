https://school.programmers.co.kr/learn/courses/30/lessons/42583

import java.util.*;

class Solution {
  public int solution(int bridge_length, int weight, int[] truck_weights) {
    Queue<Integer> q = new LinkedList<>();
    int time = 0;
    int sum = 0;

    for (int i = 0 ; i < truck_weights.length ; i++) {
      int truck = truck_weights[i];

      while (true) {
        if (q.isEmpty()) { // 다리가 비었을때
          q.offer(truck);
          sum += truck;
          time++;
          break;
        } else {
          if (q.size() == bridge_length) { //다리가 꽉찼을경우(첫번째 차가 지남)
            sum -= q.poll();
          } else if (sum + truck > weight) {//무게를 초과할때 첫차가 한칸 진행
            q.offer(0);
            time++;
          } else {//무게를 초과하지 않을때 트럭 진입
            q.offer(truck);
            sum += truck;
            time++;
            break;
          }

        }
      }
    }

    return time + bridge_length;
  }
}