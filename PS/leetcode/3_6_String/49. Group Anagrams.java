class Solution {
    private Map<String, List<String>> map;
    private List<List<String>> result;

    public List<List<String>> groupAnagrams(String[] strs) {
        map = new HashMap<>();

        for (String str : strs) {
            String key = getKey(str);
            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());
    }

    private String getKey(String str) {
        char[] arr = str.toCharArray();
        Arrays.sort(arr);

        return new String(arr);
    }
}