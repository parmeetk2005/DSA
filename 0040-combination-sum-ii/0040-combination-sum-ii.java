class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> ls=new ArrayList<>();
        Arrays.sort(candidates);
        helper(res,ls,candidates,target,0);
        return res;
    }
    private void helper(List<List<Integer>> res,List<Integer> ls,
    int[] candidates, int target,int i){
        if(target==0){
            res.add(new ArrayList<>(ls));
            return;
        }
        if(target<0){
            return;
        }
        for(int j=i;j<candidates.length;j++){
        if(candidates[i]>target){
            break;
        }
        if(j>i && candidates[j]==candidates[j-1]){
            continue;
        }
            ls.add(candidates[j]);
            helper(res,ls,candidates,target-candidates[j],j+1);
            ls.remove(ls.size()-1);
        }
    }
}