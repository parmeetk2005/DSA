class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hs = new HashSet<>();
        int left = 0;
        int max = 0;
        for(int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);
            while(hs.contains(ch)){
                hs.remove(s.charAt(left++));
            }
            hs.add(ch);
            max = Math.max(max, i - left + 1);
        }
        return max;
    }
}