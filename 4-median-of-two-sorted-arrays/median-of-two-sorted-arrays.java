class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] arr = new int[len1 + len2];
        int idx = 0;
        for(int  i = 0; i < len1; i++){
            arr[idx++] = nums1[i];
        }
        for(int  i = 0; i < len2; i++){
            arr[idx++] = nums2[i];
        }
        Arrays.sort(arr);
        if(arr.length % 2 != 0){
            return arr[arr.length / 2];
        }
        double median = (arr[(arr.length / 2) - 1] + arr[arr.length / 2]) / 2.0;
        return median;
    }
}