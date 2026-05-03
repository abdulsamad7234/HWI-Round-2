class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums1.length; i++){
            map.put(nums1[i], -1);
        }

        for(int i = 0; i < nums2.length; i++){
            for(int j = i + 1; j < nums2.length; j++){
                if(nums2[j] > nums2[i]){
                    if(map.containsKey(nums2[i])){
                        map.put(nums2[i], nums2[j]);
                    }
                    break;
                }
            }
        }
        int[] arr = new int[nums1.length];
        int idx = 0;
        for(int i = 0; i < nums1.length; i++){
            arr[idx++] = map.get(nums1[i]);
        }
        return arr;
    }
}