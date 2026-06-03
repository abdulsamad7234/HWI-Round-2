class Solution {
    public int totalFruit(int[] fruits) {
        int maxSize = 0;
        int left = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int right = 0; right < fruits.length; right++){
            map.put(fruits[right], map.getOrDefault(fruits[right], 0) + 1);
            while(map.size() > 2){
                if(map.containsKey(fruits[left])){
                    map.put(fruits[left], map.get(fruits[left]) - 1);
                    if(map.get(fruits[left]) == 0){
                        map.remove(fruits[left]);
                    }
                }
                left++;
            }
            maxSize = Math.max(maxSize, right - left + 1);
        }
        return maxSize;
    }
}