import java.util.*;
class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Arrays.fill(left, 1);
        Arrays.fill(right, 1);
        int sum = 0;
        int[] ans = new int[n];
        for(int i = 1; i < n; i++){
            if(ratings[i] > ratings[i - 1]){
                left[i] = left[i - 1] + 1;
            }
        }
        for(int i = n - 2; i >= 0; i--){
            if(ratings[i] > ratings[i + 1]){
                right[i] = right[i + 1] + 1;
            }
        }
        for(int i = 0; i < n; i++){
            ans[i] = Math.max(left[i], right[i]);
            sum += ans[i];
        }
        return sum;
    }
}