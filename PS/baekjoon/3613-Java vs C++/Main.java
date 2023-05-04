import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String s = br.readLine();
        String result;

        int type = compareType(s);

        if (type > 0) {
            result = convertToCPP(s);
        } else if (type < 0) {
            result = convertToJava(s);
        } else {
            result = "Error!";
        }

        System.out.println(result);
    }

    private static String convertToCPP(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i < s.length() ; i++) {
            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                sb.append('_');
                sb.append(Character.toLowerCase(s.charAt(i)));
            } else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

    private static String convertToJava(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0 ; i < s.length() ; i++) {
            if (s.charAt(i) == '_') {
                sb.append(Character.toUpperCase(s.charAt(++i)));
            } else {
                sb.append(s.charAt(i));
            }
        }

        return sb.toString();
    }

    private static int compareType(String s) {
        if (isJava(s)) {
            return 1;
        }

        if (isCPP(s)) {
            return -1;
        }

        return 0;
    }

    private static boolean isJava(String s) {
        if (s.isBlank()) {
            return false;
        }

        for (int i = 0 ; i < s.length() ; i++) {
            if (i == 0 && s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                return false;
            }

            if (s.charAt(i) == '_') {
                return false;
            }
        }

        return true;
    }

    private static boolean isCPP(String s) {
        if (s.isBlank()) {
            return false;
        }

        for (int i = 0 ; i < s.length() ; i++) {
            if (i == 0 && s.charAt(i) == '_') {
                return false;
            }

            if (i > 0 && s.charAt(i) == '_' && s.charAt(i - 1) == '_') {
                return false;
            }

            if (i == s.length() - 1 && s.charAt(i) == '_') {
                return false;
            }

            if (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z') {
                return false;
            }
        }

        return true;
    }
}