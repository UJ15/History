class Solution {
    public int countGoodStrings(int low, int high, int zero, int one) {
        int[] d = new int[high + 1];
        int result = 0;

        int min = Math.min(zero, one);
        int max = Math.max(zero, one);

        for (int i = 0 ; i < min ; i++) {
            d[i] = 0;
        }

        if (zero == one) {
            d[min] = 2;
        } else {
            d[min] = 1;
        }


        for (int i = min + 1 ; i <= high ; i++) {
            if (i < max) {
                d[i] = d[i - min];
                continue;
            }

            if (i == max) {
                d[i] = d[i - min] + 1;
                continue;
            }

            d[i] = (d[i - min] + d[i - max]) % 1000000007;
        }

        for (int i = low ; i <= high ; i++) {
            System.out.println("d[" + i + "]" + " : " + d[i]);
            result = (result + d[i]) % 1000000007;
        }

        return result;
    }
}