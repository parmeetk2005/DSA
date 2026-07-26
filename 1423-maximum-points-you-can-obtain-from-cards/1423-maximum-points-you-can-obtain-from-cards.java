class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int sum = 0;
        int left = 0;
        int right = k - 1;
        for(int i = 0; i <= right; i++){  
            sum += cardPoints[i];
        }
        int maxPoints = sum;       
        int lastPart = cardPoints.length - 1;
        for(int i = right; i >= 0; i--){
            sum -=cardPoints[i];    
            sum += cardPoints[lastPart];
            lastPart--;
            maxPoints = Math.max(maxPoints, sum);
        }
        return maxPoints;
    }
}