/**
 * HashMap을 이용한 수식에 대한 결과를 가져오는 로직이 속도와 메모리에 꽤 영향을 준다.
 *
 * DivideAndConquer의 대표적인 문제로 로직을 자세하게 이해하는게 중요하다.
 * 분할된 표현식별로 나올 수 이는 복수개의 정답 리스트를 반환하고 분할된 리스트들을 연산자에 맞게 계산한 값을 리턴한다.
 * 왼쪽 수식에서 완성되는 결과 리스트 [left], 오른쪽 수식에서 완성되는 결과 리스트 [right]
 * [left] op [right]를 이중 반복문으로 모든 결과를 다시 리스트에 반환하는게 핵심이다.
 */

class Solution {
    Map<String, List<Integer>> map = new HashMap<>();

    public List<Integer> diffWaysToCompute(String expression) {
        List<Integer> result = new ArrayList<>();

        if (map.containsKey(expression)) {
            return map.get(expression);
        }

        for (int i = 0 ; i < expression.length() ; i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));

                for (int l : left) {
                    for (int r : right) {
                        if (c == '+') {
                            result.add(l + r);
                        }  else if (c == '-') {
                            result.add(l - r);
                        } else {
                            result.add(l * r);
                        }
                    }
                }
            }
        }

        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }

        map.put(expression, result);

        return result;
    }
}