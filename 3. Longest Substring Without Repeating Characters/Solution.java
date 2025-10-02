import java.util.HashSet;
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxlength = 0;
        int i = 0;
        int j = 0;
        HashSet <Character> h = new HashSet<>();
        while(j < n){
            char ch = s.charAt(j);
            if(! h.contains(ch)){
                h.add(ch);
                maxlength = Math.max(maxlength, j - i + 1);
                j++;
            }
            else{
                h.remove(s.charAt(i));
                i++;
            }
        }
        return maxlength;
    }
}