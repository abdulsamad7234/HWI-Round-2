class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> {if(a[0] == b[0]){
            return a[1] - b[1];
        }else{
            return a[0] - b[0];
        }});
        int l1 = intervals[0][0];
        int r1 = intervals[0][1];
        int count = 0;
        for(int i = 1; i < n; i++){
            int l2 = intervals[i][0];
            int r2 = intervals[i][1];
            if(l2 < r1){
                count++;
                r1 = Math.min(r1, r2);
            }else{
                l1 = l2;
                r1 = r2;
            }
        }
        return count;
    }
}