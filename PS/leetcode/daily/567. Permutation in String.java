class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()) return false;
        int[] arr = new int[26];
        for(int i=0;i<s1.length();i++) arr[s1.charAt(i)-'a']++;
        int[] s2Array = s2.chars().map(i->i-97).toArray();
        for(int i=0;i<s1.length();i++) arr[s2Array[i]]--;
        int start = 0, end = s1.length()-1;
        while(end<s2.length()-1){
            if(allZeros(arr)) return true;
            arr[s2Array[start++]]++;
            arr[s2Array[++end]]--;
        }
        if(allZeros(arr)) return true;
        return false;
    }
    public boolean allZeros(int[] arr){
        return Arrays.stream(arr).allMatch(i->i==0);
    }
}