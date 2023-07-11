class Solution {
    private Map<String, Integer> map;

    public int romanToInt(String s) {
        map = new HashMap<>();
        int result = 0;

        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);

        String[] seq = s.split("");

        String pre = "";
        for (String n : seq) {
            int dec = getDecrease(pre, n);

            result += map.get(n) - dec;

            pre = n;
        }

        return result;
    }

    private int getDecrease(String pre, String n) {
        int dec = 0;

        if (pre.equals("I") && (n.equals("V") || n.equals("X"))) {
            dec = map.get("I") * 2;
        } else if (pre.equals("X") && (n.equals("L") || n.equals("C"))) {
            dec = map.get("X") * 2;
        } else if (pre.equals("C") && (n.equals("D") || n.equals("M"))) {
            dec = map.get("C") * 2;
        }

        return dec;
    }
}