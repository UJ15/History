import java.util.*;

class ShortCode {
    public int solution(String skill, String[] skill_trees) {
        List<String> skillTrees = new ArrayList<>(Arrays.asList(skill_trees));
        Iterator<String> itorator = skillTrees.iterator();

        while (itorator.hasNext()) {
            if (skill.indexOf(itorator.next().replaceAll("[^" + skill + "]", "")) != 0) {
                itorator.remove();
            }
        }

        return skillTrees.size();
    }
}