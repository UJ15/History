class UndergroundSystem {
    private Map<Integer, UserStartStation> startMap;
    private Map<String, List<Integer>> travelMap;

    public UndergroundSystem() {
        startMap = new HashMap<>();
        travelMap = new HashMap<>();
    }

    public void checkIn(int id, String stationName, int t) {
        startMap.put(id, new UserStartStation(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {
        UserStartStation startInfo = startMap.get(id);
        String key = startInfo.getName() + 00 + stationName;

        if (!travelMap.containsKey(key)) {
            travelMap.put(key, new ArrayList<>());
        }

        travelMap.get(key).add(t - startInfo.getStartTime());
    }

    public double getAverageTime(String startStation, String endStation) {
        List<Integer> list = travelMap.get(startStation + 00 + endStation);

        return list.stream()
                .mapToInt(num -> num)
                .summaryStatistics()
                .getAverage();
    }
}

class UserStartStation {
    private final String name;
    private final int startTime;

    public UserStartStation(String name, int startTime) {
        this.name = name;
        this.startTime = startTime;
    }

    public String getName() {
        return name;
    }

    public int getStartTime() {
        return startTime;
    }
}

class UserTravelInfo {
    private final String start;
    private final String end;
    private final int endTime;
    private final int startTime;

    public UserTravelInfo(String start, String end, int endTime, int startTime) {
        this.start = start;
        this.end = end;
        this.endTime = endTime;
        this.startTime = startTime;
    }

    public static UserTravelInfo of(UserStartStation userStartStation, String end, int endTime) {
        return new UserTravelInfo(userStartStation.getName(), end, endTime, userStartStation.getStartTime());
    }

    public double getTravelTime() {
        return (double) (endTime - startTime);
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */