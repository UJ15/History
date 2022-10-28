https://school.programmers.co.kr/learn/courses/30/lessons/17686

import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        Arrays.sort(files, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String[] file1 = nameSplit(s1);
                String[] file2 = nameSplit(s2);

                int headDiff = file1[0].compareTo(file2[0]);

                if (headDiff == 0) {
                    return Integer.parseInt(file1[1]) - Integer.parseInt(file2[1]);
                }

                return headDiff;
            }
        });

        return files;
    }

    private String[] nameSplit(String file) {
        String[] files = new String[3];

        int numberIndex = 0;
        int tailIndex = 0;
        for (int i = 0 ; i < file.length() ; i++) {
            if (Character.isDigit(file.charAt(i))) {
                numberIndex = i;
                break;
            }
        }

        for (int i = numberIndex ; i < file.length() ; i++) {
            if (!Character.isDigit(file.charAt(i))) {
                tailIndex = i;
                break;
            }

            if (i == file.length() - 1) {
                tailIndex = file.length();
            }
        }

        files[0] = file.substring(0, numberIndex).toLowerCase();
        files[1] = file.substring(numberIndex, tailIndex);
        files[2] = file.substring(tailIndex);

        return files;
    }
}