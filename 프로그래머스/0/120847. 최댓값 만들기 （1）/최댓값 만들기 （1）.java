class Solution {
    public int solution(int[] numbers) {
        
        int maxNum = 0;
        
        for(int i=0; i<numbers.length; i++){
           for(int j=0; j<numbers.length; j++){
               if(i==j) continue;
               maxNum = Math.max(maxNum, numbers[i]*numbers[j]);
           }
        }
        
        return maxNum;
    }
}