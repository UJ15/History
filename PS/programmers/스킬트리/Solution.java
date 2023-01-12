https://school.programmers.co.kr/learn/courses/30/lessons/49993

class Solution {
    public int solution(String skill, String[] skill_trees) {
        int answer = 0;

        for (String skillTree : skill_trees) {
            if (isValidSkillTree(skill, skillTree)) {
                answer++;
            }
        }

        return answer;
    }

    private boolean isValidSkillTree(String skill, String skillTree) {
        boolean[] visited = new boolean[skill.length()];

        for (int i = 0 ; i < skillTree.length() ; i++) {
            int index = skill.indexOf(skillTree.charAt(i));

            if (index < 0) {
                continue;
            }

            for (int j = 0 ; j < index ; j++) {
                if (!visited[j]) {
                    return false;
                }
            }

            visited[index] = true;
        }

        return true;
    }
}