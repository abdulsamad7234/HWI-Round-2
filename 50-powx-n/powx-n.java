class Solution {
    public double myPow(double x, int n) {
        if(n < 0){
            double ans = solve(x, -n);
            return 1 / ans;
        }
        return solve(x, n);
    }

    public double solve(double x, int n){
        if(n == 0){
            return 1;
        }
        double half = solve(x, n / 2);
        double full = half * half;
        if(n % 2 == 0){
            return full;
        }
        return x * full;
    }
}