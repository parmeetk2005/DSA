class Solution {
    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        HashSet<Integer> st = new HashSet<>();   // HashSet is empty
        for(int i = 0; i < nums.length; i++){
            if(st.contains(nums[i])){     // if HashSet has elements then check
                return true;
            }
            st.add(nums[i]);     // if HashSet is empty push the number we seen
        }
        return false;
    }
}


// TIME LIMIT EXCEED
// class Solution {
//     public boolean containsDuplicate(int[] nums) {
//         Arrays.sort(nums);
//         Stack<Integer> st = new Stack<>();  // stack is empty
//         for(int i = 0; i < nums.length; i++){
//             if(st.contains(nums[i])){    // if stack has elements then check 
//                 return true;
//             }
//             st.push(nums[i]); // if stack is empty push the number we seen
//         }
//         return false;
//     }
// }