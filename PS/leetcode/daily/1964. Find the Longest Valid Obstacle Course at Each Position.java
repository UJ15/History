/***
 * 어려운 문제다. 아직도 이해가 잘 안됨.
 *
 * temp라는 리스트를 선언하고 가장 큰값이 갱신될경우 temp리스트에 값을 추가 후 해당 temp 길이를 반환하면 정답이다.
 * temp최대값 보다 작을 경우 이진탐색을 진행하여 타겟보다 큰값일 경우 해당 인덱스를 기록해둔다.
 * 이진탐색을 모두 진행해서 적절한 위치를 찾으면 (작은값보다 뒤에 큰값보다 앞에) 해당 인덱스에 + 1한 값이 정답이되고 인덱스에 타겟값을 삽입힌다.
 * 내 두뇌로는 절대 나올 수 없는 풀이다. 이런 생각을 어떻게 했는지 얼탱구가 없다.
 */

class Solution {
    public int[] longestObstacleCourseAtEachPosition(int[] obstacles) {
        List<Integer> temp = new ArrayList<>();
        int[] result = new int[obstacles.length];
        result[0] = 1;
        temp.add(obstacles[0]);

        for (int i = 1 ; i < obstacles.length ; i++) {
            if (temp.get(temp.size() - 1) <= obstacles[i]) {
                temp.add(obstacles[i]);
                result[i] = temp.size();
            } else {
                int left = 0;
                int right = temp.size() - 1;
                int index = 0;

                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (temp.get(mid) <= obstacles[i]) {
                        left = mid + 1;
                    } else {
                        index = mid;
                        right = mid - 1;
                    }
                }

                temp.set(index, obstacles[i]);

                result[i] = index + 1;
            }
        }

        return result;
    }
}