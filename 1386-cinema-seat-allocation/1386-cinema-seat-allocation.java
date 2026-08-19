class Solution {                         
    private static int[] cntPres = new int[]{0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 2};
    private static int[] cntBack = new int[]{0, 2, 1, 1, 1, 1, 0, 0, 0, 0, 0};

    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Arrays.sort(reservedSeats, (a, b) -> {
            if(a[0] == b[0]){
                return a[1] - b[1];
            }
            return a[0] - b[0];
        });
        int cur = 0;
        int cnt = 0;
        int bcnt= 0;
        for(int i = 0 ; i < reservedSeats.length ; i ++){
            int[] res = reservedSeats[i];
            if(cur != res[0]){
                cur = res[0];
                cnt ++;
            }
            int[] preRes = i >= 1 ? reservedSeats[i -1] : null;
            int[] nxtRes = i < reservedSeats.length -1 ? reservedSeats[i + 1]: null;
            if(preRes == null || preRes[0] < cur){
                bcnt += cntPres[res[1]];
            }
            if(nxtRes == null || nxtRes[0] > cur || nxtRes[1] == 10){
                bcnt += cntBack[res[1]];
            }else{
                int start = res[1];
                int end = nxtRes[1];
                if(start <= 1 && end >= 10){
                    bcnt += 2;
                }else if((start <= 3 && end >= 8) || (start <= 1 && end >= 6) || (start <= 5 && end >= 10)){
                    bcnt +=1;
                }
            }
        }
        bcnt = bcnt + (n - cnt)  + (n - cnt);
        return bcnt;
    }
}