class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int sum = 0;
        int count = 0;
        for(int i = 0; i < k; i++){
            sum += arr[i];
        }
        if(sum / k >= threshold){
            count++;
        }
        for(int ei = k; ei < arr.length; ei++){
            int si = ei - k;
            sum += arr[ei];
            sum -= arr[si];
            if(sum / k >= threshold){
                count++;
            }
        }
        return count;
    }
}