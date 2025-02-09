import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        ArrayList<Integer> al = new ArrayList<>();
        
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i]; j++){
                al.add(arr[i]);
            }
        }
        
        int[] answer = new int[al.size()];
        
        for(int i=0; i<answer.length; i++){
            answer[i] = al.get(i);
        }
        
        return answer;
    }
}