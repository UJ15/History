https://school.programmers.co.kr/learn/courses/30/lessons/42839

import java.util.*;

class Solution {
    private Set<Integer> set = new HashSet<>();

    public int solution(String numbers) {
        String[] numbersArr = numbers.split("");
        boolean[] visited = new boolean[numbersArr.length];

        dfs(0, numbersArr, visited, "");
        return set.size();
    }

    private void dfs (int def, String[] arr, boolean[] visited, String number) {
        if (!number.equals("") && isPrime(Integer.parseInt(number))) {
            set.add(Integer.parseInt(number));
        }

        if (def == arr.length) {
            return;
        }

        for (int i = 0 ; i < arr.length ; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(def + 1, arr, visited, number + arr[i]);
                visited[i] = false;
            }
        }
    }

    private boolean isPrime(int number) {

        if (number == 1 || number == 0) {
            return false;
        }

        for (int i = 2 ; i * i <= number ; i++) {
            if (number % i == 0) {
                return false;
            }
        }

        return true;
    }
}