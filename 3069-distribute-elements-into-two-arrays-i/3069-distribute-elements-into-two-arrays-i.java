class Solution {
    public int[] resultArray(int[] nums) {
        int l = nums.length, k1 = 0, k2 = 0, j = 0;
        int ans[] = new int[l];
        int arr1[] = new int[l];
        int arr2[] = new int[l];
        arr1[0] = nums[0];
        arr2[0] = nums[1];
        for (int i = 2; i < l; i++)
            if (arr1[k1] < arr2[k2])
                arr2[++k2] = nums[i];
            else
                arr1[++k1] = nums[i];
        while (j <= k1)
            ans[j] = arr1[j++];
        j = 0;
        while (j <= k2)
            ans[j + k1 + 1] = arr2[j++];
        return ans;
    }
}