class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> ans = new ArrayList<>();
        if(intervals.length <= 1){
            return intervals;
        }
        int lb = intervals[0][0];
        int ub = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            int lb_curr = intervals[i][0];
            int ub_curr = intervals[i][1];
            if(lb_curr <= ub){
                ub = Math.max(ub, ub_curr);
            }else{
                ans.add(new int[]{lb, ub});
                lb = lb_curr;
                ub = ub_curr;
            }
            if(i == intervals.length - 1){
                ans.add(new int[]{lb, ub});
            }
        }
        int final_ans[][] = new int[ans.size()][2];
        int idx = 0;
        for(int[] x : ans){
            final_ans[idx++] = x;
        }
        return final_ans;
    }
}