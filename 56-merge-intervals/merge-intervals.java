class Solution {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> ansList = new ArrayList<>();
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i = 1; i < intervals.length; i++){
            int st = intervals[i][0];
            int en = intervals[i][1];
            if(st <= end){
                end = Math.max(end, en);
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(start);
                list.add(end);
                ansList.add(list);
                start = st;
                end = en;
            }
        }
        List<Integer> list = new ArrayList<>();
        list.add(start);
        list.add(end);
        ansList.add(list);
        int[][] ans = new int[ansList.size()][2];
        for(int i = 0; i < ansList.size(); i++){
            ans[i][0] = ansList.get(i).get(0);
            ans[i][1] = ansList.get(i).get(1);
        }
        return ans;
    }
}