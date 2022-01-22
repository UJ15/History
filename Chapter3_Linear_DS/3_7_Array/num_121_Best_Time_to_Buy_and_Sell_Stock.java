class Solution {
    public int maxProfit(int[] prices) {
        int result = 0;
        int min_value = 2147483647;
        
        for(int i : prices){
            min_value = Math.min(min_value, i); //최소값 대입
            result = Math.max(result, i - min_value); //결과값중 최대값 대입
        }
        return result;
    }
}
