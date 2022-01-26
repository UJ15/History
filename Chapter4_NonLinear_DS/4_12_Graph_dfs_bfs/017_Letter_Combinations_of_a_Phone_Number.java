import java.util.ArrayList;

class Solution {
    public List<String> letterCombinations(String digits) {
        ArrayList<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;
        String[] map = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        dfs(0, digits, new StringBuilder(), map, result);
        return result;
    }

    public void dfs(int idx, String digits, StringBuilder temp, String[] map, ArrayList result){ //백트래킹
        if (temp.length() == digits.length()) result.add(temp.toString());
        else{
            char[] letters = map[digits.charAt(idx) - '2'].toCharArray();// digits숫자에 해당하는 문자들을 toCharArray함수를 이용해서 배열로 저장
            for (int i = 0 ; i < letters.length ; i++){// 모든 요소를 돌며 현재 인덱스 문자를 temp에 추가해주고
                temp.append(letters[i]);
                dfs(idx + 1, digits, temp, map, result);
                temp.deleteCharAt(temp.length() - 1);// 출력이 됐으면 자리하나 빼주고 마지막 인덱스 문자들이 하나씩 들어감
            }
        }
        
    }
}
