class Solution {
    int nums[];
    int k;
    int x;
    long cost[];
    long dp[][];
    public long helper(int idx, int yo){
        if(yo >= k) return 0; 
        if(idx+x-1 >= nums.length){
            return (long)1e16;
        }

        if(dp[idx][yo] != -1) return dp[idx][yo];
        long ans = cost[idx] + helper(idx+x, yo+1);
        ans = Math.min(ans, helper(idx+1, yo));
        return dp[idx][yo] = ans;
    }
    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        this.nums = nums;
        this.k = k;
        this.x = x;

         dp = new long[n][k+1];
         for(int i = 0; i < n;i++){
            Arrays.fill(dp[i] , -1);
         }

        cost = new long[n -x+ 1];
        TreeSet<Integer> set1 = new TreeSet<>((a, b) -> {
            if (nums[a] != nums[b]) return Integer.compare(nums[a], nums[b]);
            return Integer.compare(a, b);
        });

        TreeSet<Integer> set2 = new TreeSet<>((a, b) -> {
            if (nums[a] != nums[b]) return Integer.compare(nums[a], nums[b]);
            return Integer.compare(a, b);
        });

        int target = (x + 1)/2;
        long sum1 = 0;
        long sum2 = 0;
        for (int i = 0; i < n; i++) {
            if (i >= x) {
                int idx = i - x;
                if(set1.contains(idx)){
                    set1.remove(idx);
                    sum1 -= nums[idx];
                }else{
                    set2.remove(idx);
                    sum2 -= nums[idx];
                }
            }

            int f = set2.isEmpty() ? -1 : set2.first();
            if (f != -1&&(nums[i] > nums[f])) {
                set2.add(i);
                sum2 += nums[i];
            } else {
                set1.add(i);
                sum1 += nums[i];
            }

            while (set1.size() > target) {
                int v = set1.pollLast();
                sum1 -= nums[v];
                set2.add(v);
                sum2 += nums[v];
            }
            while (set1.size() < target && !set2.isEmpty()) {
                int v = set2.pollFirst();
                sum2 -= nums[v];
                set1.add(v);
                sum1 += nums[v];
            }

            if (i >= x - 1) {
                long med = nums[set1.last()];
                cost[i - x + 1] = med * set1.size() - sum1 + sum2 - med * set2.size();
            }
        }

        return helper(0 , 0);
    }
}