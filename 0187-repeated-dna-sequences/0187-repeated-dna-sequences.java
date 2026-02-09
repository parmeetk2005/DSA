class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        HashSet<String> seen = new HashSet<>();
        HashSet<String> repeat = new HashSet<>();
        int n = s.length();
        for(int i = 0; i <= n - 10; i++){
            String sub = s.substring(i, i + 10);
            if(!seen.contains(sub)){
                seen.add(sub);
            }
            else{
                repeat.add(sub);
            }
        }
        return new ArrayList<>(repeat);
    }
}