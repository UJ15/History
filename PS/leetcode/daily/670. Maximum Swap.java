class Solution {
    public int maximumSwap(int num) {
        String s = String.valueOf(num);
        int len = s.length();
        char arr[] = s.toCharArray();

        for (int i = 0 ; i < len ; i++) {
            if (arr[i] == '9') {
                continue;
            }

            int max = arr[i] - '0';
            int index = -1;

            for (int j = len - 1 ; j > i ; j--) {
                if (max < (arr[j] - '0')) {
                    max = arr[j] - '0';
                    index = j;
                }
            }

            if (max != (arr[i] - '0')) {
                char temp = arr[i];
                arr[i] = arr[index];
                arr[index] = temp;
                break;
            }
        }

        return Integer.parseInt(String.valueOf(arr));
    }
}