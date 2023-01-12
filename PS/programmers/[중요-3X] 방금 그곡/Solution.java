https://school.programmers.co.kr/learn/courses/30/lessons/17683
import java.util.*;

class Solution {
    private String answer;
    private int size;

    public String solution(String m, String[] musicinfos) {
        answer = "(None)";
        size = 0;

        m = changeMelody(m);

        for (String info : musicinfos) {
            compareInfo(m, info);
        }


        return answer;
    }

    private void compareInfo(String m, String info) {
        String[] arr = info.split(",");
        arr[3] = changeMelody(arr[3]);
        int time = getTime(arr[0], arr[1]);

        String stream = "";
        for (int i = 0 ; i < time ; i++) {
            stream += arr[3].charAt(i % arr[3].length());
        }

        if (compareMusic(m, stream)) {
            if (time > size) {
                answer = arr[2];
                size = time;
            }
        }
    }

    private boolean compareMusic(String m , String str) {
        for (int i = 0 ; i <= str.length() - m.length() ; i++) {
            if (str.charAt(i) == m.charAt(0)) {
                String sub = str.substring(i, i + m.length());

                if (m.equals(sub)) {
                    return true;
                }

            }
        }

        return false;
    }

    private int getTime(String start, String end) {
        String[] sTime = start.split(":");
        String[] eTime = end.split(":");

        int hour = (Integer.parseInt(eTime[0]) - Integer.parseInt(sTime[0])) * 60;
        int minute = Integer.parseInt(eTime[1]) - Integer.parseInt(sTime[1]);

        return hour + minute;
    }

    String changeMelody(String oldMelody) {
        oldMelody = oldMelody.replaceAll("C#", "H");
        oldMelody = oldMelody.replaceAll("D#", "I");
        oldMelody = oldMelody.replaceAll("F#", "J");
        oldMelody = oldMelody.replaceAll("G#", "K");
        String newMelody = oldMelody.replaceAll("A#", "L");

        return newMelody;
    }
}