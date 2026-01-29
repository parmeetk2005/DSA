class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1){
            return s;
        }
        int currRow = 0;
        boolean down = true;
        StringBuilder[] sb = new StringBuilder[numRows];
        for(int i = 0; i < numRows; i++){
            sb[i] = new StringBuilder();
        }

        char[] c = s.toCharArray();
        for(int i = 0; i < c.length; i++){
            sb[currRow].append(c[i]);
            if(currRow == 0){
                down = true;
            }
            else if(currRow == numRows - 1){
                down = false;
            }
            if(down){
                currRow++;
            }
            else{
                currRow--;
            }
        }

        StringBuilder result = new StringBuilder();
        for(int i = 0; i < sb.length; i++){
            result.append(sb[i]);
        }
        return result.toString();
    }
}