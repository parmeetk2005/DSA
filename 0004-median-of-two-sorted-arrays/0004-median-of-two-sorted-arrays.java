class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int[] arr = new int[m + n];
        int L = arr.length;
        int i = 0; // for nums1
        int j = 0; // for nums2
        int k = 0; // for arr

        while(i < m && j < n){
            if(nums1[i] < nums2[j]){
                arr[k] = nums1[i];
                i++;
            }
            else{
                arr[k] = nums2[j];
                j++;
            }
            k++;
        }
        while(i < m){
            arr[k] = nums1[i];
            i++;
            k++;
        }
        while(j < n){
            arr[k] = nums2[j];
            j++;
            k++;
        }

        if (L % 2 == 1) { // odd length
            return arr[L / 2];
        } 
        else { // even length
            return (arr[(L / 2) - 1] + arr[L / 2]) / 2.0;
        }
    }
}