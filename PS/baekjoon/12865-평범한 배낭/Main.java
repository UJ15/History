package algorthmn;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Product[] products = new Product[n];
        int[] dp = new int[k + 1];

        for (int i = 0 ; i < n ; i++) {
            st = new StringTokenizer(br.readLine());
            products[i] = new Product(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0 ; i < n ; i++) {
            for (int j = k ; j >= products[i].weight ; j--) {
                dp[j] = Math.max(dp[j], dp[j - products[i].weight] + products[i].value);
            }
        }

        System.out.println(dp[k]);
    }

    static class Product {
        int weight;
        int value;

        public Product(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }
    }
}