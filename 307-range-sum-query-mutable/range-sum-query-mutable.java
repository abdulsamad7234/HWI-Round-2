class NumArray {
    static int[] segTree;
    static int n;
    public NumArray(int[] nums) {
        n = nums.length;
        segTree = new int[4 * n];
        buildTree(0, 0, n - 1, nums);;
    }
    
    public void update(int index, int val) {
        pointUpdate(0, 0, n - 1, index, val);
    }
    
    public int sumRange(int left, int right) {
        return query(0, 0, n - 1, left, right);
    }

    public int query(int idx, int l, int r, int start, int end){
        if(r < start || l > end){
            return 0;
        }
        if(l >= start && r <= end){
            return segTree[idx];
        }
        int mid = l + (r - l) / 2;
        int left = query(2 * idx + 1, l, mid, start, end);
        int right = query(2 * idx + 2, mid + 1, r, start, end);
        return left + right;
    }

    public void pointUpdate(int idx, int l, int r, int index, int val){
        if(l == r){
            segTree[idx] = val;
            return;
        }
        int mid = l + (r - l) / 2;
        if(index <= mid){
            pointUpdate(2 * idx + 1, l, mid, index, val);
        }else{
            pointUpdate(2 * idx + 2, mid + 1, r, index, val);
        }
        segTree[idx] = segTree[2 * idx + 1] + segTree[2 * idx + 2];
    }

    public void buildTree(int idx, int l, int r, int[] nums){
        if(l == r){
            segTree[idx] = nums[l];
            return;
        }
        int mid = l + (r - l) / 2;
        buildTree(2 * idx + 1, l, mid, nums);
        buildTree(2 * idx + 2, mid + 1, r, nums);
        segTree[idx] = segTree[2 * idx + 1] + segTree[2 * idx + 2];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */