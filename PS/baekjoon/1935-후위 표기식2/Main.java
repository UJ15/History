import java.io.*;
import java.util.*;

public class Main {
    private static Stack<Double> stack;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        double[] arr = new double[n];
        String expression = br.readLine();
        for (int i = 0 ; i < n ; i++) {
            arr[i] = Double.parseDouble(br.readLine());
        }

        double result = calculate(expression, arr);

        System.out.printf("%.2f%n", result);
    }

    private static double calculate(String expression, double[] arr) {
        stack = new Stack<>();

        for (int i = 0 ; i < expression.length() ; i++) {
            char c = expression.charAt(i);

            if (c >= 'A' && c <= 'Z') {
                stack.push(arr[c - 'A']);
            } else if (!stack.isEmpty()) {
                double b = stack.pop();
                double a = stack.pop();

                switch (c) {
                    case '+': stack.push(a + b);
                        break;
                    case '-': stack.push(a - b);
                        break;
                    case '*': stack.push(a * b);
                        break;
                    case '/': stack.push(a / b);
                        break;
                }
            }
        }

        return stack.pop();
    }
}