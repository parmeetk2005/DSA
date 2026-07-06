class Solution {
    public static int helper(int num){
        int sum = 0;
        while(num > 0){
            int digit = num % 10;
            sum += digit * digit;
            num /= 10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        Stack<Integer> st = new Stack<>();
        while(n > 1){
            if(st.contains(n)){
                return false;
            }
            st.push(n);
            n = helper(n);
        }
        return true;
    }
}