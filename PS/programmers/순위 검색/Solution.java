//https://school.programmers.co.kr/learn/courses/30/lessons/72412

class Solutions {
  public int[] solution(String[] info, String[] query) {
    int[] answer = {};
    return answer;
  }

  private permutation() {
    if(depth == r){
      for(int num: out) System.out.print(num);
      System.out.println();
      return;
    }
    for(int i=0; i<arr.length; i++){
      if(!visited[i]){
        visited[i] = true;
        out[depth] = arr[i];
        permutation(arr, out, visited, depth+1, r);
        visited[i] = false;
      }
    }
  }
}