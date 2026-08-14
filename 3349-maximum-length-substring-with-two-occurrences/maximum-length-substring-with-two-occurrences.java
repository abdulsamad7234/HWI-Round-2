class Solution {
    public int maximumLengthSubstring(String s) {
        int l = 0;
        int maxL = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char curr = s.charAt(i);
            map.put(curr, map.getOrDefault(curr, 0) + 1);
            if(map.containsKey(curr)){
                while(map.get(curr) > 2){
                    char left = s.charAt(l);
                    map.put(left, map.get(left) - 1);
                    if(map.get(left) == 0){
                        map.remove(left);
                    }
                    l++;
                }
            }
            maxL = Math.max(maxL, i - l + 1);
        }
        return maxL;
    }
}