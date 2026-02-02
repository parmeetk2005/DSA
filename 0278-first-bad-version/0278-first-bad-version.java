/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int low = 0;
        int high = n;
        while(low < high){
            int mid = low + (high - low) / 2;
            boolean result = isBadVersion(mid);
            if(result){
                high = mid;
            }
            else{
                low = mid + 1;
            }
        }
        return low;
    }
}