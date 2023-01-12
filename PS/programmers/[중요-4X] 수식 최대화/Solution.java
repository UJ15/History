https://school.programmers.co.kr/learn/courses/30/lessons/67257

import java.util.*;

class Solution {
    private List<Long> numbers = new ArrayList<>();
    private List<String> operators = new ArrayList<>();
    private long answer = Long.MIN_VALUE;

    private String[] oper = {"+", "-", "*"};
    private String[] priority = new String[oper.length];
    private boolean[] visited = new boolean[oper.length];

    public long solution(String expression) {
        seperate(expression);

        permutation(0, 3);
        return answer;
    }

    private void permutation(int depth, int length) {
        if (depth == length) {
            calculate();

            return;
        }

        for (int i = 0 ; i < length ; i++) {
            if (!visited[i]) {
                visited[i] = true;
                priority[depth] = oper[i];
                permutation(depth + 1, length);
                visited[i] = false;
            }
        }
    }

    private void calculate() {
        List<Long> numberList = new ArrayList<>(numbers);
        List<String> operList = new ArrayList<>(operators);

        for (int i = 0 ; i < priority.length ; i++) {
            String operator = priority[i];

            for (int j = 0 ; j < operList.size() ; j++) {
                if (operList.get(j).equals(operator)) {
                    long left = numberList.remove(j);
                    long right = numberList.remove(j);
                    long result = arith(left, right, operator);

                    numberList.add(j, result);
                    operList.remove(j);
                    j--;
                }
            }
        }

        long result = Math.abs(numberList.get(0));

        answer = Math.max(answer, result);
    }

    private long arith(long left, long right, String operator) {

        switch (operator) {
            case "+" :
                return left + right;
            case "-" :
                return left - right;
            case "*" :
                return left * right;
        }

        return -1;
    }

    private void seperate(String expression) {
        String[] numbersArr = expression.split("\\+|\\*|\\-");
        String[] operatorsArr = expression.split("[0-9]+");

        for (String number : numbersArr) {
            numbers.add(Long.parseLong(number));
        }

        for (String operator : operatorsArr) {
            operators.add(operator);
        }

        operators.remove(0);
    }
}
