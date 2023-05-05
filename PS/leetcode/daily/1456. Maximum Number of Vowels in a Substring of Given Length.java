/**
 * My Solution
 */
class Solution {
    public int maxVowels(String s, int k) {
        char[] arr = s.toCharArray();
        List<Character> vowels = List.of('a', 'e', 'i', 'o', 'u');
        int max = -1;
        int start = 0;
        int count = 0;

        for (int i = 0 ; i < k ; i++) {
            if (vowels.contains(arr[i])) {
                count++;
            }
        }

        max = count;

        for (int i = k ; i < arr.length ; i++) {
            if (vowels.contains(arr[start++])) {
                count--;
            }

            if (vowels.contains(arr[i])) {
                count++;
            }

            max = Math.max(count, max);
        }

        return max;
    }
}

/**
 * more simple sliding window
 */

class Solution {
    public int maxVowels(String s, int k) {
        int count = 0;
        int max = 0;

        for (int i = 0 ; i < s.length() ; i++) {
            if (isVowel(s.charAt(i))) {
                count++;
            }

            //i가 0부터 시작하기 때문에 k - 1과 비교하는것, 그 이수로 윈도우의 맨 앞글자들을 차례로 확인하며 카운트 감소
            if (i > k - 1 && isVowel(s.charAt(i - k))) {
                count--;
            }

            max = Math.max(max, count);
        }

        return max;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c =='u';
    }
}