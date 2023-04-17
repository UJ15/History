public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
    int maximumCandies = 0;

    for(int count   :   candies)    {
        maximumCandies = Math.max(count,maximumCandies);
    }

    List<Boolean> result = new ArrayList<>();

    for(int count : candies) {
        result.add(count+extraCandies >= maximumCandies);
    }

    return result;
}