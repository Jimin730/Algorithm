class Solution {
    public int[] solution(int[] arr) {
        for(int i=0; i<arr.length; i++){
            int num = arr[i];
            
            if(num >= 50 && num%2==0){
                arr[i] = num / 2;
            } else if(num < 50 && num%2!=0){
                arr[i] = num * 2;
            }
                
        }
        
        return arr;
    }
}