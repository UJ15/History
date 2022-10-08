

class Solution {
  public int solution(int []A, int []B) {
    int answer = 0;
    Arrays.sort(A);
    Arrays.sort(B, Collections.reverseOrder());

    for (int i = 0 ; i < A.length ; i++) {
      answer += A[i] * B[i];
    }

    return answer;
  }
}